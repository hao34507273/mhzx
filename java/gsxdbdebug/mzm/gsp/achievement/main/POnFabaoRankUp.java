/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.fabao.event.FabaoRankUpArg;
/*    */ import mzm.gsp.fabao.event.FabaoRankUpProcedure;
/*    */ 
/*    */ public class POnFabaoRankUp
/*    */   extends FabaoRankUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FabaoRankUpArg)this.arg).getRoleId(), 4203, null, "POnFabaoRankUp.processImp@handle FABAO_SPECIFIC_STAR success");
/*    */     
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFabaoRankUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */