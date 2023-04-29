/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangDuty
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 903;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 26 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 33 */     int duty = GangInterface.getGangDuty(roleId);
/* 34 */     int targetDuty = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 35 */     if (duty == targetDuty)
/*    */     {
/* 37 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(1));
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 48 */     int duty = ((Integer)context).intValue();
/* 49 */     if (((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter != duty)
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 55 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(1));
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\GangDuty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */