/*    */ package mzm.gsp.jingji.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JingjiActivityFinished extends mzm.event.BasicEvent<JingjiActivityArg>
/*    */ {
/*  7 */   private static EventManager<JingjiActivityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JingjiActivityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnJingjiActivityFinished());
/* 16 */     manager.register(new mzm.gsp.role.main.POnJingjiActivityFinished());
/* 17 */     manager.register(new mzm.gsp.active.main.POnJingjiActivityFinished());
/* 18 */     manager.register(new mzm.gsp.achievement.main.POnJingjiActivityFinished());
/* 19 */     manager.register(new mzm.gsp.grow.LevelGuide.POnJingjiActivityFinished());
/* 20 */     manager.register(new mzm.gsp.storageexp.activity.POnJingjiActivityFinished());
/* 21 */     manager.register(new mzm.gsp.exploit.main.targets.POnJingjiActivityFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\event\JingjiActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */