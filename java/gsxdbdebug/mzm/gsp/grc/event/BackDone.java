/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BackDone extends mzm.event.BasicEvent<BackDoneArg>
/*    */ {
/*  7 */   private static EventManager<BackDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BackDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnBackDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\BackDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */