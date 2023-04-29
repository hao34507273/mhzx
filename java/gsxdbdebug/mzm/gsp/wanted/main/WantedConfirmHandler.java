/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import mzm.gsp.wanted.SWantedConfirmDesc;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WantedConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 16 */     if (!(context instanceof WantedConfirmContext))
/*    */     {
/* 18 */       return null;
/*    */     }
/* 20 */     return new SWantedConfirmDesc(((WantedConfirmContext)context).wantedName);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 26 */     if (!(context instanceof WantedConfirmContext))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     WantedConfirmContext wantedConfirmContext = (WantedConfirmContext)context;
/* 31 */     return new PCWantedRoleReq(wantedConfirmContext.activeLeaderId, wantedConfirmContext.wantedRoleId, true).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */