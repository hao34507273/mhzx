/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AnimalDisappear extends mzm.event.BasicEvent<AnimalDisappearArg>
/*    */ {
/*  7 */   private static EventManager<AnimalDisappearArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AnimalDisappearArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnRemoveAnimal());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnRemoveAnimal());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalDisappear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */