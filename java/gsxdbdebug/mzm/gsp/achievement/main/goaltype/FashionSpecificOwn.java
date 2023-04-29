/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ public class FashionSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 5805;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 23 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 30 */     Set<Integer> ownFashionTypes = FashionDressInterface.getOwnFashionDressType(roleId, true);
/*    */     
/* 32 */     if (null == ownFashionTypes)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     int nowCount = 0;
/* 38 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 40 */       int goalFashionType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 41 */       if ((goalFashionType > 0) && (ownFashionTypes.contains(Integer.valueOf(goalFashionType))))
/*    */       {
/* 43 */         nowCount++;
/*    */       }
/*    */     }
/*    */     
/* 47 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 48 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, nowCount)));
/*    */     
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 57 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FashionSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */