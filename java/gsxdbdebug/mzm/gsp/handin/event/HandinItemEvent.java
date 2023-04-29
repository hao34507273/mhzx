/*    */ package mzm.gsp.handin.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class HandinItemEvent extends mzm.event.BasicEvent<HandinItemArg>
/*    */ {
/*  7 */   private static EventManager<HandinItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<HandinItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\handin\event\HandinItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */