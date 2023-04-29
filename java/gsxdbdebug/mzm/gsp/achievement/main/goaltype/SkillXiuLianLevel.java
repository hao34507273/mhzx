/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillXiuLianLevel
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 1809;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 29 */     List<Integer> xGoalParameter = xAchievementInfo.getGoal_parameters();
/*    */     
/* 31 */     Map<Integer, Integer> skillLevelMap = XiuLianSkillInterface.getXiuLianSkill(roleId);
/*    */     
/* 33 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 34 */     int goalSkillLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 35 */     Integer currentSkillLevel = (Integer)skillLevelMap.get(Integer.valueOf(goalSkillId));
/* 36 */     if (null == currentSkillLevel)
/*    */     {
/* 38 */       xGoalParameter.set(0, Integer.valueOf(0));
/*    */     }
/* 40 */     if (currentSkillLevel.intValue() > ((Integer)xGoalParameter.get(0)).intValue())
/*    */     {
/* 42 */       xGoalParameter.set(0, Integer.valueOf(Math.min(currentSkillLevel.intValue(), goalSkillLevel)));
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillXiuLianLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */