/*    */ package mzm.gsp.couple.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CreateCoupleRide extends mzm.event.BasicEvent<CreateCoupleRideArg>
/*    */ {
/*  7 */   private static EventManager<CreateCoupleRideArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CreateCoupleRideArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnCreateCoupleRide());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\event\CreateCoupleRide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */