/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LeaveCorps extends mzm.event.BasicEvent<LeaveCorpsEventArg>
/*    */ {
/*  7 */   private static EventManager<LeaveCorpsEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LeaveCorpsEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnLeaveCorps());
/* 16 */     manager.register(new mzm.gsp.crossbattle.own.POnLeaveCorps());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\LeaveCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */