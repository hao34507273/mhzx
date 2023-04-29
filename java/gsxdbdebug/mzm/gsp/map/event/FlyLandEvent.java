/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FlyLandEvent extends mzm.event.BasicEvent<FlyLandArg>
/*    */ {
/*  7 */   private static EventManager<FlyLandArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FlyLandArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\FlyLandEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */