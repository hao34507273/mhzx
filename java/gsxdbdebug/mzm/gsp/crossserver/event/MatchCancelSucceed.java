/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MatchCancelSucceed extends mzm.event.BasicEvent<MatchCancelSucceedArg>
/*    */ {
/*  7 */   private static EventManager<MatchCancelSucceedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MatchCancelSucceedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnMatchCancelSucceed());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnMatchCancelSucceed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchCancelSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */