/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReportRoleBigBossRankInfoDone extends mzm.event.BasicEvent<ReportRoleBigBossRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<ReportRoleBigBossRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReportRoleBigBossRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.bigboss.main.POnReportRoleBigBossRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportRoleBigBossRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */