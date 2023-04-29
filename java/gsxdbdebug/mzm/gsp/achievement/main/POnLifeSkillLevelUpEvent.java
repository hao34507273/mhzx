/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.lifeskill.event.LifeSkillLevelUpArg;
/*    */ import mzm.gsp.lifeskill.event.LifeSkillLevelUpEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLifeSkillLevelUpEvent
/*    */   extends LifeSkillLevelUpEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     AbstractDoneOneEventLevelTimes.Context ctx1 = new AbstractDoneOneEventLevelTimes.Context(((LifeSkillLevelUpArg)this.arg).afterSkillLevel, ((LifeSkillLevelUpArg)this.arg).skillId);
/*    */     
/*    */ 
/* 22 */     AchievementManager.updateGoalTypeState(((LifeSkillLevelUpArg)this.arg).roleId, 1807, ctx1, "POnLifeSkillLevelUpEvent.processImp@handle SKILL_SHENG_HUO_LEVEL_UP success");
/*    */     
/*    */ 
/*    */ 
/* 26 */     AbstractConditionalValueChange.Context ctx2 = new AbstractConditionalValueChange.Context(((LifeSkillLevelUpArg)this.arg).skillId, ((LifeSkillLevelUpArg)this.arg).afterSkillLevel);
/*    */     
/* 28 */     AchievementManager.updateGoalTypeState(((LifeSkillLevelUpArg)this.arg).roleId, 1810, ctx2, "POnLifeSkillLevelUpEvent.processImp@handle SKILL_SHENG_HUO_LEVEL success");
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnLifeSkillLevelUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */