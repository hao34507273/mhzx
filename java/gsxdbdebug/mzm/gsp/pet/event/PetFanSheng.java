/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetFanSheng extends mzm.event.BasicEvent<PetFanShengEventArg>
/*    */ {
/*  7 */   private static EventManager<PetFanShengEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetFanShengEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnPetFanSheng());
/* 16 */     manager.register(new mzm.gsp.mounts.main.POnPetFanSheng());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnPetFanSheng());
/* 18 */     manager.register(new mzm.gsp.pet.main.POnPetFanSheng());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetFanSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */