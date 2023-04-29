/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeEndArg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class ActivityLimitEndSession extends Session
/*    */ {
/*    */   private final long endTime;
/*    */   
/*    */   public ActivityLimitEndSession(long interval, int activityid, long endTime)
/*    */   {
/* 15 */     super(interval, activityid);
/* 16 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */   private int getActivityId() {
/* 20 */     return (int)getOwerId();
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     Executor.getInstance().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 29 */         int activityid = ActivityLimitEndSession.this.getActivityId();
/* 30 */         SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 31 */         if (activityCfg.activityTimeIds.size() <= 0) {
/* 32 */           ActivityObsever.handleonTimerActivityEnd(activityid);
/*    */         }
/*    */         
/* 35 */         ActivityLimitTimeEndArg activityLimitTimeEndArg = new ActivityLimitTimeEndArg(ActivityLimitEndSession.this.getActivityId(), ActivityLimitEndSession.this.endTime);
/* 36 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new mzm.gsp.activity.event.ActivityLimitTimeEnd(), activityLimitTimeEndArg);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityLimitEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */