/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.GraphBean;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamCreate
/*    */   extends TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     long teamId = ((TeamCreateArg)this.arg).teamid;
/* 27 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, false);
/* 28 */     if (teamInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     Set<Long> lockRoles = new HashSet(teamInfo.getTeamMemberList());
/*    */     
/*    */ 
/* 35 */     List<String> lockUsers = new ArrayList();
/* 36 */     for (Iterator i$ = lockRoles.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 38 */       lockUsers.add(RoleInterface.getUserId(tmpRoleId));
/*    */     }
/* 40 */     lock(User.getTable(), lockUsers);
/* 41 */     lock(Basic.getTable(), lockRoles);
/* 42 */     teamInfo = TeamInterface.getTeamInfo(teamId, true);
/* 43 */     if (teamInfo == null)
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     List<Long> members = teamInfo.getTeamMemberList();
/*    */     
/* 49 */     if (members.size() <= 1)
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     RoleTaskManager.updateTeamCon(members);
/*    */     
/* 56 */     long leaderId = teamInfo.getLeaderId();
/* 57 */     RoleTask leaderTask = RoleTaskManager.getRoleTask(leaderId, true);
/* 58 */     if (leaderTask.getTaskDataBean() == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     Map<Integer, GraphBean> teamGraphBeans = leaderTask.getAllTeamGraph();
/* 63 */     if ((teamGraphBeans == null) || (teamGraphBeans.size() == 0))
/*    */     {
/* 65 */       return true;
/*    */     }
/*    */     
/* 68 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/* 69 */     if (normalMembers.size() <= 1)
/*    */     {
/* 71 */       return true;
/*    */     }
/* 73 */     for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 75 */       if (roleId != leaderId)
/*    */       {
/*    */ 
/*    */ 
/* 79 */         RoleTaskManager.copyTeamGraphsTaskto(roleId, teamGraphBeans);
/*    */       }
/*    */     }
/*    */     
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */