/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.role.event.GoldValueChangeProcedure;
/*    */ import mzm.gsp.role.event.MoneyChangeArg;
/*    */ 
/*    */ public class POnRoleGoldValueChange
/*    */   extends GoldValueChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleId = ((MoneyChangeArg)this.arg).getRoleId();
/*    */     
/* 15 */     AbstractConditionalValueChange.Context context1 = new AbstractConditionalValueChange.Context(2, (int)((MoneyChangeArg)this.arg).getNewValue());
/*    */     
/*    */ 
/* 18 */     AchievementManager.updateGoalTypeState(((MoneyChangeArg)this.arg).getRoleId(), 4702, context1, "POnRoleGoldValueChange.processImp@handle OWN_MONEY finish");
/*    */     
/*    */ 
/* 21 */     long costGoldVlaue = ((MoneyChangeArg)this.arg).getOldValue() - ((MoneyChangeArg)this.arg).getNewValue();
/* 22 */     if (costGoldVlaue > 0L)
/*    */     {
/*    */ 
/* 25 */       AchievementManager.updateGoalTypeState(roleId, 4700, Integer.valueOf((int)costGoldVlaue), "POnRoleGoldValueChange.processImp@handle ACCUMULAT_COST_GOLD success");
/*    */       
/*    */ 
/*    */ 
/* 29 */       AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(2, (int)costGoldVlaue);
/* 30 */       AchievementManager.updateGoalTypeState(((MoneyChangeArg)this.arg).getRoleId(), 4701, context, "POnRoleGoldValueChange.processImp@handle ACCUMULAT_COST_MONEY finish");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 36 */       AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(2, Math.abs((int)costGoldVlaue));
/* 37 */       AchievementManager.updateGoalTypeState(((MoneyChangeArg)this.arg).getRoleId(), 4705, context, "POnRoleGoldValueChange.processImp@handle ACCUMULAT_GET_MONEY finish");
/*    */     }
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleGoldValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */