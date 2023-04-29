/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVPFightEnd extends mzm.event.BasicEvent<PVPFightEndArg>
/*    */ {
/*  7 */   private static EventManager<PVPFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVPFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnPVPFightEnd());
/* 16 */     manager.register(new mzm.gsp.ladder.main.POnPVPFightEnd());
/* 17 */     manager.register(new mzm.gsp.crossbattle.knockout.POnPVPFightEnd());
/* 18 */     manager.register(new mzm.gsp.buff.main.POnPvPFightEnd());
/* 19 */     manager.register(new mzm.gsp.role.main.POnPvPFightEnd());
/* 20 */     manager.register(new mzm.gsp.team.main.POnPvPFightEnd());
/* 21 */     manager.register(new mzm.gsp.leitai.main.POnPvPFightEnd());
/* 22 */     manager.register(new mzm.gsp.menpaipvp.main.POnPvPFightEnd());
/* 23 */     manager.register(new mzm.gsp.arena.main.POnPVPFightEnd());
/* 24 */     manager.register(new mzm.gsp.singlebattle.main.POnPVPFightEnd());
/* 25 */     manager.register(new mzm.gsp.competition.main.POnPVPFightEnd());
/* 26 */     manager.register(new mzm.gsp.qmhw.main.POnPVPFightEnd());
/* 27 */     manager.register(new mzm.gsp.marriage.main.POnPVPFightEnd());
/* 28 */     manager.register(new mzm.gsp.crossbattle.point.POnPVPFightEnd());
/* 29 */     manager.register(new mzm.gsp.crossbattle.own.POnPVPFightEnd());
/* 30 */     manager.register(new mzm.gsp.crosscompete.roam.POnPVPFightEnd());
/* 31 */     manager.register(new mzm.gsp.singlebattle.resourcepoint.POnPVPFightEnd());
/* 32 */     manager.register(new mzm.gsp.wanted.main.POnPVPFightEnd());
/* 33 */     manager.register(new mzm.gsp.pk.main.POnPVPFightEnd());
/* 34 */     manager.register(new mzm.gsp.addiction.main.POnPVPFightEnd());
/* 35 */     manager.register(new mzm.gsp.achievement.main.POnPVPFightEnd());
/* 36 */     manager.register(new mzm.gsp.changemodelcard.main.POnPVPFightEnd());
/* 37 */     manager.register(new mzm.gsp.pet.main.POnPvPFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */