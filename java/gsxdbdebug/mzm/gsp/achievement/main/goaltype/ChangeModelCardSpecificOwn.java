/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 3310;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 28 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 35 */     List<Integer> goalCardCfgIds = new LinkedList();
/* 36 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 38 */       int param = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 39 */       if (param > 0)
/*    */       {
/* 41 */         goalCardCfgIds.add(Integer.valueOf(((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter));
/*    */       }
/*    */     }
/*    */     
/* 45 */     int newNum = ChangeModelCardInterface.getSpecificCardNum(roleId, goalCardCfgIds, true);
/* 46 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 47 */     if (oldNum == newNum)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 53 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, newNum)));
/*    */     
/* 55 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 62 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ChangeModelCardSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */