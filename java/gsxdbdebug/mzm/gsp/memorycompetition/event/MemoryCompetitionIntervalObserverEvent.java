/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MemoryCompetitionIntervalObserverEvent extends mzm.event.BasicEvent<MemoryCompetitionIntervalObserverArg>
/*    */ {
/*  7 */   private static EventManager<MemoryCompetitionIntervalObserverArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MemoryCompetitionIntervalObserverArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.memorycompetition.main.POnMemoryCompetitionIntervalObserver());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionIntervalObserverEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */