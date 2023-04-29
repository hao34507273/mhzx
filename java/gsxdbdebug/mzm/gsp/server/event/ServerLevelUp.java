/*    */ package mzm.gsp.server.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ServerLevelUp extends mzm.event.BasicEvent<ServerLevelArg>
/*    */ {
/*  7 */   private static EventManager<ServerLevelArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ServerLevelArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.shanghui.main.POnServerLevelUp());
/* 16 */     manager.register(new mzm.gsp.feisheng.main.POnServerLevelUp());
/* 17 */     manager.register(new mzm.gsp.market.main.POnServerLevelUp());
/* 18 */     manager.register(new mzm.gsp.task.surprise.POnServerLevelUp());
/* 19 */     manager.register(new mzm.gsp.petarena.main.ROnServerLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\event\ServerLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */