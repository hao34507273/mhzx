/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVEFightEnd extends mzm.event.BasicEvent<PVEFightEndArg>
/*    */ {
/*  7 */   private static EventManager<PVEFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVEFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnPvEFightEnd());
/* 16 */     manager.register(new mzm.gsp.task.main.POnPvEFightEnd());
/* 17 */     manager.register(new mzm.gsp.friend.main.POnPvEFightEnd());
/* 18 */     manager.register(new mzm.gsp.map.main.POnPvEFightEnd());
/* 19 */     manager.register(new mzm.gsp.buff.main.POnPvEFightEnd());
/* 20 */     manager.register(new mzm.gsp.role.main.POnPvEFightEnd());
/* 21 */     manager.register(new mzm.gsp.visiblemonsterfight.main.POnPvEFightEnd());
/* 22 */     manager.register(new mzm.gsp.guaji.main.POnPvEFightEnd());
/* 23 */     manager.register(new mzm.gsp.circletask.main.POnPvEFightEnd());
/* 24 */     manager.register(new mzm.gsp.team.main.POnPvEFightEnd());
/* 25 */     manager.register(new mzm.gsp.instance.main.POnPvEFightEnd());
/* 26 */     manager.register(new mzm.gsp.guide.main.POnPVEFightEnd());
/* 27 */     manager.register(new mzm.gsp.jiuxiao.main.POnPVEFightEnd());
/* 28 */     manager.register(new mzm.gsp.husong.main.POnPVEFightEnd());
/* 29 */     manager.register(new mzm.gsp.grow.main.POnPVEFightEnd());
/* 30 */     manager.register(new mzm.gsp.qingyunzhi.main.POnPVEFightEnd());
/* 31 */     manager.register(new mzm.gsp.paraselene.main.POnPVEFightEnd());
/* 32 */     manager.register(new mzm.gsp.seasontask.main.POnPVEFightEnd());
/* 33 */     manager.register(new mzm.gsp.coupledaily.main.POnPVEFightEnd());
/* 34 */     manager.register(new mzm.gsp.marriage.main.POnPVEFightEnd());
/* 35 */     manager.register(new mzm.gsp.hula.main.POnPveFightEnd());
/* 36 */     manager.register(new mzm.gsp.competition.main.POnPVEFightEnd());
/* 37 */     manager.register(new mzm.gsp.menpaistar.main.POnPVEFightEnd());
/* 38 */     manager.register(new mzm.gsp.menpaistar.main.POnPVEFightEndRole());
/* 39 */     manager.register(new mzm.gsp.feisheng.fight.POnPVEFightEnd());
/* 40 */     manager.register(new mzm.gsp.feisheng.zhuxianjianzhen.POnPVEFightEnd());
/* 41 */     manager.register(new mzm.gsp.factionpve.main.POnPVEFightEnd());
/* 42 */     manager.register(new mzm.gsp.relatedboss.main.POnPVEFightEnd());
/* 43 */     manager.register(new mzm.gsp.floor.main.POnPVEFightEnd());
/* 44 */     manager.register(new mzm.gsp.wanted.main.POnPVEFightEnd());
/* 45 */     manager.register(new mzm.gsp.prison.main.POnPVEFightEnd());
/* 46 */     manager.register(new mzm.gsp.addiction.main.POnPVEFightEnd());
/* 47 */     manager.register(new mzm.gsp.chivalry.main.POnPVEFightEnd());
/* 48 */     manager.register(new mzm.gsp.achievement.main.POnPVEFightEnd());
/* 49 */     manager.register(new mzm.gsp.changemodelcard.main.POnPVEFightEnd());
/* 50 */     manager.register(new mzm.gsp.pet.main.POnPvEFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */