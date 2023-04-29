/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ public abstract class AbstractDoneOneEventComboTimes
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 16 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/* 17 */     xAchievementInfo.getGoal_parameters_extra().put(Long.valueOf(0L), "0");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 24 */     Map<Long, String> extraParaMap = xAchievementInfo.getGoal_parameters_extra();
/* 25 */     int oldTimes = Integer.valueOf((String)extraParaMap.get(Long.valueOf(0L))).intValue();
/* 26 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 27 */     int addTimes = ((Integer)context).intValue();
/*    */     int newTimes;
/* 29 */     int newTimes; if (addTimes > 0)
/*    */     {
/* 31 */       newTimes = oldTimes + addTimes;
/*    */     }
/*    */     else
/*    */     {
/* 35 */       newTimes = 0;
/*    */     }
/*    */     
/* 38 */     extraParaMap.put(Long.valueOf(0L), Integer.valueOf(newTimes).toString());
/*    */     
/*    */ 
/* 41 */     int oldMaxCombo = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 42 */     int newMaxCombo = Math.max(newTimes, oldMaxCombo);
/* 43 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(newMaxCombo, goalTimes)));
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractDoneOneEventComboTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */