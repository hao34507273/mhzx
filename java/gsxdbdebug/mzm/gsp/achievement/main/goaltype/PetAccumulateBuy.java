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
/*    */ 
/*    */ public class PetAccumulateBuy
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 5402;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 24 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 32 */     int goalPetCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 33 */     if ((goalPetCfgId != 0) && (goalPetCfgId != ((Integer)context).intValue()))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 40 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 41 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, oldCount + 1)));
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetAccumulateBuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */