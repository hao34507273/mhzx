/*    */ package mzm.gsp.config.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ConfigReloaded extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.shanghui.main.POnConfigReloaded());
/* 16 */     manager.register(new mzm.gsp.npc.main.POnConfigReloaded());
/* 17 */     manager.register(new mzm.gsp.market.main.POnConfigReloaded());
/* 18 */     manager.register(new mzm.gsp.award.gift.POnConfigReloaded());
/* 19 */     manager.register(new mzm.gsp.activity.main.POnConfigReloaded());
/* 20 */     manager.register(new mzm.gsp.config.main.POnConfigReloaded());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\config\event\ConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */