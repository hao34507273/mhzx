/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillLevelUpProcedure;
/*    */ 
/*    */ public class POnXiuLianSkillLevelUp
/*    */   extends XiuLianSkillLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     AbstractDoneOneEventLevelTimes.Context ctx1 = new AbstractDoneOneEventLevelTimes.Context(((XiuLianSkillArg)this.arg).newLevel, ((XiuLianSkillArg)this.arg).skillId);
/*    */     
/* 15 */     AchievementManager.updateGoalTypeState(((XiuLianSkillArg)this.arg).roleId, 1805, ctx1, "POnXiuLianSkillLevelUp.processImp@handle SKILL_XIULIAN_LEVELUP success");
/*    */     
/*    */ 
/*    */ 
/* 19 */     AbstractConditionalValueChange.Context ctx2 = new AbstractConditionalValueChange.Context(((XiuLianSkillArg)this.arg).skillId, ((XiuLianSkillArg)this.arg).newLevel);
/*    */     
/* 21 */     AchievementManager.updateGoalTypeState(((XiuLianSkillArg)this.arg).roleId, 1809, ctx2, "POnXiuLianSkillLevelUp.processImp@handle SKILL_XIULIAN_LEVEL success");
/*    */     
/*    */ 
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnXiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */