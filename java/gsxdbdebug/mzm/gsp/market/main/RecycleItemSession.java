/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem;
/*     */ 
/*     */ public class RecycleItemSession extends Session
/*     */ {
/*     */   public RecycleItemSession(long interval, long marketid)
/*     */   {
/*  18 */     super(interval, marketid);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  24 */     new RecycleItemSessionTimeOutPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */   private static class RecycleItemSessionTimeOutPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public RecycleItemSessionTimeOutPro(long marketId)
/*     */     {
/*  34 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  40 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(this.marketId));
/*  41 */       if (xMarketItem == null)
/*     */       {
/*  43 */         String logStr = String.format("[market]RecycleItemSessionTimeOutPro.processImp@ xbean.MarketItem get roleid null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*     */ 
/*  46 */         MarketManager.logger.error(logStr);
/*  47 */         return false;
/*     */       }
/*  49 */       long roleId = xMarketItem.getRoleid();
/*  50 */       xbean.RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(roleId));
/*  51 */       if (xRoleMarketInfo == null)
/*     */       {
/*  53 */         String logs = String.format("[market]RecycleItemSessionTimeOutPro.processImp@xRoleMarketInfo null|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*     */         
/*  55 */         MarketManager.logger.info(logs);
/*  56 */         return false;
/*     */       }
/*  58 */       long itemLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketItem.getItem().getCfgid());
/*  59 */       Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(itemLockKey) }));
/*  60 */       Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketItem.getChannel_id()) }));
/*     */       
/*  62 */       xMarketItem = Marketitem.get(Long.valueOf(this.marketId));
/*  63 */       if (xMarketItem == null)
/*     */       {
/*  65 */         String logStr = String.format("[market]RecycleItemSessionTimeOutPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  67 */         MarketManager.logger.error(logStr);
/*  68 */         return false;
/*     */       }
/*  70 */       if (xMarketItem.getRoleid() != roleId)
/*     */       {
/*  72 */         String logStr = String.format("[market]RecycleItemSessionTimeOutPro.processImp@ xbean.MarketItem role error|marketId=%d|marketRoleId=%d|roleId=%d", new Object[] { Long.valueOf(this.marketId), Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(roleId) });
/*     */         
/*     */ 
/*  75 */         MarketManager.logger.error(logStr);
/*  76 */         return false;
/*     */       }
/*  78 */       if (!MarketManager.hasState(xMarketItem.getState(), 2))
/*     */       {
/*  80 */         String logStr = String.format("[market]RecycleItemSessionTimeOutPro.processImp@ xbean.MarketItem state not sell|marketId=%d|marketRoleId=%d|roleId=%d|state=%d", new Object[] { Long.valueOf(this.marketId), Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(roleId), Integer.valueOf(xMarketItem.getState()) });
/*     */         
/*     */ 
/*  83 */         MarketManager.logger.info(logStr);
/*  84 */         return false;
/*     */       }
/*  86 */       int restNum = xMarketItem.getRest_num();
/*  87 */       if (restNum <= 0)
/*     */       {
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       xMarketItem.setState(4);
/*  93 */       xMarketItem.setConcern_role_num(0);
/*  94 */       xMarketItem.setRest_num(0);
/*  95 */       int subid = MarketManager.getSubidByItemId(xMarketItem.getItem().getCfgid());
/*  96 */       if (subid != -1)
/*     */       {
/*  98 */         MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, xMarketItem.getItem().getCfgid(), false, xMarketItem.toData());
/*     */       }
/*     */       
/*     */ 
/* 102 */       MarketManager.removeMarketIdFromItemChannel(itemLockKey, this.marketId, xMarketItem.getChannel_id());
/* 103 */       MarketManager.addMarketTimeOutOrSelledItem(xRoleMarketInfo, this.marketId, xMarketItem);
/* 104 */       Marketitem.remove(Long.valueOf(this.marketId));
/* 105 */       xtable.Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/*     */       
/* 107 */       MarketManager.logMarketBuyItem(0L, roleId, this.marketId, xMarketItem.getItem().getCfgid(), restNum, xMarketItem.getPrice(), xMarketItem.getItem().getUuid(), DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/* 110 */       MarketManager.sendSSyncSellItemNotify(roleId, this.marketId, xMarketItem.getItem().getCfgid(), 0, restNum);
/* 111 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 113 */         int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 114 */         LevelSiftRankManager.deleteSell(subid, this.marketId, level);
/*     */       }
/*     */       else
/*     */       {
/* 118 */         PriceRankManager.deleteSell(subid, this.marketId);
/*     */       }
/* 120 */       MarketItemPetPriceManager.removePrice(xMarketItem.getItem().getCfgid(), xMarketItem.getPrice());
/* 121 */       String logStr = String.format("[market]RecycleItemSessionTimeOutPro.processImp@market item recycle|roleId=%d|marketId=%d|itemId=%d|recycle_num=%d|rest_num=%d|price=%d", new Object[] { Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(restNum), Integer.valueOf(xMarketItem.getRest_num()), Integer.valueOf(xMarketItem.getPrice()) });
/*     */       
/*     */ 
/*     */ 
/* 125 */       MarketManager.logger.info(logStr);
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\RecycleItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */