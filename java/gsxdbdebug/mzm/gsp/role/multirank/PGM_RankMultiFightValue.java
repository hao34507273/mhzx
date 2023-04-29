/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RankMultiFightValue
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     NoneRealMFVRankManager.getInstance().pGM_ReRank();
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PGM_RankMultiFightValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */