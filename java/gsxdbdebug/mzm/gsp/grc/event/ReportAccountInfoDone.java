/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportAccountInfoDone extends mzm.event.BasicEvent<ReportAccountInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportAccountInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportAccountInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnReportAccountInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\ReportAccountInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */