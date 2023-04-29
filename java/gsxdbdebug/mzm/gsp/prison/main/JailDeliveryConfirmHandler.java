/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import mzm.gsp.prison.SJailDeliveryConfirmDesc;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailDeliveryConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 16 */     if (!(context instanceof JailDeliveryConfirmContext))
/*    */     {
/* 18 */       return null;
/*    */     }
/* 20 */     return new SJailDeliveryConfirmDesc(((JailDeliveryConfirmContext)context).savedName);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 26 */     if (!(context instanceof JailDeliveryConfirmContext))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     JailDeliveryConfirmContext jailDeliveryConfirmContext = (JailDeliveryConfirmContext)context;
/* 31 */     return new PCJailDeliveryReq(jailDeliveryConfirmContext.liberatorId, jailDeliveryConfirmContext.savedId, true).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailDeliveryConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */