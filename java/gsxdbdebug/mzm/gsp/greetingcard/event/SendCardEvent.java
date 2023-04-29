/*    */ package mzm.gsp.greetingcard.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SendCardEvent extends mzm.event.BasicEvent<SendCardEventArg>
/*    */ {
/*  7 */   private static EventManager<SendCardEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SendCardEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gratefuldelivery.main.POnSendGreetingCard());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\event\SendCardEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */