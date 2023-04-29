/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseAchievementCfg;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseActivityCfg;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.task.surprise.SurpriseTaskManager;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
/*     */ 
/*     */ 
/*     */ public class SurpriseActivityHandler
/*     */   implements ActivityHandler, AchievementActivityHandler
/*     */ {
/*  21 */   private final String CARNIVAL_TLOG_GOAL_STATIS_NAME = "CarnivalGoalStatis";
/*  22 */   private final String CARINVAL_TLOG_SCORE_AWARDED_NAME = "CarnivalScoreAwarded";
/*     */   
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  27 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*  28 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  30 */       xRole2AchievementInfo = Pod.newRole2AchievementInfo();
/*  31 */       Role2achievement.add(Long.valueOf(roleId), xRole2AchievementInfo);
/*     */     }
/*     */     
/*  34 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityid));
/*     */     
/*  36 */     if (xActivityAchievementInfo == null)
/*     */     {
/*  38 */       xActivityAchievementInfo = Pod.newActivityAchievementInfo();
/*  39 */       xRole2AchievementInfo.getActivity_achievement_info().put(Integer.valueOf(activityid), xActivityAchievementInfo);
/*     */     }
/*  41 */     xActivityAchievementInfo.getActivity_parameters_extra().put(Long.valueOf(1L), String.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  48 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  54 */     return null;
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
/*  78 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanTakePartIn(long roleId, int activityId)
/*     */   {
/*  84 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSwitchModule(int activityId)
/*     */   {
/*  90 */     SSurpriseActivityCfg cfg = SSurpriseActivityCfg.get(activityId);
/*  91 */     if (cfg == null)
/*     */     {
/*  93 */       return -1;
/*     */     }
/*  95 */     return cfg.switchid;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getGoalStatisTlogName()
/*     */   {
/* 101 */     return "CarnivalGoalStatis";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getScoreAwardedTlogName()
/*     */   {
/* 107 */     return "CarnivalScoreAwarded";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isTriggerGoalFinishEvent()
/*     */   {
/* 114 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanGoalAward()
/*     */   {
/* 120 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGoalCanTakePartIn(long roleId, int activityCfgId, int goalCfgId)
/*     */   {
/* 126 */     SSurpriseAchievementCfg cfg = SSurpriseAchievementCfg.get(goalCfgId);
/* 127 */     if (cfg == null)
/*     */     {
/* 129 */       return false;
/*     */     }
/* 131 */     if (!SurpriseTaskManager.isServerlevelValid(cfg.joinServerLevel, cfg.needServerLevelTime))
/*     */     {
/* 133 */       return false;
/*     */     }
/* 135 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\SurpriseActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */