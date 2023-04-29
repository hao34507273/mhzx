/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVPFightFailArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PointPVPInfo;
/*    */ 
/*    */ public class POnPVPFightFail extends mzm.gsp.fight.event.PVPFightFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!mzm.gsp.GameServerInfoManager.isRoamServer())
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     mzm.gsp.fight.main.FightContext fightContext = ((PVPFightFailArg)this.arg).context;
/* 18 */     if (!(fightContext instanceof PointRaceFightContext))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     PointRaceFightContext pointRaceFightContext = (PointRaceFightContext)fightContext;
/* 24 */     long worldid = pointRaceFightContext.worldid;
/* 25 */     RoamPointRaceOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(worldid), new PPVPFightFail(pointRaceFightContext));
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   private static class PPVPFightFail extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final PointRaceFightContext pointRaceFightContext;
/*    */     
/*    */     public PPVPFightFail(PointRaceFightContext pointRaceFightContext)
/*    */     {
/* 35 */       this.pointRaceFightContext = pointRaceFightContext;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 41 */       long worldid = this.pointRaceFightContext.worldid;
/* 42 */       PointPVPInfo xPointPVPInfo = xtable.Crossbattlepointpvp.get(Long.valueOf(worldid));
/* 43 */       if (xPointPVPInfo == null)
/*    */       {
/* 45 */         GameServer.logger().error(String.format("[crossbattlepoint]PPVPFightFail.processImp@point pvp info is null|worldid=%d", new Object[] { Long.valueOf(worldid) }));
/*    */         
/* 47 */         return false;
/*    */       }
/*    */       
/* 50 */       int activityCfgid = xPointPVPInfo.getActivity_cfgid();
/* 51 */       int zone = xPointPVPInfo.getZone();
/* 52 */       if (xPointPVPInfo.getFinish())
/*    */       {
/* 54 */         GameServer.logger().error(String.format("[crossbattlepoint]PPVPFightFail.processImp@point race ended|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*    */         
/*    */ 
/* 57 */         return false;
/*    */       }
/*    */       
/* 60 */       long activeCorpsid = this.pointRaceFightContext.activeCorpsid;
/* 61 */       long passiveCorpsid = this.pointRaceFightContext.passiveCorpsid;
/*    */       
/* 63 */       xPointPVPInfo.getFights().remove(Long.valueOf(activeCorpsid));
/* 64 */       xPointPVPInfo.getFights().remove(Long.valueOf(passiveCorpsid));
/*    */       
/* 66 */       GameServer.logger().info(String.format("[crossbattlepoint]PPVPFightFail.processImp@pvp fight start fail|activity_cfgid=%d|zone=%d|active_corpsid=%d|passive_corpsid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Long.valueOf(activeCorpsid), Long.valueOf(passiveCorpsid) }));
/*    */       
/*    */ 
/*    */ 
/* 70 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnPVPFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */