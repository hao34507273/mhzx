/*    */ package mzm.gsp.aircraft.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UnlockAircraft extends mzm.event.BasicEvent<UnlockAircraftArg>
/*    */ {
/*  7 */   private static EventManager<UnlockAircraftArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UnlockAircraftArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnAircraftUnlock());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\event\UnlockAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */