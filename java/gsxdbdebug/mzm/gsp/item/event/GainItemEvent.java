/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GainItemEvent extends mzm.event.BasicEvent<GainItemeArg>
/*    */ {
/*  7 */   private static EventManager<GainItemeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GainItemeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fabao.main.POnGainItemEvent());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnGainItemEvent());
/* 17 */     manager.register(new mzm.gsp.pet.main.POnAddPetEquipItemEvent());
/* 18 */     manager.register(new mzm.gsp.resourcecheck.main.POnGainItemEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\GainItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */