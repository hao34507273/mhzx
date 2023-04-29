/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChildCount
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 5500;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 34 */     int nowCount = ChildrenInterface.getOwnChildSize(roleId, true);
/* 35 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 36 */     if (nowCount == oldCount)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 43 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(nowCount, goalCount)));
/*    */     
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 52 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ChildCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */