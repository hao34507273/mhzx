/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MultiRoleMounts;
/*    */ import xtable.Team2multirolemounts;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 18 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(((TeamLeaderChangedArg)this.arg).newLeader, true);
/*    */     
/*    */ 
/* 21 */     if (!TeamInterface.isTeamExit(((TeamLeaderChangedArg)this.arg).teamid, true))
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(Long.valueOf(((TeamLeaderChangedArg)this.arg).teamid));
/* 27 */     if (null == xMultiRoleMounts)
/*    */     {
/* 29 */       GameServer.logger().error(String.format("[mounts]POnTeamLeaderChanged.processImp@xMultiRoleMounts not exist!|teamId=%d", new Object[] { Long.valueOf(((TeamLeaderChangedArg)this.arg).teamid) }));
/*    */       
/*    */ 
/* 32 */       xMultiRoleMounts = MultiRoleMountsManager.newMultiRoleMounts(((TeamLeaderChangedArg)this.arg).teamid);
/*    */     }
/*    */     
/*    */ 
/* 36 */     int mountsCfgId = rideMountsObj.getMountsCfgId();
/* 37 */     if ((xMultiRoleMounts.getMounts_cfg_id() == 0) && (mountsCfgId == 0))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     xMultiRoleMounts.getRole_ids().clear();
/* 44 */     if (mountsCfgId != 0)
/*    */     {
/* 46 */       xMultiRoleMounts.getRole_ids().add(Long.valueOf(((TeamLeaderChangedArg)this.arg).newLeader));
/*    */     }
/* 48 */     xMultiRoleMounts.setMounts_cfg_id(mountsCfgId);
/*    */     
/*    */ 
/* 51 */     if (!OpenInterface.getOpenStatus(409))
/*    */     {
/* 53 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 57 */     MultiRoleMountsManager.triggerMultiRoleMountsChangeViaTeam(((TeamLeaderChangedArg)this.arg).teamid, mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.TEAM_INFO_CHANGE);
/*    */     
/*    */ 
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */