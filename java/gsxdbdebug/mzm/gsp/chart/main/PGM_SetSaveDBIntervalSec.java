/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetSaveDBIntervalSec extends LogicProcedure
/*    */ {
/*    */   private int intervalSec;
/*    */   
/*    */   public PGM_SetSaveDBIntervalSec(int intervalSec) {
/* 10 */     this.intervalSec = intervalSec;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     RankDBManager.getInstance().setSaveDbIntervalSec(this.intervalSec);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\PGM_SetSaveDBIntervalSec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */