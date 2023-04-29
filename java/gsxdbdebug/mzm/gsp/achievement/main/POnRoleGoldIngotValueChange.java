/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.role.event.GoldIngotValueChangeProcedure;
/*    */ import mzm.gsp.role.event.MoneyChangeArg;
/*    */ 
/*    */ public class POnRoleGoldIngotValueChange
/*    */   extends GoldIngotValueChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     AbstractConditionalValueChange.Context context1 = new AbstractConditionalValueChange.Context(5, (int)((MoneyChangeArg)this.arg).getNewValue());
/*    */     
/*    */ 
/* 17 */     AchievementManager.updateGoalTypeState(((MoneyChangeArg)this.arg).getRoleId(), 4702, context1, "POnRoleGoldIngotValueChange.processImp@handle OWN_MONEY finish");
/*    */     
/*    */ 
/* 20 */     int costValue = (int)(((MoneyChangeArg)this.arg).getOldValue() - ((MoneyChangeArg)this.arg).getNewValue());
/* 21 */     if (costValue > 0)
/*    */     {
/*    */ 
/* 24 */       AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(5, costValue);
/* 25 */       AchievementManager.updateGoalTypeState(((MoneyChangeArg)this.arg).getRoleId(), 4701, context, "POnRoleGoldIngotValueChange.processImp@handle ACCUMULAT_COST_MONEY finish");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 31 */       AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(5, Math.abs(costValue));
/* 32 */       AchievementManager.updateGoalTypeState(((MoneyChangeArg)this.arg).getRoleId(), 4705, context, "POnRoleGoldIngotValueChange.processImp@handle ACCUMULAT_GET_MONEY finish");
/*    */     }
/*    */     
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleGoldIngotValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */