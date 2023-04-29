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
/*    */ public class AircraftOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 3014;
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
/* 35 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*    */     
/* 37 */     Collection<Integer> ownAircraftCfgIds = AircraftInterface.getOwnAircraftCfgIdList(roleId, true);
/* 38 */     int newNum; int newNum; if (null == ownAircraftCfgIds)
/*    */     {
/* 40 */       newNum = 0;
/*    */     }
/*    */     else
/*    */     {
/* 44 */       newNum = ownAircraftCfgIds.size();
/*    */     }
/*    */     
/* 47 */     if (newNum == oldNum)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 53 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, newNum)));
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 60 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AircraftOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */