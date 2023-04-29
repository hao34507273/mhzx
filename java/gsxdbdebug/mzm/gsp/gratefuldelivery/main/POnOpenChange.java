/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!GratefulDeliveryManager.postInitFlag) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     if (!((OpenChangeComplexArg)this.arg).isOpen()) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     int activityId = 0;
/* 27 */     for (SDeliveryCfg cfg : SDeliveryCfg.getAll().values())
/*    */     {
/* 29 */       if (cfg.switchId == ((OpenChangeComplexArg)this.arg).getType())
/*    */       {
/* 31 */         activityId = cfg.activityId;
/* 32 */         break;
/*    */       }
/*    */     }
/* 35 */     if (activityId == 0) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!ActivityInterface.isActivityOpen(activityId)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (GratefulDeliveryManager.isDeliveryInitialized(activityId))
/*    */     {
/*    */ 
/* 46 */       NoneRealTimeTaskManager.getInstance().addTask(new RDistributeItemAfterActivityStart(activityId));
/* 47 */       GratefulDeliveryManager.info(this, ".processImp()@activity continued|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) });
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 52 */       GratefulDeliveryManager.initActivityData(activityId);
/* 53 */       NoneRealTimeTaskManager.getInstance().addTask(new RDistributeItemOnActivityStart(activityId));
/* 54 */       NoneRealTimeTaskManager.getInstance().addTask(new RSendMailOnActivityStart(activityId));
/*    */       
/* 56 */       GratefulDeliveryManager.info(this, ".processImp()@activity started|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) });
/*    */     }
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */