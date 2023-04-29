/*    */ package mzm.gsp.banquest.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class HoldBanquestEvent extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\event\HoldBanquestEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */