/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 14 */     long battleId = SingleBattleInterface.getBattleId(roleId, false);
/* 15 */     if (battleId <= 0L)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     xbean.BattleGrabData xBattleGrabData = xtable.Grabposition.get(Long.valueOf(battleId));
/* 21 */     if (xBattleGrabData == null)
/*    */     {
/* 23 */       GameServer.logger().error(String.format("[grab]POnRoleLogin.processImp@ xBattleGrabData is null!|battleId=%d|roleId=%d", new Object[] { Long.valueOf(battleId), Long.valueOf(roleId) }));
/*    */       
/*    */ 
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     xbean.RoleGrabData xRoleGrabData = xtable.Role2rolegrabdata.get(Long.valueOf(roleId));
/* 30 */     if (xRoleGrabData == null)
/*    */     {
/* 32 */       GameServer.logger().error(String.format("[grab]POnRoleLogin.processImp@ xRoleGrabData is null!|battleId=%d|roleId=%d", new Object[] { Long.valueOf(battleId), Long.valueOf(roleId) }));
/*    */       
/*    */ 
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     GrabPositionManager.synBattlePositionInfo(xBattleGrabData, roleId);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */