/*    */ package mzm.gsp.baotu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BaoTuActivityFinished extends mzm.event.BasicEvent<BaoTuActivityArg>
/*    */ {
/*  7 */   private static EventManager<BaoTuActivityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BaoTuActivityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.active.main.POnBaoTuFinished());
/* 16 */     manager.register(new mzm.gsp.guide.main.POnBaotuActivityFinish());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnBaoTuFinished());
/* 18 */     manager.register(new mzm.gsp.exploit.main.targets.POnBaotuActivityFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\event\BaoTuActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */