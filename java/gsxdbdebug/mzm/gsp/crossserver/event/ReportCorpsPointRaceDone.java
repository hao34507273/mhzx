/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportCorpsPointRaceDone extends mzm.event.BasicEvent<ReportCorpsPointRaceDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportCorpsPointRaceDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportCorpsPointRaceDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnReportCorpsPointRaceDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportCorpsPointRaceDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */