/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BrdAgainstObserver
/*    */   extends Observer
/*    */ {
/* 13 */   private final boolean[] ret = new boolean[1];
/*    */   
/*    */   public BrdAgainstObserver(long interval) {
/* 16 */     super(interval);
/* 17 */     this.ret[0] = true;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 22 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 27 */         if (!CompetitionManager.isPrepareStage()) {
/* 28 */           BrdAgainstObserver.this.ret[0] = 0;
/* 29 */           return false;
/*    */         }
/*    */         
/* 32 */         CompetitionManager.broadcastAgainst();
/*    */         
/* 34 */         return true;
/*    */       }
/*    */       
/* 37 */     });
/* 38 */     return this.ret[0];
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\BrdAgainstObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */