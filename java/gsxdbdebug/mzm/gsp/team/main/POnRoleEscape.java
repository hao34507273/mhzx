/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.fight.event.RoleEscapeProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class POnRoleEscape extends RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     Long escapeRoleId = Long.valueOf(((RoleEscapeArg)this.arg).roleid);
/* 15 */     Long teamid = Role2team.select(escapeRoleId);
/* 16 */     if (teamid == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*    */     
/* 22 */     Set<Long> lockRoles = new java.util.HashSet();
/* 23 */     lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*    */     
/*    */ 
/* 26 */     lock(xtable.Basic.getTable(), lockRoles);
/*    */     
/* 28 */     xTeam = xtable.Team.get(teamid);
/*    */     
/* 30 */     if (!TeamManager.escapedRoleProc(teamid, xTeam, escapeRoleId.longValue()))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (!checkIsOffLine(escapeRoleId, teamid, xTeam))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean checkIsOffLine(Long escapeRoleId, Long teamid, xbean.Team xTeam)
/*    */   {
/* 50 */     TeamMember escapedMember = TeamManager.getXMember(xTeam, escapeRoleId.longValue());
/* 51 */     if (escapedMember == null)
/*    */     {
/* 53 */       return true;
/*    */     }
/* 55 */     int oldStatus = escapedMember.getStatus();
/* 56 */     if (escapedMember.getIstobeoffline())
/*    */     {
/* 58 */       escapedMember.setIstobeoffline(false);
/*    */       
/* 60 */       if (OnlineManager.getInstance().isOfflineAfterProtect(escapeRoleId.longValue()))
/*    */       {
/*    */ 
/* 63 */         if (!TeamManager.changeMemberStatus(teamid.longValue(), xTeam, escapeRoleId.longValue(), 2, false))
/*    */         {
/* 65 */           return false;
/*    */         }
/*    */         
/* 68 */         TeamManager.triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, escapeRoleId.longValue(), oldStatus, 2, false, false);
/*    */       }
/*    */     }
/*    */     
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */