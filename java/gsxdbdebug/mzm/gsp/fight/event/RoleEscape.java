/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleEscape extends mzm.event.BasicEvent<RoleEscapeArg>
/*    */ {
/*  7 */   private static EventManager<RoleEscapeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleEscapeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnRoleEscape());
/* 16 */     manager.register(new mzm.gsp.team.main.POnRoleEscape());
/* 17 */     manager.register(new mzm.gsp.map.main.POnRoleEscape());
/* 18 */     manager.register(new mzm.gsp.arena.main.POnRoleEscape());
/* 19 */     manager.register(new mzm.gsp.competition.main.POnRoleEscape());
/* 20 */     manager.register(new mzm.gsp.crosscompete.roam.POnRoleEscape());
/* 21 */     manager.register(new mzm.gsp.prison.main.POnRoleEscape());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\RoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */