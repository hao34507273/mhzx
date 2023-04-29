/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PBuyItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketId;
/*     */   private int itemid;
/*     */   private int price;
/*     */   private int buyNum;
/*     */   
/*     */   public PBuyItemReq(long roleId, long marketId, int itemid, int price, int buyNum)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.marketId = marketId;
/*  36 */     this.itemid = itemid;
/*  37 */     this.price = price;
/*  38 */     this.buyNum = buyNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  46 */       String logStr = String.format("[market]PBuyItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  47 */       MarketManager.logger.info(logStr);
/*  48 */       return false;
/*     */     }
/*  50 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, this.itemid))
/*     */     {
/*  52 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemid));
/*  53 */       return false;
/*     */     }
/*  55 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     String log = String.format("[market]PBuyItemReq.processImp@receive buy item req|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/*  62 */     MarketManager.logger.info(log);
/*     */     
/*  64 */     if ((this.price <= 0) || (this.buyNum <= 0))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     long pixNum = ItemInterface.getPileMaxCount(this.itemid);
/*  69 */     if (this.buyNum > pixNum)
/*     */     {
/*  71 */       log = String.format("[market]PBuyItemReq.processImp@buy num exceed max num|roleid=%d|itemid=%d|marketId=%d|price=%d|buynum=%d|pixnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(this.buyNum), Long.valueOf(pixNum) });
/*     */       
/*     */ 
/*  74 */       MarketManager.logger.info(log);
/*  75 */       return false;
/*     */     }
/*  77 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     int subid = MarketManager.getSubidByItemId(this.itemid);
/*  82 */     if (subid == -1)
/*     */     {
/*  84 */       MarketManager.sendCommonError(this.roleId, 7);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (!MarketManager.isRoleLevelRight(RoleInterface.getLevel(this.roleId), subid))
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     Long sellerRoleId = Marketitem.selectRoleid(Long.valueOf(this.marketId));
/*  93 */     if (sellerRoleId == null)
/*     */     {
/*  95 */       MarketManager.sendCommonError(this.roleId, 7);
/*  96 */       return false;
/*     */     }
/*  98 */     Long channlel_id = Marketitem.selectChannel_id(Long.valueOf(this.marketId));
/*  99 */     if (channlel_id == null)
/*     */     {
/* 101 */       MarketManager.sendCommonError(this.roleId, 7);
/* 102 */       return false;
/*     */     }
/* 104 */     List<Long> roleidList = new java.util.ArrayList(2);
/* 105 */     roleidList.add(Long.valueOf(this.roleId));
/* 106 */     if (sellerRoleId.longValue() != 0L)
/*     */     {
/* 108 */       roleidList.add(sellerRoleId);
/*     */     }
/* 110 */     Lockeys.lock(Role2marketinfo.getTable(), roleidList);
/*     */     
/* 112 */     long itemLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemid);
/* 113 */     Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(itemLockKey) }));
/* 114 */     Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { channlel_id }));
/*     */     
/* 116 */     MarketItem xMarketItem = Marketitem.get(Long.valueOf(this.marketId));
/* 117 */     if (xMarketItem == null)
/*     */     {
/* 119 */       MarketManager.sendCommonError(this.roleId, 7);
/* 120 */       return false;
/*     */     }
/* 122 */     if (xMarketItem.getChannel_id() != channlel_id.longValue())
/*     */     {
/* 124 */       MarketManager.sendCommonError(this.roleId, 7);
/* 125 */       return false;
/*     */     }
/* 127 */     if (xMarketItem.getRoleid() == this.roleId)
/*     */     {
/* 129 */       MarketManager.sendCommonError(this.roleId, 16);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if ((xMarketItem.getRest_num() <= 0) || (xMarketItem.getPrice() != this.price))
/*     */     {
/* 135 */       MarketManager.sendCommonError(this.roleId, 9);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if (xMarketItem.getRest_num() < this.buyNum)
/*     */     {
/* 141 */       MarketManager.sendCommonError(this.roleId, 7);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     if (!MarketManager.hasState(xMarketItem.getState(), 2))
/*     */     {
/* 147 */       return false;
/*     */     }
/* 149 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 150 */     if (MarketManager.isExpire(now, xMarketItem.getOnshelf_time()))
/*     */     {
/* 152 */       MarketManager.sendCommonError(this.roleId, 7);
/* 153 */       return false;
/*     */     }
/* 155 */     if (xMarketItem.getItem().getCfgid() != this.itemid)
/*     */     {
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     TLogArg logArg = new TLogArg(LogReason.MARKET_BUY, this.itemid);
/* 161 */     if (!RoleInterface.cutGoldIngot(this.roleId, this.price * this.buyNum, logArg))
/*     */     {
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     xMarketItem.setRest_num(xMarketItem.getRest_num() - this.buyNum);
/* 167 */     xMarketItem.setState(xMarketItem.getState() | 0x4);
/*     */     
/* 169 */     MarketManager.sendSBuyItemRes(this.roleId, this.marketId, this.itemid, this.price, xMarketItem.getRest_num(), this.buyNum, this.price * this.buyNum);
/* 170 */     if (sellerRoleId.longValue() != 0L)
/*     */     {
/* 172 */       MarketManager.sendSSyncSellItemNotify(sellerRoleId.longValue(), this.marketId, this.itemid, xMarketItem.getRest_num(), this.buyNum);
/*     */     }
/* 174 */     ItemOperateResult ret = MarketInterface.addItemToRole(this.roleId, xMarketItem.getItem(), this.buyNum, LogReason.MARKET_BUY, TimeUnit.MILLISECONDS.toSeconds(now));
/*     */     
/* 176 */     if (!ret.success())
/*     */     {
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     MarketManager.logMarketBuyItem(this.roleId, sellerRoleId.longValue(), this.marketId, this.itemid, this.buyNum, this.price, (java.util.Set)ret.getChangedItemId2Uuids().get(Integer.valueOf(this.itemid)), DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/* 184 */     String logStr = String.format("[market]PBuyItemReq.processImp@buy item success|roleid=%d|itemid=%d|num=%d|price=%d|marketId=%d|channel_id=%d|sellerRoleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.buyNum), Integer.valueOf(this.price), Long.valueOf(this.marketId), channlel_id, sellerRoleId });
/*     */     
/*     */ 
/* 187 */     MarketManager.logger.info(logStr);
/*     */     
/* 189 */     boolean isRestNumZero = false;
/* 190 */     if (xMarketItem.getRest_num() == 0)
/*     */     {
/* 192 */       isRestNumZero = true;
/* 193 */       xMarketItem.setState(4);
/*     */       
/* 195 */       Long sessionId = Marketitem2sessionid.get(Long.valueOf(this.marketId));
/*     */       
/* 197 */       if (sessionId != null)
/*     */       {
/* 199 */         Session.removeSession(sessionId.longValue());
/* 200 */         Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/*     */       }
/*     */       
/* 203 */       if (sellerRoleId.longValue() != 0L)
/*     */       {
/* 205 */         xbean.RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(sellerRoleId);
/* 206 */         if (xRoleMarketInfo == null)
/*     */         {
/* 208 */           String logs = String.format("[market]PBuyItemReq.processImp@xRoleMarketInfo null|roleid=%d|itemid=%d|num=%d|price=%d|marketId=%d|channel_id=%d", new Object[] { sellerRoleId, Integer.valueOf(this.itemid), Integer.valueOf(this.buyNum), Integer.valueOf(this.price), Long.valueOf(this.marketId), channlel_id });
/*     */           
/*     */ 
/* 211 */           MarketManager.logger.info(logs);
/* 212 */           return false;
/*     */         }
/* 214 */         MarketManager.addMarketTimeOutOrSelledItem(xRoleMarketInfo, this.marketId, xMarketItem);
/*     */       }
/*     */       
/* 217 */       MarketManager.removeMarketIdFromItemChannel(itemLockKey, this.marketId, channlel_id.longValue());
/* 218 */       Marketitem.remove(Long.valueOf(this.marketId));
/*     */       
/* 220 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 222 */         int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 223 */         LevelSiftRankManager.deleteSell(subid, this.marketId, level);
/*     */       }
/*     */       else
/*     */       {
/* 227 */         PriceRankManager.deleteSell(subid, this.marketId);
/*     */       }
/*     */     }
/*     */     
/* 231 */     if (isRestNumZero)
/*     */     {
/* 233 */       MarketItemPetPriceManager.removePrice(xMarketItem.getItem().getCfgid(), xMarketItem.getPrice());
/* 234 */       MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, this.itemid, false, xMarketItem.toData());
/*     */     }
/* 236 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */