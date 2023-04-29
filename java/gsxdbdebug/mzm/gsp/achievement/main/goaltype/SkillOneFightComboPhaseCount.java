/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.SkillResult;
/*    */ import xbean.SkillResultAttackTimes;
/*    */ import xbean.SkillResultAttackTimesRoundInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillOneFightComboPhaseCount
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5130;
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
/* 37 */     if (null == context)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     SkillResult skillResultData = (SkillResult)context;
/* 44 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 45 */     SkillResultAttackTimes xSkillResultAttackTimes = (SkillResultAttackTimes)skillResultData.getSkillattacktimesinfight().get(Integer.valueOf(goalSkillId));
/*    */     
/* 47 */     if (null == xSkillResultAttackTimes)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     int goalPhase = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 54 */     TreeMap<Integer, Integer> round2PhaseMap = new TreeMap();
/*    */     
/* 56 */     for (SkillResultAttackTimesRoundInfo xSkillResultAttackTimesRoundInfo : xSkillResultAttackTimes.getRoundinfo())
/*    */     {
/* 58 */       round2PhaseMap.put(Integer.valueOf(xSkillResultAttackTimesRoundInfo.getRoundnumber()), Integer.valueOf(xSkillResultAttackTimesRoundInfo.getTimes()));
/*    */     }
/*    */     
/* 61 */     int maxCombo = 0;
/* 62 */     int currentCombo = 0;
/* 63 */     for (Map.Entry<Integer, Integer> entry : round2PhaseMap.entrySet())
/*    */     {
/* 65 */       currentCombo = ((Integer)entry.getValue()).intValue() == goalPhase ? currentCombo + 1 : 0;
/* 66 */       maxCombo = Math.max(maxCombo, currentCombo);
/*    */     }
/*    */     
/*    */ 
/* 70 */     int goalCombo = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 71 */     int oldCombo = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 72 */     if (oldCombo == maxCombo)
/*    */     {
/* 74 */       return false;
/*    */     }
/* 76 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCombo, maxCombo)));
/*    */     
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightComboPhaseCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */