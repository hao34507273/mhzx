/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetWingEvent extends mzm.event.BasicEvent<GetWingdArg>
/*    */ {
/*  7 */   private static EventManager<GetWingdArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetWingdArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnGetWingEvent());
/* 16 */     manager.register(new mzm.gsp.role.main.POnGetWingEvent());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnGetWing());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\GetWingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */