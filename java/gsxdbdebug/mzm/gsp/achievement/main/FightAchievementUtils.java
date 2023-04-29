/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FightAchievementUtils
/*    */ {
/*    */   static void updateSkillAchievement(long roleId, SkillResult skillResult)
/*    */   {
/* 23 */     AchievementManager.updateGoalTypeState(roleId, 5121, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_KILL success");
/*    */     
/*    */ 
/*    */ 
/* 27 */     AchievementManager.updateGoalTypeState(roleId, 5122, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONCE_KILL success");
/*    */     
/*    */ 
/*    */ 
/* 31 */     AchievementManager.updateGoalTypeState(roleId, 5123, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONCE_CRITICAL success");
/*    */     
/*    */ 
/*    */ 
/* 35 */     AchievementManager.updateGoalTypeState(roleId, 5124, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_KILL_REBORN success");
/*    */     
/*    */ 
/*    */ 
/* 39 */     AchievementManager.updateGoalTypeState(roleId, 5125, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_BE_DODGED success");
/*    */     
/*    */ 
/*    */ 
/* 43 */     AchievementManager.updateGoalTypeState(roleId, 5126, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_TARGET_REMAIN_HP_COUNT success");
/*    */     
/*    */ 
/*    */ 
/* 47 */     AchievementManager.updateGoalTypeState(roleId, 5127, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_HIT_MAIN_TARGET success");
/*    */     
/*    */ 
/*    */ 
/* 51 */     AchievementManager.updateGoalTypeState(roleId, 5128, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_FAIL success");
/*    */     
/*    */ 
/*    */ 
/* 55 */     AchievementManager.updateGoalTypeState(roleId, 5130, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_COMBO_PHASE_COUNT success");
/*    */     
/*    */ 
/*    */ 
/* 59 */     AchievementManager.updateGoalTypeState(roleId, 5129, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_COMBO_TARGET_INTO_STATE success");
/*    */     
/*    */ 
/*    */ 
/* 63 */     AchievementManager.updateGoalTypeState(roleId, 5131, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_COMBO_TARGET_INTO_STATE_FAIL success");
/*    */     
/*    */ 
/*    */ 
/* 67 */     AchievementManager.updateGoalTypeState(roleId, 5134, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_SHARE_DAMAGE_KILL success");
/*    */     
/*    */ 
/*    */ 
/* 71 */     AchievementManager.updateGoalTypeState(roleId, 5135, skillResult, "FightAchievementUtils.updateSkillAchievement@handle SKILL_ONE_FIGHT_MIRROR_OCCUPATION_NUM success");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\FightAchievementUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */