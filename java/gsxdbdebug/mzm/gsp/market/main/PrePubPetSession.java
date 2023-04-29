/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.market.SSyConcernPetTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ConcernRoleIdSet;
/*    */ import xbean.MarketPet;
/*    */ import xbean.Pet;
/*    */ import xtable.Marketpet2sessionid;
/*    */ import xtable.Marketpetid2concernrole;
/*    */ 
/*    */ public class PrePubPetSession extends Session
/*    */ {
/*    */   public PrePubPetSession(long intervalSeconds, long marketId)
/*    */   {
/* 18 */     super(intervalSeconds, marketId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     new EndPrePubTipPro(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class EndPrePubTipPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long marketId;
/*    */     
/*    */     public EndPrePubTipPro(long marketId)
/*    */     {
/* 36 */       this.marketId = marketId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 43 */       MarketPet xMarketPet = xtable.Marketpet.get(Long.valueOf(this.marketId));
/* 44 */       if (xMarketPet == null)
/*    */       {
/* 46 */         String logStr = String.format("[market]EndPrePubTipPro.processImp@ xbean.MarketPet get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*    */         
/* 48 */         MarketManager.logger.error(logStr);
/* 49 */         return false;
/*    */       }
/*    */       
/* 52 */       if (xMarketPet.getState() != 1)
/*    */       {
/* 54 */         return false;
/*    */       }
/* 56 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 57 */       long publicEndtime = MarketManager.computePublicEndtime(xMarketPet.getOnshelf_time());
/* 58 */       long length = publicEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/*    */       
/* 60 */       if (length <= 0L)
/*    */       {
/* 62 */         length = 1L;
/*    */       }
/* 64 */       PublicPetSession publicPetSession = new PublicPetSession(length, this.marketId);
/* 65 */       Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/* 66 */       Marketpet2sessionid.insert(Long.valueOf(this.marketId), Long.valueOf(publicPetSession.getSessionId()));
/*    */       
/* 68 */       ConcernRoleIdSet xConcernRoleIdSet = Marketpetid2concernrole.get(Long.valueOf(this.marketId));
/* 69 */       if ((xConcernRoleIdSet != null) && (!xConcernRoleIdSet.getRoleids().isEmpty()))
/*    */       {
/* 71 */         SSyConcernPetTipRes res = new SSyConcernPetTipRes();
/* 72 */         MarketManager.fillProtocolMarketPet(res.marketpet, this.marketId, xMarketPet, null);
/*    */         
/* 74 */         OnlineManager.getInstance().sendMulti(res, xConcernRoleIdSet.getRoleids());
/* 75 */         Marketpetid2concernrole.remove(Long.valueOf(this.marketId));
/*    */       }
/* 77 */       MarketManager.sendAuctionPublicEndTipMailToSeller(xMarketPet.getRoleid(), this.marketId, xMarketPet.getPet().getTemplateid(), xMarketPet.getPet().getPetname(), xMarketPet.getPrice());
/*    */       
/* 79 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PrePubPetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */