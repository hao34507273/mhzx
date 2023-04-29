/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import xbean.CrossbattlePoint;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLoginLocal extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final long roleid;
/*     */   
/*     */   public POnRoleLoginLocal(int activityCfgid, long roleid)
/*     */   {
/*  23 */     this.activityCfgid = activityCfgid;
/*  24 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     SCrossBattlePointCfg crossBattlePointCfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  31 */     if (crossBattlePointCfg == null)
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  37 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, false, false);
/*  38 */     if (corpsInfo == null)
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     long corpsid = corpsInfo.getCorpsId();
/*  44 */     List<Long> members = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsid, this.activityCfgid, false);
/*  45 */     if ((members == null) || (!members.contains(Long.valueOf(this.roleid))))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     int zone = CrossBattlePointManager.getCorpsZoneIfActive(this.activityCfgid, corpsid, false);
/*  51 */     if (zone <= 0)
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     PointRaceBackContext pointRaceBackContext = PointRaceBackContextManager.getInstance().getContext(corpsid);
/*  58 */     if (pointRaceBackContext != null)
/*     */     {
/*  60 */       List<String> allUsers = new ArrayList();
/*  61 */       List<Long> allRoles = new ArrayList();
/*  62 */       for (PointRaceUserBackData userDataBack : pointRaceBackContext.userDatas)
/*     */       {
/*  64 */         allRoles.add(Long.valueOf(userDataBack.roleid));
/*  65 */         allUsers.add(userDataBack.userid);
/*     */       }
/*  67 */       lock(User.getTable(), allUsers);
/*  68 */       lock(xtable.Role2properties.getTable(), allRoles);
/*     */       
/*     */ 
/*  71 */       pointRaceBackContext.setLogined(this.roleid);
/*  72 */       pointRaceBackContext.tryRestoreTeam(this.roleid);
/*  73 */       if (pointRaceBackContext.isTeamRestore())
/*     */       {
/*  75 */         pointRaceBackContext.onAllRoleLogined();
/*     */       }
/*     */     }
/*     */     
/*  79 */     CrossbattlePoint xCrossbattlePoint = CrossBattlePointManager.getCrossbattlePoint(this.activityCfgid, true);
/*  80 */     if (xCrossbattlePoint == null)
/*     */     {
/*  82 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, 1, (byte)0, -1, 0L);
/*  83 */       return true;
/*     */     }
/*     */     
/*  86 */     int index = CrossBattlePointManager.getCurIndex(crossBattlePointCfg, xCrossbattlePoint, zone);
/*  87 */     if ((index > crossBattlePointCfg.timePoints.size()) || (index <= 0))
/*     */     {
/*  89 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, 0, (byte)0, -1, 0L);
/*  90 */       return true;
/*     */     }
/*     */     
/*  93 */     TimePointInfo timePointInfo = (TimePointInfo)crossBattlePointCfg.timePoints.get(index - 1);
/*  94 */     int timePointCfgid = timePointInfo.timePoint;
/*     */     
/*  96 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xCrossbattlePoint.getPoint_races().get(Integer.valueOf(timePointCfgid));
/*  97 */     if (xCrossbattlePointRaceInfo == null)
/*     */     {
/*  99 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, 1, (byte)0, -1, 0L);
/* 100 */       return true;
/*     */     }
/*     */     
/* 103 */     byte backup = 0;
/* 104 */     if (xCrossbattlePointRaceInfo.getBackup_zones().contains(Integer.valueOf(zone)))
/*     */     {
/* 106 */       backup = 1;
/*     */     }
/*     */     
/*     */ 
/* 110 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 111 */     long startTime = CrossBattlePointManager.getStartTime(crossBattlePointCfg, xCrossbattlePointRaceInfo, zone);
/* 112 */     if (startTime > now)
/*     */     {
/* 114 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, -1, 0L);
/* 115 */       return true;
/*     */     }
/*     */     
/* 118 */     int prepareDurationInMinute = crossBattlePointCfg.prepareDurationInMinute;
/* 119 */     long delay = startTime + TimeUnit.MINUTES.toMillis(prepareDurationInMinute) - now;
/* 120 */     if (delay > 0L)
/*     */     {
/* 122 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 0, delay);
/*     */     }
/*     */     else
/*     */     {
/* 126 */       int matchDurationInMinute = crossBattlePointCfg.matchDurationInMinute;
/* 127 */       delay += TimeUnit.MINUTES.toMillis(matchDurationInMinute);
/* 128 */       if (delay > 0L)
/*     */       {
/* 130 */         CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 1, delay);
/*     */       }
/*     */       else
/*     */       {
/* 134 */         delay += TimeUnit.MINUTES.toMillis(crossBattlePointCfg.durationInMinute - prepareDurationInMinute - matchDurationInMinute);
/*     */         
/*     */ 
/* 137 */         if (delay > 0L)
/*     */         {
/* 139 */           CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 2, delay);
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 144 */         else if (timePointCfgid == crossBattlePointCfg.lastTimePoint)
/*     */         {
/*     */ 
/* 147 */           CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, 0, (byte)0, -1, 0L);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 153 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnRoleLoginLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */