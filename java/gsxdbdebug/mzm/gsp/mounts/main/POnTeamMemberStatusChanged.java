/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MultiRoleMounts;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 20 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((TeamMemberStatusChangedArg)this.arg).getNowLeaderId()), Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid) }));
/* 21 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(((TeamMemberStatusChangedArg)this.arg).getNowLeaderId(), true);
/*    */     
/*    */ 
/* 24 */     if (!TeamInterface.isTeamExit(((TeamMemberStatusChangedArg)this.arg).teamid, true))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     MultiRoleMounts xMultiRoleMounts = xtable.Team2multirolemounts.get(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).teamid));
/* 30 */     if (null == xMultiRoleMounts)
/*    */     {
/*    */ 
/* 33 */       GameServer.logger().error(String.format("[mounts]POnTeamMemberStatusChanged.processImp@xMultiRoleMounts not exist!|teamId=%d", new Object[] { Long.valueOf(((TeamMemberStatusChangedArg)this.arg).teamid) }));
/*    */       
/*    */ 
/* 36 */       xMultiRoleMounts = MultiRoleMountsManager.newMultiRoleMounts(((TeamMemberStatusChangedArg)this.arg).teamid);
/*    */     }
/*    */     
/*    */ 
/* 40 */     int mountsCfgId = rideMountsObj.getMountsCfgId();
/* 41 */     if ((xMultiRoleMounts.getMounts_cfg_id() == 0) && (mountsCfgId == 0))
/*    */     {
/* 43 */       return true;
/*    */     }
/*    */     
/*    */     boolean isChanged;
/*    */     boolean isChanged;
/* 48 */     if (((TeamMemberStatusChangedArg)this.arg).leaderChange)
/*    */     {
/* 50 */       xMultiRoleMounts.getRole_ids().clear();
/* 51 */       if (mountsCfgId != 0)
/*    */       {
/* 53 */         xMultiRoleMounts.getRole_ids().add(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).getNowLeaderId()));
/*    */       }
/* 55 */       xMultiRoleMounts.setMounts_cfg_id(mountsCfgId);
/* 56 */       isChanged = true;
/*    */     }
/*    */     else {
/*    */       boolean isChanged;
/* 60 */       if ((((TeamMemberStatusChangedArg)this.arg).isTempLeave()) || (((TeamMemberStatusChangedArg)this.arg).isOffline()))
/*    */       {
/* 62 */         isChanged = MultiRoleMountsManager.removeUnmountRole(xMultiRoleMounts, ((TeamMemberStatusChangedArg)this.arg).roleid);
/*    */       }
/*    */       else
/*    */       {
/* 66 */         isChanged = false;
/*    */       }
/*    */     }
/*    */     
/* 70 */     if (!OpenInterface.getOpenStatus(409))
/*    */     {
/* 72 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 76 */     if (!RoleStatusInterface.checkCanSetStatus(((TeamMemberStatusChangedArg)this.arg).roleid, 1051, true))
/*    */     {
/* 78 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 82 */     if (isChanged)
/*    */     {
/*    */ 
/* 85 */       MultiRoleMountsManager.triggerMultiRoleMountsChangeViaTeam(((TeamMemberStatusChangedArg)this.arg).teamid, mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.TEAM_INFO_CHANGE);
/*    */     }
/*    */     
/*    */ 
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */