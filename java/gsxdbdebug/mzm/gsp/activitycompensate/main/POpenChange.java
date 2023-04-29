/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.ActivityCompensateGlobal;
/*    */ import xbean.ActivityCompensatesGlobal;
/*    */ 
/*    */ public class POpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!((OpenChangeComplexArg)this.arg).isOpen()) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     List<Integer> activities = ActivityCompensateHandlerManager.getInstance().getActivitiesBySwitchid(((OpenChangeComplexArg)this.arg).getType());
/*    */     
/*    */ 
/* 27 */     ActivityCompensatesGlobal xCompensatesGlobal = ActivityCompensateManager.createXCompensatesGlobalIfNotExist();
/* 28 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 30 */     for (Iterator i$ = activities.iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 31 */       int activityType = ActivityInterface.getLogicTypeByActivityId(activityid);
/* 32 */       ActivityCompensateHandler handler = ActivityCompensateHandlerManager.getInstance().getHandler(activityType);
/* 33 */       if (handler == null) {
/* 34 */         ActivityCompensateManager.logError("POpenChange.processImp@hander null|switchid=%d|activityid=%d|activity_type=%d", new Object[] { Integer.valueOf(((OpenChangeComplexArg)this.arg).getType()), Integer.valueOf(activityid), Integer.valueOf(activityType) });
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/*    */ 
/* 40 */         List<Integer> switchList = handler.getActivitySwitchList(activityid);
/* 41 */         if ((switchList == null) || (switchList.isEmpty())) {
/* 42 */           ActivityCompensateManager.logError("POpenChange.processImp@switch null by handler|switchid=%d|activityid=%d|activity_type=%d", new Object[] { Integer.valueOf(((OpenChangeComplexArg)this.arg).getType()), Integer.valueOf(activityid), Integer.valueOf(activityType) });
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/*    */ 
/* 48 */           for (Iterator i$ = switchList.iterator(); i$.hasNext();) { int switchid = ((Integer)i$.next()).intValue();
/* 49 */             if (switchid != ((OpenChangeComplexArg)this.arg).getType())
/*    */             {
/*    */ 
/* 52 */               if (!OpenInterface.getOpenStatus(switchid)) {
/* 53 */                 ActivityCompensateManager.logInfo("POpenChange.processImp@activity not open|opened_switchid=%d|activityid=%d|activity_type=%d|not_opened_switchid=%d", new Object[] { Integer.valueOf(((OpenChangeComplexArg)this.arg).getType()), Integer.valueOf(activityid), Integer.valueOf(activityType), Integer.valueOf(switchid) });
/*    */               }
/*    */             }
/*    */           }
/*    */           
/*    */ 
/*    */ 
/* 60 */           ActivityCompensateGlobal xCompensateGlobal = ActivityCompensateManager.createXCompensateGlobalIfNotExist(xCompensatesGlobal, activityid);
/*    */           
/* 62 */           xCompensateGlobal.setOpen_time(nowMillis);
/*    */           
/* 64 */           GlobalData.getInstance().setActivityOpenTime(activityid, nowMillis);
/*    */           
/* 66 */           ActivityCompensateManager.logInfo("POpenChange.processImp@record activity open|opened_switchid=%d|activityid=%d|activity_type=%d", new Object[] { Integer.valueOf(((OpenChangeComplexArg)this.arg).getType()), Integer.valueOf(activityid), Integer.valueOf(activityType) });
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 72 */     if (((OpenChangeComplexArg)this.arg).getType() == 544) {
/* 73 */       NoneRealTimeTaskManager.getInstance().addTask(new RRefreshOnlineCompensates());
/*    */     }
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\POpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */