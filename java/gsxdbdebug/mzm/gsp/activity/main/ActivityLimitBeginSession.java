/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeStart;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeStartArg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class ActivityLimitBeginSession extends Session
/*    */ {
/*    */   private final long beginTime;
/*    */   
/*    */   public ActivityLimitBeginSession(long interval, int activityid, long beginTime)
/*    */   {
/* 17 */     super(interval, activityid);
/* 18 */     this.beginTime = beginTime;
/*    */   }
/*    */   
/*    */   private int getActivityid() {
/* 22 */     return (int)getOwerId();
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     Executor.getInstance().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 31 */         int activityid = ActivityLimitBeginSession.this.getActivityid();
/* 32 */         SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 33 */         if (activityCfg.activityTimeIds.size() <= 0) {
/* 34 */           ActivityObsever.handleOnTimerActivityStart(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis(), ActivityLimitBeginSession.this.beginTime, activityid);
/*    */         }
/*    */         
/*    */ 
/* 38 */         ActivityLimitTimeStartArg activityLimitTimeStartArg = new ActivityLimitTimeStartArg(ActivityLimitBeginSession.this.getActivityid(), ActivityLimitBeginSession.this.beginTime);
/*    */         
/* 40 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new ActivityLimitTimeStart(), activityLimitTimeStartArg);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityLimitBeginSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */