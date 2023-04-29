/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportRoleSingleCrossFieldRankInfoDone extends mzm.event.BasicEvent<ReportRoleSingleCrossFieldRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportRoleSingleCrossFieldRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportRoleSingleCrossFieldRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnReportRoleSingleCrossFieldRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportRoleSingleCrossFieldRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */