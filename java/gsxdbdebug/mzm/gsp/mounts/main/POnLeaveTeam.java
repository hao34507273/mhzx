/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MultiRoleMounts;
/*    */ import xtable.Basic;
/*    */ import xtable.Team2multirolemounts;
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 22 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((LeaveTeamArg)this.arg).getNowLeaderId()), Long.valueOf(((LeaveTeamArg)this.arg).roleid) }));
/*    */     
/* 24 */     if (!TeamInterface.isTeamExit(((LeaveTeamArg)this.arg).teamid, true))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(Long.valueOf(((LeaveTeamArg)this.arg).teamid));
/* 30 */     if (null == xMultiRoleMounts)
/*    */     {
/*    */ 
/* 33 */       GameServer.logger().error(String.format("[mounts]POnLeaveTeam.processImp@xMultiRoleMounts not exist!|teamId=%d", new Object[] { Long.valueOf(((LeaveTeamArg)this.arg).teamid) }));
/*    */       
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(((LeaveTeamArg)this.arg).getNowLeaderId(), true);
/*    */     
/* 41 */     int nowLeaderMountsCfgId = rideMountsObj.getMountsCfgId();
/* 42 */     if ((nowLeaderMountsCfgId == 0) && (xMultiRoleMounts.getMounts_cfg_id() == 0))
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     boolean roleIdsChanged;
/*    */     boolean roleIdsChanged;
/* 48 */     if (((LeaveTeamArg)this.arg).leaderChange)
/*    */     {
/*    */ 
/* 51 */       xMultiRoleMounts.getRole_ids().clear();
/*    */       
/* 53 */       if (nowLeaderMountsCfgId != 0)
/*    */       {
/* 55 */         xMultiRoleMounts.getRole_ids().add(Long.valueOf(((LeaveTeamArg)this.arg).getNowLeaderId()));
/*    */       }
/* 57 */       xMultiRoleMounts.setMounts_cfg_id(nowLeaderMountsCfgId);
/* 58 */       roleIdsChanged = true;
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 63 */       roleIdsChanged = MultiRoleMountsManager.removeUnmountRole(xMultiRoleMounts, ((LeaveTeamArg)this.arg).roleid);
/*    */     }
/*    */     
/*    */ 
/* 67 */     if (!OpenInterface.getOpenStatus(409))
/*    */     {
/* 69 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 73 */     if (!RoleStatusInterface.checkCanSetStatus(((LeaveTeamArg)this.arg).roleid, 1051, true))
/*    */     {
/* 75 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 79 */     if (roleIdsChanged)
/*    */     {
/*    */ 
/* 82 */       MultiRoleMountsManager.triggerMultiRoleMountsChangeViaTeam(((LeaveTeamArg)this.arg).teamid, nowLeaderMountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.TEAM_INFO_CHANGE);
/*    */     }
/*    */     
/*    */ 
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */