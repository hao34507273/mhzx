/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.gangskill.event.GangSkillArg;
/*    */ import mzm.gsp.gangskill.event.GangSkillChangedProcedure;
/*    */ 
/*    */ public class POnGangSkillChange
/*    */   extends GangSkillChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((GangSkillArg)this.arg).roleid, 1811, null, "POnGangSkillChange.processImp@handle SKILL_GANG_LEVEL success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((GangSkillArg)this.arg).roleid, 1813, null, "POnGangSkillChange.processImp@handle SKILL_GANG_LEVEL_COUNT success");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGangSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */