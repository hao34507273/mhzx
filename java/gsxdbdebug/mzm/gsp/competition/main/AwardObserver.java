/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AwardObserver
/*    */   extends Observer
/*    */ {
/*    */   public AwardObserver()
/*    */   {
/* 16 */     super(SCompetitionConsts.getInstance().PrepareAwardMinutes * 60);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 21 */     Procedure.execute(new PAward(this));
/*    */     
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private static class PAward extends LogicProcedure
/*    */   {
/*    */     private AwardObserver observer;
/*    */     
/*    */     PAward(AwardObserver observer)
/*    */     {
/* 32 */       this.observer = observer;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 38 */       if (!CompetitionManager.isPrepareStage()) {
/* 39 */         this.observer.stopTimer();
/* 40 */         return false;
/*    */       }
/*    */       
/* 43 */       CompetitionManager.awardAllParticipants();
/*    */       
/* 45 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\AwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */