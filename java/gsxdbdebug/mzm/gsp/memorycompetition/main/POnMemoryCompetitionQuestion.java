/*    */ package mzm.gsp.memorycompetition.main;
/*    */ 
/*    */ import mzm.gsp.memorycompetition.event.MemoryCompetitionQuestionEventArg;
/*    */ 
/*    */ public class POnMemoryCompetitionQuestion extends mzm.gsp.memorycompetition.event.MemoryCompetitionQuestionEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     xbean.MemoryCompetitionInfo xMemoryCompetitionInfo = xtable.Memorycompetition.get(Long.valueOf(((MemoryCompetitionQuestionEventArg)this.arg).getMemoryCompetitionId()));
/* 10 */     if (xMemoryCompetitionInfo == null)
/*    */     {
/* 12 */       return false;
/*    */     }
/*    */     
/* 15 */     MemoryCompetitionQuestionObserver questionObserver = new MemoryCompetitionQuestionObserver(((MemoryCompetitionQuestionEventArg)this.arg).getObserverSeconds() * 1000, ((MemoryCompetitionQuestionEventArg)this.arg).getMemoryCompetitionId(), ((MemoryCompetitionQuestionEventArg)this.arg).getBeginTime(), ((MemoryCompetitionQuestionEventArg)this.arg).getRole2AnswerStateMap());
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 21 */     xMemoryCompetitionInfo.setRoles_current_question_observer(questionObserver);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\POnMemoryCompetitionQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */