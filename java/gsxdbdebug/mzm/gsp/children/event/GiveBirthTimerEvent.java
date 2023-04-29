/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GiveBirthTimerEvent extends mzm.event.BasicEvent<GiveBirthTimerEventArg>
/*    */ {
/*  7 */   private static EventManager<GiveBirthTimerEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GiveBirthTimerEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.main.POnChildGiveBirthTimer());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\GiveBirthTimerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */