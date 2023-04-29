/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.market.SSyConcernItemTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ConcernRoleIdSet;
/*    */ import xbean.Item;
/*    */ import xbean.MarketItem;
/*    */ import xtable.Marketitem2sessionid;
/*    */ import xtable.Marketitemid2concernrole;
/*    */ 
/*    */ public class PrePubItemSession extends Session
/*    */ {
/*    */   public PrePubItemSession(long intervalSeconds, long marketId)
/*    */   {
/* 19 */     super(intervalSeconds, marketId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     new EndPrePubTipPro(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class EndPrePubTipPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long marketId;
/*    */     
/*    */     public EndPrePubTipPro(long marketId)
/*    */     {
/* 37 */       this.marketId = marketId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       MarketItem xMarketItem = xtable.Marketitem.get(Long.valueOf(this.marketId));
/* 45 */       if (xMarketItem == null)
/*    */       {
/* 47 */         String logStr = String.format("[market]EndPrePubTipPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*    */         
/* 49 */         MarketManager.logger.error(logStr);
/* 50 */         return false;
/*    */       }
/* 52 */       if (xMarketItem.getState() != 1)
/*    */       {
/* 54 */         return false;
/*    */       }
/* 56 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 57 */       long publicEndtime = MarketManager.computePublicEndtime(xMarketItem.getOnshelf_time());
/* 58 */       long length = publicEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/*    */       
/* 60 */       if (length <= 0L)
/*    */       {
/* 62 */         length = 1L;
/*    */       }
/* 64 */       PublicItemSession publicItemSession = new PublicItemSession(length, this.marketId);
/* 65 */       Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/* 66 */       Marketitem2sessionid.insert(Long.valueOf(this.marketId), Long.valueOf(publicItemSession.getSessionId()));
/* 67 */       ConcernRoleIdSet xConcernRoleIdSet = Marketitemid2concernrole.get(Long.valueOf(this.marketId));
/* 68 */       if ((xConcernRoleIdSet != null) && (!xConcernRoleIdSet.getRoleids().isEmpty()))
/*    */       {
/* 70 */         SSyConcernItemTipRes res = new SSyConcernItemTipRes();
/* 71 */         MarketManager.fillProtocolMarketItem(res.marketitem, this.marketId, xMarketItem, null);
/* 72 */         OnlineManager.getInstance().sendMulti(res, xConcernRoleIdSet.getRoleids());
/* 73 */         Marketitemid2concernrole.remove(Long.valueOf(this.marketId));
/*    */       }
/*    */       
/* 76 */       MarketManager.sendAuctionPublicEndTipMailToSeller(xMarketItem.getRoleid(), this.marketId, xMarketItem.getItem().getCfgid(), ItemInterface.getItemName(xMarketItem.getItem().getCfgid()), xMarketItem.getPrice());
/*    */       
/*    */ 
/* 79 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PrePubItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */