/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerTeleportToLocation extends mzm.event.BasicEvent<PlayerTeleportToLocationArg>
/*    */ {
/*  7 */   private static EventManager<PlayerTeleportToLocationArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PlayerTeleportToLocationArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.gather.POnPlayerTeleportToLocation());
/* 16 */     manager.register(new mzm.gsp.singlebattle.grab.POnPlayerTeleportToLocation());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\PlayerTeleportToLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */