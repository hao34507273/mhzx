/*    */ package mzm.gsp.watchmoon.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WatchMoonFinishEvent extends mzm.event.BasicEvent<WatchMoonFinishArg>
/*    */ {
/*  7 */   private static EventManager<WatchMoonFinishArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WatchMoonFinishArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnWatchMoonActivityFinish());
/* 16 */     manager.register(new mzm.gsp.exploit.main.targets.POnShangyueActivityFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\event\WatchMoonFinishEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */