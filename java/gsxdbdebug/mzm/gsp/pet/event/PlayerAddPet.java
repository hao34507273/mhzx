/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerAddPet extends mzm.event.BasicEvent<PetEventArg>
/*    */ {
/*  7 */   private static EventManager<PetEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.main.POnPlayerAddPet());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnPlayerAddPet());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnPlayerAddPet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PlayerAddPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */