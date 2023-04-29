/*    */ package mzm.gsp.online.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerRealDelete extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnPlayerDelete());
/* 16 */     manager.register(new mzm.gsp.friend.main.POnPlayerRealDelete());
/* 17 */     manager.register(new mzm.gsp.gang.main.POnPlayerDelete());
/* 18 */     manager.register(new mzm.gsp.sworn.main.POnPlayerDelete());
/* 19 */     manager.register(new mzm.gsp.chart.main.POnPlayerDelete());
/* 20 */     manager.register(new mzm.gsp.group.main.POnPlayerRealDelete());
/* 21 */     manager.register(new mzm.gsp.chatgift.main.POnRoleLogoff());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\event\PlayerRealDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */