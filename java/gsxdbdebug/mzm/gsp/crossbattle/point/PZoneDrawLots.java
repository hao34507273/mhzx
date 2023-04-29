/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.SZoneDrawLotsFail;
/*     */ import mzm.gsp.crossbattle.SZoneDrawLotsSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattleDrawLots;
/*     */ import xbean.DrawLotsZoneInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PZoneDrawLots
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PZoneDrawLots(long roleid, int activityCfgid)
/*     */   {
/*  58 */     this.roleid = roleid;
/*  59 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  65 */     if (this.activityCfgid <= 0)
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(this.activityCfgid);
/*  71 */     if (cfg == null)
/*     */     {
/*  73 */       onFailed(7);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (!CrossBattlePointManager.canDoAction(this.roleid, 1431))
/*     */     {
/*  79 */       onFailed(3);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!CrossBattlePointManager.isFunOpen(this.roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  85 */       onFailed(1);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     String userid = RoleInterface.getUserId(this.roleid);
/*  90 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*  91 */     if (!result.isCanJoin())
/*     */     {
/*  93 */       onFailed(4);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  99 */     int drawLotsTimePoint = cfg.drawLotsTimePoint;
/* 100 */     STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(drawLotsTimePoint);
/* 101 */     if (timePointCommonCfg == null)
/*     */     {
/* 103 */       onFailed(7);
/* 104 */       return false;
/*     */     }
/* 106 */     long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg);
/* 107 */     if (now < startTime)
/*     */     {
/* 109 */       onFailed(-1);
/* 110 */       return false;
/*     */     }
/* 112 */     if (now >= startTime + TimeUnit.MINUTES.toMillis(cfg.durationInMinute))
/*     */     {
/* 114 */       onFailed(-1);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, true, true);
/* 120 */     if (corpsInfo == null)
/*     */     {
/* 122 */       onFailed(5);
/* 123 */       return false;
/*     */     }
/* 125 */     long corpsid = corpsInfo.getCorpsId();
/* 126 */     List<Long> corpsids = CrossBattleOwnInterface.getAllCrossBattleOwnPromotionCorpsids(this.activityCfgid, true);
/* 127 */     if (!corpsids.contains(Long.valueOf(corpsid)))
/*     */     {
/* 129 */       onFailed(-5);
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     if (corpsInfo.getCaptain() != this.roleid)
/*     */     {
/* 136 */       Map<String, Object> extras = new HashMap();
/* 137 */       extras.put("captain", Long.valueOf(corpsInfo.getCaptain()));
/* 138 */       onFailed(-2, extras);
/* 139 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 143 */     CrossbattleDrawLots xCrossbattleDrawLots = CrossBattlePointManager.getAndInitCrossbattleDrawLots(this.activityCfgid);
/* 144 */     DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(Long.valueOf(corpsid));
/* 145 */     if (xDrawLotsZoneInfo == null)
/*     */     {
/*     */ 
/* 148 */       if (!CrossBattlePointManager.getCorpsZones(this.roleid, corpsid, this.activityCfgid, corpsids))
/*     */       {
/* 150 */         onFailed(8);
/*     */       }
/* 152 */       return true;
/*     */     }
/*     */     
/* 155 */     int zone = xDrawLotsZoneInfo.getZone();
/* 156 */     if (zone <= 0)
/*     */     {
/*     */ 
/* 159 */       if (!CrossBattlePointManager.getCorpsZones(this.roleid, corpsid, this.activityCfgid, corpsids))
/*     */       {
/* 161 */         onFailed(8);
/*     */       }
/* 163 */       return true;
/*     */     }
/*     */     
/* 166 */     if (xDrawLotsZoneInfo.getActive() == 1)
/*     */     {
/* 168 */       onFailed(-3);
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     xDrawLotsZoneInfo.setActive(1);
/*     */     
/*     */ 
/* 176 */     CrossBattlePointManager.asyncZoneCorpsMail(this.activityCfgid, corpsid, zone);
/*     */     
/* 178 */     SZoneDrawLotsSuccess rsp = new SZoneDrawLotsSuccess();
/* 179 */     rsp.activity_cfgid = this.activityCfgid;
/* 180 */     rsp.zone = xDrawLotsZoneInfo.getZone();
/* 181 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 183 */     GameServer.logger().info(String.format("[crossbattlepoint]PZoneDrawLots.processImp@draw lots success|roleid=%d|activity_cfgid=%d|corps=%d|zone=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(corpsid), Integer.valueOf(zone) }));
/*     */     
/*     */ 
/*     */ 
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 192 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 197 */     SZoneDrawLotsFail resp = new SZoneDrawLotsFail();
/* 198 */     resp.retcode = retcode;
/* 199 */     resp.activity_cfgid = this.activityCfgid;
/* 200 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 202 */     StringBuffer logBuilder = new StringBuffer();
/* 203 */     logBuilder.append("[crossbattlepoint]PZoneDrawLots.onFailed@zone draw lots failed");
/* 204 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 205 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 206 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 208 */     if (extraParams != null)
/*     */     {
/* 210 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 212 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 216 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PZoneDrawLots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */