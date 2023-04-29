/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetRoleCrossBattleBetWinRankInfoDone extends mzm.event.BasicEvent<GetRoleCrossBattleBetWinRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetRoleCrossBattleBetWinRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetRoleCrossBattleBetWinRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnGetRoleCrossBattleBetWinRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetRoleCrossBattleBetWinRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */