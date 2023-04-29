/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.singlebattle.SGatherBattleItemFail;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGatherData;
/*    */ import xbean.GatherItemData;
/*    */ import xbean.RoleGatherData;
/*    */ import xtable.Battlegather;
/*    */ import xtable.Role2gatherdata;
/*    */ 
/*    */ public class PStopBattleGather extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int reason;
/*    */   
/*    */   public PStopBattleGather(long roleId, int reason)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     long battleId = SingleBattleInterface.getBattleId(this.roleId, false);
/* 33 */     if (battleId <= 0L)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!RoleStatusInterface.containsStatus(this.roleId, 1516))
/*    */     {
/*    */ 
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 45 */     BattleGatherData xBattleGatherData = Battlegather.get(Long.valueOf(battleId));
/* 46 */     if (xBattleGatherData == null)
/*    */     {
/* 48 */       GameServer.logger().error(String.format("[battlegather]PStopBattleGather.processImp@ not in battle!| roleId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     RoleGatherData xRoleGatherData = Role2gatherdata.get(Long.valueOf(this.roleId));
/* 55 */     if (xRoleGatherData == null)
/*    */     {
/* 57 */       GameServer.logger().error(String.format("[battlegather]PStopBattleGather.processImp@ xRoleGatherData is null!| roleId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/*    */ 
/* 61 */       return false;
/*    */     }
/* 63 */     long instanceId = xRoleGatherData.getGatherinstanceid();
/* 64 */     if (instanceId <= 0L)
/*    */     {
/* 66 */       GameServer.logger().error(String.format("[battlegather]PStopBattleGather.processImp@ instanceId is null!| roleId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     int gatherItemCfgId = 0;
/*    */     
/* 74 */     GatherItemData xGatherItemData = (GatherItemData)xBattleGatherData.getGatheritemdatas().get(Long.valueOf(instanceId));
/* 75 */     if (xGatherItemData != null)
/*    */     {
/*    */ 
/* 78 */       xGatherItemData.setGathering(false);
/* 79 */       gatherItemCfgId = xGatherItemData.getGathercfgid();
/*    */     }
/*    */     
/* 82 */     Session.removeSession(xRoleGatherData.getGathersessionid());
/*    */     
/* 84 */     xRoleGatherData.setGatherinstanceid(0L);
/* 85 */     xRoleGatherData.setGathersessionid(0L);
/*    */     
/* 87 */     RoleStatusInterface.unsetStatus(this.roleId, 1516);
/*    */     
/*    */ 
/* 90 */     OnlineManager.getInstance().send(this.roleId, new SGatherBattleItemFail(instanceId, this.reason, gatherItemCfgId));
/*    */     
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\PStopBattleGather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */