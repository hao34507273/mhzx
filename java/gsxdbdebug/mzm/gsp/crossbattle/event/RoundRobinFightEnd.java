/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoundRobinFightEnd extends mzm.event.BasicEvent<RoundRobinFightEndArg>
/*    */ {
/*  7 */   private static EventManager<RoundRobinFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoundRobinFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnRoundRobinFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\RoundRobinFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */