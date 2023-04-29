/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AnimalMate extends mzm.event.BasicEvent<AnimalMateArg>
/*    */ {
/*  7 */   private static EventManager<AnimalMateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AnimalMateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAnimalMate());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnAnimalMate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */