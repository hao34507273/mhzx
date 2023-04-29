/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Role2qingyuan;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnJoinTeam extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long roleId = ((JoinTeamArg)this.arg).member.roleid;
/*    */     
/* 23 */     if (((JoinTeamArg)this.arg).member.status != 0)
/*    */     {
/* 25 */       return true;
/*    */     }
/*    */     
/* 28 */     List<Long> xQingYuanRoleIdList = Role2qingyuan.selectQing_yuan_role_list(Long.valueOf(roleId));
/*    */     
/* 30 */     if (xQingYuanRoleIdList == null)
/*    */     {
/* 32 */       return true;
/*    */     }
/*    */     
/* 35 */     List<Long> normalRoleList = TeamInterface.getNormalRoleList(roleId);
/* 36 */     Set<Long> needInstallBuffRoleIdSet = new HashSet();
/* 37 */     for (Iterator i$ = normalRoleList.iterator(); i$.hasNext();) { long teamRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       if (xQingYuanRoleIdList.contains(Long.valueOf(teamRoleId)))
/*    */       {
/* 41 */         needInstallBuffRoleIdSet.add(Long.valueOf(roleId));
/* 42 */         needInstallBuffRoleIdSet.add(Long.valueOf(teamRoleId));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 47 */     if (needInstallBuffRoleIdSet.isEmpty())
/*    */     {
/* 49 */       return true;
/*    */     }
/*    */     
/* 52 */     Set<String> userIdSet = new HashSet();
/* 53 */     for (Iterator i$ = needInstallBuffRoleIdSet.iterator(); i$.hasNext();) { long needInstallBuffRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 55 */       userIdSet.add(RoleInterface.getUserId(needInstallBuffRoleId));
/*    */     }
/*    */     
/*    */ 
/* 59 */     lock(User.getTable(), userIdSet);
/*    */     
/* 61 */     lock(xtable.Role2properties.getTable(), needInstallBuffRoleIdSet);
/*    */     
/* 63 */     for (Iterator i$ = needInstallBuffRoleIdSet.iterator(); i$.hasNext();) { long needInstallBuffRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 65 */       BuffInterface.installBuff(needInstallBuffRoleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*    */     }
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */