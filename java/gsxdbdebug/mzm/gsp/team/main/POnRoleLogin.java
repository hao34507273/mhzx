/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import xbean.TeamMember;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  20 */     Long teamid = Role2team.select((Long)this.arg);
/*  21 */     if (teamid == null)
/*     */     {
/*  23 */       return false;
/*     */     }
/*  25 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*  26 */     if (xTeam == null)
/*     */     {
/*  28 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  32 */     List<Long> lockRoles = TeamManager.getMemberListByXTeam(xTeam);
/*  33 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*     */ 
/*  36 */     xTeam = xtable.Team.get(teamid);
/*     */     
/*  38 */     TeamMember xMember = TeamManager.getXMember(xTeam, ((Long)this.arg).longValue());
/*  39 */     if (xMember.getIstobeoffline())
/*     */     {
/*  41 */       xMember.setIstobeoffline(false);
/*     */ 
/*     */ 
/*     */     }
/*  45 */     else if (!TeamManager.isLeader(((Long)this.arg).longValue(), xTeam))
/*     */     {
/*     */ 
/*  48 */       if (TeamManager.getTeamMemberStatus(((Long)this.arg).longValue(), xTeam) == 2)
/*     */       {
/*  50 */         if (!TeamManager.changeMemberStatus(teamid.longValue(), xTeam, ((Long)this.arg).longValue(), 1, false))
/*     */         {
/*  52 */           return false;
/*     */         }
/*     */         
/*  55 */         TeamManager.triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, ((Long)this.arg).longValue(), 2, 1, false, false);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     TeamManager.syncTeam(teamid.longValue(), xTeam, ((Long)this.arg).longValue());
/*     */     
/*     */ 
/*  65 */     checkRoleStableState(xTeam, ((Long)this.arg).longValue());
/*     */     
/*  67 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkRoleStableState(xbean.Team xTeam, long roleId)
/*     */   {
/*  78 */     if (TeamManager.isStableTeam(xTeam).booleanValue())
/*     */     {
/*  80 */       if (isNeedInstallStableBuff(xTeam, roleId))
/*     */       {
/*  82 */         BuffInterface.installBuff(roleId, TeamManager.teamConsts.STABLE_TEAM_BUF);
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/*  87 */       BuffInterface.uninstallBuf(roleId, TeamManager.teamConsts.STABLE_TEAM_BUF);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isNeedInstallStableBuff(xbean.Team xTeam, long roleId)
/*     */   {
/*  93 */     for (TeamMember xTeamMember : xTeam.getMembers())
/*     */     {
/*  95 */       if (xTeamMember.getStatus() != 0)
/*     */       {
/*  97 */         return false;
/*     */       }
/*     */     }
/* 100 */     if (BuffInterface.isContainBuff(roleId, TeamManager.teamConsts.STABLE_TEAM_BUF))
/*     */     {
/* 102 */       return false;
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */