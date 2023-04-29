/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Role2singlebattle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginAFMap
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 22 */     RoleSingleBattle xRoleBattleData = Role2singlebattle.select(Long.valueOf(roleId));
/* 23 */     if (xRoleBattleData == null)
/*    */     {
/*    */ 
/* 26 */       new CheckRoleStatus(roleId).execute();
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     long battleId = xRoleBattleData.getBattleid();
/*    */     
/* 32 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(battleId, true);
/* 33 */     if (globalInfo == null)
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[singlebattle]POnMapRoleCreated.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d|battleCfgId=%d|", new Object[] { Long.valueOf(roleId), Long.valueOf(battleId), Integer.valueOf(xRoleBattleData.getBattlecfgid()) }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     xRoleBattleData = Role2singlebattle.get(Long.valueOf(roleId));
/* 43 */     if (xRoleBattleData == null)
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[singlebattle]POnMapRoleCreated.processImp@ recheck no RoleSingleBattle! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     if (MapInterface.getRoleWorldInstanceId(roleId) == globalInfo.getBattleWorldId())
/*    */     {
/* 55 */       SingleBattleManager.initRoleBattleMapData(roleId, battleId);
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   class CheckRoleStatus extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     CheckRoleStatus(long roleId)
/*    */     {
/* 66 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 73 */       RoleSingleBattle xRoleBattleData = Role2singlebattle.get(Long.valueOf(this.roleId));
/* 74 */       if (xRoleBattleData != null)
/*    */       {
/* 76 */         return false;
/*    */       }
/* 78 */       if (SingleBattleManager.removeSingleBattleAllStatus(this.roleId))
/*    */       {
/* 80 */         GameServer.logger().info(String.format("[singlebattle]CheckRoleStatus.processImp@ contains single battle status!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       }
/*    */       
/*    */ 
/* 84 */       MapInterface.unSetModelProtocol(this.roleId, 12621580);
/* 85 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\POnRoleLoginAFMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */