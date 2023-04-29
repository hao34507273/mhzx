/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.confbean.SAchievementActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PMailAchievementGoalAward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int goalCfgid;
/*     */   private final int mailCfgid;
/*  50 */   private final List<String> contentArgs = new ArrayList();
/*     */   
/*     */ 
/*     */   public PMailAchievementGoalAward(long roleid, int activityCfgid, int goalCfgid, int mailCfgid, List<String> contentArgs)
/*     */   {
/*  55 */     this.roleid = roleid;
/*  56 */     this.activityCfgid = activityCfgid;
/*  57 */     this.goalCfgid = goalCfgid;
/*  58 */     this.mailCfgid = mailCfgid;
/*     */     
/*  60 */     if (contentArgs != null)
/*     */     {
/*  62 */       this.contentArgs.addAll(contentArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  69 */     if (!AchievementManager.isAchievementSwitchOpen(this.roleid, this.activityCfgid, "PMailAchievementGoalAward.processImp"))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     String userId = RoleInterface.getUserId(this.roleid);
/*  75 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  77 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(this.roleid));
/*  78 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@role achievement info is null|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(this.activityCfgid);
/*  88 */     if (sAchievementActivityCfg == null)
/*     */     {
/*  90 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@activity cfg is null|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  99 */     if (xActivityAchievementInfo == null)
/*     */     {
/* 101 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@role activity achievement is null|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(this.goalCfgid));
/* 109 */     if (xAchievementInfo == null)
/*     */     {
/* 111 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@role not take part in the goal|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (xAchievementInfo.getGoal_state() != 2)
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@this goal role can't get award|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d|goal_state=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid), Integer.valueOf(xAchievementInfo.getGoal_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     SAchievementGoalCfg achievementGoalCfg = SAchievementGoalCfg.get(this.goalCfgid);
/* 128 */     if (achievementGoalCfg == null)
/*     */     {
/* 130 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@achievement goal cfg not exist|role_id=%d|goal_cfg_id=%d|activity_cfg_id=%d|goal_state=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.goalCfgid), Integer.valueOf(this.activityCfgid), Integer.valueOf(xAchievementInfo.getGoal_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 134 */       return false;
/*     */     }
/* 136 */     xAchievementInfo.setGoal_state(3);
/*     */     
/* 138 */     int awardCfgid = achievementGoalCfg.fixAwardId;
/* 139 */     if (awardCfgid <= 0)
/*     */     {
/* 141 */       GameServer.logger().warn(String.format("[achievement]PMailAchievementGoalAward.processImp@award invalid|role_id=%d|goal_cfg_id=%d|activity_cfg_id=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.goalCfgid), Integer.valueOf(this.activityCfgid), Integer.valueOf(awardCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       return true;
/*     */     }
/*     */     
/* 148 */     AwardReason awardReason = new AwardReason(LogReason.ACHIEVEMENT_MAIL_AWARD, this.goalCfgid);
/* 149 */     AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, this.roleid, awardReason);
/* 150 */     if (awardModel == null)
/*     */     {
/* 152 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@get award model failed|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d|award_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid), Integer.valueOf(awardCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     List<String> emptyStrings = Collections.emptyList();
/* 160 */     MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, false);
/* 161 */     TLogArg tLogArg = new TLogArg(LogReason.ACHIEVEMENT_MAIL_AWARD, this.goalCfgid);
/* 162 */     SendMailRet ret = MailInterface.synBuildAndSendMail(this.roleid, this.mailCfgid, emptyStrings, this.contentArgs, attachment, tLogArg);
/*     */     
/* 164 */     if (!ret.isOK())
/*     */     {
/* 166 */       GameServer.logger().error(String.format("[achievement]PMailAchievementGoalAward.processImp@send mail failed|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d|mail_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid), Integer.valueOf(this.mailCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     AchievementManager.tlogGoalStateStatis(this.roleid, this.activityCfgid, this.goalCfgid, xActivityAchievementInfo.getScore_value(), GoalStateTlogEnum.SUPPLY);
/*     */     
/*     */ 
/* 176 */     GameServer.logger().info(String.format("[achievement]PMailAchievementGoalAward.processImp@mail achievement goal award success|role_id=%d|activity_cfg_id=%d|goal_cfg_id=%d|mail_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.goalCfgid), Integer.valueOf(this.mailCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PMailAchievementGoalAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */