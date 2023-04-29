/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class ROnRoleLogout
/*    */   extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 14 */     if (RoleStatusInterface.containsStatus(roleId, 2162))
/*    */     {
/* 16 */       BallBattleGameInstance.handlePlayerLogout(roleId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */