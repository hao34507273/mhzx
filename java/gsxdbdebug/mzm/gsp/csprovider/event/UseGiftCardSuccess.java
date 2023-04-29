/*    */ package mzm.gsp.csprovider.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UseGiftCardSuccess extends mzm.event.BasicEvent<UseGiftCardArg>
/*    */ {
/*  7 */   private static EventManager<UseGiftCardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UseGiftCardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.csprovider.main.POnUseGiftCardSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\event\UseGiftCardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */