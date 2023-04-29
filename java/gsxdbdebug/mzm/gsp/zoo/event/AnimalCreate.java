/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AnimalCreate extends mzm.event.BasicEvent<AnimalCreateArg>
/*    */ {
/*  7 */   private static EventManager<AnimalCreateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AnimalCreateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAddAnimal());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnAddAnimal());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */