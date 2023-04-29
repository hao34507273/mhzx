/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class LoginAwardManager
/*    */ {
/*    */   static boolean checkRoleStatus(long roleid, int status)
/*    */   {
/* 10 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, status, true))
/*    */     {
/* 12 */       GameServer.logger().error(String.format("[loginaward]LoginAwardManager.checkRoleStatus@status check failed|roleid=%d|status=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(status) }));
/*    */       
/*    */ 
/* 15 */       return false;
/*    */     }
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\LoginAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */