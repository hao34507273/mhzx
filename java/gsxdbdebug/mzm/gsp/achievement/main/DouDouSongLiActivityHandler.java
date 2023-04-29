/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.achievement.confbean.DouDouSongLiConsts;
/*     */ import mzm.gsp.achievement.event.AchievementMailAwardArg;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
/*     */ 
/*     */ public class DouDouSongLiActivityHandler implements mzm.gsp.activity.main.ActivityHandler, AchievementActivityHandler
/*     */ {
/*     */   private final String CARNIVAL_TLOG_GOAL_STATIS_NAME = "CarnivalGoalStatis";
/*     */   private final String CARINVAL_TLOG_SCORE_AWARDED_NAME = "CarnivalScoreAwarded";
/*     */   
/*     */   public DouDouSongLiActivityHandler()
/*     */   {
/*  24 */     this.CARNIVAL_TLOG_GOAL_STATIS_NAME = "CarnivalGoalStatis";
/*  25 */     this.CARINVAL_TLOG_SCORE_AWARDED_NAME = "CarnivalScoreAwarded";
/*     */   }
/*     */   
/*     */   public boolean isNeedSync(long roleId, int activityCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/*  30 */     long leftTime = getLeftTimeInSeconds();
/*     */     
/*  32 */     String awardState = (String)xActivityAchievementInfo.getActivity_parameters_extra().get(Long.valueOf(1L));
/*     */     
/*     */ 
/*  35 */     if ((awardState != null) && (awardState.equals(String.valueOf(0))) && (GameServerInfoManager.getOpenServerTimestamp() != 0L))
/*     */     {
/*     */ 
/*  38 */       AchievementManager.triggerActivityFinishMailAward(new AchievementMailAwardArg(roleId, leftTime > 0L ? leftTime : 0L, DouDouSongLiConsts.getInstance().activityId, DouDouSongLiConsts.getInstance().mailId));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  45 */     return isCanTakePartIn(roleId, activityCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isActivityOpen()
/*     */   {
/*  55 */     return (GameServerInfoManager.getOpenServerTimestamp() == 0L) || (getLeftTimeInSeconds() > 0L);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanTakePartIn(long roleId, int activityCfgId)
/*     */   {
/*  61 */     return (checkRoleLevel(roleId)) && (isActivityOpen());
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSwitchModule(int activityCfgId)
/*     */   {
/*  67 */     return 436;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getGoalStatisTlogName()
/*     */   {
/*  73 */     return "CarnivalGoalStatis";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getScoreAwardedTlogName()
/*     */   {
/*  79 */     return "CarnivalScoreAwarded";
/*     */   }
/*     */   
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  85 */     if (!isActivityOpen())
/*     */     {
/*  87 */       return;
/*     */     }
/*     */     
/*     */ 
/*  91 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*  92 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  94 */       xRole2AchievementInfo = Pod.newRole2AchievementInfo();
/*  95 */       Role2achievement.add(Long.valueOf(roleId), xRole2AchievementInfo);
/*     */     }
/*     */     
/*  98 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityid));
/*     */     
/* 100 */     if (xActivityAchievementInfo == null)
/*     */     {
/* 102 */       xActivityAchievementInfo = Pod.newActivityAchievementInfo();
/* 103 */       xRole2AchievementInfo.getActivity_achievement_info().put(Integer.valueOf(activityid), xActivityAchievementInfo);
/*     */     }
/* 105 */     xActivityAchievementInfo.getActivity_parameters_extra().put(Long.valueOf(1L), String.valueOf(0));
/*     */     
/*     */ 
/*     */ 
/* 109 */     new DouDouSongLiFixAndSynInfo(roleId, activityid).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/* 115 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*     */   {
/* 121 */     return null;
/*     */   }
/*     */   
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
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getLeftTimeInSeconds()
/*     */   {
/* 150 */     long serverOpenTimeStamp = GameServerInfoManager.getOpenServerTimestamp();
/* 151 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 152 */     calendar.setTimeInMillis(serverOpenTimeStamp);
/* 153 */     calendar.add(5, DouDouSongLiConsts.getInstance().dayCount);
/*     */     
/* 155 */     long endTimeStamp = DateTimeUtils.getBeginTimeOfCurrDay(calendar.getTimeInMillis());
/* 156 */     return TimeUnit.MILLISECONDS.toSeconds(endTimeStamp - DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   private static boolean checkRoleLevel(long roleId)
/*     */   {
/* 161 */     return mzm.gsp.role.main.RoleInterface.getLevel(roleId) >= DouDouSongLiConsts.getInstance().roleMinLevel;
/*     */   }
/*     */   
/*     */   static class DouDouSongLiFixAndSynInfo extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     final long roleId;
/*     */     final int activityId;
/*     */     
/*     */     DouDouSongLiFixAndSynInfo(long roleId, int activityId)
/*     */     {
/* 171 */       this.roleId = roleId;
/* 172 */       this.activityId = activityId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 180 */       AchievementManager.collectLocksToCorrectAchievement(this.roleId);
/*     */       
/* 182 */       Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(this.roleId));
/* 183 */       if (xRole2AchievementInfo == null)
/*     */       {
/* 185 */         return false;
/*     */       }
/* 187 */       ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityId));
/*     */       
/* 189 */       if (xActivityAchievementInfo == null)
/*     */       {
/* 191 */         return false;
/*     */       }
/*     */       
/* 194 */       if (!AchievementManager.isNeedSync(this.roleId, this.activityId, xActivityAchievementInfo))
/*     */       {
/* 196 */         return false;
/*     */       }
/*     */       
/* 199 */       AchievementManager.correctAchievementGoalStateOnLogin(this.roleId, this.activityId, xActivityAchievementInfo);
/*     */       
/*     */ 
/* 202 */       AchievementManager.synAchievementInfo(this.roleId, this.activityId, xActivityAchievementInfo);
/*     */       
/* 204 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void DouDouSongLiFixServerOpen(long roleId, Role2AchievementInfo xRole2AchievementInfo)
/*     */   {
/* 213 */     if (!isActivityOpen())
/*     */     {
/* 215 */       return;
/*     */     }
/*     */     
/* 218 */     int douDouSongLiActivityId = DouDouSongLiConsts.getInstance().activityId;
/*     */     
/* 220 */     if (xRole2AchievementInfo == null)
/*     */     {
/* 222 */       xRole2AchievementInfo = Pod.newRole2AchievementInfo();
/* 223 */       Role2achievement.insert(Long.valueOf(roleId), xRole2AchievementInfo);
/*     */     }
/*     */     
/* 226 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(douDouSongLiActivityId));
/*     */     
/* 228 */     if (xActivityAchievementInfo != null)
/*     */     {
/* 230 */       return;
/*     */     }
/*     */     
/* 233 */     xActivityAchievementInfo = Pod.newActivityAchievementInfo();
/* 234 */     xRole2AchievementInfo.getActivity_achievement_info().put(Integer.valueOf(douDouSongLiActivityId), xActivityAchievementInfo);
/*     */     
/* 236 */     xActivityAchievementInfo.getActivity_parameters_extra().put(Long.valueOf(1L), String.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */   public static void synDouDouSongLiInfo(long roleId)
/*     */   {
/* 242 */     if ((!checkRoleLevel(roleId)) || (!isActivityOpen()))
/*     */     {
/* 244 */       return;
/*     */     }
/*     */     
/* 247 */     new DouDouSongLiFixAndSynInfo(roleId, DouDouSongLiConsts.getInstance().activityId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTriggerGoalFinishEvent()
/*     */   {
/* 253 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanGoalAward()
/*     */   {
/* 259 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGoalCanTakePartIn(long roleId, int activityCfgId, int goalCfgId)
/*     */   {
/* 265 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\DouDouSongLiActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */