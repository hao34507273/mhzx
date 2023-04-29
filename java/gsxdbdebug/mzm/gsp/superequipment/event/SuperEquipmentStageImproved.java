/*    */ package mzm.gsp.superequipment.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SuperEquipmentStageImproved extends mzm.event.BasicEvent<SuperEquipmentStageImprovedArg>
/*    */ {
/*  7 */   private static EventManager<SuperEquipmentStageImprovedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SuperEquipmentStageImprovedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.superequipment.wushi.main.POnRoleImproveSuperEquipmentStage());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\event\SuperEquipmentStageImproved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */