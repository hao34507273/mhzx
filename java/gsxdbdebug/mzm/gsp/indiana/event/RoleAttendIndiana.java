/*    */ package mzm.gsp.indiana.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleAttendIndiana extends mzm.event.BasicEvent<RoleAttendIndianaArg>
/*    */ {
/*  7 */   private static EventManager<RoleAttendIndianaArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleAttendIndianaArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRoleAttendIndiana());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\event\RoleAttendIndiana.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */