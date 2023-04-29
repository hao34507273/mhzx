/*    */ package mzm.gsp.aircraft.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AircraftPropertyChange extends mzm.event.BasicEvent<AircraftPropertyChangeArg>
/*    */ {
/*  7 */   private static EventManager<AircraftPropertyChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AircraftPropertyChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnAircraftPropertyChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\event\AircraftPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */