/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
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
/* 19 */     new POnRoleLoginLoginActivity(userid, roleid).call();
/* 20 */     new POnRoleLoginLoginSumActivity(userid, roleid).call();
/* 21 */     new POnRoleLoginLoginSignActivity(userid, roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */