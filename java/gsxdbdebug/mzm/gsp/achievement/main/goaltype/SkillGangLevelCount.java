/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.gangskill.main.GangSkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillGangLevelCount
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 1813;
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
/* 35 */     int goalSkillLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 36 */     Map<Integer, Integer> gangSkillId2Level = GangSkillInterface.getGangSkillid2Level(roleId);
/* 37 */     int validSkillCount = 0;
/* 38 */     for (Iterator i$ = gangSkillId2Level.values().iterator(); i$.hasNext();) { int skillLevel = ((Integer)i$.next()).intValue();
/*    */       
/* 40 */       if (skillLevel >= goalSkillLevel)
/*    */       {
/* 42 */         validSkillCount++;
/*    */       }
/*    */     }
/*    */     
/* 46 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 47 */     if (validSkillCount == oldCount)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 53 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, validSkillCount)));
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillGangLevelCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */