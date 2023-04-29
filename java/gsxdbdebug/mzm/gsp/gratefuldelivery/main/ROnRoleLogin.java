/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReceiving;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReward;
/*     */ import mzm.gsp.gratefuldelivery.SSyncFetchedRewards;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryStageCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SStageInformation;
/*     */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*     */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEvent;
/*     */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
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
/*     */ public class ROnRoleLogin
/*     */   extends PlayerLoginRunnable
/*     */ {
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  42 */     if (GameServerInfoManager.isRoamServer()) {
/*  43 */       return;
/*     */     }
/*  45 */     for (final SDeliveryCfg cfg : SDeliveryCfg.getAll().values())
/*     */     {
/*     */ 
/*  48 */       if (OpenInterface.getOpenStatus(cfg.switchId))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  53 */         boolean canJoin = new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/*  58 */             String userId = RoleInterface.getUserId(((Long)ROnRoleLogin.this.arg).longValue());
/*  59 */             return (userId != null) && (ActivityInterface.canJoinAndCheckInitActivityData(userId, ((Long)ROnRoleLogin.this.arg).longValue(), cfg.activityId).isCanJoin());
/*     */           }
/*     */         }.call();
/*     */         
/*  63 */         if (canJoin)
/*     */         {
/*     */ 
/*  66 */           final Status status = new Status(null);
/*     */           
/*     */ 
/*     */ 
/*  70 */           new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/*  75 */               RoleDeliveryStatus xRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue(), true);
/*     */               
/*  77 */               DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(cfg.activityId, true);
/*     */               
/*  79 */               if ((xRoleDeliveryStatus == null) || (xDeliveryStatus == null)) {
/*  80 */                 return false;
/*     */               }
/*     */               
/*  83 */               GratefulDeliveryManager.updateRoleInAvailableRoleMap(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue());
/*     */               
/*  85 */               Integer autoRedeliveryTime = (Integer)xDeliveryStatus.getItem_holders().get(ROnRoleLogin.this.arg);
/*  86 */               if (autoRedeliveryTime != null)
/*     */               {
/*  88 */                 status.hasItem = true;
/*  89 */                 status.sourceId = xRoleDeliveryStatus.getSource_id();
/*  90 */                 status.autoDeliveryTime = autoRedeliveryTime.intValue();
/*     */               }
/*  92 */               return true;
/*     */             }
/*     */           }.call();
/*     */           
/*     */ 
/*  97 */           if (status.hasItem)
/*     */           {
/*  99 */             SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/* 100 */             sNotifyReceiving.source_id = status.sourceId;
/* 101 */             if (status.sourceId != 0L)
/*     */             {
/* 103 */               Octets sourceName = new Octets();
/* 104 */               sourceName.setString(RoleInterface.getName(status.sourceId), "UTF-8");
/*     */             }
/* 106 */             sNotifyReceiving.activity_id = cfg.activityId;
/* 107 */             sNotifyReceiving.time = status.autoDeliveryTime;
/* 108 */             OnlineManager.getInstance().send(((Long)this.arg).longValue(), sNotifyReceiving);
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 113 */           if (!status.hasItem)
/*     */           {
/* 115 */             new LogicProcedure()
/*     */             {
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/* 120 */                 String userId = RoleInterface.getUserId(((Long)ROnRoleLogin.this.arg).longValue());
/* 121 */                 if (userId == null) {
/* 122 */                   return false;
/*     */                 }
/* 124 */                 RoleDeliveryStatus xRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue(), true);
/*     */                 
/* 126 */                 DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(cfg.activityId, true);
/*     */                 
/* 128 */                 if ((xRoleDeliveryStatus == null) || (xDeliveryStatus == null))
/*     */                 {
/* 130 */                   GratefulDeliveryManager.error(this, ".process()@data not found|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(cfg.activityId), ROnRoleLogin.this.arg });
/*     */                   
/* 132 */                   return false;
/*     */                 }
/*     */                 
/*     */ 
/* 136 */                 GratefulDeliveryManager.updateRoleInAvailableRoleMap(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue());
/*     */                 
/* 138 */                 int size = xDeliveryStatus.getRecycled_item_list().size();
/* 139 */                 if (size > 0)
/*     */                 {
/* 141 */                   if (GratefulDeliveryManager.canReceiveItemNow(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue()))
/*     */                   {
/*     */ 
/* 144 */                     status.sourceId = ((Long)xDeliveryStatus.getRecycled_item_list().remove(size - 1)).longValue();
/* 145 */                     status.autoDeliveryTime = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + cfg.autoRedeliveryCountdown);
/*     */                     
/* 147 */                     xRoleDeliveryStatus.setSource_id(status.sourceId);
/* 148 */                     if (status.sourceId != 0L)
/* 149 */                       xDeliveryStatus.setDelivery_count(xDeliveryStatus.getDelivery_count() + 1);
/* 150 */                     xDeliveryStatus.getItem_holders().put(ROnRoleLogin.this.arg, Integer.valueOf(status.autoDeliveryTime));
/*     */                     
/* 152 */                     status.recycledItemDistributed = true;
/*     */                     
/*     */ 
/* 155 */                     GratefulDeliveryManager.updateRoleInAvailableRoleMap(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue());
/*     */                     
/*     */ 
/* 158 */                     status.sendRewardBroadcast = GratefulDeliveryManager.checkAndBroadcastReward(cfg.activityId);
/*     */                     
/* 160 */                     GratefulDeliveryManager.info(this, ".process()@recycled item distributed|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(cfg.activityId), Long.valueOf(status.sourceId), ROnRoleLogin.this.arg });
/*     */                   }
/*     */                 }
/*     */                 
/*     */ 
/* 165 */                 return true;
/*     */               }
/*     */             }.call();
/*     */             
/*     */ 
/*     */ 
/* 171 */             if (status.recycledItemDistributed)
/*     */             {
/* 173 */               SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/* 174 */               sNotifyReceiving.source_id = status.sourceId;
/* 175 */               if (status.sourceId != 0L)
/*     */               {
/* 177 */                 Octets sourceName = new Octets();
/* 178 */                 sourceName.setString(RoleInterface.getName(status.sourceId), "UTF-8");
/* 179 */                 sNotifyReceiving.source_name = sourceName;
/*     */               }
/* 181 */               sNotifyReceiving.activity_id = cfg.activityId;
/* 182 */               sNotifyReceiving.time = status.autoDeliveryTime;
/* 183 */               OnlineManager.getInstance().send(((Long)this.arg).longValue(), sNotifyReceiving);
/*     */               
/* 185 */               TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(cfg.activityId, ((Long)this.arg).longValue(), status.autoDeliveryTime), RoleOneByOneManager.getInstance().getTaskOneByOne(this.arg));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 194 */           new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 199 */               RoleDeliveryStatus xRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(cfg.activityId, ((Long)ROnRoleLogin.this.arg).longValue(), true);
/*     */               
/* 201 */               if (xRoleDeliveryStatus == null) {
/* 202 */                 return false;
/*     */               }
/* 204 */               HashSet<Integer> fetchedRewards = new HashSet(xRoleDeliveryStatus.getFetched_rewards());
/* 205 */               if (fetchedRewards.size() > 0)
/*     */               {
/*     */ 
/* 208 */                 SSyncFetchedRewards sSyncFetchedRewards = new SSyncFetchedRewards();
/* 209 */                 sSyncFetchedRewards.fetched_rewards = fetchedRewards;
/* 210 */                 sSyncFetchedRewards.activity_id = cfg.activityId;
/* 211 */                 OnlineManager.getInstance().sendAtOnce(((Long)ROnRoleLogin.this.arg).longValue(), sSyncFetchedRewards);
/*     */               }
/*     */               
/*     */ 
/*     */ 
/* 216 */               if (!status.sendRewardBroadcast)
/*     */               {
/* 218 */                 SDeliveryStageCfg sDeliveryStageCfg = SDeliveryStageCfg.get(cfg.activityId);
/* 219 */                 if (sDeliveryStageCfg == null) {
/* 220 */                   return false;
/*     */                 }
/* 222 */                 int currentStage = GratefulDeliveryManager.getCurrentDeliveryCountStage(cfg.activityId);
/*     */                 
/* 224 */                 SStageInformation sStageInformation = (SStageInformation)sDeliveryStageCfg.stages.get(currentStage - 1);
/* 225 */                 if (sStageInformation == null) {
/* 226 */                   return false;
/*     */                 }
/*     */                 
/* 229 */                 if ((currentStage > 0) && (!xRoleDeliveryStatus.getNotified_rewards().contains(Integer.valueOf(currentStage))) && (!fetchedRewards.contains(Integer.valueOf(currentStage))))
/*     */                 {
/*     */ 
/* 232 */                   xRoleDeliveryStatus.getNotified_rewards().add(Integer.valueOf(currentStage));
/*     */                   
/* 234 */                   SNotifyReward sNotifyReward = new SNotifyReward();
/* 235 */                   sNotifyReward.activity_id = cfg.activityId;
/* 236 */                   sNotifyReward.count = sStageInformation.count;
/* 237 */                   OnlineManager.getInstance().send(((Long)ROnRoleLogin.this.arg).longValue(), sNotifyReward);
/*     */                 }
/*     */               }
/* 240 */               return true;
/*     */             }
/*     */             
/*     */ 
/* 244 */           }.call();
/* 245 */           new PCheckAndSendRewardMail(cfg.activityId, ((Long)this.arg).longValue()).call();
/*     */         }
/*     */       } }
/*     */   }
/*     */   
/* 250 */   private class Status { boolean hasItem = false;
/* 251 */     long sourceId = 0L;
/* 252 */     int autoDeliveryTime = 0;
/* 253 */     boolean recycledItemDistributed = false;
/* 254 */     boolean sendRewardBroadcast = false;
/*     */     
/*     */     private Status() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */