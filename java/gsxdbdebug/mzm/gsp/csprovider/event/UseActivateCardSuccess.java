/*    */ package mzm.gsp.csprovider.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UseActivateCardSuccess extends mzm.event.BasicEvent<UseActivateCardArg>
/*    */ {
/*  7 */   private static EventManager<UseActivateCardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UseActivateCardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.csprovider.main.POnUseActivateCardSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\event\UseActivateCardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */