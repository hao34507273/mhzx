/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetComboFanShengWithSkillNum
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 5408;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 26 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 33 */     long petId = ((Long)context).longValue();
/* 34 */     int goalSkillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 35 */     int skillNum = PetInterface.getPetSkillNum(roleId, petId);
/*    */     int newCombo;
/* 37 */     int newCombo; if (goalSkillNum == skillNum)
/*    */     {
/* 39 */       newCombo = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue() + 1;
/*    */     }
/*    */     else
/*    */     {
/* 43 */       newCombo = 0;
/*    */     }
/*    */     
/* 46 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(newCombo));
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetComboFanShengWithSkillNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */