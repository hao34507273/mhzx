/*     */ package mzm.gsp.hula.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.ActivityTeamHandler;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HulaPrepareTeamHandler
/*     */   implements JoinTeamCheckHandler, ActivityTeamHandler
/*     */ {
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  27 */     JoinTeamResult result = new JoinTeamResult();
/*  28 */     if ((!ActivityInterface.isInActivityLevel(RoleInterface.getUserId(roleId), roleId, SHulaCfgConsts.getInstance().ACTIVITY_ID)) || (!RoleStatusInterface.checkCanSetStatus(roleId, 450, true)))
/*     */     {
/*     */ 
/*     */ 
/*  32 */       result.setSucceed(false); }
/*  33 */     switch (joinTeamType)
/*     */     {
/*     */ 
/*     */     case JOIN_TEAM__INVITE: 
/*  37 */       HulaManager.sendErrorInfo(roleId, 2);
/*     */       
/*  39 */       break;
/*     */     
/*     */     case JOIN_TEAM__APPLY: 
/*  42 */       HulaManager.sendErrorInfo(teamInfo.getLeaderId(), 2);
/*     */       
/*  44 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case JOIN_TEAM__PLATFORM: 
/*     */       break;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     default: 
/*  58 */       break;result.setSucceed(true);
/*     */     }
/*     */     
/*  61 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  68 */     ReturnTeamResult result = new ReturnTeamResult();
/*  69 */     if ((!ActivityInterface.isInActivityLevel(RoleInterface.getUserId(roleId), roleId, SHulaCfgConsts.getInstance().ACTIVITY_ID)) || (!RoleStatusInterface.checkCanSetStatus(roleId, 450, true)))
/*     */     {
/*     */ 
/*     */ 
/*  73 */       result.setSucceed(false);
/*     */     }
/*     */     else
/*     */     {
/*  77 */       result.setSucceed(true);
/*     */     }
/*     */     
/*  80 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> findTeams(long roleId, long worldId)
/*     */   {
/*  87 */     if (worldId != HulaWorldManager.getInstance().getPrepareWorldId())
/*     */     {
/*  89 */       return new ArrayList();
/*     */     }
/*  91 */     return MapInterface.getAllTeamInWorld(worldId);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> findMembers(long roleId, long worldId)
/*     */   {
/*  97 */     if (worldId != HulaWorldManager.getInstance().getPrepareWorldId())
/*     */     {
/*  99 */       return new ArrayList();
/*     */     }
/* 101 */     return MapInterface.getAllSingleRoleInWorld(worldId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaPrepareTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */