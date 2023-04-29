/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MapRoleCreated extends mzm.event.BasicEvent<MapRoleCreatedArg>
/*    */ {
/*  7 */   private static EventManager<MapRoleCreatedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MapRoleCreatedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.competition.main.POnMapRoleCreated());
/* 16 */     manager.register(new mzm.gsp.menpaipvp.main.POnMapRoleCreated());
/* 17 */     manager.register(new mzm.gsp.factionpve.main.POnMapRoleCreated());
/* 18 */     manager.register(new mzm.gsp.crosscompete.roam.POnMapRoleCreated());
/* 19 */     manager.register(new mzm.gsp.singlebattle.main.POnMapRoleCreated());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\MapRoleCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */