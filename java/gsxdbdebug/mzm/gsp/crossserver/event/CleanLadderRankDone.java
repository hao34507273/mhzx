/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CleanLadderRankDone extends mzm.event.BasicEvent<CleanLadderRankDoneArg>
/*    */ {
/*  7 */   private static EventManager<CleanLadderRankDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CleanLadderRankDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnCleanLadderRankDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\CleanLadderRankDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */