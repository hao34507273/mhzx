/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OwnToken
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 4704;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 27 */     int tokenType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 28 */     long nowAmount = MallInterface.getJifen(roleId, tokenType);
/*    */     
/*    */ 
/* 31 */     int oldAmount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 32 */     if (oldAmount == nowAmount)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     int goalAmount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 37 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf((int)Math.min(goalAmount, nowAmount)));
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\OwnToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */