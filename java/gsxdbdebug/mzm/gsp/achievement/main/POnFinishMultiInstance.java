/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.instance.event.FinishMultiInstanceArg;
/*    */ import mzm.gsp.instance.event.FinishMultiInstanceProcedure;
/*    */ 
/*    */ public class POnFinishMultiInstance
/*    */   extends FinishMultiInstanceProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(((FinishMultiInstanceArg)this.arg).getInstanceDisType(), 1);
/* 13 */     AchievementManager.updateGoalTypeState(((FinishMultiInstanceArg)this.arg).getRoleid(), 5004, context, "POnFinishMultiInstance.processImp@handle FINISH_MULTI_INSTANCE_COUNT success");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFinishMultiInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */