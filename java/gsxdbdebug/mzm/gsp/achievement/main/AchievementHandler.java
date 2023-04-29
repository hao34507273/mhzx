/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.confbean.AchievementConsts;
/*     */ import mzm.gsp.achievement.confbean.SAchievementActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AchievementInfo;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
/*     */ 
/*     */ class AchievementHandler implements ActivityHandler, AchievementActivityHandler
/*     */ {
/*     */   private static final String TLOG_GOAL_STATIS_NAME = "AchievementGoalStatis";
/*     */   private static final String TLOG_SCORE_AWARDED_NAME = "AchievementScoreAwarded";
/*     */   
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  35 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*  36 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  38 */       xRole2AchievementInfo = Pod.newRole2AchievementInfo();
/*  39 */       Role2achievement.add(Long.valueOf(roleId), xRole2AchievementInfo);
/*     */     }
/*     */     
/*  42 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityid));
/*     */     
/*  44 */     if (xActivityAchievementInfo == null)
/*     */     {
/*  46 */       xActivityAchievementInfo = Pod.newActivityAchievementInfo();
/*  47 */       xRole2AchievementInfo.getActivity_achievement_info().put(Integer.valueOf(activityid), xActivityAchievementInfo);
/*     */     }
/*  49 */     xActivityAchievementInfo.getActivity_parameters_extra().put(Long.valueOf(1L), String.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  56 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<ActivityStage> getActivityStages()
/*     */   {
/*  62 */     return null;
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
/*  87 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isCanTakePartIn(long roleId, int activityCfgId)
/*     */   {
/*  94 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSwitchModule(int activityCfgId)
/*     */   {
/* 100 */     return 445;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getGoalStatisTlogName()
/*     */   {
/* 106 */     return "AchievementGoalStatis";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getScoreAwardedTlogName()
/*     */   {
/* 112 */     return "AchievementScoreAwarded";
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTriggerGoalFinishEvent()
/*     */   {
/* 118 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanGoalAward()
/*     */   {
/* 124 */     return false;
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
/*     */   static void fixAchievement(long roleId, Role2AchievementInfo xRole2AchievementInfo)
/*     */   {
/* 139 */     int activityId = AchievementConsts.getInstance().activityId;
/* 140 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(activityId);
/* 141 */     if ((null == sAchievementActivityCfg) || (sAchievementActivityCfg.goalAwardType != 2))
/*     */     {
/* 143 */       return;
/*     */     }
/*     */     
/* 146 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityId));
/* 147 */     if (null == xActivityAchievementInfo)
/*     */     {
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     int totalScore = 0;
/* 153 */     for (Map.Entry<Integer, AchievementInfo> entry : xActivityAchievementInfo.getGoal_info().entrySet())
/*     */     {
/* 155 */       AchievementInfo xAchievementInfo = (AchievementInfo)entry.getValue();
/* 156 */       int achievementGoalCfgId = ((Integer)entry.getKey()).intValue();
/* 157 */       if ((xAchievementInfo.getGoal_state() == 2) || (xAchievementInfo.getGoal_state() == 3))
/*     */       {
/* 159 */         SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(achievementGoalCfgId);
/* 160 */         if (null != sAchievementGoalCfg)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */           totalScore += sAchievementGoalCfg.score;
/*     */           
/*     */ 
/* 169 */           if (xAchievementInfo.getGoal_state() == 2)
/*     */           {
/*     */ 
/* 172 */             int fixAwardId = sAchievementGoalCfg.fixAwardId;
/* 173 */             if (fixAwardId > 0)
/*     */             {
/* 175 */               AwardReason reason = new AwardReason(LogReason.ACHIEVEMENT_MAIL_AUTO_AWARD);
/* 176 */               AwardModel awardModel = AwardInterface.getRoleFixAwardModel(fixAwardId, roleId, reason);
/* 177 */               MailAttachment attachment = new MailAttachment();
/* 178 */               AwardInterface.fillMailAttachMentBy(Collections.singletonList(awardModel), attachment);
/*     */               
/* 180 */               MailInterface.asynBuildAndSendMail(roleId, AchievementConsts.getInstance().mailId, new ArrayList(), new ArrayList(), attachment, new TLogArg(LogReason.ACHIEVEMENT_MAIL_AUTO_AWARD));
/*     */               
/*     */ 
/*     */ 
/* 184 */               xAchievementInfo.setGoal_state(3);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 190 */     int oldScore = xActivityAchievementInfo.getScore_value();
/* 191 */     if (oldScore != totalScore)
/*     */     {
/* 193 */       GameServer.logger().warn(String.format("[achievement]AchievementHandler.fixAchievement@oldScore and nowScore not match|role_id=%d|oldScore=%d|newScore=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldScore), Integer.valueOf(totalScore) }));
/*     */       
/*     */ 
/*     */ 
/* 197 */       xActivityAchievementInfo.setScore_value(totalScore);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGoalCanTakePartIn(long roleId, int activityCfgId, int goalCfgId)
/*     */   {
/* 204 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\AchievementHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */