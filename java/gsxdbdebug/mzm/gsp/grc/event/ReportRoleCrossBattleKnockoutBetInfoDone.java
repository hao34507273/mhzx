/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportRoleCrossBattleKnockoutBetInfoDone extends mzm.event.BasicEvent<ReportRoleCrossBattleKnockoutBetInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportRoleCrossBattleKnockoutBetInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportRoleCrossBattleKnockoutBetInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnReportRoleCrossBattleKnockoutBetInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\ReportRoleCrossBattleKnockoutBetInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */