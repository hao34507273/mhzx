/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVPFightFail extends mzm.event.BasicEvent<PVPFightFailArg>
/*    */ {
/*  7 */   private static EventManager<PVPFightFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVPFightFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnPVPFightFail());
/* 16 */     manager.register(new mzm.gsp.crossbattle.own.POnPVPFightFail());
/* 17 */     manager.register(new mzm.gsp.crossbattle.point.POnPVPFightFail());
/* 18 */     manager.register(new mzm.gsp.crossbattle.knockout.POnPVPFightFail());
/* 19 */     manager.register(new mzm.gsp.pk.main.POnPVPFightFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVPFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */