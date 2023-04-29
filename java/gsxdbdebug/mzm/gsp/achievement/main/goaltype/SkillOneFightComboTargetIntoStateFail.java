/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.SkillBuffResult;
/*    */ import xbean.SkillBuffResultInfo;
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ public class SkillOneFightComboTargetIntoStateFail extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 5131;
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
/* 30 */     if (null == context)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     SkillResult skillResultData = (SkillResult)context;
/* 37 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 38 */     java.util.Map<Integer, SkillBuffResult> skillBuffResultMap = skillResultData.getSkillbuffinfight();
/* 39 */     SkillBuffResult xSkillBuffResult = (SkillBuffResult)skillBuffResultMap.get(Integer.valueOf(goalSkillId));
/* 40 */     if (null == xSkillBuffResult)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     TreeMap<Integer, SkillBuffResultInfo> roundInfoMap = new TreeMap();
/* 47 */     for (SkillBuffResultInfo xSkillBuffResultInfo : xSkillBuffResult.getRoundinfo())
/*    */     {
/* 49 */       roundInfoMap.put(Integer.valueOf(xSkillBuffResultInfo.getRoundnumber()), xSkillBuffResultInfo);
/*    */     }
/* 51 */     int goalBuff = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 52 */     int maxCombo = 0;
/* 53 */     int currentCombo = 0;
/* 54 */     for (SkillBuffResultInfo xSkillBuffResultInfo : roundInfoMap.values())
/*    */     {
/* 56 */       currentCombo = (!xSkillBuffResultInfo.getIsok()) && (xSkillBuffResultInfo.getBuff() == goalBuff) ? currentCombo + 1 : 0;
/* 57 */       maxCombo = Math.max(maxCombo, currentCombo);
/*    */     }
/*    */     
/*    */ 
/* 61 */     int goalCombo = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 62 */     int oldCombo = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 63 */     if (oldCombo == maxCombo)
/*    */     {
/* 65 */       return false;
/*    */     }
/* 67 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCombo, maxCombo)));
/*    */     
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightComboTargetIntoStateFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */