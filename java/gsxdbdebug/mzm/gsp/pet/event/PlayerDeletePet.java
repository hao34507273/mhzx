/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerDeletePet extends mzm.event.BasicEvent<PetEventArg>
/*    */ {
/*  7 */   private static EventManager<PetEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnPlayerDeletePet());
/* 16 */     manager.register(new mzm.gsp.task.main.POnPlayerDeletePet());
/* 17 */     manager.register(new mzm.gsp.map.main.POnPlayerDeletePet());
/* 18 */     manager.register(new mzm.gsp.pet.main.POnPlayerDeletePet());
/* 19 */     manager.register(new mzm.gsp.mounts.main.POnPlayerDeletePet());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnPlayerDeletePet());
/* 21 */     manager.register(new mzm.gsp.petmark.main.POnDeletePet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PlayerDeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */