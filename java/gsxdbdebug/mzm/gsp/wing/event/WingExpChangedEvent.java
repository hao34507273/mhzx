/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WingExpChangedEvent extends mzm.event.BasicEvent<WingExpChangedArg>
/*    */ {
/*  7 */   private static EventManager<WingExpChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WingExpChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnWingExpChangedEvent());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnWingExpChangedEvent());
/* 17 */     manager.register(new mzm.gsp.grow.LevelGuide.POnWingExpChangedEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingExpChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */