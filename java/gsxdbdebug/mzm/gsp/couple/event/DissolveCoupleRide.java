/*    */ package mzm.gsp.couple.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DissolveCoupleRide extends mzm.event.BasicEvent<DissolveCoupleRideArg>
/*    */ {
/*  7 */   private static EventManager<DissolveCoupleRideArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DissolveCoupleRideArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnDissolveCoupleRide());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\event\DissolveCoupleRide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */