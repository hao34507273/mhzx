/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketChannelIds;
/*     */ import xbean.MarketIds;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PSellItemReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemKey;
/*     */   private int itemid;
/*     */   private int price;
/*     */   private int num;
/*     */   
/*     */   public PSellItemReq(long roleId, int itemKey, int itemid, int price, int num)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.itemKey = itemKey;
/*  40 */     this.itemid = itemid;
/*  41 */     this.price = price;
/*  42 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, this.itemid))
/*     */     {
/*  50 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemid));
/*  51 */       return false;
/*     */     }
/*  53 */     String log = String.format("[market]PSellItemReq.processImp@receive sellitem req|roleid=%d|itemid=%d|itemkey=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.itemKey), Integer.valueOf(this.price), Integer.valueOf(this.num) });
/*     */     
/*     */ 
/*  56 */     MarketManager.logger.info(log);
/*     */     
/*  58 */     if ((this.price <= 0) || (this.num <= 0))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  64 */       String logStr = String.format("[market]PSellItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  65 */       MarketManager.logger.info(logStr);
/*  66 */       return false;
/*     */     }
/*  68 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  74 */       return false;
/*     */     }
/*  76 */     int subid = MarketManager.getSubidByItemId(this.itemid);
/*  77 */     if (subid == -1)
/*     */     {
/*  79 */       MarketManager.sendCommonError(this.roleId, 7);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (MarketManager.isMarketSellnumToMax(subid))
/*     */     {
/*  85 */       MarketManager.sendCommonError(this.roleId, 13);
/*  86 */       return false;
/*     */     }
/*  88 */     if (!MarketManager.canSellItem(this.itemid))
/*     */     {
/*     */ 
/*  91 */       String logStr = String.format("[market]PSellItemReq.processImp@item can not sell|roleid=%d|itemId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price) });
/*     */       
/*  93 */       MarketManager.logger.error(logStr);
/*  94 */       return false;
/*     */     }
/*  96 */     Lockeys.lock(Role2marketinfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  98 */     long key = GameServerInfoManager.toGlobalId(this.itemid);
/*  99 */     Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/* 100 */     RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/* 101 */     if (xRoleMarketInfo == null)
/*     */     {
/* 103 */       xRoleMarketInfo = Pod.newRoleMarketInfo();
/* 104 */       Role2marketinfo.insert(Long.valueOf(this.roleId), xRoleMarketInfo);
/*     */     }
/*     */     
/* 107 */     int alreadySellNum = xRoleMarketInfo.getOnshelf_item_ids().size() + xRoleMarketInfo.getOnshelf_pet_ids().size();
/* 108 */     if (alreadySellNum >= MarketManager.getRoleMaxMarketGrid())
/*     */     {
/* 110 */       String logStr = String.format("[market]PSellItemReq.processImp@market grid not enough|roleid=%d|gridnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alreadySellNum) });
/*     */       
/* 112 */       MarketManager.logger.error(logStr);
/*     */       
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     TLogArg logArg = new TLogArg(LogReason.MARKET_SHANGJIA, this.itemid);
/*     */     
/* 119 */     BasicItem basicitem = ItemInterface.getAndRemoveItemInBag(this.roleId, this.itemKey, this.num, logArg);
/* 120 */     if (basicitem == null)
/*     */     {
/* 122 */       return false;
/*     */     }
/* 124 */     if ((basicitem.getCfgId() != this.itemid) || (this.num != basicitem.getNumber()) || (basicitem.isBind()))
/*     */     {
/* 126 */       String logStr = String.format("[market]PSellItemReq.processImp@market item error|roleid=%d|itmekey=%d|itemid=%d|serveritemid=%d|num=%d|servernum=%d|isbind=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(basicitem == null ? 0 : basicitem.getCfgId()), Integer.valueOf(this.num), Integer.valueOf(basicitem.getNumber()), Integer.valueOf(basicitem.isBind() ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/* 130 */       MarketManager.logger.error(logStr);
/*     */       
/* 132 */       return false;
/*     */     }
/* 134 */     if (MarketManager.isItemInFrozenState(this.itemid, basicitem.getMarketBuytime()))
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     boolean isWithSkill = MarketManager.isItemWithSkill(basicitem.getItem());
/* 139 */     if (!MarketManager.isItemPriceRight(this.itemid, this.price, isWithSkill))
/*     */     {
/* 141 */       String logStr = String.format("[market]PSellItemReq.processImp@market sell item price error|roleid=%d|itmekey=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 146 */       MarketManager.logger.error(logStr);
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     long tax = MarketManager.computeSellNeedTaxGold(this.price, this.num);
/* 151 */     if (tax <= 0L)
/*     */     {
/* 153 */       String logStr = String.format("[market]PSellItemReq.processImp@market sell item tax error|roleid=%d|itmekey=%d|itemid=%d|tax=%d|num=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Long.valueOf(tax), Integer.valueOf(this.num), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 156 */       MarketManager.logger.error(logStr);
/* 157 */       return false;
/*     */     }
/* 159 */     if (!RoleInterface.cutGold(this.roleId, tax, logArg))
/*     */     {
/* 161 */       MarketManager.sendCommonError(this.roleId, 6);
/*     */       
/* 163 */       return false;
/*     */     }
/* 165 */     int channelSize = MarketManager.getChannelSizeByItemId(this.itemid);
/* 166 */     if (channelSize == -1)
/*     */     {
/*     */ 
/* 169 */       String logStr = String.format("[market]PSellItemReq.processImp@market sell item channelSize error|roleid=%d|itmekey=%d|itemid=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 172 */       MarketManager.logger.error(logStr);
/* 173 */       return false;
/*     */     }
/*     */     
/* 176 */     MarketChannelIds xMarketChannelIds = MarketManager.getMarketItemChannelIdsOnAdd(this.itemid);
/*     */     
/* 178 */     ChannelIdXMarketIdsBean channelIdXMarketIdsBean = MarketManager.findChannelIdXMarketIdsBean(xMarketChannelIds, channelSize);
/*     */     
/* 180 */     if (channelIdXMarketIdsBean == null)
/*     */     {
/* 182 */       String logStr = String.format("[market]PSellItemReq.processImp@market sell item error,not get an available channle|roleid=%d|itemid=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 185 */       MarketManager.logger.error(logStr);
/* 186 */       return false;
/*     */     }
/* 188 */     long channelid = channelIdXMarketIdsBean.channelid;
/* 189 */     MarketIds xMarketIds = channelIdXMarketIdsBean.xMarketIds;
/*     */     
/* 191 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 192 */     long marketid = MarketManager.createMarketItemInfo(this.roleId, basicitem.getItem(), this.price, now, channelid, 1);
/*     */     
/* 194 */     boolean ret = xMarketIds.getMarket_ids().add(Long.valueOf(marketid));
/* 195 */     if (!ret)
/*     */     {
/* 197 */       return false;
/*     */     }
/* 199 */     xRoleMarketInfo.getOnshelf_item_ids().add(Long.valueOf(marketid));
/*     */     
/* 201 */     long publicEndtime = MarketManager.computePublicEndtime(now);
/*     */     
/* 203 */     MarketManager.sendSSellItemRes(this.roleId, marketid, this.itemid, this.price, publicEndtime, basicitem.getItem().getNumber(), 0, 1, marketid);
/*     */     
/*     */ 
/* 206 */     long publicTipEndtime = MarketManager.computePublicTipEndTime(now);
/* 207 */     long length = publicTipEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 208 */     if (length <= 0L)
/*     */     {
/* 210 */       length = 1L;
/*     */     }
/* 212 */     PrePubItemSession prePubItemSession = new PrePubItemSession(length, marketid);
/* 213 */     Marketitem2sessionid.remove(Long.valueOf(marketid));
/* 214 */     Marketitem2sessionid.insert(Long.valueOf(marketid), Long.valueOf(prePubItemSession.getSessionId()));
/*     */     
/* 216 */     if (MarketManager.isLevelSift(subid))
/*     */     {
/* 218 */       int level = ItemInterface.getUseLevel(this.itemid);
/*     */       
/* 220 */       LevelSiftRankManager.rankPub(subid, marketid, level, this.price);
/*     */     }
/*     */     else
/*     */     {
/* 224 */       PriceRankManager.rankPub(subid, marketid, this.price);
/*     */     }
/* 226 */     MarketManager.tlogMarket(this.roleId, this.itemid, this.num, this.price, tax, MarketOperateEnum.SELL_ITEM);
/*     */     
/* 228 */     long lengthTime = MarketManager.computePublicEndtime(now) - TimeUnit.MILLISECONDS.toSeconds(now) + TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().AUCTION_TIME);
/*     */     
/*     */ 
/* 231 */     MarketManager.tlogMarketSellItemForIdip(this.roleId, this.itemid, this.num, this.price, basicitem.getItem().getUuidAsData(), marketid, lengthTime, MarketOperateEnum.SELL_ITEM.value);
/*     */     
/* 233 */     String logStr = String.format("[market]PSellItemReq.processImp@market sell item success|roleid=%d|itmekey=%d|itemid=%d|num=%d|price=%d|marketId=%d|channel_id=%d|subid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(this.num), Integer.valueOf(this.price), Long.valueOf(marketid), Long.valueOf(channelid), Integer.valueOf(subid) });
/*     */     
/*     */ 
/* 236 */     MarketManager.logger.info(logStr);
/*     */     
/* 238 */     MarketInterface.triggerMarketItemOnShelfEvent(marketid, this.itemid, true);
/* 239 */     MarketManager.sendBulletinForItem(RoleInterface.getName(this.roleId), marketid, this.itemid, this.price, false);
/* 240 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */