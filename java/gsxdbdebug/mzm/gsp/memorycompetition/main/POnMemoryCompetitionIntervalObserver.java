/*    */ package mzm.gsp.memorycompetition.main;
/*    */ 
/*    */ import mzm.gsp.memorycompetition.event.MemoryCompetitionIntervalObserverArg;
/*    */ import mzm.gsp.memorycompetition.event.MemoryCompetitionIntervalObserverEventProcedure;
/*    */ 
/*    */ public class POnMemoryCompetitionIntervalObserver extends MemoryCompetitionIntervalObserverEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     new MemoryCompetitionQuestionIntervalObserver(((MemoryCompetitionIntervalObserverArg)this.arg).getObserverSeconds() * 1000, ((MemoryCompetitionIntervalObserverArg)this.arg).getMemoryCompetitionId());
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\POnMemoryCompetitionIntervalObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */