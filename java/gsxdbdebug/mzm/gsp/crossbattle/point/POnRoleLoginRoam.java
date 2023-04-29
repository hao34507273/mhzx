/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PointPVPInfo;
/*     */ import xbean.UserRoamedInfo;
/*     */ import xtable.Crossbattlepointpvp;
/*     */ 
/*     */ public class POnRoleLoginRoam extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public POnRoleLoginRoam(long roleid)
/*     */   {
/*  21 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  28 */     UserRoamedInfo xUserRoamedInfo = xtable.User2roamedinfo.get(userid);
/*  29 */     if (xUserRoamedInfo == null)
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     if (xUserRoamedInfo.getRoam_type() != RoamType.CROSS_BATTLE_POINT.ordinal())
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     long worldid = xUserRoamedInfo.getInstanceid();
/*  40 */     PointPVPInfo xPointPVPInfo = Crossbattlepointpvp.get(Long.valueOf(worldid));
/*  41 */     if (xPointPVPInfo == null)
/*     */     {
/*  43 */       GameServer.logger().error(String.format("[crossbattlepoint]POnRoleLogin.processImp@crosss battle point pvp is null|roleid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid) }));
/*     */       
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/*  51 */     if (zoneManager == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[crossbattlepoint]POnRoleLogin.processImp@zone manager is null|roleid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     int zone = zoneManager.zone;
/*  60 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/*  61 */     Long corpsid = corpsManager.getCorpsid(this.roleid);
/*  62 */     if (corpsid == null)
/*     */     {
/*  64 */       GameServer.logger().error(String.format("[crossbattlepoint]POnRoleLogin.processImp@corpsid is null|roleid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid) }));
/*     */       
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     PointRaceCorpsCurInfo curInfo = corpsManager.getCorpsCurInfo(corpsid.longValue());
/*  71 */     if (curInfo == null)
/*     */     {
/*  73 */       GameServer.logger().error(String.format("[crossbattlepoint]POnRoleLogin.processImp@point race corps cur info is null|roleid=%d|worldid=%d|corpsid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid), corpsid }));
/*     */       
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     PointRaceCorpsPreInfo preInfo = corpsManager.getCorpsPreInfo(corpsid.longValue());
/*  80 */     if (preInfo == null)
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[crossbattlepoint]POnRoleLogin.processImp@point race corps pre info is null|roleid=%d|worldid=%d|corpsid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid), corpsid }));
/*     */       
/*     */ 
/*     */ 
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     List<Long> roleids = corpsManager.getRoleids(corpsid.longValue());
/*  90 */     int corpsDuty = 2;
/*  91 */     if (this.roleid == ((Long)roleids.get(0)).longValue())
/*     */     {
/*  93 */       corpsDuty = 1;
/*     */     }
/*     */     
/*  96 */     int index = zoneManager.index;
/*  97 */     byte backup = zoneManager.backup;
/*     */     
/*     */ 
/* 100 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 101 */     long startTime = xPointPVPInfo.getStart_time();
/* 102 */     SCrossBattlePointCfg crossBattlePointCfg = zoneManager.crossBattlePointCfg;
/*     */     
/* 104 */     int prepareDurationInMinute = crossBattlePointCfg.prepareDurationInMinute;
/* 105 */     long delay = startTime + TimeUnit.MINUTES.toMillis(prepareDurationInMinute) - now;
/* 106 */     if (delay > 0L)
/*     */     {
/* 108 */       CrossBattlePointManager.setPointRaceTitle(this.roleid, corpsid.longValue(), preInfo.name, corpsDuty, preInfo.icon);
/* 109 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 0, delay);
/* 110 */       return true;
/*     */     }
/*     */     
/* 113 */     int matchDurationInMinute = crossBattlePointCfg.matchDurationInMinute;
/* 114 */     delay += TimeUnit.MINUTES.toMillis(matchDurationInMinute);
/* 115 */     if (delay > 0L)
/*     */     {
/* 117 */       CrossBattlePointManager.setPointRaceTitle(this.roleid, corpsid.longValue(), preInfo.name, corpsDuty, preInfo.icon);
/* 118 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 1, delay);
/* 119 */       return true;
/*     */     }
/*     */     
/* 122 */     delay += TimeUnit.MINUTES.toMillis(crossBattlePointCfg.durationInMinute - prepareDurationInMinute - matchDurationInMinute);
/*     */     
/*     */ 
/* 125 */     if (delay > 0L)
/*     */     {
/* 127 */       CrossBattlePointManager.setPointRaceTitle(this.roleid, corpsid.longValue(), preInfo.name, corpsDuty, preInfo.icon);
/* 128 */       CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 2, delay);
/* 129 */       return true;
/*     */     }
/*     */     
/* 132 */     if (!xPointPVPInfo.getFights().contains(corpsid))
/*     */     {
/* 134 */       delay += TimeUnit.SECONDS.toMillis(crossBattlePointCfg.endFightCountDown);
/* 135 */       if (delay > 0L)
/*     */       {
/* 137 */         CrossBattlePointManager.setPointRaceTitle(this.roleid, corpsid.longValue(), preInfo.name, corpsDuty, preInfo.icon);
/* 138 */         CrossBattlePointManager.syncPointRaceStage(this.roleid, zone, index, backup, 3, delay);
/*     */         
/* 140 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 144 */       GameServer.logger().error(String.format("[crossbattlepoint]POnRoleLogin.processImp@point race ended|roleid=%d|worldid=%d|corpsid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid), corpsid }));
/*     */       
/*     */ 
/*     */ 
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnRoleLoginRoam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */