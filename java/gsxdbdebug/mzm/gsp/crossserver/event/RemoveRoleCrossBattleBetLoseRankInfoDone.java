/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemoveRoleCrossBattleBetLoseRankInfoDone extends mzm.event.BasicEvent<RemoveRoleCrossBattleBetLoseRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<RemoveRoleCrossBattleBetLoseRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemoveRoleCrossBattleBetLoseRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnRemoveRoleCrossBattleBetLoseRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemoveRoleCrossBattleBetLoseRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */