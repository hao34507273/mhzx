/*    */ package mzm.gsp.active.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AddActivePoint extends mzm.event.BasicEvent<ActiveArg>
/*    */ {
/*  7 */   private static EventManager<ActiveArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActiveArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnRoleAddActivePoint());
/* 16 */     manager.register(new mzm.gsp.backgame.main.POnRoleAddActivePoint());
/* 17 */     manager.register(new mzm.gsp.competition.main.POnRoleAddActivePoint());
/* 18 */     manager.register(new mzm.gsp.shitu.main.POnRoleAddActivePoint());
/* 19 */     manager.register(new mzm.gsp.grc.main.POnRoleAddActivePoint());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\event\AddActivePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */