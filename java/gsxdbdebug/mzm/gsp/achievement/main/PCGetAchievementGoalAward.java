/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.SGetAchievementGoalAwardSuccess;
/*     */ import mzm.gsp.achievement.confbean.SAchievementActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalParameterCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AchievementInfo;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2achievement;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetAchievementGoalAward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int goalCfgId;
/*     */   
/*     */   public PCGetAchievementGoalAward(long roleId, int activityCfgId, int goalCfgId)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.activityCfgId = activityCfgId;
/*  44 */     this.goalCfgId = goalCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!AchievementManager.checkMutexStatus(this.roleId, true, false))
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@achievement status error|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!AchievementManager.isAchievementSwitchOpen(this.roleId, this.activityCfgId, "PCGetAchievementGoalAward.processImp"))
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@achievement switch not open|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)AchievementManager.achievementModuleMap.get(Integer.valueOf(this.activityCfgId));
/*  69 */     if (achievementActivityHandler == null)
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@achievement handler not found|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!achievementActivityHandler.isCanGoalAward())
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@achievement can not get goal award|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     String userId = RoleInterface.getUserId(this.roleId);
/*  88 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  90 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(this.roleId));
/*     */     
/*  92 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@role achievement info is null|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(this.activityCfgId);
/* 102 */     if (sAchievementActivityCfg == null)
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@activity cfg is null|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 108 */       return false;
/*     */     }
/* 110 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityCfgId);
/*     */     
/* 112 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 114 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@role can't take part in activity|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d|ret_code=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityCfgId));
/*     */     
/* 123 */     if (xActivityAchievementInfo == null)
/*     */     {
/* 125 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@role activity achievement is null|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(this.goalCfgId));
/* 133 */     if (xAchievementInfo == null)
/*     */     {
/* 135 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@role not take part in the goal|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     if (xAchievementInfo.getGoal_state() != 2)
/*     */     {
/* 144 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementGoalAward.processImp@this goal role can't get award|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d|goal_state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId), Integer.valueOf(xAchievementInfo.getGoal_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(this.goalCfgId);
/* 152 */     if (sAchievementGoalCfg == null)
/*     */     {
/* 154 */       GameServer.logger().warn(String.format("[achievement]PCGetAchievementGoalAward.processImp@achievement goal cfg not exist|role_id=%d|goal_cfg_id=%d|activity_cfg_id=%d|goal_state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.goalCfgId), Integer.valueOf(this.activityCfgId), Integer.valueOf(xAchievementInfo.getGoal_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 158 */       return false;
/*     */     }
/* 160 */     xAchievementInfo.setGoal_state(3);
/*     */     
/* 162 */     int awardId = sAchievementGoalCfg.fixAwardId;
/* 163 */     if (awardId > 0)
/*     */     {
/* 165 */       AwardReason awardReason = new AwardReason(LogReason.ACHIEVEMENT_GET_GOAL_AWARD, this.activityCfgId);
/*     */       
/* 167 */       AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, awardReason);
/* 168 */       if (awardModel == null)
/*     */       {
/* 170 */         GameServer.logger().warn(String.format("[achievement]PCGetAchievementGoalAward.processImp@award failed|role_id=%d|award_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(awardId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */         
/*     */ 
/*     */ 
/* 174 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 179 */     if (sAchievementActivityCfg.goalAwardType == 1)
/*     */     {
/* 181 */       int score = SAchievementGoalParameterCfg.get(this.goalCfgId).score;
/* 182 */       AchievementManager.offerAchievementScore(this.roleId, xActivityAchievementInfo, score, this.activityCfgId);
/*     */     }
/*     */     
/* 185 */     SGetAchievementGoalAwardSuccess sGetAchievementGoalAwardSuccess = new SGetAchievementGoalAwardSuccess();
/* 186 */     sGetAchievementGoalAwardSuccess.activity_cfg_id = this.activityCfgId;
/* 187 */     sGetAchievementGoalAwardSuccess.goal_cfg_id = this.goalCfgId;
/* 188 */     sGetAchievementGoalAwardSuccess.now_score_value = xActivityAchievementInfo.getScore_value();
/*     */     
/* 190 */     OnlineManager.getInstance().send(this.roleId, sGetAchievementGoalAwardSuccess);
/*     */     
/* 192 */     AchievementManager.tlogGoalStateStatis(this.roleId, this.activityCfgId, this.goalCfgId, xActivityAchievementInfo.getScore_value(), GoalStateTlogEnum.AWARDED);
/*     */     
/*     */ 
/* 195 */     GameServer.logger().info(String.format("[achievement]PCGetAchievementGoalAward.processImp@handle get achievement goal award success|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.goalCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 199 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PCGetAchievementGoalAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */