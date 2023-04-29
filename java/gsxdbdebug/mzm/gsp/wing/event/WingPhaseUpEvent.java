/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WingPhaseUpEvent extends mzm.event.BasicEvent<WingPhaseUpArg>
/*    */ {
/*  7 */   private static EventManager<WingPhaseUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WingPhaseUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnWingPhaseUpEvent());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnWingPhaseUpEvent());
/* 17 */     manager.register(new mzm.gsp.role.main.POnWingPhaseUpEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingPhaseUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */