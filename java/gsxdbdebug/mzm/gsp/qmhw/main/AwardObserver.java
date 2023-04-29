/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.QMHWActivity;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ class AwardObserver
/*    */   extends Observer
/*    */ {
/*    */   public AwardObserver()
/*    */   {
/* 15 */     super(SQMHWCfgConsts.getInstance().COMMON_AWARD_INTERVAL_MIN * 60L);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 26 */         if (!QMHWManager.isInPrepareStage()) {
/* 27 */           AwardObserver.this.stopTimer();
/* 28 */           return false;
/*    */         }
/*    */         
/* 31 */         QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/* 32 */         QMHWManager.commonAward(xQmhwActivity);
/*    */         
/* 34 */         return true;
/*    */       }
/*    */       
/* 37 */     });
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\AwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */