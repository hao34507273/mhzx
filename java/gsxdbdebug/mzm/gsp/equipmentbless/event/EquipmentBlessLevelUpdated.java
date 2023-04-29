/*    */ package mzm.gsp.equipmentbless.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EquipmentBlessLevelUpdated extends mzm.event.BasicEvent<EquipmentBlessLevelUpdatedArg>
/*    */ {
/*  7 */   private static EventManager<EquipmentBlessLevelUpdatedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EquipmentBlessLevelUpdatedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnEquipmentBlessLevelUpdated());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\event\EquipmentBlessLevelUpdated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */