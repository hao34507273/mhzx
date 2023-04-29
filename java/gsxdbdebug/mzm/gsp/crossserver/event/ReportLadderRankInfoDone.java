/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportLadderRankInfoDone extends mzm.event.BasicEvent<ReportLadderRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportLadderRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportLadderRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnReportLadderRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportLadderRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */