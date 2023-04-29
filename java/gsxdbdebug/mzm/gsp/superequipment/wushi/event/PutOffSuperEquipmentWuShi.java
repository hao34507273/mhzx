/*    */ package mzm.gsp.superequipment.wushi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PutOffSuperEquipmentWuShi extends mzm.event.BasicEvent<PutOffSuperEquipmentWuShiArg>
/*    */ {
/*  7 */   private static EventManager<PutOffSuperEquipmentWuShiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PutOffSuperEquipmentWuShiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnPutOffSuperEquipmentWuShi());
/* 16 */     manager.register(new mzm.gsp.superequipment.wushi.main.POnPutOffSuperEquipmentWuShi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\event\PutOffSuperEquipmentWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */