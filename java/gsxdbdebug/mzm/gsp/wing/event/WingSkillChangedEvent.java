/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WingSkillChangedEvent extends mzm.event.BasicEvent<WingSkillChangedArg>
/*    */ {
/*  7 */   private static EventManager<WingSkillChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WingSkillChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnWingSkillChangedEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingSkillChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */