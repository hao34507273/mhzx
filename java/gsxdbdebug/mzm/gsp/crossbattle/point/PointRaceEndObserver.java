/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PointPVPInfo;
/*     */ 
/*     */ public class PointRaceEndObserver extends Observer
/*     */ {
/*     */   private final long worldid;
/*     */   
/*     */   public PointRaceEndObserver(long intervalSeconds, long worldid)
/*     */   {
/*  18 */     super(intervalSeconds);
/*  19 */     this.worldid = worldid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  25 */     RoamPointRaceOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(this.worldid), new PPointRaceEnd(this.worldid));
/*  26 */     return false;
/*     */   }
/*     */   
/*     */   private static class PPointRaceEnd extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long worldid;
/*     */     
/*     */     public PPointRaceEnd(long worldid)
/*     */     {
/*  35 */       this.worldid = worldid;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  42 */       PointPVPInfo xPointPVPInfo = xtable.Crossbattlepointpvp.get(Long.valueOf(this.worldid));
/*  43 */       if (xPointPVPInfo == null)
/*     */       {
/*  45 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceEnd.processImp@point pvp info is null|worldid=%d", new Object[] { Long.valueOf(this.worldid) }));
/*     */         
/*     */ 
/*  48 */         return false;
/*     */       }
/*     */       
/*  51 */       int activityCfgid = xPointPVPInfo.getActivity_cfgid();
/*  52 */       int zone = xPointPVPInfo.getZone();
/*  53 */       if (xPointPVPInfo.getFinish())
/*     */       {
/*  55 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceEnd.processImp@point race ended|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*     */         
/*     */ 
/*  58 */         return false;
/*     */       }
/*     */       
/*  61 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(this.worldid);
/*  62 */       if (zoneManager == null)
/*     */       {
/*  64 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceEnd.processImp@zone manager is null|activity_cfgid=%d|zone=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone) }));
/*     */         
/*     */ 
/*     */ 
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/*  72 */       Set<Long> corpsids = new java.util.HashSet();
/*  73 */       corpsManager.fillAllCorpsid(corpsids);
/*  74 */       corpsids.removeAll(xPointPVPInfo.getFights());
/*  75 */       for (Iterator i$ = corpsids.iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/*  78 */         CrossBattlePointManager.returnOriginalServer(this.worldid, corpsid);
/*     */       }
/*     */       
/*  81 */       if (xPointPVPInfo.getFights().isEmpty())
/*     */       {
/*  83 */         xPointPVPInfo.setFinish(true);
/*     */         
/*  85 */         int countDown = zoneManager.getReturnOriginalCountDown();
/*  86 */         new PointRaceEndObserver.DestoryWorldObserver(countDown, this.worldid);
/*     */       }
/*     */       
/*  89 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DestoryWorldObserver extends Observer
/*     */   {
/*     */     private final long worlid;
/*     */     
/*     */     public DestoryWorldObserver(long intervalSeconds, long worldid)
/*     */     {
/*  99 */       super();
/*     */       
/* 101 */       this.worlid = worldid;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 107 */       new PointRaceEndObserver.RDestoryWorld(this.worlid).execute();
/* 108 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RDestoryWorld extends LogicRunnable
/*     */   {
/*     */     private final long worldid;
/*     */     
/*     */     public RDestoryWorld(long worldid)
/*     */     {
/* 118 */       this.worldid = worldid;
/*     */     }
/*     */     
/*     */ 
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 125 */       MapInterface.destroyWorld(this.worldid);
/*     */       
/*     */ 
/* 128 */       new RReportCVC(this.worldid).process();
/*     */       
/* 130 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().removeZoneManager(this.worldid);
/* 131 */       if (zoneManager == null)
/*     */       {
/* 133 */         return;
/*     */       }
/*     */       
/* 136 */       int activityCfgid = zoneManager.activityCfgid;
/* 137 */       int zone = zoneManager.zone;
/* 138 */       int timePointCfgid = zoneManager.timePointCfgid;
/* 139 */       if (!CrossBattlePointManager.notifyPointRaceEnd(activityCfgid, zone, timePointCfgid))
/*     */       {
/* 141 */         GameServer.logger().error(String.format("[crossbattlepoint]RDestoryWorld.process@notify matcher point race end failed|activity_cfgid=%d|zone=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(timePointCfgid) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 146 */       zoneManager.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceEndObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */