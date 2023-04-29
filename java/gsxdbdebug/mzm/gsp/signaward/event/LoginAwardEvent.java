/*    */ package mzm.gsp.signaward.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LoginAwardEvent extends mzm.event.BasicEvent<LoginAwardArg>
/*    */ {
/*  7 */   private static EventManager<LoginAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LoginAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnLoginAwardEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\event\LoginAwardEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */