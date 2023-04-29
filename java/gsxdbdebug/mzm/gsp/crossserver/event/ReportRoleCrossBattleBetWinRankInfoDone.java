/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportRoleCrossBattleBetWinRankInfoDone extends mzm.event.BasicEvent<ReportRoleCrossBattleBetWinRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportRoleCrossBattleBetWinRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportRoleCrossBattleBetWinRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnReportRoleCrossBattleBetWinRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportRoleCrossBattleBetWinRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */