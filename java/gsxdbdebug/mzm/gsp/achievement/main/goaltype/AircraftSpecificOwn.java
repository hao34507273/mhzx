/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AircraftSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 3013;
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
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 36 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*    */     
/* 38 */     Collection<Integer> ownAircraftCfgIds = AircraftInterface.getOwnAircraftCfgIdList(roleId, true);
/* 39 */     int newNum; int newNum; if (null == ownAircraftCfgIds)
/*    */     {
/* 41 */       newNum = 0;
/*    */     }
/*    */     else
/*    */     {
/* 45 */       int tmpNum = 0;
/* 46 */       for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */       {
/* 48 */         int targetAircraftCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 49 */         if (ownAircraftCfgIds.contains(Integer.valueOf(targetAircraftCfgId)))
/*    */         {
/* 51 */           tmpNum++;
/*    */         }
/*    */       }
/* 54 */       newNum = tmpNum;
/*    */     }
/*    */     
/* 57 */     if (newNum == oldNum)
/*    */     {
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 63 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, newNum)));
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 70 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AircraftSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */