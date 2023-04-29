/*    */ package mzm.gsp.activity.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivityLimitTimeStart extends mzm.event.BasicEvent<ActivityLimitTimeStartArg>
/*    */ {
/*  7 */   private static EventManager<ActivityLimitTimeStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivityLimitTimeStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.luckystar.main.POnActivityLimitStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\event\ActivityLimitTimeStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */