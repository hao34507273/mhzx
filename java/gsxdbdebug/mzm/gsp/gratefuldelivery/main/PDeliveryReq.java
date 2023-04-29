/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.gratefuldelivery.SDeliveryFail;
/*     */ import mzm.gsp.gratefuldelivery.SDeliverySuccess;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReceiving;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*     */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.DeliveryStatus;
/*     */ import xbean.RoleDeliveryStatus;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Grateful_delivery_status;
/*     */ import xtable.Role2gratefuldelivery;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PDeliveryReq extends LogicProcedure
/*     */ {
/*     */   private final int activityId;
/*     */   private final long sourceId;
/*     */   private final long targetId;
/*     */   
/*     */   public PDeliveryReq(int activityId, long sourceId, long targetId)
/*     */   {
/*  42 */     this.activityId = activityId;
/*  43 */     this.sourceId = sourceId;
/*  44 */     this.targetId = targetId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  52 */     if (sDeliveryCfg == null) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/*  57 */       return false;
/*     */     }
/*  59 */     String sourceUserId = RoleInterface.getUserId(this.sourceId);
/*  60 */     String targetUserId = RoleInterface.getUserId(this.targetId);
/*  61 */     if ((sourceUserId == null) || (targetUserId == null)) {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { sourceUserId, targetUserId }));
/*  66 */     Lockeys.lock(Role2gratefuldelivery.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.sourceId), Long.valueOf(this.targetId) }));
/*  67 */     Lockeys.lock(Grateful_delivery_status.getTable(), Collections.singletonList(Long.valueOf(GameServerInfoManager.toGlobalId(this.activityId))));
/*     */     
/*     */ 
/*     */ 
/*  71 */     if (!FriendInterface.isFriend(this.sourceId, this.targetId, true)) {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(sourceUserId, this.sourceId, this.activityId).isCanJoin())
/*  76 */       return false;
/*  77 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(targetUserId, this.targetId, this.activityId).isCanJoin()) {
/*  78 */       return false;
/*     */     }
/*  80 */     RoleDeliveryStatus xSourceRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(this.activityId, this.sourceId, true);
/*     */     
/*  82 */     RoleDeliveryStatus xTargetRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(this.activityId, this.targetId, true);
/*     */     
/*  84 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, true);
/*  85 */     if ((xSourceRoleDeliveryStatus == null) || (xTargetRoleDeliveryStatus == null) || (xDeliveryStatus == null))
/*     */     {
/*  87 */       GratefulDeliveryManager.error(this, ".processImp()@data not found|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.sourceId), Long.valueOf(this.targetId) });
/*     */       
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     if (!GratefulDeliveryManager.hasItem(this.activityId, this.sourceId))
/*     */     {
/*  96 */       SDeliveryFail sDeliveryFail = new SDeliveryFail();
/*  97 */       sDeliveryFail.retcode = 1;
/*  98 */       sDeliveryFail.target_id = this.targetId;
/*  99 */       sDeliveryFail.activity_id = this.activityId;
/* 100 */       OnlineManager.getInstance().sendAtOnce(this.sourceId, sDeliveryFail);
/*     */       
/* 102 */       GratefulDeliveryManager.info(this, ".processImp()@no item|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.sourceId), Long.valueOf(this.targetId) });
/*     */       
/*     */ 
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     if (!GratefulDeliveryManager.canReceiveItemNow(this.activityId, this.targetId))
/*     */     {
/* 111 */       SDeliveryFail sDeliveryFail = new SDeliveryFail();
/* 112 */       sDeliveryFail.retcode = (OnlineManager.getInstance().isOnline(this.targetId) ? 2 : 3);
/*     */       
/* 114 */       sDeliveryFail.target_id = this.targetId;
/* 115 */       sDeliveryFail.activity_id = this.activityId;
/* 116 */       OnlineManager.getInstance().sendAtOnce(this.sourceId, sDeliveryFail);
/*     */       
/* 118 */       GratefulDeliveryManager.info(this, ".processImp()@cannot receive now|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.sourceId), Long.valueOf(this.targetId) });
/*     */       
/*     */ 
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     int autoDeliveryTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + sDeliveryCfg.autoRedeliveryCountdown;
/*     */     
/*     */ 
/*     */ 
/* 128 */     ActivityInterface.addActivityCount(sourceUserId, this.sourceId, this.activityId);
/* 129 */     xSourceRoleDeliveryStatus.setTarget_id(this.targetId);
/* 130 */     xTargetRoleDeliveryStatus.setSource_id(this.sourceId);
/* 131 */     xDeliveryStatus.setDelivery_count(xDeliveryStatus.getDelivery_count() + 1);
/* 132 */     xDeliveryStatus.getItem_holders().remove(Long.valueOf(this.sourceId));
/* 133 */     xDeliveryStatus.getItem_holders().put(Long.valueOf(this.targetId), Integer.valueOf(autoDeliveryTime));
/*     */     
/*     */ 
/* 136 */     GratefulDeliveryManager.updateRoleInAvailableRoleMap(this.activityId, this.sourceId);
/* 137 */     GratefulDeliveryManager.updateRoleInAvailableRoleMap(this.activityId, this.targetId);
/*     */     
/*     */ 
/* 140 */     Octets targetName = new Octets();
/* 141 */     targetName.setString(RoleInterface.getName(this.targetId), "UTF-8");
/* 142 */     SDeliverySuccess sDeliverySuccess = new SDeliverySuccess();
/* 143 */     sDeliverySuccess.target_id = this.targetId;
/* 144 */     sDeliverySuccess.target_name = targetName;
/* 145 */     sDeliverySuccess.activity_id = this.activityId;
/* 146 */     OnlineManager.getInstance().send(this.sourceId, sDeliverySuccess);
/*     */     
/* 148 */     Octets sourceName = new Octets();
/* 149 */     sourceName.setString(RoleInterface.getName(this.sourceId), "UTF-8");
/* 150 */     SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/* 151 */     sNotifyReceiving.source_id = this.sourceId;
/* 152 */     sNotifyReceiving.source_name = sourceName;
/* 153 */     sNotifyReceiving.time = autoDeliveryTime;
/* 154 */     sNotifyReceiving.activity_id = this.activityId;
/* 155 */     OnlineManager.getInstance().send(this.targetId, sNotifyReceiving);
/*     */     
/*     */ 
/* 158 */     GratefulDeliveryManager.checkAndBroadcastReward(this.activityId);
/*     */     
/*     */ 
/* 161 */     int rewardId = sDeliveryCfg.deliveryRewardId;
/* 162 */     AwardReason reason = new AwardReason(LogReason.DELIVERY_REWARD, sDeliveryCfg.activitySubtype);
/* 163 */     AwardInterface.award(rewardId, sourceUserId, this.sourceId, false, true, reason);
/*     */     
/*     */ 
/* 166 */     TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(this.activityId, this.targetId, autoDeliveryTime), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.targetId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 171 */     GratefulDeliveryManager.tlogManualDelivery(this.sourceId, this.activityId, this.targetId);
/* 172 */     GratefulDeliveryManager.info(this, ".processImp()@item delivered|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.sourceId), Long.valueOf(this.targetId) });
/*     */     
/*     */ 
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PDeliveryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */