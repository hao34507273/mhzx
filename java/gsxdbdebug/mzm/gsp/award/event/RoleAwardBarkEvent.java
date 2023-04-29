/*    */ package mzm.gsp.award.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleAwardBarkEvent extends mzm.event.BasicEvent<mzm.gsp.award.watchdog.AwardBarkEventArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.award.watchdog.AwardBarkEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.award.watchdog.AwardBarkEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.award.watchdog.POnRoleAwardBark());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\event\RoleAwardBarkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */