/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerTransferScene extends mzm.event.BasicEvent<MapTransferArg>
/*    */ {
/*  7 */   private static EventManager<MapTransferArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MapTransferArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.instance.main.POnTransferScene());
/* 16 */     manager.register(new mzm.gsp.jiuxiao.main.POnTransferScene());
/* 17 */     manager.register(new mzm.gsp.buff.main.POnPlayerLeaveScene());
/* 18 */     manager.register(new mzm.gsp.menpaipvp.main.POnTransferScene());
/* 19 */     manager.register(new mzm.gsp.arena.main.POnTransferScene());
/* 20 */     manager.register(new mzm.gsp.competition.main.POnTransferScene());
/* 21 */     manager.register(new mzm.gsp.paraselene.main.POnTransferScene());
/* 22 */     manager.register(new mzm.gsp.watchmoon.main.POnTransferScene());
/* 23 */     manager.register(new mzm.gsp.couple.main.POnTransferScene());
/* 24 */     manager.register(new mzm.gsp.qmhw.main.POnTransferScene());
/* 25 */     manager.register(new mzm.gsp.visiblemonsterfight.main.robber.POnTransferScene());
/* 26 */     manager.register(new mzm.gsp.homeland.main.POnTransferScene());
/* 27 */     manager.register(new mzm.gsp.treasurehunt.main.POnTransferScene());
/* 28 */     manager.register(new mzm.gsp.hula.main.POnTransferScene());
/* 29 */     manager.register(new mzm.gsp.interactivetask.main.POnTransferScene());
/* 30 */     manager.register(new mzm.gsp.banquest.main.POnTransferScene());
/* 31 */     manager.register(new mzm.gsp.masswedding.main.POnTransferScene());
/* 32 */     manager.register(new mzm.gsp.factionpve.main.POnTransferScene());
/* 33 */     manager.register(new mzm.gsp.crosscompete.roam.POnTransferScene());
/* 34 */     manager.register(new mzm.gsp.prison.main.POnTransferScene());
/* 35 */     manager.register(new mzm.gsp.cake.main.POnTransferScene());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\PlayerTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */