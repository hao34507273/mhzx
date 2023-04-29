/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CorpsCaptainChange extends mzm.event.BasicEvent<CorpsCaptainChangeEventArg>
/*    */ {
/*  7 */   private static EventManager<CorpsCaptainChangeEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CorpsCaptainChangeEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnCorpsCaptainChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\CorpsCaptainChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */