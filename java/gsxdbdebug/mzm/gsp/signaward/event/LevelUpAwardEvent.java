/*    */ package mzm.gsp.signaward.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LevelUpAwardEvent extends mzm.event.BasicEvent<LevelUpAwardArg>
/*    */ {
/*  7 */   private static EventManager<LevelUpAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LevelUpAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnLevelUpAwardEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\event\LevelUpAwardEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */