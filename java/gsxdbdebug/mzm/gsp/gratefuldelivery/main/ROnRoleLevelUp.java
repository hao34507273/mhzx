/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReceiving;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReward;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryStageCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SStageInformation;
/*     */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*     */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.event.RoleLevelUpArg;
/*     */ import mzm.gsp.role.event.RoleLevelUpRunnable;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.DeliveryStatus;
/*     */ import xbean.RoleDeliveryStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ROnRoleLevelUp
/*     */   extends RoleLevelUpRunnable
/*     */ {
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  41 */     if (GameServerInfoManager.isRoamServer()) {
/*  42 */       return;
/*     */     }
/*  44 */     for (final SDeliveryCfg cfg : SDeliveryCfg.getAll().values())
/*     */     {
/*     */ 
/*  47 */       if (OpenInterface.getOpenStatus(cfg.switchId))
/*     */       {
/*     */ 
/*     */ 
/*  51 */         SActivityCfg sActivityCfg = SActivityCfg.get(cfg.activityId);
/*  52 */         if (sActivityCfg != null)
/*     */         {
/*  54 */           int minLevel = sActivityCfg.levelMin;
/*  55 */           if ((((RoleLevelUpArg)this.arg).oldLevel < minLevel) && (((RoleLevelUpArg)this.arg).newLevel >= minLevel))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  60 */             boolean canJoin = new LogicProcedure()
/*     */             {
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/*  65 */                 String userId = RoleInterface.getUserId(((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId);
/*  66 */                 return (userId != null) && (ActivityInterface.canJoinAndCheckInitActivityData(userId, ((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId, cfg.activityId).isCanJoin());
/*     */               }
/*     */             }.call();
/*     */             
/*  70 */             if (canJoin)
/*     */             {
/*     */ 
/*  73 */               final Status status = new Status(null);
/*     */               
/*     */ 
/*     */ 
/*  77 */               new LogicProcedure()
/*     */               {
/*     */                 protected boolean processImp()
/*     */                   throws Exception
/*     */                 {
/*  82 */                   String userId = RoleInterface.getUserId(((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId);
/*  83 */                   if (userId == null) {
/*  84 */                     return false;
/*     */                   }
/*  86 */                   RoleDeliveryStatus xRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(cfg.activityId, ((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId, true);
/*     */                   
/*  88 */                   DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(cfg.activityId, true);
/*     */                   
/*  90 */                   if ((xRoleDeliveryStatus == null) || (xDeliveryStatus == null))
/*     */                   {
/*  92 */                     GratefulDeliveryManager.error(this, ".process()@data not found|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(cfg.activityId), Long.valueOf(((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId) });
/*     */                     
/*  94 */                     return false;
/*     */                   }
/*     */                   
/*     */ 
/*  98 */                   GratefulDeliveryManager.updateRoleInAvailableRoleMap(cfg.activityId, ((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId);
/*     */                   
/* 100 */                   int size = xDeliveryStatus.getRecycled_item_list().size();
/* 101 */                   if (size > 0)
/*     */                   {
/* 103 */                     if (GratefulDeliveryManager.canReceiveItemNow(cfg.activityId, ((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId))
/*     */                     {
/*     */ 
/* 106 */                       status.sourceId = ((Long)xDeliveryStatus.getRecycled_item_list().remove(size - 1));
/* 107 */                       status.autoDeliveryTime = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + cfg.autoRedeliveryCountdown);
/*     */                       
/* 109 */                       xRoleDeliveryStatus.setSource_id(status.sourceId.longValue());
/* 110 */                       if (status.sourceId.longValue() != 0L)
/* 111 */                         xDeliveryStatus.setDelivery_count(xDeliveryStatus.getDelivery_count() + 1);
/* 112 */                       xDeliveryStatus.getItem_holders().put(Long.valueOf(((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId), Integer.valueOf(status.autoDeliveryTime));
/*     */                       
/*     */ 
/* 115 */                       GratefulDeliveryManager.updateRoleInAvailableRoleMap(cfg.activityId, ((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId);
/*     */                       
/*     */ 
/* 118 */                       status.sendRewardBroadcast = GratefulDeliveryManager.checkAndBroadcastReward(cfg.activityId);
/*     */                       
/* 120 */                       GratefulDeliveryManager.info(this, ".process()@recycled item distributed|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(cfg.activityId), status.sourceId, Long.valueOf(((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId) });
/*     */                     }
/*     */                   }
/*     */                   
/*     */ 
/* 125 */                   return true;
/*     */                 }
/*     */               }.call();
/*     */               
/*     */ 
/*     */ 
/* 131 */               if (status.sourceId != null)
/*     */               {
/* 133 */                 SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/* 134 */                 sNotifyReceiving.source_id = status.sourceId.longValue();
/* 135 */                 if (status.sourceId.longValue() != 0L)
/*     */                 {
/* 137 */                   Octets sourceName = new Octets();
/* 138 */                   sourceName.setString(RoleInterface.getName(status.sourceId.longValue()), "UTF-8");
/* 139 */                   sNotifyReceiving.source_name = sourceName;
/*     */                 }
/* 141 */                 sNotifyReceiving.activity_id = cfg.activityId;
/* 142 */                 sNotifyReceiving.time = status.autoDeliveryTime;
/* 143 */                 OnlineManager.getInstance().send(((RoleLevelUpArg)this.arg).roleId, sNotifyReceiving);
/*     */                 
/* 145 */                 TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(cfg.activityId, ((RoleLevelUpArg)this.arg).roleId, status.autoDeliveryTime), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(((RoleLevelUpArg)this.arg).roleId)));
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 154 */               new LogicProcedure()
/*     */               {
/*     */                 protected boolean processImp()
/*     */                   throws Exception
/*     */                 {
/* 159 */                   if (!status.sendRewardBroadcast)
/*     */                   {
/* 161 */                     int currentStage = GratefulDeliveryManager.getCurrentDeliveryCountStage(cfg.activityId);
/* 162 */                     if (currentStage > 0)
/*     */                     {
/* 164 */                       SDeliveryStageCfg sDeliveryStageCfg = SDeliveryStageCfg.get(cfg.activityId);
/* 165 */                       if (sDeliveryStageCfg == null) {
/* 166 */                         return false;
/*     */                       }
/* 168 */                       SStageInformation sStageInformation = (SStageInformation)sDeliveryStageCfg.stages.get(currentStage - 1);
/* 169 */                       if (sStageInformation == null) {
/* 170 */                         return false;
/*     */                       }
/* 172 */                       SNotifyReward sNotifyReward = new SNotifyReward();
/* 173 */                       sNotifyReward.activity_id = cfg.activityId;
/* 174 */                       sNotifyReward.count = sStageInformation.count;
/* 175 */                       OnlineManager.getInstance().send(((RoleLevelUpArg)ROnRoleLevelUp.this.arg).roleId, sNotifyReward);
/*     */                     }
/*     */                   }
/* 178 */                   return true;
/*     */                 }
/*     */                 
/*     */ 
/* 182 */               }.call();
/* 183 */               new PCheckAndSendRewardMail(cfg.activityId, ((RoleLevelUpArg)this.arg).roleId).call();
/*     */             }
/*     */           }
/*     */         } } } }
/*     */   
/* 188 */   private class Status { Long sourceId = null;
/* 189 */     int autoDeliveryTime = 0;
/* 190 */     boolean sendRewardBroadcast = false;
/*     */     
/*     */     private Status() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\ROnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */