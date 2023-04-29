/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.TeamMember;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ import xtable.Role2qingyuan;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     Set<Long> roleIdSet = new HashSet();
/* 19 */     Set<String> userIdSet = new HashSet();
/*    */     
/* 21 */     for (TeamMember teamMember : ((TeamMemberStatusChangedArg)this.arg).teamMembers)
/*    */     {
/* 23 */       roleIdSet.add(Long.valueOf(teamMember.roleid));
/* 24 */       userIdSet.add(RoleInterface.getUserId(teamMember.roleid));
/*    */     }
/*    */     
/*    */ 
/* 28 */     lock(User.getTable(), userIdSet);
/* 29 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/*    */     
/*    */ 
/* 32 */     Set<Long> uninstallBuffRoleIdSet = new HashSet();
/*    */     
/*    */ 
/* 35 */     Role2QingYuanInfo xRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid));
/*    */     List<Long> xQingYuanRoleIdList;
/* 37 */     if ((((TeamMemberStatusChangedArg)this.arg).oldStatus == 0) && (xRole2QingYuanInfo != null))
/*    */     {
/* 39 */       xQingYuanRoleIdList = xRole2QingYuanInfo.getQing_yuan_role_list();
/*    */       
/* 41 */       for (TeamMember teamMember : ((TeamMemberStatusChangedArg)this.arg).teamMembers)
/*    */       {
/* 43 */         long memberRoleId = teamMember.roleid;
/* 44 */         if (xQingYuanRoleIdList.contains(Long.valueOf(memberRoleId)))
/*    */         {
/* 46 */           uninstallBuffRoleIdSet.add(Long.valueOf(memberRoleId));
/* 47 */           uninstallBuffRoleIdSet.add(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 52 */     QingYuanManager.updateQingYuanTeamBuff(uninstallBuffRoleIdSet, ((TeamMemberStatusChangedArg)this.arg).teamMembers);
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */