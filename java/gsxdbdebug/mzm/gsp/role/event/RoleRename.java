/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleRename extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleRename());
/* 16 */     manager.register(new mzm.gsp.friend.main.POnRoleRename());
/* 17 */     manager.register(new mzm.gsp.gang.main.POnRoleRename());
/* 18 */     manager.register(new mzm.gsp.team.main.POnRoleRename());
/* 19 */     manager.register(new mzm.gsp.corps.main.POnRoleRename());
/* 20 */     manager.register(new mzm.gsp.grow.LevelGuide.POnRoleRename());
/* 21 */     manager.register(new mzm.gsp.marriage.main.POnRoleRename());
/* 22 */     manager.register(new mzm.gsp.shitu.main.POnRoleRename());
/* 23 */     manager.register(new mzm.gsp.qingyuan.main.POnRoleRename());
/* 24 */     manager.register(new mzm.gsp.msdkprofile.main.POnRoleRename());
/* 25 */     manager.register(new mzm.gsp.personal.main.POnRoleRename());
/* 26 */     manager.register(new mzm.gsp.group.main.POnRoleRename());
/* 27 */     manager.register(new mzm.gsp.menpaistar.main.POnRoleRename());
/* 28 */     manager.register(new mzm.gsp.friendscircle.main.POnRoleRename());
/* 29 */     manager.register(new mzm.gsp.achievement.main.POnRoleRename());
/* 30 */     manager.register(new mzm.gsp.petarena.main.POnRoleRename());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\RoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */