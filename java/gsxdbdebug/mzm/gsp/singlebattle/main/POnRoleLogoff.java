/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Role2singlebattle;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 17 */     RoleSingleBattle xRoleBattleData = Role2singlebattle.select(Long.valueOf(roleId));
/* 18 */     if (xRoleBattleData == null)
/*    */     {
/* 20 */       GameServer.logger().error(String.format("[singlebattle]POnRoleLogoff.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     long battleId = xRoleBattleData.getBattleid();
/*    */     
/* 27 */     int campId = xRoleBattleData.getCampid();
/*    */     
/* 29 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(battleId, true);
/* 30 */     if (globalInfo == null)
/*    */     {
/* 32 */       GameServer.logger().error(String.format("[singlebattle]POnRoleLogoff.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     xRoleBattleData = Role2singlebattle.get(Long.valueOf(roleId));
/* 40 */     if (xRoleBattleData == null)
/*    */     {
/* 42 */       GameServer.logger().error(String.format("[singlebattle]POnRoleLogoff.processImp@ recheck no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (xRoleBattleData.getJointime() <= 0L)
/*    */     {
/* 49 */       GameServer.logger().info(String.format("[singlebattle]POnRoleLogoff.processImp@ not join battle yet! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 51 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 55 */     globalInfo.roleOutLineBattleBro(roleId);
/*    */     
/* 57 */     globalInfo.setRoleState(roleId, campId, 2);
/*    */     
/*    */ 
/*    */ 
/* 61 */     SingleBattleMemberManager.getInstance().removeRoleAFOffLine(globalInfo.getBattleCfg().battleType, battleId, roleId);
/*    */     
/* 63 */     SingleBattleManager.clearRoleMapData(roleId);
/*    */     
/* 65 */     checkAdvanceEndMatch(roleId, battleId, campId, globalInfo);
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   private void checkAdvanceEndMatch(long roleId, long battleId, int campId, SingleBattleGlobalInfo globalInfo)
/*    */   {
/* 71 */     if ((globalInfo.getStage() == 4) || (globalInfo.isSurrender(campId)))
/*    */     {
/* 73 */       return;
/*    */     }
/*    */     
/* 76 */     if (!globalInfo.checkAndSetSurrender(campId))
/*    */     {
/* 78 */       return;
/*    */     }
/* 80 */     SingleBattleManager.advanceEndMatch(battleId, globalInfo.getBattleCfg(), 3);
/* 81 */     GameServer.logger().info(String.format("[singlebattle]POnRoleLogoff.checkAdvanceEndMatch@ end battle for off line!|battleId=%d|battleCfgId=%d|roleId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(globalInfo.getBattleCfgId()), Long.valueOf(roleId) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */