/*    */ package mzm.gsp.activity.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivityPause extends mzm.event.BasicEvent<ActivityPauseArg>
/*    */ {
/*  7 */   private static EventManager<ActivityPauseArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivityPauseArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.jiuxiao.main.POnActivityPause());
/* 16 */     manager.register(new mzm.gsp.qmhw.main.POnActivityPause());
/* 17 */     manager.register(new mzm.gsp.instance.main.POnActivityPause());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\event\ActivityPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */