/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerUpdateKeyPath extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.gather.POnPlayerUpdateKeyPath());
/* 16 */     manager.register(new mzm.gsp.singlebattle.grab.POnPlayerUpdateKeyPath());
/* 17 */     manager.register(new mzm.gsp.singlebattle.antiafk.ROnPlayerUpdateKeyPath());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\PlayerUpdateKeyPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */