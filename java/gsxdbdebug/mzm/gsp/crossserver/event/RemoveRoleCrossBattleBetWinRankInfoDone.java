/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemoveRoleCrossBattleBetWinRankInfoDone extends mzm.event.BasicEvent<RemoveRoleCrossBattleBetWinRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<RemoveRoleCrossBattleBetWinRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemoveRoleCrossBattleBetWinRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnRemoveRoleCrossBattleBetWinRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemoveRoleCrossBattleBetWinRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */