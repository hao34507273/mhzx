/*    */ package mzm.gsp.bounty.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishOneTask extends mzm.event.BasicEvent<FinishOneTaskArg>
/*    */ {
/*  7 */   private static EventManager<FinishOneTaskArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FinishOneTaskArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnFinishOneTask());
/* 16 */     manager.register(new mzm.gsp.active.main.POnFinishOneBounty());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnFinishOneBounty());
/* 18 */     manager.register(new mzm.gsp.storageexp.activity.POnFinishOneBounty());
/* 19 */     manager.register(new mzm.gsp.exploit.main.targets.PShangjinActivityFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\event\FinishOneTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */