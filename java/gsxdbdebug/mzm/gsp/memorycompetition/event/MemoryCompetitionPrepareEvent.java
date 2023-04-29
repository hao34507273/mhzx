/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MemoryCompetitionPrepareEvent extends mzm.event.BasicEvent<MemoryCompetitionPrepareEventArg>
/*    */ {
/*  7 */   private static EventManager<MemoryCompetitionPrepareEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MemoryCompetitionPrepareEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.memorycompetition.main.POnMemoryCompetitionPrepare());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionPrepareEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */