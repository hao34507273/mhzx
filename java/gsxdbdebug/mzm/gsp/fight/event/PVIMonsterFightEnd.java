/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVIMonsterFightEnd extends mzm.event.BasicEvent<PVIMonsterFightEndArg>
/*    */ {
/*  7 */   private static EventManager<PVIMonsterFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVIMonsterFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnPVIMonsterFightEnd());
/* 16 */     manager.register(new mzm.gsp.bigboss.main.PveBigbossFightEnd());
/* 17 */     manager.register(new mzm.gsp.addiction.main.POnPVIMonsterFightEnd());
/* 18 */     manager.register(new mzm.gsp.pet.main.POnPvIFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVIMonsterFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */