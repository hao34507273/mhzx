/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.SSyncItemExpire;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem;
/*     */ 
/*     */ public class MarketItemSession extends Session
/*     */ {
/*     */   public MarketItemSession(long interval, long marketId)
/*     */   {
/*  19 */     super(interval, marketId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  26 */     new MarketItemSessionPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */   private static class MarketItemSessionPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public MarketItemSessionPro(long marketId)
/*     */     {
/*  36 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  42 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(this.marketId));
/*  43 */       if (xMarketItem == null)
/*     */       {
/*  45 */         String logStr = String.format("[market]MarketItemSessionPro.processImp@ xbean.MarketItem get roleid null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  47 */         MarketManager.logger.error(logStr);
/*  48 */         return false;
/*     */       }
/*  50 */       long roleId = xMarketItem.getRoleid();
/*  51 */       if (roleId != 0L)
/*     */       {
/*  53 */         Lockeys.lock(xtable.Role2auctioninfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */       }
/*     */       
/*  56 */       long itemLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketItem.getItem().getCfgid());
/*  57 */       Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(itemLockKey) }));
/*  58 */       Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketItem.getChannel_id()) }));
/*     */       
/*  60 */       xMarketItem = Marketitem.get(Long.valueOf(this.marketId));
/*  61 */       if (xMarketItem == null)
/*     */       {
/*  63 */         String logStr = String.format("[market]MarketItemSessionPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  65 */         MarketManager.logger.error(logStr);
/*  66 */         return false;
/*     */       }
/*  68 */       if (xMarketItem.getRoleid() != roleId)
/*     */       {
/*  70 */         String logStr = String.format("[market]MarketItemSessionPro.processImp@ xbean.MarketItem role error|marketId=%d|marketRoleId=%d|roleId=%d", new Object[] { Long.valueOf(this.marketId), Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(roleId) });
/*     */         
/*     */ 
/*  73 */         MarketManager.logger.error(logStr);
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       if (xMarketItem.getRest_num() <= 0)
/*     */       {
/*  79 */         return false;
/*     */       }
/*  81 */       xMarketItem.setState(xMarketItem.getState() | 0x8);
/*  82 */       xMarketItem.setState(xMarketItem.getState() & 0xFFFFFFFD);
/*  83 */       xMarketItem.setConcern_role_num(0);
/*  84 */       int subid = MarketManager.getSubidByItemId(xMarketItem.getItem().getCfgid());
/*  85 */       if (subid != -1)
/*     */       {
/*  87 */         MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, xMarketItem.getItem().getCfgid(), false, xMarketItem.toData());
/*     */       }
/*     */       
/*     */ 
/*  91 */       MarketManager.removeMarketIdFromItemChannel(itemLockKey, this.marketId, xMarketItem.getChannel_id());
/*  92 */       if (roleId != 0L)
/*     */       {
/*  94 */         xbean.RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(roleId));
/*  95 */         if (xRoleMarketInfo == null)
/*     */         {
/*  97 */           String logs = String.format("[market]MarketItemSessionPro.processImp@xRoleMarketInfo null|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*     */           
/*  99 */           MarketManager.logger.info(logs);
/* 100 */           return false;
/*     */         }
/* 102 */         MarketManager.addMarketTimeOutOrSelledItem(xRoleMarketInfo, this.marketId, xMarketItem);
/*     */         
/* 104 */         SSyncItemExpire expireRes = new SSyncItemExpire();
/* 105 */         expireRes.marketid = this.marketId;
/* 106 */         expireRes.itemid = xMarketItem.getItem().getCfgid();
/* 107 */         OnlineManager.getInstance().send(roleId, expireRes);
/*     */       }
/*     */       
/* 110 */       Marketitem.remove(Long.valueOf(this.marketId));
/* 111 */       xtable.Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/* 112 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 114 */         int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 115 */         LevelSiftRankManager.deleteSell(subid, this.marketId, level);
/*     */       }
/*     */       else
/*     */       {
/* 119 */         PriceRankManager.deleteSell(subid, this.marketId);
/*     */       }
/* 121 */       MarketItemPetPriceManager.removePrice(xMarketItem.getItem().getCfgid(), xMarketItem.getPrice());
/* 122 */       String logStr = String.format("[market]MarketItemSessionPro.processImp@ market item time out|roleId=%d|marketId=%d|itemId=%d|restNum=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(xMarketItem.getRest_num()) });
/*     */       
/*     */ 
/* 125 */       MarketManager.logger.info(logStr);
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */