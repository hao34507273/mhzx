/*    */ package mzm.gsp.aircraft.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AircraftModelChange extends mzm.event.BasicEvent<AircraftModelChangeArg>
/*    */ {
/*  7 */   private static EventManager<AircraftModelChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AircraftModelChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnAircraftModelChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\event\AircraftModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */