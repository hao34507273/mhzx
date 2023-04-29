/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AnimalGetAward extends mzm.event.BasicEvent<AnimalGetAwardArg>
/*    */ {
/*  7 */   private static EventManager<AnimalGetAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AnimalGetAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAnimalMateGetAward());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalGetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */