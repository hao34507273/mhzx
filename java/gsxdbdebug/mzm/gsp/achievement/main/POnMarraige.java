/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.marriage.event.MarriageArg;
/*    */ import mzm.gsp.marriage.event.MarriageEventProcedure;
/*    */ 
/*    */ 
/*    */ public class POnMarraige
/*    */   extends MarriageEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 14 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((MarriageArg)this.arg).roleidA), Long.valueOf(((MarriageArg)this.arg).roleidB) }));
/*    */     
/*    */ 
/* 17 */     AchievementManager.updateGoalTypeState(((MarriageArg)this.arg).roleidA, 303, Integer.valueOf(1), "POnMarraige.processImp@handle MARRY_COUNT sucess");
/*    */     
/* 19 */     AchievementManager.updateGoalTypeState(((MarriageArg)this.arg).roleidB, 303, Integer.valueOf(1), "POnMarraige.processImp@handle MARRY_COUNT sucess");
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 24 */     int fengshuiValue = HomelandInterface.getFengshui(((MarriageArg)this.arg).roleidA);
/* 25 */     AchievementManager.updateGoalTypeState(((MarriageArg)this.arg).roleidA, 5604, Integer.valueOf(Math.max(0, fengshuiValue)), "POnMarraige.processImp@handle HOME_FENGSHUI_VALUE success");
/*    */     
/* 27 */     AchievementManager.updateGoalTypeState(((MarriageArg)this.arg).roleidB, 5604, Integer.valueOf(Math.max(0, fengshuiValue)), "POnMarraige.processImp@handle HOME_FENGSHUI_VALUE success");
/*    */     
/*    */ 
/*    */ 
/* 31 */     int homeLevel = HomelandInterface.getCurrentHomeLevel(((MarriageArg)this.arg).roleidA);
/* 32 */     AchievementManager.updateGoalTypeState(((MarriageArg)this.arg).roleidA, 5602, Integer.valueOf(Math.max(0, homeLevel)), "POnMarraige.processImp@handle HOME_LEVEL success");
/*    */     
/* 34 */     AchievementManager.updateGoalTypeState(((MarriageArg)this.arg).roleidB, 5602, Integer.valueOf(Math.max(0, homeLevel)), "POnMarraige.processImp@handle HOME_LEVEL success");
/*    */     
/*    */ 
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMarraige.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */