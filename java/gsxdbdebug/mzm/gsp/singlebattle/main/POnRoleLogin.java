/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Role2singlebattle;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 15 */     RoleSingleBattle xRoleBattleData = Role2singlebattle.select(Long.valueOf(roleId));
/* 16 */     if (xRoleBattleData == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     long battleId = xRoleBattleData.getBattleid();
/*    */     
/* 23 */     int campId = xRoleBattleData.getCampid();
/*    */     
/* 25 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(battleId, true);
/* 26 */     if (globalInfo == null)
/*    */     {
/* 28 */       GameServer.logger().error(String.format("[singlebattle]POnRoleLogin.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     xRoleBattleData = Role2singlebattle.select(Long.valueOf(roleId));
/* 35 */     if (xRoleBattleData == null)
/*    */     {
/* 37 */       GameServer.logger().error(String.format("[singlebattle]POnRoleLogin.processImp@ recheck no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (xRoleBattleData.getJointime() <= 0L)
/*    */     {
/* 44 */       GameServer.logger().info(String.format("[singlebattle]POnRoleLogin.processImp@ not join battle yet! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     globalInfo.synBattleInfo(roleId);
/*    */     
/* 51 */     globalInfo.roleJoinBattleBro(roleId);
/*    */     
/* 53 */     globalInfo.setRoleState(roleId, campId, 1);
/*    */     
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */