/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.achievement.confbean.SCarnivalConsts;
/*     */ import mzm.gsp.achievement.event.AchievementMailAwardArg;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
/*     */ 
/*     */ public class CarnivalActivityHandler implements ActivityHandler, AchievementActivityHandler
/*     */ {
/*  18 */   private final String CARNIVAL_TLOG_GOAL_STATIS_NAME = "CarnivalGoalStatis";
/*  19 */   private final String CARINVAL_TLOG_SCORE_AWARDED_NAME = "CarnivalScoreAwarded";
/*     */   
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  24 */     long leftTime = getLeftTime(roleId);
/*  25 */     boolean isCanTakePartIn = leftTime > 0L;
/*     */     
/*  27 */     if (!isCanTakePartIn)
/*     */     {
/*  29 */       return;
/*     */     }
/*  31 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*  32 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  34 */       xRole2AchievementInfo = Pod.newRole2AchievementInfo();
/*  35 */       Role2achievement.add(Long.valueOf(roleId), xRole2AchievementInfo);
/*     */     }
/*     */     
/*  38 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityid));
/*     */     
/*  40 */     if (xActivityAchievementInfo == null)
/*     */     {
/*  42 */       xActivityAchievementInfo = Pod.newActivityAchievementInfo();
/*  43 */       xRole2AchievementInfo.getActivity_achievement_info().put(Integer.valueOf(activityid), xActivityAchievementInfo);
/*     */     }
/*  45 */     xActivityAchievementInfo.getActivity_parameters_extra().put(Long.valueOf(1L), String.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*     */   {
/*  52 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<ActivityStage> getActivityStages()
/*     */   {
/*  58 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNeedSync(long roleId, int activityCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/*  82 */     long leftTime = getLeftTime(roleId);
/*     */     
/*  84 */     String awardState = (String)xActivityAchievementInfo.getActivity_parameters_extra().get(Long.valueOf(1L));
/*     */     
/*     */ 
/*  87 */     if ((awardState != null) && (awardState.equals(String.valueOf(0))))
/*     */     {
/*  89 */       AchievementManager.triggerActivityFinishMailAward(new AchievementMailAwardArg(roleId, leftTime > 0L ? leftTime : 0L, SCarnivalConsts.getInstance().carnivalActivityId, SCarnivalConsts.getInstance().mailId));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */     return leftTime > 0L;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanTakePartIn(long roleId, int activityCfgId)
/*     */   {
/* 102 */     return getLeftTime(roleId) > 0L;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSwitchModule(int activityCfgId)
/*     */   {
/* 108 */     return 117;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private long getLeftTime(long roleId)
/*     */   {
/* 116 */     long activityOpenTime = RoleInterface.getRoleCreateTime(roleId);
/* 117 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 119 */     long serviceTime = SCarnivalConsts.getInstance().lastTime * 86400000L;
/* 120 */     long elapsedTime = currentTimeMillis - activityOpenTime;
/*     */     
/* 122 */     long leftTime = (serviceTime - elapsedTime) / 1000L;
/* 123 */     return leftTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getGoalStatisTlogName()
/*     */   {
/* 129 */     return "CarnivalGoalStatis";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getScoreAwardedTlogName()
/*     */   {
/* 135 */     return "CarnivalScoreAwarded";
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTriggerGoalFinishEvent()
/*     */   {
/* 141 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanGoalAward()
/*     */   {
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGoalCanTakePartIn(long roleId, int activityCfgId, int goalCfgId)
/*     */   {
/* 153 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\CarnivalActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */