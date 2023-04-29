/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ public class MemoryCompetitionIntervalObserverArg
/*    */ {
/*    */   private final int observerSeconds;
/*    */   private final long memoryCompetitionId;
/*    */   
/*    */   public MemoryCompetitionIntervalObserverArg(int observerSeconds, long memoryCompetitionId)
/*    */   {
/* 10 */     this.observerSeconds = observerSeconds;
/* 11 */     this.memoryCompetitionId = memoryCompetitionId;
/*    */   }
/*    */   
/*    */   public long getMemoryCompetitionId()
/*    */   {
/* 16 */     return this.memoryCompetitionId;
/*    */   }
/*    */   
/*    */   public int getObserverSeconds()
/*    */   {
/* 21 */     return this.observerSeconds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionIntervalObserverArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */