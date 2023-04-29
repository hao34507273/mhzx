/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AllRoamedRoleReady extends mzm.event.BasicEvent<AllRoamedRoleReadyArg>
/*    */ {
/*  7 */   private static EventManager<AllRoamedRoleReadyArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AllRoamedRoleReadyArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnAllRoamedRoleReady());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\AllRoamedRoleReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */