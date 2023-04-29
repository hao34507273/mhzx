/*    */ package mzm.gsp.activity.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivityLimitTimeEnd extends mzm.event.BasicEvent<ActivityLimitTimeEndArg>
/*    */ {
/*  7 */   private static EventManager<ActivityLimitTimeEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivityLimitTimeEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.mibao.main.POnActivityLimitEnd());
/* 16 */     manager.register(new mzm.gsp.worldgoal.main.POnActivityLimitEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\event\ActivityLimitTimeEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */