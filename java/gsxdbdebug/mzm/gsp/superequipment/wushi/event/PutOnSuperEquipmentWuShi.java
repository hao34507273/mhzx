/*    */ package mzm.gsp.superequipment.wushi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PutOnSuperEquipmentWuShi extends mzm.event.BasicEvent<PutOnSuperEquipmentWuShiArg>
/*    */ {
/*  7 */   private static EventManager<PutOnSuperEquipmentWuShiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PutOnSuperEquipmentWuShiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnPutOnSuperEquipmentWuShi());
/* 16 */     manager.register(new mzm.gsp.superequipment.wushi.main.POnPutOnSuperEquipmentWuShi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\event\PutOnSuperEquipmentWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */