/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.memorycompetition.main.MemoryCompetitionQuestionObserver.QuestionAnswerState;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MemoryCompetitionQuestionEventArg
/*    */ {
/*    */   private final int observerSeconds;
/*    */   private final long memoryCompetitionId;
/*    */   private final long beginTime;
/*    */   private final Map<Long, MemoryCompetitionQuestionObserver.QuestionAnswerState> role2AnswerStateMap;
/*    */   
/*    */   public MemoryCompetitionQuestionEventArg(int observerSeconds, long memoryCompetitionId, long beginTime, Map<Long, MemoryCompetitionQuestionObserver.QuestionAnswerState> role2AnswerStateMap)
/*    */   {
/* 17 */     this.observerSeconds = observerSeconds;
/* 18 */     this.memoryCompetitionId = memoryCompetitionId;
/* 19 */     this.beginTime = beginTime;
/* 20 */     this.role2AnswerStateMap = role2AnswerStateMap;
/*    */   }
/*    */   
/*    */   public long getMemoryCompetitionId()
/*    */   {
/* 25 */     return this.memoryCompetitionId;
/*    */   }
/*    */   
/*    */   public Map<Long, MemoryCompetitionQuestionObserver.QuestionAnswerState> getRole2AnswerStateMap()
/*    */   {
/* 30 */     return this.role2AnswerStateMap;
/*    */   }
/*    */   
/*    */   public int getObserverSeconds()
/*    */   {
/* 35 */     return this.observerSeconds;
/*    */   }
/*    */   
/*    */   public long getBeginTime()
/*    */   {
/* 40 */     return this.beginTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionQuestionEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */