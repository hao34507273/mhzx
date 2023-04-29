/*    */ package mzm.gsp.husong.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class HuSongEvent extends mzm.event.BasicEvent<HuSongArg>
/*    */ {
/*  7 */   private static EventManager<HuSongArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<HuSongArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnHuSongEvent());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnHuSongEvent());
/* 17 */     manager.register(new mzm.gsp.role.main.POnHuSongEvent());
/* 18 */     manager.register(new mzm.gsp.active.main.POnHuSongEvent());
/* 19 */     manager.register(new mzm.gsp.exploit.main.targets.POnHusongActivityFinished());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnHuSongEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\event\HuSongEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */