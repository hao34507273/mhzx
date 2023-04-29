/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVPFightStart extends mzm.event.BasicEvent<PVPFightStartArg>
/*    */ {
/*  7 */   private static EventManager<PVPFightStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVPFightStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnPvPFightStart());
/* 16 */     manager.register(new mzm.gsp.leitai.main.POnPvPFightStart());
/* 17 */     manager.register(new mzm.gsp.menpaipvp.main.POnPvPFightStart());
/* 18 */     manager.register(new mzm.gsp.arena.main.POnPVPFightStart());
/* 19 */     manager.register(new mzm.gsp.competition.main.POnPVPFightStart());
/* 20 */     manager.register(new mzm.gsp.singlebattle.main.POnPVPFightStart());
/* 21 */     manager.register(new mzm.gsp.singlebattle.grab.POnPVPFightStart());
/* 22 */     manager.register(new mzm.gsp.singlebattle.gather.POnPVPFightStart());
/* 23 */     manager.register(new mzm.gsp.qmhw.main.POnPVPFightStart());
/* 24 */     manager.register(new mzm.gsp.achievement.main.POnPVPFightStart());
/* 25 */     manager.register(new mzm.gsp.marriage.main.POnPVPFightStart());
/* 26 */     manager.register(new mzm.gsp.crossbattle.own.POnPVPFightStart());
/* 27 */     manager.register(new mzm.gsp.crossbattle.point.POnPVPFightStart());
/* 28 */     manager.register(new mzm.gsp.crossbattle.knockout.POnPVPFightStart());
/* 29 */     manager.register(new mzm.gsp.crosscompete.roam.POnPVPFightStart());
/* 30 */     manager.register(new mzm.gsp.wanted.main.POnPVPFightStart());
/* 31 */     manager.register(new mzm.gsp.pk.main.POnPVPFightStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */