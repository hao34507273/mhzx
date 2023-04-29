/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MapRoleDestroyedEvent extends mzm.event.BasicEvent<MapRoleDestroyedArg>
/*    */ {
/*  7 */   private static EventManager<MapRoleDestroyedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MapRoleDestroyedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.competition.main.POnMapRoleDestroyed());
/* 16 */     manager.register(new mzm.gsp.menpaipvp.main.POnMapRoleDestroyed());
/* 17 */     manager.register(new mzm.gsp.factionpve.main.POnMapRoleDestroyed());
/* 18 */     manager.register(new mzm.gsp.crosscompete.roam.POnMapRoleDestroyed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\MapRoleDestroyedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */