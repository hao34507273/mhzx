/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CreateHomeEvent extends mzm.event.BasicEvent<CreateHomeArg>
/*    */ {
/*  7 */   private static EventManager<CreateHomeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CreateHomeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.guide.main.POnHomeCreated());
/* 16 */     manager.register(new mzm.gsp.homeland.mysteryvisitor.POnHomeCreated());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnHomeCreated());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\CreateHomeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */