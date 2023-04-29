/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.singlebattle.SGrapPositionFail;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BattleGrabData;
/*    */ import xbean.GrabPositionData;
/*    */ import xbean.RoleGrabData;
/*    */ import xbean.RoleGrabSessions;
/*    */ import xtable.Grabposition;
/*    */ import xtable.Role2rolegrabdata;
/*    */ 
/*    */ public class PStopGrab extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int reason;
/*    */   
/*    */   public PStopGrab(long roleId, int reason)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     long battleId = SingleBattleInterface.getBattleId(this.roleId, false);
/* 34 */     if (battleId <= 0L)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!RoleStatusInterface.containsStatus(this.roleId, 1514))
/*    */     {
/*    */ 
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     BattleGrabData xBattleGrabData = Grabposition.get(Long.valueOf(battleId));
/* 45 */     if (xBattleGrabData == null)
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[grab]PStopGrab.processImp@ no grab position data! | roleId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     RoleGrabData xRoleGrabData = Role2rolegrabdata.get(Long.valueOf(this.roleId));
/* 54 */     if (xRoleGrabData == null)
/*    */     {
/* 56 */       GameServer.logger().error(String.format("[grab]PStopGrab.processImp@ no grab role data!| roleId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.reason) }));
/*    */       
/* 58 */       return false;
/*    */     }
/* 60 */     int positionId = xRoleGrabData.getGrabpositionid();
/* 61 */     if (positionId <= 0)
/*    */     {
/* 63 */       GameServer.logger().error(String.format("[grab]PStopGrab.processImp@ not grabing!| roleId=%d|reason=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.reason), Long.valueOf(battleId) }));
/*    */       
/*    */ 
/* 66 */       return false;
/*    */     }
/* 68 */     GrabPositionData xGrabPositionData = (GrabPositionData)xBattleGrabData.getPositiondatas().get(Integer.valueOf(positionId));
/* 69 */     if (xGrabPositionData == null)
/*    */     {
/* 71 */       GameServer.logger().error(String.format("[grab]PStopGrab.processImp@ not position data!| roleId=%d|reason=%d|battleId=%d|positionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.reason), Long.valueOf(battleId), Integer.valueOf(positionId) }));
/*    */       
/*    */ 
/*    */ 
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     if (xGrabPositionData.getState() == 2)
/*    */     {
/* 80 */       GrabPositionManager.setPositionState(battleId, xGrabPositionData, 1, positionId);
/*    */     }
/*    */     else
/*    */     {
/* 84 */       GameServer.logger().error(String.format("[grab]PStopGrab.processImp@ not in grabing state| roleId=%d|reason=%d|battleId=%d|positionId=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.reason), Long.valueOf(battleId), Integer.valueOf(positionId), Integer.valueOf(xGrabPositionData.getState()) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 90 */     xRoleGrabData.setGrabpositionid(0);
/* 91 */     xGrabPositionData.setGrabingroleid(0L);
/* 92 */     RoleStatusInterface.unsetStatus(this.roleId, 1514);
/*    */     
/* 94 */     Session.removeSession(xRoleGrabData.getSessiondata().getGrabsessionid());
/* 95 */     xRoleGrabData.getSessiondata().setGrabsessionid(0L);
/*    */     
/* 97 */     OnlineManager.getInstance().send(this.roleId, new SGrapPositionFail(positionId, this.reason));
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\PStopGrab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */