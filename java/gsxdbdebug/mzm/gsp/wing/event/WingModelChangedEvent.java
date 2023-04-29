/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WingModelChangedEvent extends mzm.event.BasicEvent<WingModelChangedArg>
/*    */ {
/*  7 */   private static EventManager<WingModelChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WingModelChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnWingChangedEvent());
/* 16 */     manager.register(new mzm.gsp.team.main.POnWingChangedEvent());
/* 17 */     manager.register(new mzm.gsp.corps.main.POnWingChangedEvent());
/* 18 */     manager.register(new mzm.gsp.shitu.main.POnWingChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingModelChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */