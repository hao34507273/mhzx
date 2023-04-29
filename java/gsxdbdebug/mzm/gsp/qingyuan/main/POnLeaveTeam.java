/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.TeamMember;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnLeaveTeam extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     Set<Long> roleIdSet = new HashSet();
/* 18 */     Set<String> userIdSet = new HashSet();
/*    */     
/* 20 */     for (TeamMember teamMember : ((LeaveTeamArg)this.arg).teamMembers)
/*    */     {
/* 22 */       roleIdSet.add(Long.valueOf(teamMember.roleid));
/* 23 */       userIdSet.add(RoleInterface.getUserId(teamMember.roleid));
/*    */     }
/* 25 */     roleIdSet.add(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 26 */     userIdSet.add(RoleInterface.getUserId(((LeaveTeamArg)this.arg).roleid));
/*    */     
/*    */ 
/* 29 */     lock(User.getTable(), userIdSet);
/* 30 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/*    */     
/*    */ 
/* 33 */     Set<Long> uninstallBuffRoleIdSet = new HashSet();
/*    */     
/* 35 */     Role2QingYuanInfo xRole2QingYuanInfo = xtable.Role2qingyuan.get(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 36 */     List<Long> xleaveRoleQingYuanRoleList; if (xRole2QingYuanInfo != null)
/*    */     {
/* 38 */       xleaveRoleQingYuanRoleList = xRole2QingYuanInfo.getQing_yuan_role_list();
/* 39 */       for (TeamMember teamMember : ((LeaveTeamArg)this.arg).teamMembers)
/*    */       {
/* 41 */         long teamMemberRoleId = teamMember.roleid;
/* 42 */         if (xleaveRoleQingYuanRoleList.contains(Long.valueOf(teamMemberRoleId)))
/*    */         {
/* 44 */           uninstallBuffRoleIdSet.add(Long.valueOf(teamMemberRoleId));
/* 45 */           uninstallBuffRoleIdSet.add(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 50 */     QingYuanManager.updateQingYuanTeamBuff(uninstallBuffRoleIdSet, ((LeaveTeamArg)this.arg).teamMembers);
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */