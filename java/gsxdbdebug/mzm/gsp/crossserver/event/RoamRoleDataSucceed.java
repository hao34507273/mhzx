/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoamRoleDataSucceed extends mzm.event.BasicEvent<RoamRoleDataSucceedArg>
/*    */ {
/*  7 */   private static EventManager<RoamRoleDataSucceedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoamRoleDataSucceedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.online.main.POnRoamRoleDataSucceed());
/* 16 */     manager.register(new mzm.gsp.ladder.main.POnRoamRoleDataSucceed());
/* 17 */     manager.register(new mzm.gsp.crosscompete.main.POnRoamRoleDataSucceed());
/* 18 */     manager.register(new mzm.gsp.crossbattle.point.POnRoamRoleDataSucceed());
/* 19 */     manager.register(new mzm.gsp.crossbattle.knockout.POnRoamRoleDataSucceed());
/* 20 */     manager.register(new mzm.gsp.crossfield.main.POnRoamRoleDataSucceed());
/* 21 */     manager.register(new mzm.gsp.crossserver.main.POnRoamRoleDataSucceed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */