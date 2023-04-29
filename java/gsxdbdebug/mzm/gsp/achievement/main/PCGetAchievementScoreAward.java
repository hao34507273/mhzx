/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.SGetAchievementScoreAwardSuccess;
/*     */ import mzm.gsp.achievement.confbean.SAchievementScoreActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementScoreCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAchievementScoreAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityCfgId;
/*     */   final int scoreIndexId;
/*     */   
/*     */   public PCGetAchievementScoreAward(long roleId, int activityCfgId, int scoreIndexId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.activityCfgId = activityCfgId;
/*  30 */     this.scoreIndexId = scoreIndexId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!AchievementManager.checkMutexStatus(this.roleId, true, false))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!AchievementManager.isAchievementSwitchOpen(this.roleId, this.activityCfgId, "PCGetAchievementScoreAward.processImp"))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  46 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  48 */     SAchievementScoreActivityCfg sAchievementScoreActivityCfg = SAchievementScoreActivityCfg.get(this.activityCfgId);
/*  49 */     if (sAchievementScoreActivityCfg == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@activity Cfg id not exist|role_id=%d|activity_cfg_id=%d|score=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     Integer achievementScoreCfgId = (Integer)sAchievementScoreActivityCfg.scoreMap.get(Integer.valueOf(this.scoreIndexId));
/*  59 */     if (achievementScoreCfgId == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@score cfg not exist|role_id=%d|activity_cfg_id=%d|score=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     Role2AchievementInfo xRole2AchievementInfo = xtable.Role2achievement.get(Long.valueOf(this.roleId));
/*     */     
/*  70 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@role achievement info is null|role_id=%d|activity_cfg_id=%d|score=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId) }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityCfgId);
/*     */     
/*  81 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  83 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@role can't take part in activity|role_id=%d|activity_cfg_id=%d|score_index=%d|ret_code=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*  89 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityCfgId));
/*     */     
/*  91 */     if (xActivityAchievementInfo == null)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@role activity achievement is null|role_id=%d|activity_cfg_id=%d|score=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     SAchievementScoreCfg sAchievementScoreCfg = SAchievementScoreCfg.get(achievementScoreCfgId.intValue());
/*     */     
/* 103 */     int scoreAwardId = sAchievementScoreCfg.awardId;
/*     */     
/* 105 */     int needScore = sAchievementScoreCfg.score;
/* 106 */     if (xActivityAchievementInfo.getScore_value() < needScore)
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@score not enough|role_id=%d|activity_cfg_id=%d|score_index_id=%d|now_score=%d|need_score=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId), Integer.valueOf(xActivityAchievementInfo.getScore_value()), Integer.valueOf(needScore) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 113 */       return false;
/*     */     }
/* 115 */     Set<Integer> xAleardyAwardedSet = xActivityAchievementInfo.getAleardy_awarded_score();
/* 116 */     if (xAleardyAwardedSet.contains(Integer.valueOf(this.scoreIndexId)))
/*     */     {
/* 118 */       GameServer.logger().error(String.format("[achievement]PCGetAchievementScoreAward.processImp@score award aleardy awarded|role_id=%d|activity_cfg_id=%d|score=%d|already_awarded_score=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.scoreIndexId), xAleardyAwardedSet.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(scoreAwardId, userId, this.roleId, true, true, new AwardReason(mzm.gsp.tlog.LogReason.ACHIEVEMENT_GET_SCORE_AWARD, this.activityCfgId));
/*     */     
/* 127 */     if (awardModel == null)
/*     */     {
/* 129 */       GameServer.logger().debug(String.format("[achievement]PCGetAchievementScoreAward.processImp@get award failed|role_id=%d|score_index_id=%d|score_award_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.scoreIndexId), Integer.valueOf(scoreAwardId), Integer.valueOf(this.activityCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     xAleardyAwardedSet.add(Integer.valueOf(this.scoreIndexId));
/*     */     
/* 138 */     SGetAchievementScoreAwardSuccess sGetAchievementScoreAwardSuccess = new SGetAchievementScoreAwardSuccess();
/* 139 */     sGetAchievementScoreAwardSuccess.activity_cfg_id = this.activityCfgId;
/* 140 */     sGetAchievementScoreAwardSuccess.score = this.scoreIndexId;
/*     */     
/* 142 */     OnlineManager.getInstance().send(this.roleId, sGetAchievementScoreAwardSuccess);
/*     */     
/* 144 */     AchievementManager.tlogScoreAwarded(this.roleId, this.activityCfgId, this.scoreIndexId, needScore);
/* 145 */     GameServer.logger().info(String.format("[achievement]PCGetAchievementScoreAward.processImp@get score award success|role_id=%d|score_index_id=%d|score_award_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.scoreIndexId), Integer.valueOf(scoreAwardId), Integer.valueOf(this.activityCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PCGetAchievementScoreAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */