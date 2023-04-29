/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetBigBossRankRangeDone extends mzm.event.BasicEvent<GetBigBossRankRangeDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetBigBossRankRangeDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetBigBossRankRangeDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.bigboss.main.POnGetBigBossRankRangeDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetBigBossRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */