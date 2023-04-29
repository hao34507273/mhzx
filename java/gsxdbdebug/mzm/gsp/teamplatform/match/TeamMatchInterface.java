/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.STeamPlatformMomCfg;
/*     */ import mzm.gsp.team.confbean.TeamPlatformConsts;
/*     */ import mzm.gsp.teamplatform.SRoleMatchSuc;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.MatchKey;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamMatchInterface
/*     */ {
/*     */   public static RoleMatchInfo getRoleTeamMatchInfo(long roleId, boolean isRemainMatchLock)
/*     */   {
/*  29 */     RoleMatchInfo roleMatchInfo = new RoleMatchInfo(roleId, isRemainMatchLock);
/*  30 */     if (!roleMatchInfo.inMatchQueue())
/*     */     {
/*  32 */       return null;
/*     */     }
/*  34 */     return roleMatchInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static STeamPlatformMomCfg getMatchCfg(int matchCfgId)
/*     */   {
/*  45 */     return STeamPlatformMomCfg.get(matchCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void sendRoleMatchSucPro(long roleId, long teamLeaderId)
/*     */   {
/*  57 */     SRoleMatchSuc sRoleMatchSuc = new SRoleMatchSuc();
/*  58 */     RoleInterface.fillRoleInfo(teamLeaderId, sRoleMatchSuc.teamleaderinfo);
/*  59 */     OnlineManager.getInstance().send(roleId, sRoleMatchSuc);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<RoleActivityCfg> getRoleMatchActivtys(long roleId)
/*     */   {
/*  72 */     List<RoleActivityCfg> activityCfgs = new ArrayList();
/*     */     
/*  74 */     MatchActivityCfg matchActivityCfgBean = TeamMatchMananger.getRoleActivity(roleId, false);
/*  75 */     if ((matchActivityCfgBean == null) || (matchActivityCfgBean.getActivity() == null))
/*     */     {
/*  77 */       return activityCfgs;
/*     */     }
/*  79 */     RoleActivityCfg activity = new RoleActivityCfg(matchActivityCfgBean.getActivity().getActivityid(), matchActivityCfgBean.getActivity().getIndex());
/*     */     
/*  81 */     activityCfgs.add(activity);
/*  82 */     return activityCfgs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isNewGuyToLeader(long leaderId, long roleId, int momCfgId, int index)
/*     */   {
/* 102 */     List<Integer> newGuyRange = getRoleNewGuyRange(momCfgId, index, leaderId);
/* 103 */     if ((newGuyRange == null) || (newGuyRange.size() != 2))
/*     */     {
/* 105 */       return false;
/*     */     }
/* 107 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 108 */     if ((roleLevel >= ((Integer)newGuyRange.get(0)).intValue()) && (roleLevel <= ((Integer)newGuyRange.get(1)).intValue()))
/*     */     {
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getRoleNewGuyRange(int momCfgId, int index, long roleId)
/*     */   {
/* 130 */     STeamPlatformMomCfg cfg = STeamPlatformMomCfg.get(momCfgId);
/* 131 */     if ((cfg == null) || (cfg.matchType != 2))
/*     */     {
/* 133 */       return new ArrayList();
/*     */     }
/* 135 */     return TeamMatchMananger.activityHand(index, 0, 0, new ArrayList(), cfg, RoleInterface.getLevel(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getNewGuyLevelDiff()
/*     */   {
/* 147 */     return TeamPlatformConsts.getInstance().NEW_GUY_LEVEL__DIFF;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\TeamMatchInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */