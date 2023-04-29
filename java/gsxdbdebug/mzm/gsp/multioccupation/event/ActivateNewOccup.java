/*    */ package mzm.gsp.multioccupation.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivateNewOccup extends mzm.event.BasicEvent<ActivateNewOccupArg>
/*    */ {
/*  7 */   private static EventManager<ActivateNewOccupArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivateNewOccupArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleActivateNewOccup());
/* 16 */     manager.register(new mzm.gsp.guide.main.POnRoleActivateNewOccup());
/* 17 */     manager.register(new mzm.gsp.friend.main.POnRoleActivateNewOccup());
/* 18 */     manager.register(new mzm.gsp.menpaistar.main.POnRoleActivateNewOccup());
/* 19 */     manager.register(new mzm.gsp.corps.main.POnRoleActivateNewOccup());
/* 20 */     manager.register(new mzm.gsp.friendscircle.main.POnRoleActivateNewOccup());
/* 21 */     manager.register(new mzm.gsp.achievement.main.POnRoleActivateNewOccup());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\event\ActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */