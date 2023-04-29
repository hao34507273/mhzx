/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WorldDestroyEvent extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnWorldDestroyEvent());
/* 16 */     manager.register(new mzm.gsp.homeland.main.POnHomeWorldDestroy());
/* 17 */     manager.register(new mzm.gsp.relatedboss.main.POnWorldDestroy());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\WorldDestroyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */