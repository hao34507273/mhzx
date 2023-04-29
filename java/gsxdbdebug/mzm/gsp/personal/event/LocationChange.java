/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LocationChange extends mzm.event.BasicEvent<LocationArg>
/*    */ {
/*  7 */   private static EventManager<LocationArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LocationArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.personal.main.POnLocationChange());
/* 16 */     manager.register(new mzm.gsp.friendscircle.main.POnLocationChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\LocationChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */