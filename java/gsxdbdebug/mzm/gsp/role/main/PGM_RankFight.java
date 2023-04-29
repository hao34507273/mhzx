/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_RankFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     NoneRealFightValueRankManager.getInstance().pGM_ReRank();
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_RankFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */