/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.event.PointRacePVPFightEnd;
/*     */ import mzm.gsp.crossbattle.event.PointRacePVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.main.FightContext;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PointPVPInfo;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  20 */     FightContext fightContext = ((PVPFightEndArg)this.arg).context;
/*  21 */     if (!(fightContext instanceof PointRaceFightContext))
/*     */     {
/*  23 */       return false;
/*     */     }
/*  25 */     if (!mzm.gsp.GameServerInfoManager.isRoamServer())
/*     */     {
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     PointRaceFightContext pointRaceFightContext = (PointRaceFightContext)fightContext;
/*  31 */     long worldid = pointRaceFightContext.worldid;
/*  32 */     RoamPointRaceOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(worldid), new PPVPFightEnd(pointRaceFightContext, ((PVPFightEndArg)this.arg).isActiveWin));
/*     */     
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   private static class PPVPFightEnd extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final boolean activeWin;
/*     */     private final PointRaceFightContext pointRaceFightContext;
/*     */     
/*     */     public PPVPFightEnd(PointRaceFightContext pointRaceFightContext, boolean activeWin)
/*     */     {
/*  44 */       this.pointRaceFightContext = pointRaceFightContext;
/*  45 */       this.activeWin = activeWin;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  51 */       long worldid = this.pointRaceFightContext.worldid;
/*  52 */       PointPVPInfo xPointPVPInfo = xtable.Crossbattlepointpvp.get(Long.valueOf(worldid));
/*  53 */       if (xPointPVPInfo == null)
/*     */       {
/*  55 */         GameServer.logger().error(String.format("[crossbattlepoint]PPVPFightEnd.processImp@point pvp info is null|worldid=%d", new Object[] { Long.valueOf(worldid) }));
/*     */         
/*  57 */         return false;
/*     */       }
/*     */       
/*  60 */       int activityCfgid = xPointPVPInfo.getActivity_cfgid();
/*  61 */       int zone = xPointPVPInfo.getZone();
/*  62 */       if (xPointPVPInfo.getFinish())
/*     */       {
/*  64 */         GameServer.logger().error(String.format("[crossbattlepoint]PPVPFightEnd.processImp@point race ended|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*     */         
/*     */ 
/*  67 */         return false;
/*     */       }
/*     */       
/*  70 */       SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(activityCfgid);
/*  71 */       if (cfg == null)
/*     */       {
/*  73 */         GameServer.logger().error(String.format("[crossbattlepoint]PPVPFightEnd.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */         
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       long activeCorpsid = this.pointRaceFightContext.activeCorpsid;
/*  79 */       long passiveCorpsid = this.pointRaceFightContext.passiveCorpsid;
/*     */       
/*     */ 
/*  82 */       xPointPVPInfo.getFights().remove(Long.valueOf(activeCorpsid));
/*  83 */       xPointPVPInfo.getFights().remove(Long.valueOf(passiveCorpsid));
/*     */       
/*     */ 
/*  86 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/*  87 */       if (zoneManager == null)
/*     */       {
/*  89 */         GameServer.logger().error(String.format("[crossbattlepoint]PPVPFightEnd.processImp@zone manager is null|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*     */         
/*     */ 
/*     */ 
/*  93 */         return false;
/*     */       }
/*     */       
/*  96 */       PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/*  97 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  98 */       int winPoint = cfg.winPoint;
/*  99 */       int losePoint = cfg.losePoint;
/* 100 */       if (this.activeWin)
/*     */       {
/*     */ 
/* 103 */         corpsManager.update(activeCorpsid, passiveCorpsid, winPoint, losePoint, now);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 108 */         corpsManager.update(passiveCorpsid, activeCorpsid, winPoint, losePoint, now);
/*     */       }
/*     */       
/*     */ 
/* 112 */       zoneManager.updateChart(activeCorpsid);
/* 113 */       zoneManager.updateChart(passiveCorpsid);
/*     */       
/*     */ 
/* 116 */       long startTime = xPointPVPInfo.getStart_time();
/* 117 */       if (startTime + TimeUnit.MINUTES.toMillis(cfg.durationInMinute) <= now)
/*     */       {
/*     */ 
/* 120 */         CrossBattlePointManager.returnOriginalServer(worldid, activeCorpsid);
/* 121 */         CrossBattlePointManager.returnOriginalServer(worldid, passiveCorpsid);
/*     */         
/* 123 */         if (xPointPVPInfo.getFights().isEmpty())
/*     */         {
/* 125 */           new PointRaceEndObserver(15L, worldid);
/*     */         }
/*     */       }
/*     */       
/* 129 */       PointRacePVPFightEnd event = new PointRacePVPFightEnd();
/* 130 */       PointRacePVPFightEndArg arg = new PointRacePVPFightEndArg(worldid, activeCorpsid, passiveCorpsid);
/* 131 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */       
/*     */ 
/* 134 */       GameServer.logger().info(String.format("[crossbattlepoint]PPVPFightEnd.processImp@pvp fight end|activity_cfgid=%d|zone=%d|active_corpsid=%d|passive_corpsid=%d|active_win=%b", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Long.valueOf(activeCorpsid), Long.valueOf(passiveCorpsid), Boolean.valueOf(this.activeWin) }));
/*     */       
/*     */ 
/*     */ 
/* 138 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */