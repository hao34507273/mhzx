/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AvatarSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5803;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 30 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 37 */     int ownCount = 0;
/* 38 */     Set<Integer> avatarSet = new HashSet();
/* 39 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 41 */       int parameter = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 42 */       if (parameter != 0)
/*    */       {
/*    */ 
/*    */ 
/* 46 */         avatarSet.add(Integer.valueOf(parameter));
/* 47 */         if (AvatarInterface.hasAvatars(roleId, avatarSet, true, true))
/*    */         {
/* 49 */           ownCount++;
/*    */         }
/* 51 */         avatarSet.clear();
/*    */       } }
/* 53 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 54 */     if (oldCount == ownCount)
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 61 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, ownCount)));
/* 62 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 69 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AvatarSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */