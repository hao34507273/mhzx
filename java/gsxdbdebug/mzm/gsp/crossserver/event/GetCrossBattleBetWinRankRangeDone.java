/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetCrossBattleBetWinRankRangeDone extends mzm.event.BasicEvent<GetCrossBattleBetWinRankRangeDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetCrossBattleBetWinRankRangeDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetCrossBattleBetWinRankRangeDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnGetCrossBattleBetWinRankRangeDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetCrossBattleBetWinRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */