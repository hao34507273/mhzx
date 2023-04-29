/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AppearanceMountsObserver extends mzm.event.BasicEvent<AppearanceMountsObserverArg>
/*    */ {
/*  7 */   private static EventManager<AppearanceMountsObserverArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AppearanceMountsObserverArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.mounts.main.POnAppearanceMountsObserver());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\AppearanceMountsObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */