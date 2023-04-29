/*    */ package mzm.gsp.visiblemonsterfight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KillLuanShiYaoMo extends mzm.event.BasicEvent<KillLuanShiYaoMoArg>
/*    */ {
/*  7 */   private static EventManager<KillLuanShiYaoMoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KillLuanShiYaoMoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnKillLuanShiYaoMo());
/* 16 */     manager.register(new mzm.gsp.role.main.POnKillLuanShiYaoMo());
/* 17 */     manager.register(new mzm.gsp.grow.LevelGuide.POnKillLuanShiYaoMo());
/* 18 */     manager.register(new mzm.gsp.active.main.POnKillLuanShiYaoMo());
/* 19 */     manager.register(new mzm.gsp.storageexp.activity.POnKillLuanShiYaoMo());
/* 20 */     manager.register(new mzm.gsp.exploit.main.targets.POnLuanshiActivityFinished());
/* 21 */     manager.register(new mzm.gsp.achievement.main.POnKillLuanShiYaoMo());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\event\KillLuanShiYaoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */