/*    */ package mzm.gsp.shimen.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ShimenActivityFinished extends mzm.event.BasicEvent<ShimenActivityArg>
/*    */ {
/*  7 */   private static EventManager<ShimenActivityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ShimenActivityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnShimenActivityFinished());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnShimenActivityFinished());
/* 17 */     manager.register(new mzm.gsp.role.main.POnShimenActivityFinished());
/* 18 */     manager.register(new mzm.gsp.active.main.POnShimenFinished());
/* 19 */     manager.register(new mzm.gsp.guide.main.POnShimenActivityFinish());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnShimenActivityFinish());
/* 21 */     manager.register(new mzm.gsp.grc.main.POnShimenActivityFinish());
/* 22 */     manager.register(new mzm.gsp.storageexp.activity.POnShimenActivityFinish());
/* 23 */     manager.register(new mzm.gsp.exploit.main.targets.POnShimenActivityFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\event\ShimenActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */