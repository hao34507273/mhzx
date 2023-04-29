/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ public class MemoryCompetitionPrepareEventArg
/*    */ {
/*    */   private final int observerSeconds;
/*    */   private final long beginTime;
/*    */   private final long memoryCompetitionId;
/*    */   
/*    */   public MemoryCompetitionPrepareEventArg(int observerSeconds, long beginTime, long memoryCompetitionId)
/*    */   {
/* 11 */     this.observerSeconds = observerSeconds;
/* 12 */     this.beginTime = beginTime;
/* 13 */     this.memoryCompetitionId = memoryCompetitionId;
/*    */   }
/*    */   
/*    */   public long getMemoryCompetitionId()
/*    */   {
/* 18 */     return this.memoryCompetitionId;
/*    */   }
/*    */   
/*    */   public int getObserverSeconds()
/*    */   {
/* 23 */     return this.observerSeconds;
/*    */   }
/*    */   
/*    */   public long getBeginTime()
/*    */   {
/* 28 */     return this.beginTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionPrepareEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */