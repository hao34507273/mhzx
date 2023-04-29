/*    */ package mzm.gsp.huanhun.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishHuanHun extends mzm.event.BasicEvent<FinishHuanHunArg>
/*    */ {
/*  7 */   private static EventManager<FinishHuanHunArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FinishHuanHunArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnFinishHuanHun());
/* 16 */     manager.register(new mzm.gsp.role.main.POnFinishHuanHun());
/* 17 */     manager.register(new mzm.gsp.exploit.main.targets.PHuanhunActivityFinished());
/* 18 */     manager.register(new mzm.gsp.achievement.main.POnFinishHuanHun());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\event\FinishHuanHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */