/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AnimalStageChange extends mzm.event.BasicEvent<AnimalStageChangeArg>
/*    */ {
/*  7 */   private static EventManager<AnimalStageChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AnimalStageChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAnimalStageChange());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnAnimalStageChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalStageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */