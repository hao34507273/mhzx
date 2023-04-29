/*    */ package mzm.gsp.signaward.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SignEvent extends mzm.event.BasicEvent<SignArg>
/*    */ {
/*  7 */   private static EventManager<SignArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SignArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnSignEvent());
/* 16 */     manager.register(new mzm.gsp.grc.main.POnSignEvent());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnSignEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\event\SignEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */