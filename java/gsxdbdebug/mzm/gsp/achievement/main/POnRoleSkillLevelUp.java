/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.skill.confbean.SSkillBagCfg;
/*    */ import mzm.gsp.skill.event.RoleSkillArg;
/*    */ import mzm.gsp.skill.event.RoleSkillLevelUpProcedure;
/*    */ 
/*    */ public class POnRoleSkillLevelUp extends RoleSkillLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 15 */     for (Map.Entry<Integer, Integer> entry : ((RoleSkillArg)this.arg).newLevelMap.entrySet())
/*    */     {
/* 17 */       int skillCfgId = ((Integer)entry.getKey()).intValue();
/*    */       
/* 19 */       if (null != SSkillBagCfg.get(skillCfgId))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 24 */         int skillLevel = ((Integer)entry.getValue()).intValue();
/*    */         
/* 26 */         AbstractConditionalValueChange.Context context1 = new AbstractConditionalValueChange.Context(skillCfgId, skillLevel);
/*    */         
/* 28 */         AchievementManager.updateGoalTypeState(((RoleSkillArg)this.arg).roleId, 1808, context1, "POnRoleSkillLevelUp.processImp@handle SKILL_MENPAI_LEVEL success");
/*    */         
/*    */ 
/*    */ 
/* 32 */         AbstractDoneOneEventLevelTimes.Context context2 = new AbstractDoneOneEventLevelTimes.Context(skillLevel, skillCfgId);
/*    */         
/* 34 */         AchievementManager.updateGoalTypeState(((RoleSkillArg)this.arg).roleId, 1800, context2, "POnRoleSkillLevelUp.processImp@handle SKILL_MENPAI_SHENGJI success");
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */