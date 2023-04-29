/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MatchFail extends mzm.event.BasicEvent<MatchFailArg>
/*    */ {
/*  7 */   private static EventManager<MatchFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MatchFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnMatchFail());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnMatchFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */