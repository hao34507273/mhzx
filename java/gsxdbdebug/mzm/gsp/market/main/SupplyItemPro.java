/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.market.confbean.SMarketSupplyItemCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketChannelIds;
/*     */ import xbean.MarketIds;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem2sessionid;
/*     */ 
/*     */ public class SupplyItemPro extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int itemid;
/*     */   private final int supplyNum;
/*     */   
/*     */   public SupplyItemPro(int itemid, int supplyNum)
/*     */   {
/*  25 */     this.itemid = itemid;
/*  26 */     this.supplyNum = supplyNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!MarketManager.isMarketSupplySwitchOpen())
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, this.itemid))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     int subid = MarketManager.getSubidByItemId(this.itemid);
/*  42 */     if (subid == -1)
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (MarketManager.isMarketSellnumToMax(subid))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!MarketManager.canSellItem(this.itemid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemid);
/*  56 */     xdb.Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/*  58 */     int channelSize = MarketManager.getChannelSizeByItemId(this.itemid);
/*  59 */     if (channelSize == -1)
/*     */     {
/*  61 */       String logStr = String.format("[market]SupplyItemPro.processImp@market sell item channelSize error|itemid=%d|channelSize=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/*  64 */       MarketManager.logger.error(logStr);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     SMarketSupplyItemCfg sMarketSupplyItemCfg = SMarketSupplyItemCfg.get(this.itemid);
/*  69 */     if (sMarketSupplyItemCfg == null)
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     MarketChannelIds xMarketChannelIds = MarketManager.getMarketItemChannelIdsOnAdd(this.itemid);
/*  75 */     if (xMarketChannelIds.getSupply_num() >= sMarketSupplyItemCfg.daySupplyNum)
/*     */     {
/*  77 */       String logStr = String.format("[market]SupplyItemPro.processImp@market supply num to day max|itemid=%d|supply_num=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(xMarketChannelIds.getSupply_num()) });
/*     */       
/*     */ 
/*  80 */       MarketManager.logger.info(logStr);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     xMarketChannelIds.setSupply_num(xMarketChannelIds.getSupply_num() + this.supplyNum);
/*  85 */     List<Item> xItems = ItemInterface.createXItem(this.itemid, this.supplyNum);
/*  86 */     if (xItems == null)
/*     */     {
/*  88 */       String logStr = String.format("[market]SupplyItemPro.processImp@create xitem error|itemid=%d|supplyNum=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(this.supplyNum) });
/*     */       
/*  90 */       MarketManager.logger.error(logStr);
/*     */       
/*  92 */       return false;
/*     */     }
/*  94 */     if (xItems.size() != 1)
/*     */     {
/*  96 */       String logStr = String.format("[market]SupplyItemPro.processImp@create xitem error,more than one grid|itemid=%d|supplyNum=%d|size=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(this.supplyNum), Integer.valueOf(xItems.size()) });
/*     */       
/*     */ 
/*  99 */       MarketManager.logger.error(logStr);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     Item xItem = (Item)xItems.get(0);
/* 104 */     if (xItem.getNumber() != this.supplyNum)
/*     */     {
/* 106 */       String logStr = String.format("[market]SupplyItemPro.processImp@create xitem number error|itemid=%d|supplyNum=%d|create_num=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(this.supplyNum), Integer.valueOf(xItem.getNumber()) });
/*     */       
/*     */ 
/* 109 */       MarketManager.logger.error(logStr);
/* 110 */       return false;
/*     */     }
/* 112 */     double priceRate = MarketManager.randomSupplyItemPrice(xItem, sMarketSupplyItemCfg);
/* 113 */     if (priceRate <= 0.0D)
/*     */     {
/* 115 */       String logStr = String.format("[market]SupplyItemPro.processImp@random priceRate error|itemid=%d|supply_num=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(this.supplyNum) });
/*     */       
/* 117 */       MarketManager.logger.error(logStr);
/* 118 */       return false;
/*     */     }
/* 120 */     int minPrice = MarketManager.getMinItemPrice(this.itemid);
/* 121 */     if (minPrice <= 0)
/*     */     {
/* 123 */       String logStr = String.format("[market]SupplyItemPro.processImp@get min price error|itemid=%d|minPrice=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(minPrice) });
/*     */       
/* 125 */       MarketManager.logger.error(logStr);
/* 126 */       return false;
/*     */     }
/* 128 */     int price = (int)(minPrice * priceRate);
/*     */     
/* 130 */     boolean isWithSkill = MarketManager.isItemWithSkill(xItem);
/* 131 */     if (isWithSkill)
/*     */     {
/* 133 */       if (xMarketChannelIds.getSupply_skill_equip_num() >= SMarketConsts.getInstance().MAX_SUPPLY_SKILL_EQUIP_NUM)
/*     */       {
/* 135 */         MarketManager.removeEquipSkill(xItem);
/* 136 */         isWithSkill = false;
/*     */       }
/*     */       else
/*     */       {
/* 140 */         xMarketChannelIds.setSupply_skill_equip_num(xMarketChannelIds.getSupply_skill_equip_num() + this.supplyNum);
/*     */       }
/*     */     }
/* 143 */     if (!MarketManager.isItemPriceRight(this.itemid, price, isWithSkill))
/*     */     {
/* 145 */       String logStr = String.format("[market]SupplyItemPro.processImp@market sell item price error|itemid=%d|price=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(price) });
/*     */       
/* 147 */       MarketManager.logger.error(logStr);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     ChannelIdXMarketIdsBean channelIdXMarketIdsBean = MarketManager.findChannelIdXMarketIdsBean(xMarketChannelIds, channelSize);
/*     */     
/* 153 */     if (channelIdXMarketIdsBean == null)
/*     */     {
/* 155 */       String logStr = String.format("[market]SupplyItemPro.processImp@market supply item error,not get an available channle|itemid=%d|channelSize=%d", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 158 */       MarketManager.logger.error(logStr);
/* 159 */       return false;
/*     */     }
/* 161 */     long channelid = channelIdXMarketIdsBean.channelid;
/* 162 */     MarketIds xMarketIds = channelIdXMarketIdsBean.xMarketIds;
/*     */     
/* 164 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 165 */     long marketid = MarketManager.createMarketItemInfo(0L, xItem, price, now, channelid, 1);
/*     */     
/* 167 */     boolean ret = xMarketIds.getMarket_ids().add(Long.valueOf(marketid));
/* 168 */     if (!ret)
/*     */     {
/* 170 */       String logStr = String.format("[market]SupplyItemPro.processImp@market supply item error,add marketid error|itemid=%d|marketid=%d|channelid=%d", new Object[] { Integer.valueOf(this.itemid), Long.valueOf(marketid), Long.valueOf(channelid) });
/*     */       
/*     */ 
/* 173 */       MarketManager.logger.error(logStr);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     long publicTipEndtime = MarketManager.computePublicTipEndTime(now);
/* 178 */     long length = publicTipEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 179 */     if (length <= 0L)
/*     */     {
/* 181 */       length = 1L;
/*     */     }
/* 183 */     PrePubItemSession prePubItemSession = new PrePubItemSession(length, marketid);
/* 184 */     Marketitem2sessionid.remove(Long.valueOf(marketid));
/* 185 */     Marketitem2sessionid.insert(Long.valueOf(marketid), Long.valueOf(prePubItemSession.getSessionId()));
/*     */     
/* 187 */     if (MarketManager.isLevelSift(subid))
/*     */     {
/* 189 */       int level = ItemInterface.getUseLevel(this.itemid);
/* 190 */       LevelSiftRankManager.rankPub(subid, marketid, level, price);
/*     */     }
/*     */     else
/*     */     {
/* 194 */       PriceRankManager.rankPub(subid, marketid, price);
/*     */     }
/* 196 */     MarketManager.tlogMarket(this.itemid, this.supplyNum, price, 0L, MarketOperateEnum.SYS_SELL_ITEM);
/*     */     
/* 198 */     long lengthTime = MarketManager.computePublicEndtime(now) - TimeUnit.MILLISECONDS.toSeconds(now) + TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().AUCTION_TIME);
/*     */     
/*     */ 
/* 201 */     MarketManager.tlogMarketSellItemForIdip(0L, this.itemid, this.supplyNum, price, xItem.getUuid(), marketid, lengthTime, MarketOperateEnum.SYS_SELL_ITEM.value);
/*     */     
/*     */ 
/* 204 */     String logStr = String.format("[market]SupplyItemPro.processImp@market supply item success|itemid=%d|num=%d|price=%d|marketId=%d|channel_id=%d|subid=%d|is_with_skill=%b", new Object[] { Integer.valueOf(this.itemid), Integer.valueOf(this.supplyNum), Integer.valueOf(price), Long.valueOf(marketid), Long.valueOf(channelid), Integer.valueOf(subid), Boolean.valueOf(isWithSkill) });
/*     */     
/*     */ 
/* 207 */     MarketManager.logger.info(logStr);
/*     */     
/* 209 */     MarketInterface.triggerMarketItemOnShelfEvent(marketid, this.itemid, true, true);
/*     */     
/* 211 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\SupplyItemPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */