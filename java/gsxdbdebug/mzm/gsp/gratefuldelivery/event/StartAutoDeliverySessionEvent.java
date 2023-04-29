/*    */ package mzm.gsp.gratefuldelivery.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class StartAutoDeliverySessionEvent extends mzm.event.BasicEvent<ArgForAutoDeliverySession>
/*    */ {
/*  7 */   private static EventManager<ArgForAutoDeliverySession> manager = new EventManager();
/*    */   
/*    */   public EventManager<ArgForAutoDeliverySession> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gratefuldelivery.main.ROnStartAutoDeliverySessionEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\event\StartAutoDeliverySessionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */