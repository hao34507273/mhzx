/*    */ package mzm.gsp.status.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleStatusChanged extends mzm.event.BasicEvent<RoleStatusChangeArg>
/*    */ {
/*  7 */   private static EventManager<RoleStatusChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleStatusChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleStatusChanged());
/* 16 */     manager.register(new mzm.gsp.interaction.main.POnRoleStatusChanged());
/* 17 */     manager.register(new mzm.gsp.marriage.main.POnRoleStatusChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\event\RoleStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */