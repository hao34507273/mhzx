/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class ROnRoleLogoff extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return;
/*    */     }
/*    */     
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     String userid = RoleInterface.getUserId(((Long)this.arg).longValue());
/*    */     
/* 19 */     new POnRoleLogoffLoginActivity(userid, roleid).call();
/* 20 */     new POnRoleLogoffLoginSumActivity(userid, roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\ROnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */