/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogout
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     if (!InteractionManager.isEnable()) {
/* 12 */       return false;
/*    */     }
/* 14 */     return InteractionManager.cancelOrDeclineInteractionInvitationOnEvent(((Long)this.arg).longValue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */