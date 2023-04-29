/*   */ package mzm.gsp.qmhw.main;
/*   */ 
/*   */ import mzm.gsp.util.LogicProcedure;
/*   */ 
/*   */ public class PGM_HandleEndResult extends LogicProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return new PQMHWEndResult(-1L, false).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PGM_HandleEndResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */