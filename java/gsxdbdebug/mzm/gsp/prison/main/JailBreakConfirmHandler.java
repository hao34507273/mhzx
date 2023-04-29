/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import mzm.gsp.prison.SJailBreakConfirmDesc;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailBreakConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 16 */     if (!(context instanceof JailBreakConfirmContext))
/*    */     {
/* 18 */       return null;
/*    */     }
/* 20 */     return new SJailBreakConfirmDesc();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 26 */     if (!(context instanceof JailBreakConfirmContext))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     return new PCJailBreakReq(((JailBreakConfirmContext)context).roleId, true).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailBreakConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */