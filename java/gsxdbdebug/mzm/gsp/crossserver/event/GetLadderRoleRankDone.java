/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetLadderRoleRankDone extends mzm.event.BasicEvent<GetLadderRoleRankDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetLadderRoleRankDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetLadderRoleRankDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnGetLadderRoleRankDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetLadderRoleRankDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */