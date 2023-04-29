/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.achievement.confbean.SActivityAchieveDisplayCfg;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.AchievementInfo;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
/*     */ 
/*     */ public class ActivityAchievementHandler implements ActivityHandler, AchievementActivityHandler
/*     */ {
/*  22 */   private final String TLOG_GOAL_STATIS_NAME = "CarnivalGoalStatis";
/*  23 */   private final String CARINVAL_TLOG_SCORE_AWARDED_NAME = "CarnivalScoreAwarded";
/*     */   
/*     */ 
/*     */   public boolean isNeedSync(long roleId, int activityCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/*  28 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  29 */     long startTime = ActivityInterface.getActivityStartTime(activityCfgId);
/*  30 */     if (startTime > now)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     long endTime = ActivityInterface.getActivityEndTime(activityCfgId);
/*  36 */     if (now < endTime)
/*     */     {
/*  38 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  42 */     SActivityAchieveDisplayCfg activityAchieveDisplayCfg = SActivityAchieveDisplayCfg.get(activityCfgId);
/*  43 */     if (activityAchieveDisplayCfg == null)
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     int mailCfgid = activityAchieveDisplayCfg.mailCfgid;
/*  48 */     if (mailCfgid <= 0)
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     List<String> contentArgs = new ArrayList();
/*  54 */     contentArgs.add(activityAchieveDisplayCfg.name);
/*     */     
/*  56 */     for (Map.Entry<Integer, AchievementInfo> xEntry : xActivityAchievementInfo.getGoal_info().entrySet())
/*     */     {
/*  58 */       AchievementInfo xAchievementInfo = (AchievementInfo)xEntry.getValue();
/*  59 */       if (xAchievementInfo.getGoal_state() == 2)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  65 */         int goalCfgid = ((Integer)xEntry.getKey()).intValue();
/*     */         
/*     */ 
/*  68 */         NoneRealTimeTaskManager.getInstance().addTask(new PMailAchievementGoalAward(roleId, activityCfgId, goalCfgid, mailCfgid, contentArgs));
/*     */       }
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanTakePartIn(long roleId, int activityCfgId)
/*     */   {
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSwitchModule(int activityCfgId)
/*     */   {
/*  83 */     return 468;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getGoalStatisTlogName()
/*     */   {
/*  89 */     return "CarnivalGoalStatis";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getScoreAwardedTlogName()
/*     */   {
/*  95 */     return "CarnivalScoreAwarded";
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTriggerGoalFinishEvent()
/*     */   {
/* 101 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/* 107 */     return new AwardReason(mzm.gsp.tlog.LogReason.ACHIEVEMENT_ACTIVITY_JOIN);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/* 114 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/* 115 */     if (xRole2AchievementInfo == null)
/*     */     {
/* 117 */       xRole2AchievementInfo = Pod.newRole2AchievementInfo();
/* 118 */       Role2achievement.add(Long.valueOf(roleId), xRole2AchievementInfo);
/*     */     }
/*     */     
/* 121 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityid));
/*     */     
/* 123 */     if (xActivityAchievementInfo == null)
/*     */     {
/* 125 */       xActivityAchievementInfo = Pod.newActivityAchievementInfo();
/* 126 */       xRole2AchievementInfo.getActivity_achievement_info().put(Integer.valueOf(activityid), xActivityAchievementInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*     */   {
/* 133 */     return null;
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
/*     */   public boolean isCanGoalAward()
/*     */   {
/* 157 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGoalCanTakePartIn(long roleId, int activityCfgId, int goalCfgId)
/*     */   {
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\ActivityAchievementHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */