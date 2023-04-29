/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetAttendIndianaNumDone extends mzm.event.BasicEvent<GetAttendIndianaNumDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetAttendIndianaNumDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetAttendIndianaNumDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.indiana.main.POnGetAttendIndianaNumDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetAttendIndianaNumDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */