/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractConditionalDoneOneEventComboTimes
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 17 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 25 */     int condition = ((Integer)context).intValue();
/* 26 */     int goalCondition = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*    */     int newCount;
/* 28 */     int newCount; if ((condition > 0) && ((goalCondition == 0) || (condition == goalCondition)))
/*    */     {
/* 30 */       newCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue() + 1;
/*    */     }
/*    */     else
/*    */     {
/* 34 */       newCount = 0;
/*    */     }
/*    */     
/* 37 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(newCount));
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractConditionalDoneOneEventComboTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */