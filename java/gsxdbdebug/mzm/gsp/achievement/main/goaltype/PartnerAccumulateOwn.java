/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class PartnerAccumulateOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 16 */     return 604;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 22 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 30 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 31 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 32 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, oldCount + 1)));
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 41 */     int currentCount = PartnerInterface.getRoleAllPartnerIds(roleId, true).size();
/* 42 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 43 */     if (oldCount == currentCount)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 49 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, currentCount)));
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PartnerAccumulateOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */