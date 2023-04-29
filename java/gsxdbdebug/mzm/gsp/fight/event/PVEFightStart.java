/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVEFightStart extends mzm.event.BasicEvent<PVEFightStartArg>
/*    */ {
/*  7 */   private static EventManager<PVEFightStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVEFightStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.guide.main.POnPVEFightStart());
/* 16 */     manager.register(new mzm.gsp.map.main.POnPVEFightStart());
/* 17 */     manager.register(new mzm.gsp.hula.main.POnPveFightStart());
/* 18 */     manager.register(new mzm.gsp.competition.main.POnPVEFightStart());
/* 19 */     manager.register(new mzm.gsp.factionpve.main.POnPVEFightStart());
/* 20 */     manager.register(new mzm.gsp.relatedboss.main.POnPVEFightStart());
/* 21 */     manager.register(new mzm.gsp.wanted.main.POnPVEFightStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */