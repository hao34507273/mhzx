/*     */ package mzm.gsp.birthdaypray.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.birthdaypray.RewardStages;
/*     */ import mzm.gsp.birthdaypray.SReceiveRewardFail;
/*     */ import mzm.gsp.birthdaypray.SSyncRewardInfoInfo;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayRewardCfg;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayRewardInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.WorldCounterRewardInfo;
/*     */ import xbean.WorldCounterRewardStages;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCReceiveRewardReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int taskActivityId;
/*     */   private final int stageId;
/*     */   
/*     */   public PCReceiveRewardReq(long roleId, int activityCfgId, int taskActivityId, int stageId)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.activityCfgId = activityCfgId;
/*  44 */     this.taskActivityId = taskActivityId;
/*  45 */     this.stageId = stageId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     SBirthdayPrayCfg sBirthdayPrayCfg = SBirthdayPrayCfg.get(this.activityCfgId);
/*  53 */     if (sBirthdayPrayCfg == null)
/*     */     {
/*  55 */       onFailed(4);
/*  56 */       return false;
/*     */     }
/*  58 */     SBirthdayPrayRewardCfg sBirthdayPrayRewardCfg = SBirthdayPrayRewardCfg.get(this.activityCfgId);
/*  59 */     if (sBirthdayPrayRewardCfg == null)
/*     */     {
/*  61 */       onFailed(4);
/*  62 */       return false;
/*     */     }
/*  64 */     SBirthdayPrayRewardInfo sBirthdayPrayRewardInfo = (SBirthdayPrayRewardInfo)sBirthdayPrayRewardCfg.taskActivityId2RewardInfo.get(Integer.valueOf(this.taskActivityId));
/*  65 */     if (sBirthdayPrayRewardInfo == null)
/*     */     {
/*  67 */       onFailed(4);
/*  68 */       return false;
/*     */     }
/*  70 */     Integer rewardCfgId = (Integer)sBirthdayPrayRewardInfo.stage2RewardId.get(Integer.valueOf(this.stageId));
/*  71 */     if (rewardCfgId == null)
/*     */     {
/*  73 */       onFailed(4);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (!BirthdayPrayManager.isBirthdayPraySwitchOpen(this.roleId, sBirthdayPrayCfg.openId))
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     String userId = RoleInterface.getUserId(this.roleId);
/*  82 */     if (userId == null)
/*     */     {
/*  84 */       onFailed(2);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  90 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  93 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1851, true, true))
/*     */     {
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityCfgId);
/*     */     
/* 101 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 104 */       Map<String, Object> extraInfo = new HashMap();
/* 105 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 106 */       onFailed(5, extraInfo);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     long nowTimes = BirthdayPrayManager.getWorldCounterTimes(this.activityCfgId, this.taskActivityId, false);
/*     */     
/* 113 */     if (nowTimes < this.stageId)
/*     */     {
/* 115 */       onFailed(6);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     WorldCounterRewardInfo xWorldCounterRewardInfo = BirthdayPrayManager.getWorldCounterRewardInfo(this.roleId, this.activityCfgId);
/*     */     
/* 121 */     WorldCounterRewardStages xWorldCounterRewardStages = (WorldCounterRewardStages)xWorldCounterRewardInfo.getIndex2reward_stages().get(Integer.valueOf(this.taskActivityId));
/*     */     
/* 123 */     if (xWorldCounterRewardStages == null)
/*     */     {
/* 125 */       xWorldCounterRewardStages = Pod.newWorldCounterRewardStages();
/* 126 */       xWorldCounterRewardInfo.getIndex2reward_stages().put(Integer.valueOf(this.taskActivityId), xWorldCounterRewardStages);
/*     */     }
/* 128 */     if (xWorldCounterRewardStages.getRewarded_stages().contains(Integer.valueOf(this.stageId)))
/*     */     {
/* 130 */       onFailed(7);
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true))
/*     */     {
/* 136 */       onFailed(8);
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     AwardReason awardReason = new AwardReason(LogReason.BIRTHDAY_PRAY_REWARD, rewardCfgId.intValue());
/* 142 */     awardReason.setAwardItemBind(true);
/* 143 */     AwardModel awardModel = AwardInterface.awardFixAward(rewardCfgId.intValue(), userId, this.roleId, true, true, awardReason);
/* 144 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 147 */       Map<String, Object> extras = new HashMap();
/* 148 */       extras.put("rewardCfgId", rewardCfgId);
/* 149 */       onFailed(3, extras);
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     xWorldCounterRewardStages.getRewarded_stages().add(Integer.valueOf(this.stageId));
/*     */     
/*     */ 
/* 156 */     SSyncRewardInfoInfo protocol = new SSyncRewardInfoInfo();
/* 157 */     protocol.activity_cfg_id = this.activityCfgId;
/* 158 */     RewardStages rewardStages = new RewardStages();
/* 159 */     rewardStages.rewarded_stages.addAll(xWorldCounterRewardStages.getRewarded_stages());
/* 160 */     protocol.task_activity_id2reward_stages.put(Integer.valueOf(this.taskActivityId), rewardStages);
/* 161 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/* 163 */     BirthdayPrayManager.logger.info(String.format("[birthdaypray]PCReceiveRewardReq.processImp@receive reward success|userId=%s|roleId=%d|activityCfgId=%d|graphId=%d|stageId=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.taskActivityId), Integer.valueOf(this.stageId) }));
/*     */     
/*     */ 
/*     */ 
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int errorCode)
/*     */   {
/* 172 */     onFailed(errorCode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int errorCode, Map<String, Object> extraParams)
/*     */   {
/* 183 */     SReceiveRewardFail rsp = new SReceiveRewardFail();
/* 184 */     rsp.activity_cfg_id = this.activityCfgId;
/* 185 */     rsp.task_activity_id = this.taskActivityId;
/* 186 */     rsp.stage_id = this.stageId;
/*     */     
/* 188 */     rsp.error_code = errorCode;
/* 189 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 191 */     StringBuffer logBuilder = new StringBuffer();
/* 192 */     logBuilder.append("[birthdaypray]PCReceiveRewardReq.onFailed@getReward failed");
/* 193 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 194 */     logBuilder.append('|').append("activityCfgId=").append(this.activityCfgId);
/* 195 */     logBuilder.append('|').append("graphId=").append(this.taskActivityId);
/* 196 */     logBuilder.append('|').append("stageId=").append(this.stageId);
/* 197 */     logBuilder.append('|').append("errorCode=").append(errorCode);
/*     */     
/* 199 */     if (extraParams != null)
/*     */     {
/* 201 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 203 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 207 */     BirthdayPrayManager.logger.error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\PCReceiveRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */