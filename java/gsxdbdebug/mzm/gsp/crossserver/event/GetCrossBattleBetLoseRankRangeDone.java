/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetCrossBattleBetLoseRankRangeDone extends mzm.event.BasicEvent<GetCrossBattleBetLoseRankRangeDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetCrossBattleBetLoseRankRangeDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetCrossBattleBetLoseRankRangeDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnGetCrossBattleBetLoseRankRangeDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetCrossBattleBetLoseRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */