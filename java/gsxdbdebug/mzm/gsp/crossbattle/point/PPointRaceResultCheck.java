/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.GetPointRaceResultReq;
/*     */ import mzm.gsp.crossbattle.GetZonePointRaceContext;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattlePoint;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ 
/*     */ public class PPointRaceResultCheck extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PPointRaceResultCheck(int activityCfgid)
/*     */   {
/*  25 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  32 */     if (cfg == null)
/*     */     {
/*  34 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResultCheck.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     Map<Long, Integer> corpsZones = CrossBattlePointManager.getCorpsZone(this.activityCfgid);
/*  41 */     if (corpsZones.isEmpty())
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     CrossbattlePoint xCrossbattlePoint = CrossBattlePointManager.getCrossbattlePoint(this.activityCfgid, true);
/*  47 */     if (xCrossbattlePoint == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     for (CrossbattlePointRaceInfo xCrossbattlePointRaceInfo : xCrossbattlePoint.getPoint_races().values())
/*     */     {
/*  54 */       if (!xCrossbattlePointRaceInfo.getBackup_zones().isEmpty())
/*     */       {
/*  56 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResultCheck.processImp@backup exist|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xCrossbattlePointRaceInfo.getTime_point_cfgid()) }));
/*     */         
/*     */ 
/*     */ 
/*  60 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  64 */     Map<Integer, GetZonePointRaceContext> zone2Context = new HashMap();
/*  65 */     Map<Integer, GetPointRaceResultReq> zone2req = new HashMap();
/*     */     
/*  67 */     for (Map.Entry<Long, Integer> entry : corpsZones.entrySet())
/*     */     {
/*  69 */       Long corpsid = (Long)entry.getKey();
/*  70 */       Integer rankResult = (Integer)xCrossbattlePoint.getCorps_result().get(corpsid);
/*  71 */       if ((rankResult == null) || (rankResult.intValue() == 0))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  76 */         int zone = ((Integer)entry.getValue()).intValue();
/*  77 */         GetZonePointRaceContext context = (GetZonePointRaceContext)zone2Context.get(Integer.valueOf(zone));
/*  78 */         if (context == null)
/*     */         {
/*  80 */           context = new GetZonePointRaceContext();
/*  81 */           context.oper_type = 2;
/*  82 */           zone2Context.put(Integer.valueOf(zone), context);
/*     */         }
/*     */         
/*  85 */         GetPointRaceResultReq req = (GetPointRaceResultReq)zone2req.get(Integer.valueOf(zone));
/*  86 */         if (req == null)
/*     */         {
/*  88 */           req = new GetPointRaceResultReq();
/*  89 */           zone2req.put(Integer.valueOf(zone), req);
/*     */         }
/*  91 */         req.corpsids.add(corpsid);
/*     */       }
/*     */     }
/*  94 */     if (zone2Context.isEmpty())
/*     */     {
/*  96 */       return true;
/*     */     }
/*     */     
/*  99 */     List<Integer> timePoints = new ArrayList();
/* 100 */     for (TimePointInfo timePointInfo : cfg.timePoints)
/*     */     {
/* 102 */       timePoints.add(Integer.valueOf(timePointInfo.timePoint));
/*     */     }
/*     */     
/* 105 */     for (Map.Entry<Integer, GetZonePointRaceContext> entry : zone2Context.entrySet())
/*     */     {
/* 107 */       Integer zone = (Integer)entry.getKey();
/* 108 */       GetPointRaceResultReq req = (GetPointRaceResultReq)zone2req.get(zone);
/* 109 */       req.time_points.addAll(timePoints);
/* 110 */       OctetsStream reqOs = new OctetsStream();
/* 111 */       req.marshal(reqOs);
/*     */       
/* 113 */       GetZonePointRaceContext context = (GetZonePointRaceContext)entry.getValue();
/* 114 */       context.content = reqOs;
/*     */       
/* 116 */       OctetsStream contextOs = new OctetsStream();
/* 117 */       contextOs.marshal(context);
/* 118 */       CrossServerInterface.asyncGetZonePointRace(this.activityCfgid, zone.intValue(), contextOs);
/*     */     }
/*     */     
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceResultCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */