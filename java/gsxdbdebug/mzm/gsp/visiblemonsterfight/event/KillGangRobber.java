/*    */ package mzm.gsp.visiblemonsterfight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KillGangRobber extends mzm.event.BasicEvent<KillRobberArg>
/*    */ {
/*  7 */   private static EventManager<KillRobberArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KillRobberArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnKillGangRobber());
/* 16 */     manager.register(new mzm.gsp.role.main.POnKillGangRobber());
/* 17 */     manager.register(new mzm.gsp.grow.LevelGuide.POnKillGangRobber());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\event\KillGangRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */