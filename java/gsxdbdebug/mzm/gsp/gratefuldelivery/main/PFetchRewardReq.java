/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gratefuldelivery.SFetchRewardFail;
/*     */ import mzm.gsp.gratefuldelivery.SFetchRewardSuccess;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryStageCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SStageInformation;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleDeliveryStatus;
/*     */ 
/*     */ 
/*     */ public class PFetchRewardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int activityId;
/*     */   private final long roleId;
/*     */   private final int stage;
/*     */   
/*     */   public PFetchRewardReq(int activityId, long roleId, int stage)
/*     */   {
/*  32 */     this.activityId = activityId;
/*  33 */     this.roleId = roleId;
/*  34 */     this.stage = stage;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  42 */     SDeliveryStageCfg sDeliveryStageCfg = SDeliveryStageCfg.get(this.activityId);
/*  43 */     if ((sDeliveryCfg == null) || (sDeliveryStageCfg == null)) {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userId = RoleInterface.getUserId(this.roleId);
/*  52 */     if (userId == null)
/*  53 */       return false;
/*  54 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId).isCanJoin()) {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if ((this.stage <= 0) || (this.stage > sDeliveryStageCfg.stages.size())) {
/*  59 */       return false;
/*     */     }
/*  61 */     RoleDeliveryStatus xRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(this.activityId, this.roleId, true);
/*     */     
/*  63 */     if (xRoleDeliveryStatus == null) {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     int currentStage = GratefulDeliveryManager.getCurrentDeliveryCountStage(this.activityId);
/*     */     
/*     */ 
/*  71 */     if (this.stage > currentStage)
/*     */     {
/*  73 */       SFetchRewardFail sFetchRewardFail = new SFetchRewardFail();
/*  74 */       sFetchRewardFail.retcode = 1;
/*  75 */       sFetchRewardFail.stage = this.stage;
/*  76 */       sFetchRewardFail.activity_id = this.activityId;
/*  77 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sFetchRewardFail);
/*     */       
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     if (xRoleDeliveryStatus.getFetched_rewards().contains(Integer.valueOf(this.stage)))
/*     */     {
/*  85 */       SFetchRewardFail sFetchRewardFail = new SFetchRewardFail();
/*  86 */       sFetchRewardFail.retcode = 2;
/*  87 */       sFetchRewardFail.stage = this.stage;
/*  88 */       sFetchRewardFail.activity_id = this.activityId;
/*  89 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sFetchRewardFail);
/*     */       
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     int stageIndex = this.stage - 1;
/*  96 */     SStageInformation sStageInformation = (SStageInformation)sDeliveryStageCfg.stages.get(stageIndex);
/*  97 */     if (sStageInformation == null)
/*     */     {
/*  99 */       GratefulDeliveryManager.error(this, ".processImp()@stage info not found|activity_cfgid=%d|stage=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     int rewardId = sStageInformation.rewardId;
/*     */     
/* 106 */     LogReason stageRewardReason = LogReason.getReason(LogReason.DELIVERY_STAGE_REWARD1.value + stageIndex);
/* 107 */     AwardReason reason = new AwardReason(stageRewardReason, sDeliveryCfg.activitySubtype);
/* 108 */     AwardModel awardResult = AwardInterface.award(rewardId, userId, this.roleId, true, true, reason);
/* 109 */     if (awardResult == null) {
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     xRoleDeliveryStatus.getFetched_rewards().add(Integer.valueOf(this.stage));
/*     */     
/* 115 */     SFetchRewardSuccess sFetchRewardSuccess = new SFetchRewardSuccess();
/* 116 */     sFetchRewardSuccess.stage = this.stage;
/* 117 */     sFetchRewardSuccess.activity_id = this.activityId;
/* 118 */     OnlineManager.getInstance().send(this.roleId, sFetchRewardSuccess);
/*     */     
/* 120 */     GratefulDeliveryManager.info(this, ".processImp()@stage reward fetched|activity_cfgid=%d|roleid=%d|stage=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.roleId), Integer.valueOf(this.stage) });
/*     */     
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PFetchRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */