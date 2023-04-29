/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WingPropertyChangedEvent extends mzm.event.BasicEvent<WingPropertyChangedArg>
/*    */ {
/*  7 */   private static EventManager<WingPropertyChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WingPropertyChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnWingPropertyChangedEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingPropertyChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */