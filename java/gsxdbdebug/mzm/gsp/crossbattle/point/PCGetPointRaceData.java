/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.PointRaceData;
/*     */ import mzm.gsp.crossbattle.SGetPointRaceDataFail;
/*     */ import mzm.gsp.crossbattle.SGetPointRaceDataSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.UserRoamedInfo;
/*     */ 
/*     */ public class PCGetPointRaceData extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCGetPointRaceData(long roleid)
/*     */   {
/*  23 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     String userid = RoleInterface.getUserId(this.roleid);
/*  35 */     UserRoamedInfo xUserRoamedInfo = xtable.User2roamedinfo.get(userid);
/*  36 */     if (xUserRoamedInfo == null)
/*     */     {
/*  38 */       GameServer.logger().error(String.format("[crossbattlepoint]PCGetPointRaceData.processImp@user roamed info is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (xUserRoamedInfo.getRoam_type() != RoamType.CROSS_BATTLE_POINT.ordinal())
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[crossbattlepoint]PCGetPointRaceData.processImp@roam type invalid|roleid=%d|roam_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xUserRoamedInfo.getRoam_type()) }));
/*     */       
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     long worldid = xUserRoamedInfo.getInstanceid();
/*  53 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/*  54 */     if (zoneManager == null)
/*     */     {
/*  56 */       onFailed(8);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     SCrossBattlePointCfg cfg = zoneManager.crossBattlePointCfg;
/*  61 */     if (!CrossBattlePointManager.isFunOpen(this.roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/*  67 */     Long corpsid = corpsManager.getCorpsid(this.roleid);
/*  68 */     if (corpsid == null)
/*     */     {
/*  70 */       onFailed(5);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     PointRaceChart chart = zoneManager.getChart();
/*  75 */     PointRaceGatherChart gatherChart = zoneManager.getGatherChart();
/*  76 */     PointRaceCorpsCurInfo curInfo = corpsManager.getCorpsCurInfo(corpsid.longValue());
/*  77 */     PointRaceCorpsPreInfo preInfo = corpsManager.getCorpsPreInfo(corpsid.longValue());
/*  78 */     PointRaceCorpsFightInfo fightInfo = corpsManager.getCorpsFightInfo(corpsid.longValue());
/*     */     
/*  80 */     SGetPointRaceDataSuccess rsp = new SGetPointRaceDataSuccess();
/*  81 */     PointRaceData pointRaceData = rsp.point_race_data;
/*  82 */     if (curInfo != null)
/*     */     {
/*  84 */       pointRaceData.cur_lose = curInfo.lose;
/*  85 */       pointRaceData.cur_point = curInfo.point;
/*  86 */       pointRaceData.cur_win = curInfo.win;
/*     */     }
/*  88 */     if (fightInfo != null)
/*     */     {
/*  90 */       pointRaceData.victories = fightInfo.wins;
/*     */     }
/*  92 */     if (preInfo != null)
/*     */     {
/*  94 */       pointRaceData.wins = (preInfo.win + pointRaceData.cur_win);
/*  95 */       pointRaceData.loses = (preInfo.lose + pointRaceData.cur_lose);
/*  96 */       pointRaceData.points = (preInfo.point + pointRaceData.cur_point);
/*     */     }
/*     */     else
/*     */     {
/* 100 */       pointRaceData.wins = pointRaceData.cur_win;
/* 101 */       pointRaceData.loses = pointRaceData.cur_lose;
/* 102 */       pointRaceData.points = pointRaceData.cur_point;
/*     */     }
/* 104 */     pointRaceData.cur_rank = (chart.getRank(corpsid) + 1);
/* 105 */     pointRaceData.rank = (gatherChart.getRank(corpsid) + 1);
/*     */     
/* 107 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 114 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 119 */     SGetPointRaceDataFail resp = new SGetPointRaceDataFail();
/* 120 */     resp.retcode = retcode;
/* 121 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 123 */     StringBuffer logBuilder = new StringBuffer();
/* 124 */     logBuilder.append("[crossbattlepoint]PCGetPointRaceData.onFailed@get point race failed");
/* 125 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 126 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 128 */     if (extraParams != null)
/*     */     {
/* 130 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 132 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 136 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PCGetPointRaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */