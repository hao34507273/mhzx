/*    */ package mzm.gsp.petarena.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetArenaRankChanged extends mzm.event.BasicEvent<PetArenaRankChangedArg>
/*    */ {
/*  7 */   private static EventManager<PetArenaRankChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetArenaRankChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.petarena.main.POnPetArenaRankChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\event\PetArenaRankChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */