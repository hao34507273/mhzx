/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MatchCancelFail extends mzm.event.BasicEvent<MatchCancelFailArg>
/*    */ {
/*  7 */   private static EventManager<MatchCancelFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MatchCancelFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnMatchCancelFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchCancelFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */