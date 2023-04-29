/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.genius.event.GeniusSkillChangeArg;
/*    */ import mzm.gsp.genius.event.GeniusSkillChangeProcedure;
/*    */ 
/*    */ public class POnGeniusSkillChange
/*    */   extends GeniusSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((GeniusSkillChangeArg)this.arg).roleid, 1812, null, "POnGeniusSkillChange.processImp@handle SKILL_GENIUS_LEVEL success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGeniusSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */