/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChange
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     if (((TaskEventArg)this.arg).taskState != 8)
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 19 */     AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(((TaskEventArg)this.arg).taskId, 1);
/* 20 */     AchievementManager.updateGoalTypeState(((TaskEventArg)this.arg).roleId, 1, context, "POnTaskStateChange.processImp@handle TASK_STATE_HANDUP success");
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */