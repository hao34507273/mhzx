/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentSkillGet
/*    */   extends AbstractConditionalDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 3011;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 28 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 29 */     List<Integer> equipSkills = ItemInterface.getEquipSkillCount(roleId, Collections.singletonList(Integer.valueOf(goalSkillId)), true);
/* 30 */     int skillCount = null == equipSkills ? 0 : equipSkills.size();
/* 31 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 32 */     if (skillCount == oldCount)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 38 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, skillCount)));
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\EquipmentSkillGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */