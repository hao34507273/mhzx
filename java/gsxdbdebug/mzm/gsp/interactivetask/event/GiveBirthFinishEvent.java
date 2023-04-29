/*    */ package mzm.gsp.interactivetask.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GiveBirthFinishEvent extends mzm.event.BasicEvent<GiveBirthArg>
/*    */ {
/*  7 */   private static EventManager<GiveBirthArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GiveBirthArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.main.POnGiveBirthFinishEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\event\GiveBirthFinishEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */