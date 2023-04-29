/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVCFightEnd extends mzm.event.BasicEvent<PVCFightEndArg>
/*    */ {
/*  7 */   private static EventManager<PVCFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVCFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnPVCFightEnd());
/* 16 */     manager.register(new mzm.gsp.task.main.POnPVCFightEnd());
/* 17 */     manager.register(new mzm.gsp.jingji.main.POnPVPFightEnd());
/* 18 */     manager.register(new mzm.gsp.team.main.POnPVCFightEnd());
/* 19 */     manager.register(new mzm.gsp.addiction.main.POnPVCFightEnd());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnPVCFightEnd());
/* 21 */     manager.register(new mzm.gsp.changemodelcard.main.POnPVCFightEnd());
/* 22 */     manager.register(new mzm.gsp.pet.main.POnPvCFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */