/*     */ package mzm.gsp.birthdaypray.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*     */ import mzm.gsp.birthdaypray.RewardStages;
/*     */ import mzm.gsp.birthdaypray.SSyncRewardInfoInfo;
/*     */ import mzm.gsp.birthdaypray.SSyncScheduleInfo;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayRewardCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.WorldCounterInfo;
/*     */ import xbean.WorldCounterRewardInfo;
/*     */ import xbean.WorldCounterRewardStages;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ import xtable.Worldcounter;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  32 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*     */     
/*  34 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  36 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  41 */     for (Map.Entry<Integer, SBirthdayPrayCfg> entry : SBirthdayPrayCfg.getAll().entrySet())
/*     */     {
/*  43 */       SBirthdayPrayCfg sBirthdayPrayCfg = (SBirthdayPrayCfg)entry.getValue();
/*     */       
/*  45 */       if (BirthdayPrayManager.isBirthdayPraySwitchOpen(roleId, sBirthdayPrayCfg.openId))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  50 */         ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, sBirthdayPrayCfg.activityId);
/*     */         
/*  52 */         if ((activityJoinResult.isCanJoin()) || (activityJoinResult.isRoleLevelWrong()))
/*     */         {
/*  54 */           long globalIndex = GameServerInfoManager.toGlobalId(sBirthdayPrayCfg.activityId);
/*     */           
/*  56 */           WorldCounterInfo xWorldCounterInfo = Worldcounter.select(Long.valueOf(globalIndex));
/*  57 */           if (xWorldCounterInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  62 */             SSyncScheduleInfo sSyncScheduleInfo = new SSyncScheduleInfo();
/*  63 */             sSyncScheduleInfo.activity_cfg_id = sBirthdayPrayCfg.activityId;
/*  64 */             sSyncScheduleInfo.task_activity_id2times.putAll(xWorldCounterInfo.getIndex2times());
/*  65 */             OnlineManager.getInstance().send(roleId, sSyncScheduleInfo);
/*     */             
/*  67 */             SBirthdayPrayRewardCfg sBirthdayPrayRewardCfg = SBirthdayPrayRewardCfg.get(sBirthdayPrayCfg.activityId);
/*  68 */             if (sBirthdayPrayRewardCfg != null)
/*     */             {
/*     */ 
/*     */ 
/*  72 */               WorldCounterRewardInfo xWorldCounterRewardInfo = BirthdayPrayManager.getWorldCounterRewardInfo(roleId, sBirthdayPrayCfg.activityId);
/*     */               
/*  74 */               SSyncRewardInfoInfo sSyncRewardInfoInfo = new SSyncRewardInfoInfo();
/*  75 */               sSyncRewardInfoInfo.activity_cfg_id = sBirthdayPrayCfg.activityId;
/*     */               
/*     */ 
/*     */ 
/*  79 */               for (Map.Entry<Integer, mzm.gsp.nationalholiday.confbean.SBirthdayPrayRewardInfo> rewardEntry : sBirthdayPrayRewardCfg.taskActivityId2RewardInfo.entrySet())
/*     */               {
/*  81 */                 WorldCounterRewardStages xWorldCounterRewardStages = (WorldCounterRewardStages)xWorldCounterRewardInfo.getIndex2reward_stages().get(rewardEntry.getKey());
/*  82 */                 if (xWorldCounterRewardStages == null)
/*     */                 {
/*  84 */                   xWorldCounterRewardStages = xbean.Pod.newWorldCounterRewardStages();
/*  85 */                   xWorldCounterRewardInfo.getIndex2reward_stages().put(rewardEntry.getKey(), xWorldCounterRewardStages);
/*     */                 }
/*  87 */                 if (xWorldCounterRewardStages.getRewarded_stages().size() > 0)
/*     */                 {
/*  89 */                   RewardStages rewardStages = new RewardStages();
/*  90 */                   rewardStages.rewarded_stages.addAll(xWorldCounterRewardStages.getRewarded_stages());
/*  91 */                   sSyncRewardInfoInfo.task_activity_id2reward_stages.put(rewardEntry.getKey(), rewardStages);
/*     */                 }
/*     */               }
/*     */               
/*  95 */               OnlineManager.getInstance().send(roleId, sSyncRewardInfoInfo);
/*     */             }
/*  97 */           } } else if (ActivityInterface.getActivityLimitTimeStage(sBirthdayPrayCfg.activityId, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()) == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER)
/*     */         {
/*     */ 
/* 100 */           WorldCounterRewardInfo xWorldCounterRewardInfo = BirthdayPrayManager.getWorldCounterRewardInfo(roleId, sBirthdayPrayCfg.activityId);
/*     */           
/* 102 */           if (!xWorldCounterRewardInfo.getSended_reward_mail())
/*     */           {
/* 104 */             long globalIndex = GameServerInfoManager.toGlobalId(sBirthdayPrayCfg.activityId);
/*     */             
/* 106 */             WorldCounterInfo xWorldCounterInfo = Worldcounter.select(Long.valueOf(globalIndex));
/* 107 */             if (xWorldCounterInfo != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 112 */               new PSendRewardMail(roleId, sBirthdayPrayCfg.activityId, xWorldCounterInfo, xWorldCounterRewardInfo).call(); }
/*     */           }
/*     */         }
/*     */       } }
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */