/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_Refreshqualificationcorps
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     CrossBattleKnockoutManager.clearCanJoinNowStageKnockOutCorpsIdSet();
/*    */     
/* 13 */     CrossBattleKnockoutManager.checkCanJoinNowStageKnockOut(-1L, -1L);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_Refreshqualificationcorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */