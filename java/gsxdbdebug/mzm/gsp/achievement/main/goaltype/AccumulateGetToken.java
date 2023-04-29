/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class AccumulateGetToken extends AbstractConditionalDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 14 */     return 4706;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     int tokenType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 23 */     long nowAmount = MallInterface.getJifen(roleId, tokenType);
/*    */     
/*    */ 
/* 26 */     int oldAmount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 27 */     if (oldAmount >= nowAmount)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     int goalAmount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 32 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf((int)Math.min(goalAmount, nowAmount)));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AccumulateGetToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */