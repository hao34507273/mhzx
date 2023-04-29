/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.confbean.SAchievementActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementScoreActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementScoreCfg;
/*     */ import mzm.gsp.achievement.event.AchievementMailAwardArg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AchievementInfo;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xbean.Role2AchievementObserver;
/*     */ import xtable.Role2achievementobserver;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PAchievementActivityFinishMailAward extends mzm.gsp.achievement.event.AchievementActivityFinishMailAwardProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     AchievementAwardMailObserver observer = new AchievementAwardMailObserver(((AchievementMailAwardArg)this.arg).leftTime, ((AchievementMailAwardArg)this.arg).roleId, ((AchievementMailAwardArg)this.arg).activityCfgId, ((AchievementMailAwardArg)this.arg).mailCfgId);
/*     */     
/*     */ 
/*  37 */     Role2AchievementObserver xRole2AchievementObserver = Role2achievementobserver.get(Long.valueOf(((AchievementMailAwardArg)this.arg).roleId));
/*  38 */     if (xRole2AchievementObserver == null)
/*     */     {
/*  40 */       xRole2AchievementObserver = xbean.Pod.newRole2AchievementObserver();
/*  41 */       Role2achievementobserver.add(Long.valueOf(((AchievementMailAwardArg)this.arg).roleId), xRole2AchievementObserver);
/*     */     }
/*     */     
/*  44 */     AchievementAwardMailObserver oldObserver = (AchievementAwardMailObserver)xRole2AchievementObserver.getObserver_map().put(Integer.valueOf(((AchievementMailAwardArg)this.arg).activityCfgId), observer);
/*     */     
/*  46 */     if (oldObserver != null)
/*     */     {
/*  48 */       observer.stopTimer();
/*     */     }
/*     */     
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public static class AchievementAwardMailObserver
/*     */     extends Session
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int mailCfgId;
/*     */     
/*     */     public AchievementAwardMailObserver(long interval, long roleId, int activityCfgId, int mailCfgId)
/*     */     {
/*  62 */       super(roleId);
/*  63 */       this.activityCfgId = activityCfgId;
/*  64 */       this.mailCfgId = mailCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/*  70 */       PAchievementActivityFinishMailAward.PAchievementSendMailAward pSendMailAward = new PAchievementActivityFinishMailAward.PAchievementSendMailAward(getOwerId(), this.activityCfgId, this.mailCfgId);
/*     */       
/*  72 */       pSendMailAward.execute();
/*     */     }
/*     */   }
/*     */   
/*     */   static class PAchievementSendMailAward
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int activityCfgId;
/*     */     private final int mailCfgId;
/*     */     
/*     */     public PAchievementSendMailAward(long roleId, int activityCfgId, int mailCfgId)
/*     */     {
/*  85 */       this.roleId = roleId;
/*  86 */       this.activityCfgId = activityCfgId;
/*  87 */       this.mailCfgId = mailCfgId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  93 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  94 */       lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */       
/*  96 */       Role2AchievementInfo xRole2AchievementInfo = xtable.Role2achievement.get(Long.valueOf(this.roleId));
/*  97 */       if (xRole2AchievementInfo == null)
/*     */       {
/*  99 */         GameServer.logger().error(String.format("[achievement]PAchievementSendMailAward.processImp@role achievement info is null|role_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId) }));
/*     */         
/*     */ 
/*     */ 
/* 103 */         return false;
/*     */       }
/* 105 */       ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityCfgId));
/*     */       
/* 107 */       if (xActivityAchievementInfo == null)
/*     */       {
/* 109 */         GameServer.logger().error(String.format("[achievement]PAchievementSendMailAward.processImp@role activity achievement info is null|role_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId) }));
/*     */         
/*     */ 
/*     */ 
/* 113 */         return false;
/*     */       }
/* 115 */       String awardState = (String)xActivityAchievementInfo.getActivity_parameters_extra().get(Long.valueOf(1L));
/*     */       
/*     */ 
/* 118 */       if ((awardState == null) || (awardState.equals(String.valueOf(1))))
/*     */       {
/* 120 */         GameServer.logger().warn(String.format("[achievement]PAchievementSendMailAward.processImp@award state is null or awardstate aleardy awared|role_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId) }));
/*     */         
/*     */ 
/*     */ 
/* 124 */         return false;
/*     */       }
/* 126 */       SAchievementScoreActivityCfg sAchievementScoreActivityCfg = SAchievementScoreActivityCfg.get(this.activityCfgId);
/* 127 */       if (sAchievementScoreActivityCfg == null)
/*     */       {
/* 129 */         GameServer.logger().error(String.format("[achievement]PAchievementSendMailAward.processImp@achievement score activity cfg is null|role_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId) }));
/*     */         
/*     */ 
/*     */ 
/* 133 */         return false;
/*     */       }
/* 135 */       List<AwardModel> awardModelList = new ArrayList();
/* 136 */       AwardReason awardReason = new AwardReason(LogReason.ACHIEVEMENT_GOAL_AWARD_MODEL_MAIl_AWARD, this.activityCfgId);
/*     */       
/* 138 */       for (Map.Entry<Integer, AchievementInfo> entry : xActivityAchievementInfo.getGoal_info().entrySet())
/*     */       {
/* 140 */         SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(((Integer)entry.getKey()).intValue());
/* 141 */         if (sAchievementGoalCfg != null)
/*     */         {
/*     */ 
/*     */ 
/* 145 */           AchievementInfo xAchievementInfo = (AchievementInfo)entry.getValue();
/* 146 */           if (xAchievementInfo.getGoal_state() == 2)
/*     */           {
/* 148 */             xAchievementInfo.setGoal_state(3);
/*     */             
/*     */ 
/* 151 */             SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(this.activityCfgId);
/* 152 */             if (sAchievementActivityCfg.goalAwardType == 1)
/*     */             {
/* 154 */               AchievementManager.offerAchievementScore(this.roleId, xActivityAchievementInfo, sAchievementGoalCfg.score, this.activityCfgId);
/*     */             }
/*     */             
/*     */ 
/* 158 */             AwardModel awardModel = AwardInterface.getRoleFixAwardModel(sAchievementGoalCfg.fixAwardId, this.roleId, awardReason);
/*     */             
/* 160 */             awardModelList.add(awardModel);
/*     */           }
/*     */         } }
/* 163 */       Set<Integer> xAleardyAwardedIndexList = xActivityAchievementInfo.getAleardy_awarded_score();
/* 164 */       for (Map.Entry<Integer, Integer> entry : sAchievementScoreActivityCfg.scoreMap.entrySet())
/*     */       {
/* 166 */         SAchievementScoreCfg sAchievementScoreCfg = SAchievementScoreCfg.get(((Integer)entry.getValue()).intValue());
/* 167 */         if ((!xAleardyAwardedIndexList.contains(entry.getKey())) && (xActivityAchievementInfo.getScore_value() >= sAchievementScoreCfg.score))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 173 */           xAleardyAwardedIndexList.add(entry.getKey());
/*     */           
/* 175 */           AwardModel awardModel = AwardInterface.getRoleFixAwardModel(sAchievementScoreCfg.awardId, this.roleId, awardReason);
/*     */           
/* 177 */           awardModelList.add(awardModel);
/*     */         }
/*     */       }
/* 180 */       if (awardModelList.size() != 0)
/*     */       {
/* 182 */         MailAttachment mailAttachment = new MailAttachment();
/* 183 */         AwardInterface.fillMailAttachMentBy(awardModelList, mailAttachment);
/* 184 */         mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.roleId, this.mailCfgId, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.ACHIEVEMENT_GOAL_MAIl_AWARD, this.activityCfgId));
/*     */       }
/*     */       
/*     */ 
/* 188 */       xActivityAchievementInfo.getActivity_parameters_extra().put(Long.valueOf(1L), String.valueOf(1));
/*     */       
/*     */ 
/*     */ 
/* 192 */       Role2AchievementObserver xRole2AchievementObserver = Role2achievementobserver.get(Long.valueOf(this.roleId));
/* 193 */       if (xRole2AchievementObserver != null)
/*     */       {
/* 195 */         xRole2AchievementObserver.getObserver_map().remove(Integer.valueOf(this.activityCfgId));
/*     */         
/* 197 */         if (xRole2AchievementObserver.getObserver_map().isEmpty())
/*     */         {
/* 199 */           Role2achievementobserver.remove(Long.valueOf(this.roleId));
/*     */         }
/*     */       }
/*     */       
/* 203 */       GameServer.logger().info(String.format("[achievement]PAchievementSendMailAward.processImp@send mail award success|role_id=%d|activity_cfg_id=%d|award_list_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(awardModelList.size()) }));
/*     */       
/*     */ 
/*     */ 
/* 207 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PAchievementActivityFinishMailAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */