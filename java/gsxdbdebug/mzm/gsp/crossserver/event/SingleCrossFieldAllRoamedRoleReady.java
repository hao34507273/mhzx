/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleCrossFieldAllRoamedRoleReady extends mzm.event.BasicEvent<SingleCrossFieldAllRoamedRoleReadyArg>
/*    */ {
/*  7 */   private static EventManager<SingleCrossFieldAllRoamedRoleReadyArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleCrossFieldAllRoamedRoleReadyArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.roam.POnSingleCrossFieldAllRoamedRoleReady());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldAllRoamedRoleReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */