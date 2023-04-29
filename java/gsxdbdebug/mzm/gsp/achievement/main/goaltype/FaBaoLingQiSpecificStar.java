/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FaBaoLingQiSpecificStar
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 4204;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 29 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 37 */     int goalClassId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 38 */     int goalStarRank = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 39 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/*    */     
/*    */     int nowCount;
/*    */     int nowCount;
/* 43 */     if (goalClassId == 0)
/*    */     {
/* 45 */       nowCount = FabaoArtifactInterface.getArtifactCountByLevel(roleId, goalStarRank, true);
/*    */     }
/*    */     else
/*    */     {
/* 49 */       nowCount = FabaoArtifactInterface.getArtifactCountByLevelAndClass(roleId, goalStarRank, goalClassId, true);
/*    */     }
/*    */     
/*    */ 
/* 53 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 54 */     if (oldCount == nowCount)
/*    */     {
/* 56 */       return false;
/*    */     }
/* 58 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, nowCount)));
/*    */     
/* 60 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 67 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FaBaoLingQiSpecificStar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */