/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.skill.event.MakeFuMoFuProcedure;
/*    */ 
/*    */ public class POnMakeFuMoFu
/*    */   extends MakeFuMoFuProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     AchievementManager.updateGoalTypeState(((Long)this.arg).longValue(), 1801, Integer.valueOf(1), "POnMakeFuMoFu.processImp@handle SKILL_FUMOFU_ZHIZAO success");
/*    */     
/*    */ 
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMakeFuMoFu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */