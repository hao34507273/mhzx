/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MemoryCompetitionQuestionEvent extends mzm.event.BasicEvent<MemoryCompetitionQuestionEventArg>
/*    */ {
/*  7 */   private static EventManager<MemoryCompetitionQuestionEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MemoryCompetitionQuestionEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.memorycompetition.main.POnMemoryCompetitionQuestion());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionQuestionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */