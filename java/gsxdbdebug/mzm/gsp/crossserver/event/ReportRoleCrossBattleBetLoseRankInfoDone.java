/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportRoleCrossBattleBetLoseRankInfoDone extends mzm.event.BasicEvent<ReportRoleCrossBattleBetLoseRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportRoleCrossBattleBetLoseRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportRoleCrossBattleBetLoseRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnReportRoleCrossBattleBetLoseRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportRoleCrossBattleBetLoseRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */