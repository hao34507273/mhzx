/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChange
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     int graphId = ((TaskEventArg)this.arg).graphId;
/* 20 */     long roleId = ((TaskEventArg)this.arg).roleId;
/*    */     
/* 22 */     int activityId = SingleTaskManager.getActivityId(graphId);
/* 23 */     if (activityId <= 0)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     switch (((TaskEventArg)this.arg).taskState)
/*    */     {
/*    */     case 8: 
/* 31 */       return new PTaskHandUp(roleId, activityId, graphId, ((TaskEventArg)this.arg).isToEnd).call();
/*    */     
/*    */     case 2: 
/* 34 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/* 35 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/*    */       
/* 37 */       return true;
/*    */     
/*    */     case 9: 
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */