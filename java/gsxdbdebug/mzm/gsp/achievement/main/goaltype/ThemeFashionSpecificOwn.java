/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThemeFashionSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 3020;
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
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 35 */     Collection<Integer> themeCfgIds = (Collection)ctx;
/* 36 */     int newCount = 0;
/* 37 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 39 */       if (themeCfgIds.contains(Integer.valueOf(((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter)))
/*    */       {
/* 41 */         newCount++;
/*    */       }
/*    */     }
/*    */     
/* 45 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 46 */     if (oldCount == newCount)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 52 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, newCount)));
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ThemeFashionSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */