/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.marriage.event.DivorceArg;
/*    */ import mzm.gsp.marriage.event.DivorceEventProcedure;
/*    */ 
/*    */ 
/*    */ public class POnDivorce
/*    */   extends DivorceEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 14 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((DivorceArg)this.arg).roleidA), Long.valueOf(((DivorceArg)this.arg).roleidB) }));
/*    */     
/*    */ 
/* 17 */     int fengshuiValue1 = HomelandInterface.getFengshui(((DivorceArg)this.arg).roleidA);
/* 18 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidA, 5604, Integer.valueOf(Math.max(0, fengshuiValue1)), "POnDivorce.processImp@handle HOME_FENGSHUI_VALUE success");
/*    */     
/* 20 */     int fengshuiValue2 = HomelandInterface.getFengshui(((DivorceArg)this.arg).roleidB);
/* 21 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidB, 5604, Integer.valueOf(Math.max(0, fengshuiValue2)), "POnDivorce.processImp@handle HOME_FENGSHUI_VALUE success");
/*    */     
/*    */ 
/*    */ 
/* 25 */     int homeLevel1 = HomelandInterface.getCurrentHomeLevel(((DivorceArg)this.arg).roleidA);
/* 26 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidA, 5602, Integer.valueOf(Math.max(0, homeLevel1)), "POnDivorce.processImp@handle HOME_LEVEL success");
/*    */     
/* 28 */     int homeLevel2 = HomelandInterface.getCurrentHomeLevel(((DivorceArg)this.arg).roleidB);
/* 29 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidB, 5602, Integer.valueOf(Math.max(0, homeLevel2)), "POnDivorce.processImp@handle HOME_LEVEL success");
/*    */     
/*    */ 
/*    */ 
/* 33 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidA, 5603, null, "POnDivorce.processImp@handle HOME_DISPLAY_TYPE_FURNITURE success");
/*    */     
/* 35 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidB, 5603, null, "POnDivorce.processImp@handle HOME_DISPLAY_TYPE_FURNITURE success");
/*    */     
/*    */ 
/*    */ 
/* 39 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidA, 309, Integer.valueOf(0), "POnDivorce.processImp@handle MARRY_FRIEND_POINT finish");
/*    */     
/* 41 */     AchievementManager.updateGoalTypeState(((DivorceArg)this.arg).roleidB, 309, Integer.valueOf(0), "POnDivorce.processImp@handle MARRY_FRIEND_POINT finish");
/*    */     
/*    */ 
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */