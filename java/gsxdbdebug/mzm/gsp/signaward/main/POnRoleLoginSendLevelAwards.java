/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginSendLevelAwards
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     SignAwardManager.sendSLevelAwardRes(((Long)this.arg).longValue(), null);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\POnRoleLoginSendLevelAwards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */