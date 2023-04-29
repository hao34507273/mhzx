/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetIndianaNumberDone extends mzm.event.BasicEvent<GetIndianaNumberDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetIndianaNumberDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetIndianaNumberDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.indiana.main.POnGetIndianaNumberDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetIndianaNumberDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */