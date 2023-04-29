/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*     */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEvent;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.DeliveryStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GratefulDeliveryActivityHandler
/*     */   implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  29 */     GratefulDeliveryManager.initRoleData(activityid, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  35 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  41 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, final int activityId)
/*     */   {
/*  54 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(activityId, true);
/*     */     
/*     */ 
/*  57 */     if ((xDeliveryStatus != null) && (activityStartType.startAgain()))
/*     */     {
/*     */ 
/*  60 */       for (final Map.Entry<Long, Integer> entry : xDeliveryStatus.getItem_holders().entrySet())
/*     */       {
/*     */ 
/*  63 */         if (((Integer)entry.getValue()).intValue() > (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L))
/*     */         {
/*  65 */           TriggerEventsManger.getInstance().triggerEvent(new StartAutoDeliverySessionEvent(), new ArgForAutoDeliverySession(activityId, ((Long)entry.getKey()).longValue(), ((Integer)entry.getValue()).intValue()), RoleOneByOneManager.getInstance().getTaskOneByOne(entry.getKey()));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*  74 */           new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/*  79 */               return GratefulDeliveryManager.recycleItem(activityId, ((Long)entry.getKey()).longValue());
/*     */             }
/*     */           }.execute();
/*     */         }
/*     */       }
/*     */       
/*  85 */       GratefulDeliveryManager.info(this, ".onActivityStart()@activity started again|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) });
/*  86 */       return;
/*     */     }
/*     */     
/*     */ 
/*  90 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(activityId);
/*  91 */     if (sDeliveryCfg == null)
/*  92 */       return;
/*  93 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/*  94 */       return;
/*     */     }
/*  96 */     GratefulDeliveryManager.initActivityData(activityId);
/*  97 */     NoneRealTimeTaskManager.getInstance().addTask(new RDistributeItemOnActivityStart(activityId));
/*  98 */     NoneRealTimeTaskManager.getInstance().addTask(new RSendMailOnActivityStart(activityId));
/*     */     
/* 100 */     GratefulDeliveryManager.info(this, ".onActivityStart()@activity started|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) });
/*     */   }
/*     */   
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */   public void onActivityEnd(int activityid) {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\GratefulDeliveryActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */