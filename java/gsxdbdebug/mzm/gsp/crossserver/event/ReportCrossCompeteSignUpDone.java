/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportCrossCompeteSignUpDone extends mzm.event.BasicEvent<ReportCrossCompeteSignUpDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportCrossCompeteSignUpDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportCrossCompeteSignUpDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crosscompete.main.ROnReportCrossCompeteSignUpDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportCrossCompeteSignUpDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */