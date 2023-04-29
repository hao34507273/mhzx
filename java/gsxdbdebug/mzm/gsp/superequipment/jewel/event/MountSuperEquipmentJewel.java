/*    */ package mzm.gsp.superequipment.jewel.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MountSuperEquipmentJewel extends mzm.event.BasicEvent<MountSuperEquipmentJewelArg>
/*    */ {
/*  7 */   private static EventManager<MountSuperEquipmentJewelArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MountSuperEquipmentJewelArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnMountSuperEquipmentJewel());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\event\MountSuperEquipmentJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */