/*    */ package mzm.gsp.zhenyao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ZhenyaoActivityFinished extends mzm.event.BasicEvent<ZhenyaoActivityArg>
/*    */ {
/*  7 */   private static EventManager<ZhenyaoActivityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ZhenyaoActivityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnZhenyaoActivityFinished());
/* 16 */     manager.register(new mzm.gsp.role.main.POnZhenyaoActivityFinished());
/* 17 */     manager.register(new mzm.gsp.grow.LevelGuide.POnZhenyaoActivityFinished());
/* 18 */     manager.register(new mzm.gsp.active.main.POnZhenyaoFinished());
/* 19 */     manager.register(new mzm.gsp.guide.main.POnZhenyaoActivityFinish());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnZhenyaoActivityFinish());
/* 21 */     manager.register(new mzm.gsp.storageexp.activity.POnZhenyaoActivityFinish());
/* 22 */     manager.register(new mzm.gsp.chivalry.main.POnZhenyaoActivityFinish());
/* 23 */     manager.register(new mzm.gsp.exploit.main.targets.POnZhenyaoActivityFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\event\ZhenyaoActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */