/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleId = ((TeamMemberStatusChangedArg)this.arg).roleid;
/* 20 */     long teamId = ((TeamMemberStatusChangedArg)this.arg).teamid;
/* 21 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, false);
/* 22 */     if (teamInfo == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     Set<Long> lockRoles = new java.util.HashSet(teamInfo.getTeamMemberList());
/* 27 */     if (!lockRoles.contains(Long.valueOf(roleId)))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     List<String> lockUsers = new ArrayList();
/* 34 */     for (Iterator i$ = lockRoles.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 36 */       lockUsers.add(RoleInterface.getUserId(tmpRoleId));
/*    */     }
/* 38 */     lock(User.getTable(), lockUsers);
/* 39 */     lock(Basic.getTable(), lockRoles);
/* 40 */     teamInfo = TeamInterface.getTeamInfo(teamId, true);
/* 41 */     if (teamInfo == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     List<Long> members = teamInfo.getTeamMemberList();
/* 46 */     if (!members.contains(Long.valueOf(roleId)))
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (teamInfo.getMemberStatus(roleId) == 0)
/*    */     {
/* 53 */       long leaderId = teamInfo.getLeaderId();
/* 54 */       RoleTask leaderTask = RoleTaskManager.getRoleTask(leaderId, true);
/* 55 */       RoleTaskManager.copyRoleTeamTaskTo(roleId, leaderTask);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 60 */       RoleTaskManager.remTeamGraph(((TeamMemberStatusChangedArg)this.arg).roleid);
/*    */     }
/*    */     
/* 63 */     RoleTaskManager.updateTeamCon(members);
/*    */     
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */