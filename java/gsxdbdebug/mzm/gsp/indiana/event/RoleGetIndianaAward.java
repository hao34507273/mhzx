/*    */ package mzm.gsp.indiana.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleGetIndianaAward extends mzm.event.BasicEvent<RoleGetIndianaAwardArg>
/*    */ {
/*  7 */   private static EventManager<RoleGetIndianaAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleGetIndianaAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRoleGetIndianaAward());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\event\RoleGetIndianaAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */