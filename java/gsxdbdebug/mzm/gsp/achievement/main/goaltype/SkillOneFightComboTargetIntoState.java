/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.SkillBuffResult;
/*    */ import xbean.SkillBuffResultInfo;
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillOneFightComboTargetIntoState
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5129;
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
/* 45 */     Map<Integer, SkillBuffResult> skillBuffResultMap = skillResultData.getSkillbuffinfight();
/* 46 */     SkillBuffResult xSkillBuffResult = (SkillBuffResult)skillBuffResultMap.get(Integer.valueOf(goalSkillId));
/* 47 */     if (null == xSkillBuffResult)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     TreeMap<Integer, SkillBuffResultInfo> roundInfoMap = new TreeMap();
/* 54 */     for (SkillBuffResultInfo xSkillBuffResultInfo : xSkillBuffResult.getRoundinfo())
/*    */     {
/* 56 */       roundInfoMap.put(Integer.valueOf(xSkillBuffResultInfo.getRoundnumber()), xSkillBuffResultInfo);
/*    */     }
/* 58 */     int goalBuff = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 59 */     int maxCombo = 0;
/* 60 */     int currentCombo = 0;
/* 61 */     for (SkillBuffResultInfo xSkillBuffResultInfo : roundInfoMap.values())
/*    */     {
/* 63 */       currentCombo = (xSkillBuffResultInfo.getIsok()) && (xSkillBuffResultInfo.getBuff() == goalBuff) ? currentCombo + 1 : 0;
/* 64 */       maxCombo = Math.max(maxCombo, currentCombo);
/*    */     }
/*    */     
/*    */ 
/* 68 */     int goalCombo = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 69 */     int oldCombo = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 70 */     if (oldCombo == maxCombo)
/*    */     {
/* 72 */       return false;
/*    */     }
/* 74 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCombo, maxCombo)));
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightComboTargetIntoState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */