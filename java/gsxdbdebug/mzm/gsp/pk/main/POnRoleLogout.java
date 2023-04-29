/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogout
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     PKStatusManager.stopStatusSessions(((Long)this.arg).longValue());
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */