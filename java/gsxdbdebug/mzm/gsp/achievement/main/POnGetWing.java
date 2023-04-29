/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.wing.event.GetWingEventProcedure;
/*    */ import mzm.gsp.wing.event.GetWingdArg;
/*    */ 
/*    */ public class POnGetWing
/*    */   extends GetWingEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     AbstractConditionalValueChange.Context context = new AbstractConditionalValueChange.Context(((GetWingdArg)this.arg).getNewWing(), 1);
/* 13 */     AchievementManager.updateGoalTypeState(((GetWingdArg)this.arg).getRoleid(), 3903, context, "POnGetWing.processImp@handle WING_VIEW_OWN finish");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGetWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */