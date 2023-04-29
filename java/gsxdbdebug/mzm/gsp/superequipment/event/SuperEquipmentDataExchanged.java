/*    */ package mzm.gsp.superequipment.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SuperEquipmentDataExchanged extends mzm.event.BasicEvent<SuperEquipmentDataExchangedArg>
/*    */ {
/*  7 */   private static EventManager<SuperEquipmentDataExchangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SuperEquipmentDataExchangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnSuperEquipmentDataExchanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\event\SuperEquipmentDataExchanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */