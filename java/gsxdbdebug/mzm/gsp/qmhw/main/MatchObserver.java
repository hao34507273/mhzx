/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ class MatchObserver
/*    */   extends Observer
/*    */ {
/*    */   public MatchObserver()
/*    */   {
/* 13 */     super(SQMHWCfgConsts.getInstance().MATCH_INTERVAL_SEC);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 19 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 24 */         if (!QMHWManager.isInMathStage()) {
/* 25 */           MatchObserver.this.stopTimer();
/* 26 */           return false;
/*    */         }
/*    */         
/* 29 */         QMHWManager.matchFight();
/*    */         
/* 31 */         return true;
/*    */       }
/*    */       
/* 34 */     });
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\MatchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */