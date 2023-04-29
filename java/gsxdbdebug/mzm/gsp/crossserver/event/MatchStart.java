/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MatchStart extends mzm.event.BasicEvent<MatchStartArg>
/*    */ {
/*  7 */   private static EventManager<MatchStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MatchStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossserver.main.POnMatchStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */