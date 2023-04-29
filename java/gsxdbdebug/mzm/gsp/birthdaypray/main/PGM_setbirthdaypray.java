/*    */ package mzm.gsp.birthdaypray.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.birthdaypray.SSyncScheduleInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGM_setbirthdaypray extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   private final int taskActivityId;
/*    */   private final int changeTimes;
/*    */   
/*    */   public PGM_setbirthdaypray(int activityId, int taskActivityId, int changeTimes)
/*    */   {
/* 15 */     this.activityId = activityId;
/* 16 */     this.taskActivityId = taskActivityId;
/* 17 */     this.changeTimes = changeTimes;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     long nowTimes = BirthdayPrayManager.addWorldCounterTimes(this.activityId, this.taskActivityId, this.changeTimes);
/*    */     
/*    */ 
/* 26 */     SSyncScheduleInfo syn = new SSyncScheduleInfo();
/* 27 */     syn.activity_cfg_id = this.taskActivityId;
/* 28 */     syn.task_activity_id2times.put(Integer.valueOf(this.taskActivityId), Long.valueOf(nowTimes));
/* 29 */     OnlineManager.getInstance().sendAll(syn);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\PGM_setbirthdaypray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */