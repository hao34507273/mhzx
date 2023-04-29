/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyAutoDelivery;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReceiving;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*     */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AutoDeliverySession
/*     */   extends Session
/*     */ {
/*     */   private final int activityId;
/*     */   private final long roleId;
/*     */   
/*     */   AutoDeliverySession(long interval, int activityId, long roleId)
/*     */   {
/*  48 */     super(interval, roleId);
/*  49 */     this.activityId = activityId;
/*  50 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  56 */     new PAutoDelivery(this.activityId, this.roleId).execute();
/*     */   }
/*     */   
/*     */   private class PAutoDelivery extends LogicProcedure
/*     */   {
/*     */     private final int activityId;
/*     */     private final long roleId;
/*     */     
/*     */     PAutoDelivery(int activityId, long roleId)
/*     */     {
/*  66 */       this.activityId = activityId;
/*  67 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  74 */       SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  75 */       if (sDeliveryCfg == null) {
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       String userId = RoleInterface.getUserId(this.roleId);
/*  80 */       if ((userId == null) || (!GratefulDeliveryManager.hasItem(this.activityId, this.roleId))) {
/*  81 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  85 */       if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/*  86 */         return GratefulDeliveryManager.recycleItem(this.activityId, this.roleId);
/*     */       }
/*     */       
/*  89 */       Long targetId = GratefulDeliveryManager.getAndRemoveAvailableRoleId(this.activityId, this.roleId);
/*  90 */       String targetUserId = targetId == null ? null : RoleInterface.getUserId(targetId.longValue());
/*     */       
/*     */ 
/*     */ 
/*  94 */       if (targetUserId == null) {
/*  95 */         return GratefulDeliveryManager.recycleItem(this.activityId, this.roleId);
/*     */       }
/*     */       
/*     */ 
/*  99 */       Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId, targetUserId }));
/* 100 */       Lockeys.lock(Role2gratefuldelivery.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), targetId }));
/* 101 */       Lockeys.lock(Grateful_delivery_status.getTable(), Collections.singletonList(Long.valueOf(GameServerInfoManager.toGlobalId(this.activityId))));
/*     */       
/*     */ 
/* 104 */       RoleDeliveryStatus xSourceRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(this.activityId, this.roleId, true);
/*     */       
/* 106 */       RoleDeliveryStatus xTargetRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(this.activityId, targetId.longValue(), true);
/*     */       
/* 108 */       DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, true);
/* 109 */       if ((xSourceRoleDeliveryStatus == null) || (xTargetRoleDeliveryStatus == null) || (xDeliveryStatus == null))
/*     */       {
/*     */ 
/* 112 */         GratefulDeliveryManager.addIntoAvailableRoleMap(this.activityId, targetId.longValue());
/* 113 */         GratefulDeliveryManager.error(this, ".processImp()@data not found|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.roleId), targetId });
/*     */         
/*     */ 
/* 116 */         return false;
/*     */       }
/*     */       
/* 119 */       int autoDeliveryTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + sDeliveryCfg.autoRedeliveryCountdown;
/*     */       
/*     */ 
/*     */ 
/* 123 */       ActivityInterface.addActivityCount(userId, this.roleId, this.activityId);
/* 124 */       xSourceRoleDeliveryStatus.setTarget_id(targetId.longValue());
/* 125 */       xTargetRoleDeliveryStatus.setSource_id(this.roleId);
/* 126 */       xDeliveryStatus.setDelivery_count(xDeliveryStatus.getDelivery_count() + 1);
/* 127 */       xDeliveryStatus.getItem_holders().remove(Long.valueOf(this.roleId));
/* 128 */       xDeliveryStatus.getItem_holders().put(targetId, Integer.valueOf(autoDeliveryTime));
/*     */       
/*     */ 
/* 131 */       GratefulDeliveryManager.updateRoleInAvailableRoleMap(this.activityId, this.roleId);
/* 132 */       GratefulDeliveryManager.updateRoleInAvailableRoleMap(this.activityId, targetId.longValue());
/*     */       
/*     */ 
/* 135 */       AwardReason reason = new AwardReason(LogReason.AUTO_REDELIVERY_REWARD, sDeliveryCfg.activitySubtype);
/* 136 */       AwardInterface.award(sDeliveryCfg.autoDeliveryRewardId, userId, this.roleId, false, true, reason);
/*     */       
/*     */ 
/* 139 */       Octets targetName = new Octets();
/* 140 */       targetName.setString(RoleInterface.getName(targetId.longValue()), "UTF-8");
/* 141 */       SNotifyAutoDelivery sNotifyAutoDelivery = new SNotifyAutoDelivery();
/* 142 */       sNotifyAutoDelivery.target_id = targetId.longValue();
/* 143 */       sNotifyAutoDelivery.target_name = targetName;
/* 144 */       sNotifyAutoDelivery.activity_id = this.activityId;
/* 145 */       OnlineManager.getInstance().send(this.roleId, sNotifyAutoDelivery);
/*     */       
/* 147 */       Octets roleName = new Octets();
/* 148 */       roleName.setString(RoleInterface.getName(this.roleId), "UTF-8");
/* 149 */       SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/* 150 */       sNotifyReceiving.source_id = this.roleId;
/* 151 */       sNotifyReceiving.source_name = roleName;
/* 152 */       sNotifyReceiving.time = autoDeliveryTime;
/* 153 */       sNotifyReceiving.activity_id = this.activityId;
/* 154 */       OnlineManager.getInstance().send(targetId.longValue(), sNotifyReceiving);
/*     */       
/*     */ 
/* 157 */       GratefulDeliveryManager.checkAndBroadcastReward(this.activityId);
/*     */       
/*     */ 
/* 160 */       TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(this.activityId, targetId.longValue(), autoDeliveryTime), RoleOneByOneManager.getInstance().getTaskOneByOne(targetId));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 165 */       GratefulDeliveryManager.tlogAutoDelivery(this.roleId, this.activityId, targetId.longValue());
/* 166 */       GratefulDeliveryManager.info(this, ".onTimeout()@auto delivered|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.roleId), targetId });
/*     */       
/*     */ 
/* 169 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\AutoDeliverySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */