/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyDistribution;
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
/*     */ public class RDistributeItemOnActivityStart extends LogicRunnable
/*     */ {
/*     */   private final int activityId;
/*     */   
/*     */   RDistributeItemOnActivityStart(int activityId)
/*     */   {
/*  30 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  36 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  37 */     if (sDeliveryCfg == null) {
/*  38 */       return;
/*     */     }
/*     */     
/*  41 */     GratefulDeliveryManager.clearAvailableRoleMap(this.activityId);
/*     */     
/*  43 */     int minLevel = sDeliveryCfg.minLevel - 1;
/*  44 */     Set<Long> roleIds = OnlineManager.getInstance().getOnlineHigherRoleidSet(minLevel);
/*     */     
/*     */ 
/*  47 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*  48 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  53 */           String userId = RoleInterface.getUserId(roleId);
/*  54 */           if (userId == null) {
/*  55 */             return false;
/*     */           }
/*     */           
/*  58 */           if (ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, RDistributeItemOnActivityStart.this.activityId).isCanJoin()) {
/*  59 */             GratefulDeliveryManager.updateRoleInAvailableRoleMap(RDistributeItemOnActivityStart.this.activityId, roleId);
/*     */           }
/*  61 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */     
/*  66 */     int availableRoleCount = GratefulDeliveryManager.getAvailableRoleCount(this.activityId);
/*  67 */     int minItemNum = SDeliveryCfg.get(this.activityId).minItemNum;
/*  68 */     int maxItemNum = SDeliveryCfg.get(this.activityId).maxItemNum;
/*  69 */     int itemNum = availableRoleCount / 100;
/*  70 */     itemNum = itemNum < minItemNum ? minItemNum : itemNum;
/*  71 */     itemNum = itemNum > maxItemNum ? maxItemNum : itemNum;
/*     */     
/*     */ 
/*  74 */     final int autoDeliveryTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + SDeliveryCfg.get(this.activityId).autoRedeliveryCountdown;
/*     */     
/*     */ 
/*     */ 
/*  78 */     SNotifyDistribution sNotifyDistribution = new SNotifyDistribution();
/*  79 */     sNotifyDistribution.activity_id = this.activityId;
/*  80 */     SNotifyReceiving sNotifyReceiving = new SNotifyReceiving();
/*  81 */     sNotifyReceiving.activity_id = this.activityId;
/*  82 */     sNotifyReceiving.source_id = 0L;
/*  83 */     sNotifyReceiving.time = autoDeliveryTime;
/*     */     
/*     */ 
/*  86 */     for (int i = 0; i < itemNum; i++)
/*     */     {
/*  88 */       final Long roleId = GratefulDeliveryManager.getAndRemoveAvailableRoleId(this.activityId);
/*  89 */       if (roleId == null) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/*  94 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  99 */           RoleDeliveryStatus xRoleDeliveryStatus = GratefulDeliveryManager.getLatestRoleDeliveryStatus(RDistributeItemOnActivityStart.this.activityId, roleId.longValue(), true);
/*     */           
/* 101 */           DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(RDistributeItemOnActivityStart.this.activityId, true);
/*     */           
/* 103 */           if ((xRoleDeliveryStatus == null) || (xDeliveryStatus == null))
/*     */           {
/* 105 */             GratefulDeliveryManager.error(this, ".process()@data not found|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(RDistributeItemOnActivityStart.this.activityId), roleId });
/*     */             
/* 107 */             return false;
/*     */           }
/*     */           
/* 110 */           xRoleDeliveryStatus.setSource_id(0L);
/* 111 */           xDeliveryStatus.getItem_holders().put(roleId, Integer.valueOf(autoDeliveryTime));
/*     */           
/*     */ 
/* 114 */           GratefulDeliveryManager.updateRoleInAvailableRoleMap(RDistributeItemOnActivityStart.this.activityId, roleId.longValue());
/*     */           
/*     */ 
/* 117 */           TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(RDistributeItemOnActivityStart.this.activityId, roleId.longValue(), autoDeliveryTime), RoleOneByOneManager.getInstance().getTaskOneByOne(roleId));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 122 */           GratefulDeliveryManager.tlogDistribute(roleId.longValue(), RDistributeItemOnActivityStart.this.activityId);
/* 123 */           GratefulDeliveryManager.info(this, ".process()@item distributed|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(RDistributeItemOnActivityStart.this.activityId), roleId });
/*     */           
/* 125 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 129 */       }.call();
/* 130 */       Octets roleName = new Octets();
/* 131 */       roleName.setString(RoleInterface.getName(roleId.longValue()), "UTF-8");
/* 132 */       sNotifyDistribution.roles.put(roleId, roleName);
/*     */     }
/*     */     
/*     */ 
/* 136 */     OnlineManager.getInstance().sendAllAtOnce(sNotifyDistribution);
/* 137 */     OnlineManager.getInstance().sendMultiAtOnce(sNotifyReceiving, sNotifyDistribution.roles.keySet());
/*     */     
/*     */ 
/*     */ 
/* 141 */     int recycleNum = itemNum - sNotifyDistribution.roles.size();
/* 142 */     for (int i = 0; i < recycleNum; i++) {
/* 143 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 148 */           return GratefulDeliveryManager.recycleItem(RDistributeItemOnActivityStart.this.activityId, 0L);
/*     */         }
/*     */       }.call();
/*     */     }
/* 152 */     GratefulDeliveryManager.info(this, ".process()@done|activity_cfg=%d|num_of_item_to_distribute=%d|num_of_item_distributed=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(itemNum), Integer.valueOf(sNotifyDistribution.roles.size()) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\RDistributeItemOnActivityStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */