/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MultiRoleMounts;
/*    */ import xtable.Basic;
/*    */ import xtable.Team2multirolemounts;
/*    */ 
/*    */ public class POnJoinTeam
/*    */   extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 22 */     if (!OpenInterface.getOpenStatus(409))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     if (!RoleStatusInterface.checkCanSetStatus(((JoinTeamArg)this.arg).member.roleid, 1050, true))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     lock(Basic.getTable(), Collections.singletonList(Long.valueOf(((JoinTeamArg)this.arg).leaderid)));
/*    */     
/*    */ 
/* 37 */     if (!TeamInterface.isTeamExit(((JoinTeamArg)this.arg).teamid, true))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(Long.valueOf(((JoinTeamArg)this.arg).teamid));
/* 43 */     if (null == xMultiRoleMounts)
/*    */     {
/*    */ 
/* 46 */       GameServer.logger().error(String.format("[mounts]POnJoinTeam.processImp@xMultiRoleMounts not exist!|teamId=%d", new Object[] { Long.valueOf(((JoinTeamArg)this.arg).teamid) }));
/*    */       
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 52 */     MultiRoleMountsManager.AddMountRoleResult addResult = MultiRoleMountsManager.addMountRole(xMultiRoleMounts, ((JoinTeamArg)this.arg).leaderid, ((JoinTeamArg)this.arg).member.roleid);
/*    */     
/*    */ 
/* 55 */     if ((!addResult.success) && (addResult.failReason == MultiRoleMountsManager.AddMountRoleResult.FailReason.ALREADY_RIDE))
/*    */     {
/* 57 */       GameServer.logger().error(String.format("[mounts]POnJoinTeam.processImp@role already ride when join team!?|teamId=%d,roleId=%d", new Object[] { Long.valueOf(((JoinTeamArg)this.arg).teamid), Long.valueOf(((JoinTeamArg)this.arg).member.roleid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 63 */     if (addResult.success)
/*    */     {
/*    */ 
/* 66 */       MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(((JoinTeamArg)this.arg).leaderid, true);
/* 67 */       int mountsCfgId = rideMountsObj.getMountsCfgId();
/* 68 */       MultiRoleMountsManager.triggerMultiRoleMountsChangeViaTeam(((JoinTeamArg)this.arg).teamid, mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.TEAM_INFO_CHANGE);
/*    */     }
/*    */     
/*    */ 
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */