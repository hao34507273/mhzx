/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.SyncPointRaceEnd;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattlePoint;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xbean.PointRaceInfo;
/*     */ 
/*     */ public class PPointRaceCheck extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int timePointCfgid;
/*     */   private final boolean send;
/*     */   
/*     */   public PPointRaceCheck(int activityCfgid, int timePointCfgid, boolean send)
/*     */   {
/*  27 */     this.activityCfgid = activityCfgid;
/*  28 */     this.timePointCfgid = timePointCfgid;
/*  29 */     this.send = send;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  36 */     if (cfg == null)
/*     */     {
/*  38 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceCheck.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if ((CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch)) && (this.send))
/*     */     {
/*  47 */       SyncPointRaceEnd msg = new SyncPointRaceEnd();
/*  48 */       msg.activity_cfgid = this.activityCfgid;
/*  49 */       OnlineManager.getInstance().sendAll(msg);
/*     */     }
/*     */     
/*  52 */     Map<Long, Integer> corpsZones = CrossBattlePointManager.getCorpsZone(this.activityCfgid);
/*  53 */     if (corpsZones.isEmpty())
/*     */     {
/*  55 */       return true;
/*     */     }
/*     */     
/*  58 */     CrossbattlePoint xCrossbattlePoint = CrossBattlePointManager.getCrossbattlePoint(this.activityCfgid, true);
/*  59 */     if (xCrossbattlePoint == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceCheck.processImp@xbean cross battle point is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.timePointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*  67 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(this.timePointCfgid));
/*     */     
/*  69 */     if (xCrossbattlePointRaceInfo == null)
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceCheck.processImp@xbean cross battle point race is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.timePointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     int nextTimePointCfgid = 0;
/*  79 */     List<TimePointInfo> timePointInfos = cfg.timePoints;
/*  80 */     Iterator<TimePointInfo> it = timePointInfos.iterator();
/*  81 */     while (it.hasNext())
/*     */     {
/*  83 */       TimePointInfo timePointInfo = (TimePointInfo)it.next();
/*  84 */       if (timePointInfo.timePoint == this.timePointCfgid)
/*     */       {
/*  86 */         if (!it.hasNext())
/*     */           break;
/*  88 */         nextTimePointCfgid = ((TimePointInfo)it.next()).timePoint; break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  94 */     for (Map.Entry<Long, Integer> entry : corpsZones.entrySet())
/*     */     {
/*  96 */       long corpsid = ((Long)entry.getKey()).longValue();
/*  97 */       int zone = ((Integer)entry.getValue()).intValue();
/*  98 */       PointRaceInfo xPointRaceInfo = (PointRaceInfo)xCrossbattlePointRaceInfo.getCorps().get(Long.valueOf(corpsid));
/*  99 */       if (xPointRaceInfo == null)
/*     */       {
/* 101 */         xPointRaceInfo = xbean.Pod.newPointRaceInfo();
/* 102 */         xCrossbattlePointRaceInfo.getCorps().put(Long.valueOf(corpsid), xPointRaceInfo);
/*     */       }
/* 104 */       if (!xPointRaceInfo.getReported())
/*     */       {
/*     */ 
/* 107 */         mzm.gsp.crossbattle.CorpsPointRaceData data = new mzm.gsp.crossbattle.CorpsPointRaceData(xPointRaceInfo.getWin(), xPointRaceInfo.getLose(), xPointRaceInfo.getPoint(), xPointRaceInfo.getUpdate_time());
/*     */         
/*     */ 
/* 110 */         CrossBattlePointManager.reportCorpsPointRace(this.activityCfgid, corpsid, this.timePointCfgid, data);
/*     */       }
/*     */       
/*     */ 
/* 114 */       int curIndex = CrossBattlePointManager.getCurIndex(cfg, xCrossbattlePoint, zone);
/* 115 */       List<Long> members = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsid, this.activityCfgid, true);
/* 116 */       CrossBattlePointManager.syncPointRaceStage(members, zone, curIndex, (byte)0, -1, 0L);
/*     */       
/*     */ 
/* 119 */       if (nextTimePointCfgid > 0)
/*     */       {
/* 121 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PPointRacePrepareMail(this.activityCfgid, corpsid, nextTimePointCfgid));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     xCrossbattlePointRaceInfo.getBackup_zones().clear();
/*     */     
/* 129 */     if (this.timePointCfgid == cfg.lastTimePoint)
/*     */     {
/*     */ 
/* 132 */       int random = CrossBattlePointManager.random();
/* 133 */       new GetPointRaceResultObserver(TimeUnit.MINUTES.toSeconds(30L) + random, this.activityCfgid);
/*     */     }
/*     */     
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */