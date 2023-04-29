/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MatchSucceed extends mzm.event.BasicEvent<MatchSucceedArg>
/*    */ {
/*  7 */   private static EventManager<MatchSucceedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MatchSucceedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnMatchSucceed());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnMatchSucceed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */