/*    */ package mzm.gsp.superequipment.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SuperEquipmentLevelImproved extends mzm.event.BasicEvent<SuperEquipmentLevelImprovedArg>
/*    */ {
/*  7 */   private static EventManager<SuperEquipmentLevelImprovedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SuperEquipmentLevelImprovedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnSuperEquipmentLevelImproved());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\event\SuperEquipmentLevelImproved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */