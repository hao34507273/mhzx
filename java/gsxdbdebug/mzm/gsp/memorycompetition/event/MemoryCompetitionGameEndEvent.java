/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MemoryCompetitionGameEndEvent extends mzm.event.BasicEvent<MemoryCompetitionGameEndArg>
/*    */ {
/*  7 */   private static EventManager<MemoryCompetitionGameEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MemoryCompetitionGameEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.memorycompetition.romanticdance.POnMemoryCompetitionGameEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionGameEndEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */