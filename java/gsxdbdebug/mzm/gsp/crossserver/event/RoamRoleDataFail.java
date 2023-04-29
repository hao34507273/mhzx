/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoamRoleDataFail extends mzm.event.BasicEvent<RoamRoleDataFailArg>
/*    */ {
/*  7 */   private static EventManager<RoamRoleDataFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoamRoleDataFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnRoamRoleDataFail());
/* 16 */     manager.register(new mzm.gsp.crosscompete.main.POnRoamRoleDataFail());
/* 17 */     manager.register(new mzm.gsp.crossbattle.point.POnRoamRoleDataFail());
/* 18 */     manager.register(new mzm.gsp.crossbattle.knockout.POnRoamRoleDataFail());
/* 19 */     manager.register(new mzm.gsp.crossfield.main.POnRoamRoleDataFail());
/* 20 */     manager.register(new mzm.gsp.crossserver.main.POnRoamRoleDataFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RoamRoleDataFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */