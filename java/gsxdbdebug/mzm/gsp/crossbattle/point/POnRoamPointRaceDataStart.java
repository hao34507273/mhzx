/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import hub.PointRaceCorpsInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossserver.event.RoamPointRaceDataStartArg;
/*     */ import mzm.gsp.crossserver.event.RoamPointRaceDataStartProcedure;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xbean.PointRaceInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoamPointRaceDataStart extends RoamPointRaceDataStartProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  25 */     long contextid = ((RoamPointRaceDataStartArg)this.arg).getContextid();
/*  26 */     int activityCfgid = ((RoamPointRaceDataStartArg)this.arg).getActivityCfgid();
/*  27 */     int timePointCfgid = ((RoamPointRaceDataStartArg)this.arg).getTimePointCfgid();
/*  28 */     long corpsid = ((RoamPointRaceDataStartArg)this.arg).getCorpsid();
/*     */     
/*  30 */     Map<Long, String> role2Userids = new HashMap();
/*  31 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : ((RoamPointRaceDataStartArg)this.arg).getRolePointRaceMarkingInfos())
/*     */     {
/*  33 */       long roleid = rolePointRaceMarkingInfo.getRoleid();
/*  34 */       String userid = RoleInterface.getUserId(roleid);
/*  35 */       role2Userids.put(Long.valueOf(roleid), userid);
/*     */     }
/*     */     
/*  38 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PRoamPointRaceDataStart(contextid, activityCfgid, timePointCfgid, corpsid, role2Userids));
/*     */     
/*     */ 
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   private static class PRoamPointRaceDataStart
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long contextid;
/*     */     private final int activityCfgid;
/*     */     private final int timePointCfgid;
/*     */     private final long corpsid;
/*     */     private final Map<Long, String> role2Userids;
/*     */     
/*     */     public PRoamPointRaceDataStart(long contextid, int activityCfgid, int timePointCfgid, long corpsid, Map<Long, String> role2Userids)
/*     */     {
/*  55 */       this.contextid = contextid;
/*  56 */       this.activityCfgid = activityCfgid;
/*  57 */       this.timePointCfgid = timePointCfgid;
/*  58 */       this.corpsid = corpsid;
/*  59 */       this.role2Userids = role2Userids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  65 */       java.util.List<Long> roleids = new ArrayList(this.role2Userids.keySet());
/*     */       
/*  67 */       lock(User.getTable(), this.role2Userids.values());
/*  68 */       lock(Basic.getTable(), roleids);
/*     */       
/*  70 */       SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  71 */       if (cfg == null)
/*     */       {
/*  73 */         CrossBattlePointManager.onCrossServerFail(roleids, 7, this.activityCfgid);
/*  74 */         return true;
/*     */       }
/*     */       
/*  77 */       CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = CrossBattlePointManager.getCrossbattlePointRaceInfo(this.activityCfgid, this.timePointCfgid, true);
/*     */       
/*  79 */       if (xCrossbattlePointRaceInfo == null)
/*     */       {
/*  81 */         CrossBattlePointManager.onCrossServerFail(roleids, 8, this.activityCfgid);
/*  82 */         return true;
/*     */       }
/*     */       
/*  85 */       int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, this.corpsid);
/*     */       
/*  87 */       long lastTime = TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/*  88 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  89 */       long startTime = CrossBattlePointManager.getStartTime(cfg, xCrossbattlePointRaceInfo, zone);
/*  90 */       long delay = CrossBattlePointManager.getDelay(now, startTime, lastTime);
/*  91 */       if (delay <= 0L)
/*     */       {
/*  93 */         CrossBattlePointManager.onCrossServerFail(roleids, -2, this.activityCfgid);
/*     */         
/*  95 */         return true;
/*     */       }
/*     */       
/*  98 */       PointRaceInfo xPointRaceInfo = (PointRaceInfo)xCrossbattlePointRaceInfo.getCorps().get(Long.valueOf(this.corpsid));
/*  99 */       if (xPointRaceInfo == null)
/*     */       {
/* 101 */         xPointRaceInfo = xbean.Pod.newPointRaceInfo();
/* 102 */         xCrossbattlePointRaceInfo.getCorps().put(Long.valueOf(this.corpsid), xPointRaceInfo);
/*     */       }
/*     */       
/* 105 */       PointRaceCorpsInfo pointRaceCorpsInfo = new PointRaceCorpsInfo();
/* 106 */       pointRaceCorpsInfo.corpsid = this.corpsid;
/* 107 */       pointRaceCorpsInfo.lose = xPointRaceInfo.getLose();
/* 108 */       pointRaceCorpsInfo.point = xPointRaceInfo.getPoint();
/* 109 */       pointRaceCorpsInfo.update_time = xPointRaceInfo.getUpdate_time();
/* 110 */       pointRaceCorpsInfo.win = xPointRaceInfo.getWin();
/*     */       
/* 112 */       if (!CrossServerInterface.roamPointRaceData(this.contextid, pointRaceCorpsInfo))
/*     */       {
/* 114 */         CrossBattlePointManager.onCrossServerFail(roleids, -7, this.activityCfgid);
/*     */       }
/*     */       
/* 117 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnRoamPointRaceDataStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */