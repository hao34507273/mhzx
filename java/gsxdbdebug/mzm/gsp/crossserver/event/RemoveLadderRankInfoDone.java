/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemoveLadderRankInfoDone extends mzm.event.BasicEvent<RemoveLadderRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<RemoveLadderRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemoveLadderRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnRemoveLadderRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemoveLadderRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */