/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.mall.event.JiFenChangedArg;
/*    */ import mzm.gsp.mall.event.JiFenChangedProcedure;
/*    */ 
/*    */ public class POnJiFenChanged extends JiFenChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     int tokenType = ((JiFenChangedArg)this.arg).tokenType;
/*    */     
/* 14 */     AbstractConditionalValueChange.Context ctx1 = new AbstractConditionalValueChange.Context(tokenType, (int)((JiFenChangedArg)this.arg).leftNum);
/*    */     
/* 16 */     AchievementManager.updateGoalTypeState(((JiFenChangedArg)this.arg).roleId, 4704, ctx1, "POnJiFenChanged.processImp@handle OWN_TOKEN finish");
/*    */     
/*    */ 
/*    */ 
/* 20 */     AbstractConditionalDoneOneEventTimes.Context ctx2 = new AbstractConditionalDoneOneEventTimes.Context(tokenType, Math.abs((int)((JiFenChangedArg)this.arg).changeNum));
/*    */     
/*    */ 
/* 23 */     if (((JiFenChangedArg)this.arg).changeNum > 0L)
/*    */     {
/*    */ 
/* 26 */       AchievementManager.updateGoalTypeState(((JiFenChangedArg)this.arg).roleId, 4706, ctx2, "POnJiFenChanged.processImp@handle ACCUMULAT_GET_TOKEN finish");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 32 */       AchievementManager.updateGoalTypeState(((JiFenChangedArg)this.arg).roleId, 4703, ctx2, "POnJiFenChanged.processImp@handle ACCUMULAT_COST_TOKEN finish");
/*    */     }
/*    */     
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJiFenChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */