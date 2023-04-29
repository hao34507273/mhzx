/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetIndianaAwardNumberDone extends mzm.event.BasicEvent<GetIndianaAwardNumberDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetIndianaAwardNumberDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetIndianaAwardNumberDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.indiana.main.POnGetIndianaAwardNumberDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetIndianaAwardNumberDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */