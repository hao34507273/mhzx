/*    */ package mzm.gsp.activity.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivityRecovery extends mzm.event.BasicEvent<ActivityRecoveryArg>
/*    */ {
/*  7 */   private static EventManager<ActivityRecoveryArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivityRecoveryArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\event\ActivityRecovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */