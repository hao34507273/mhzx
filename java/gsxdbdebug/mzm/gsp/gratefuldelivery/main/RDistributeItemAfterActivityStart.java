/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReceiving;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*     */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.DeliveryStatus;
/*     */ import xbean.RoleDeliveryStatus;
/*     */ 
/*     */ public class RDistributeItemAfterActivityStart
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final int activityId;
/*     */   
/*     */   RDistributeItemAfterActivityStart(int activityId)
/*     */   {
/*  31 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  37 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  38 */     if (sDeliveryCfg == null) {
/*  39 */       return;
/*     */     }
/*     */     
/*  42 */     GratefulDeliveryManager.clearAvailableRoleMap(this.activityId);
/*     */     
/*     */ 
/*  45 */     int minLevel = sDeliveryCfg.minLevel - 1;
/*  46 */     Set<Long> roleIds = OnlineManager.getInstance().getOnlineHigherRoleidSet(minLevel);
/*  47 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  49 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  54 */           String userId = RoleInterface.getUserId(roleId);
/*  55 */           if (userId == null) {
/*  56 */             return false;
/*     */           }
/*  58 */           if (ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, RDistributeItemAfterActivityStart.this.activityId).isCanJoin()) {
/*  59 */             GratefulDeliveryManager.updateRoleInAvailableRoleMap(RDistributeItemAfterActivityStart.this.activityId, roleId);
/*     */           }
/*  61 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */     
/*     */     for (;;)
/*     */     {
/*  68 */       final Status status = new Status(null);
/*     */       
/*     */ 
/*  71 */       final int autoRedeliveryTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + sDeliveryCfg.autoRedeliveryCountdown;
/*     */       
/*     */ 
/*     */ 
/*  75 */       status.targetId = GratefulDeliveryManager.getAndRemoveAvailableRoleId(this.activityId);
/*     */       
/*  77 */       if (status.targetId == null) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/*  82 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  87 */           RoleDeliveryStatus xTargetRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(RDistributeItemAfterActivityStart.this.activityId, status.targetId.longValue(), true);
/*     */           
/*  89 */           DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(RDistributeItemAfterActivityStart.this.activityId, true);
/*     */           
/*  91 */           if ((xTargetRoleDeliveryStatus == null) || (xDeliveryStatus == null)) {
/*  92 */             return false;
/*     */           }
/*  94 */           int size = xDeliveryStatus.getRecycled_item_list().size();
/*  95 */           if (size <= 0) {
/*  96 */             return false;
/*     */           }
/*     */           
/*  99 */           status.sourceId = ((Long)xDeliveryStatus.getRecycled_item_list().remove(size - 1));
/* 100 */           if (status.sourceId.longValue() != 0L)
/* 101 */             xDeliveryStatus.setDelivery_count(xDeliveryStatus.getDelivery_count() + 1);
/* 102 */           xDeliveryStatus.getItem_holders().put(status.targetId, Integer.valueOf(autoRedeliveryTime));
/* 103 */           xTargetRoleDeliveryStatus.setSource_id(status.sourceId.longValue());
/*     */           
/*     */ 
/* 106 */           GratefulDeliveryManager.updateRoleInAvailableRoleMap(RDistributeItemAfterActivityStart.this.activityId, status.targetId.longValue());
/*     */           
/*     */ 
/* 109 */           GratefulDeliveryManager.checkAndBroadcastReward(RDistributeItemAfterActivityStart.this.activityId);
/*     */           
/* 111 */           GratefulDeliveryManager.info(this, ".process()@recycled item distributed|activity_cfgid=%d|source_roleid=%d|target_roleid=%d", new Object[] { Integer.valueOf(RDistributeItemAfterActivityStart.this.activityId), status.sourceId, status.targetId });
/*     */           
/*     */ 
/* 114 */           return true;
/*     */         }
/*     */       }.call();
/*     */       
/*     */ 
/* 119 */       if (status.sourceId == null)
/*     */       {
/* 121 */         GratefulDeliveryManager.addIntoAvailableRoleMap(this.activityId, status.targetId.longValue());
/* 122 */         break;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 127 */       SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/* 128 */       sNotifyReceiving.source_id = status.sourceId.longValue();
/* 129 */       if (status.sourceId.longValue() != 0L)
/*     */       {
/* 131 */         Octets sourceName = new Octets();
/* 132 */         sourceName.setString(RoleInterface.getName(status.sourceId.longValue()), "UTF-8");
/* 133 */         sNotifyReceiving.source_name = sourceName;
/*     */       }
/* 135 */       sNotifyReceiving.activity_id = this.activityId;
/* 136 */       sNotifyReceiving.time = autoRedeliveryTime;
/* 137 */       OnlineManager.getInstance().send(status.targetId.longValue(), sNotifyReceiving);
/*     */       
/*     */ 
/* 140 */       TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(this.activityId, status.targetId.longValue(), autoRedeliveryTime), RoleOneByOneManager.getInstance().getTaskOneByOne(status.targetId));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 146 */     GratefulDeliveryManager.info(this, ".process()@done|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityId) });
/*     */   }
/*     */   
/*     */   private class Status
/*     */   {
/* 151 */     Long sourceId = null;
/* 152 */     Long targetId = null;
/*     */     
/*     */     private Status() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\RDistributeItemAfterActivityStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */