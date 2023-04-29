/*    */ package mzm.gsp.superequipment.jewel.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UnMountSuperEquipmentJewel extends mzm.event.BasicEvent<UnMountSuperEquipmentJewelArg>
/*    */ {
/*  7 */   private static EventManager<UnMountSuperEquipmentJewelArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UnMountSuperEquipmentJewelArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnUnMountSuperEquipmentJewel());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\event\UnMountSuperEquipmentJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */