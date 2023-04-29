/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.SGetPointRaceRankFail;
/*     */ import mzm.gsp.crossbattle.SGetPointRaceRankSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.UserRoamedInfo;
/*     */ 
/*     */ public class PCGetPointRaceRank extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final byte rankType;
/*     */   private final int from;
/*     */   private final int to;
/*     */   
/*     */   public PCGetPointRaceRank(long roleid, byte rankType, int from, int to)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.rankType = rankType;
/*  28 */     this.from = from;
/*  29 */     this.to = to;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if ((this.rankType != 0) && (this.rankType != 1))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (this.from < 0)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (this.from > this.to)
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleid);
/*  55 */     UserRoamedInfo xUserRoamedInfo = xtable.User2roamedinfo.get(userid);
/*  56 */     if (xUserRoamedInfo == null)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[crossbattlepoint]PCGetPointRaceData.processImp@user roamed info is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (xUserRoamedInfo.getRoam_type() != RoamType.CROSS_BATTLE_POINT.ordinal())
/*     */     {
/*  66 */       GameServer.logger().error(String.format("[crossbattlepoint]PCGetPointRaceData.processImp@roam type invalid|roleid=%d|roam_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xUserRoamedInfo.getRoam_type()) }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     long worldid = xUserRoamedInfo.getInstanceid();
/*  73 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/*  74 */     if (zoneManager == null)
/*     */     {
/*  76 */       onFailed(8);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     SCrossBattlePointCfg cfg = zoneManager.crossBattlePointCfg;
/*  81 */     if (!CrossBattlePointManager.isFunOpen(this.roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/*  87 */     Long corpsid = corpsManager.getCorpsid(this.roleid);
/*  88 */     if (corpsid == null)
/*     */     {
/*  90 */       onFailed(5);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     SGetPointRaceRankSuccess rsp = new SGetPointRaceRankSuccess();
/*  95 */     rsp.rank_type = this.rankType;
/*  96 */     rsp.from = this.from;
/*  97 */     rsp.to = this.to;
/*     */     
/*  99 */     if (this.rankType == 0)
/*     */     {
/* 101 */       PointRaceChart pointRaceChart = zoneManager.getChart();
/* 102 */       List<PointRaceChartObj> chartObjs = pointRaceChart.getRankObjs(this.from - 1, this.to - 1);
/* 103 */       CrossBattlePointManager.fillPointRaceChartObjs(rsp.point_race_ranks, this.from, chartObjs);
/*     */     }
/*     */     else
/*     */     {
/* 107 */       PointRaceGatherChart pointRaceGatherChart = zoneManager.getGatherChart();
/* 108 */       List<PointRaceChartObj> chartObjs = pointRaceGatherChart.getRankObjs(this.from - 1, this.to - 1);
/* 109 */       CrossBattlePointManager.fillPointRaceChartObjs(rsp.point_race_ranks, this.from, chartObjs);
/*     */     }
/* 111 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 118 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 123 */     SGetPointRaceRankFail resp = new SGetPointRaceRankFail();
/* 124 */     resp.retcode = retcode;
/* 125 */     resp.rank_type = this.rankType;
/* 126 */     resp.from = this.from;
/* 127 */     resp.to = this.to;
/* 128 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 130 */     StringBuffer logBuilder = new StringBuffer();
/* 131 */     logBuilder.append("[crossbattlepoint]PCGetPointRaceRank.onFailed@get point race rank failed");
/* 132 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 133 */     logBuilder.append('|').append("rank_type=").append(this.rankType);
/* 134 */     logBuilder.append('|').append("from=").append(this.from);
/* 135 */     logBuilder.append('|').append("to=").append(this.to);
/* 136 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 138 */     if (extraParams != null)
/*     */     {
/* 140 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 142 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 146 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PCGetPointRaceRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */