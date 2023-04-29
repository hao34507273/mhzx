/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class POnPVPFightStart extends mzm.gsp.fight.event.PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     FightContext fightContext = ((PVPFightStartArg)this.arg).context;
/* 13 */     if (!(fightContext instanceof PointRaceFightContext))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     if (!GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     PointRaceFightContext pointRaceFightContext = (PointRaceFightContext)fightContext;
/* 24 */     long activeCorpsid = pointRaceFightContext.activeCorpsid;
/* 25 */     long passiveCorpsid = pointRaceFightContext.passiveCorpsid;
/*    */     
/* 27 */     GameServer.logger().info(String.format("[crossbattlepoint]POnPVPFightStart.processImp@pvp fight start|active_corpsid=%d|passive_corpsid=%d", new Object[] { Long.valueOf(activeCorpsid), Long.valueOf(passiveCorpsid) }));
/*    */     
/*    */ 
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */