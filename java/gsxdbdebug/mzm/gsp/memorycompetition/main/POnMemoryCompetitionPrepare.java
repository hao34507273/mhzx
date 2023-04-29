/*    */ package mzm.gsp.memorycompetition.main;
/*    */ 
/*    */ import mzm.gsp.memorycompetition.event.MemoryCompetitionPrepareEventArg;
/*    */ 
/*    */ public class POnMemoryCompetitionPrepare extends mzm.gsp.memorycompetition.event.MemoryCompetitionPrepareEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     xbean.MemoryCompetitionInfo xMemoryCompetitionInfo = xtable.Memorycompetition.get(Long.valueOf(((MemoryCompetitionPrepareEventArg)this.arg).getMemoryCompetitionId()));
/* 10 */     if (xMemoryCompetitionInfo == null)
/*    */     {
/* 12 */       return false;
/*    */     }
/*    */     
/* 15 */     MemoryCompetitionPrepareObserver prepareObserver = new MemoryCompetitionPrepareObserver(((MemoryCompetitionPrepareEventArg)this.arg).getObserverSeconds() * 1000, ((MemoryCompetitionPrepareEventArg)this.arg).getMemoryCompetitionId(), ((MemoryCompetitionPrepareEventArg)this.arg).getBeginTime());
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 20 */     xMemoryCompetitionInfo.setRoles_current_prepare_question_observer(prepareObserver);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\POnMemoryCompetitionPrepare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */