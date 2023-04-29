/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.fabao.event.FabaoComplexArg;
/*    */ import mzm.gsp.fabao.event.FabaoComplexProcedure;
/*    */ 
/*    */ public class POnFabaoComplex
/*    */   extends FabaoComplexProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FabaoComplexArg)this.arg).getRoleId(), 4203, null, "POnFabaoComplex.processImp@handle FABAO_SPECIFIC_STAR success");
/*    */     
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFabaoComplex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */