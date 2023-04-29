/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SelectionOrFinalAllRoamedRoleReady extends mzm.event.BasicEvent<SelectionOrFinalAllRoamedRoleReadyArg>
/*    */ {
/*  7 */   private static EventManager<SelectionOrFinalAllRoamedRoleReadyArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SelectionOrFinalAllRoamedRoleReadyArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnAllRoamedRoleReady());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SelectionOrFinalAllRoamedRoleReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */