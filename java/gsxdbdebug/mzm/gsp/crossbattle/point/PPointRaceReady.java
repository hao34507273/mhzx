/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.SPointRaceReadyFail;
/*     */ import mzm.gsp.crossbattle.SPointRaceReadySuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2pointracecontextid;
/*     */ import xtable.User;
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
/*     */ class PPointRaceReady
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int index;
/*     */   
/*     */   public PPointRaceReady(long roleid, int activityCfgid, int index)
/*     */   {
/*  67 */     this.roleid = roleid;
/*  68 */     this.activityCfgid = activityCfgid;
/*  69 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  75 */     if (this.activityCfgid <= 0)
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  81 */     if (cfg == null)
/*     */     {
/*  83 */       onFailed(7);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if ((this.index <= 0) || (this.index > cfg.timePoints.size()))
/*     */     {
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (!CrossBattlePointManager.canDoAction(this.roleid, 1442))
/*     */     {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  99 */       onFailed(1);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 105 */     if (teamid == null)
/*     */     {
/* 107 */       onFailed(-3);
/* 108 */       return false;
/*     */     }
/* 110 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), false);
/* 111 */     if (teamInfo == null)
/*     */     {
/* 113 */       Map<String, Object> extras = new HashMap();
/* 114 */       extras.put("teamid", teamid);
/* 115 */       onFailed(-3, extras);
/* 116 */       return false;
/*     */     }
/* 118 */     if (teamInfo.getLeaderId() != this.roleid)
/*     */     {
/* 120 */       Map<String, Object> extras = new HashMap();
/* 121 */       extras.put("tip_info", "not leader");
/* 122 */       onFailed(-3, extras);
/* 123 */       return false;
/*     */     }
/* 125 */     List<Long> teamNormals = teamInfo.getTeamNormalList();
/* 126 */     if (teamNormals.size() < CrossBattlePointManager.TEAM_SIZE)
/*     */     {
/* 128 */       Map<String, Object> extras = new HashMap();
/* 129 */       extras.put("team_size", Integer.valueOf(teamNormals.size()));
/* 130 */       onFailed(-4, extras);
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     Map<Long, String> role2Users = new HashMap();
/* 135 */     for (Iterator i$ = teamNormals.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 137 */       String userid = RoleInterface.getUserId(roleid);
/* 138 */       role2Users.put(Long.valueOf(roleid), userid);
/*     */     }
/*     */     
/*     */ 
/* 142 */     lock(User.getTable(), role2Users.values());
/* 143 */     lock(Basic.getTable(), teamNormals);
/*     */     
/*     */ 
/* 146 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(role2Users, teamNormals, this.activityCfgid);
/*     */     
/* 148 */     if (!result.isCanJoin())
/*     */     {
/* 150 */       onFailed(4);
/* 151 */       return false;
/*     */     }
/* 153 */     for (Iterator i$ = teamNormals.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 155 */       if (!CrossBattlePointManager.isFunOpen(roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */       {
/* 157 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), cfg.funSwitch);
/* 158 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 163 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, true, true);
/* 164 */     if (corpsInfo == null)
/*     */     {
/* 166 */       onFailed(5);
/* 167 */       return false;
/*     */     }
/* 169 */     long corpsid = corpsInfo.getCorpsId();
/* 170 */     int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, corpsid);
/* 171 */     if (zone <= 0)
/*     */     {
/* 173 */       onFailed(-6);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     List<Long> registerRoles = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsid, this.activityCfgid, true);
/*     */     
/* 179 */     if (registerRoles == null)
/*     */     {
/* 181 */       onFailed(-5);
/* 182 */       return false;
/*     */     }
/* 184 */     if (!registerRoles.containsAll(teamNormals))
/*     */     {
/* 186 */       onFailed(-5);
/* 187 */       return false;
/*     */     }
/*     */     
/* 190 */     int timePointCfgid = ((TimePointInfo)cfg.timePoints.get(this.index - 1)).timePoint;
/* 191 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = CrossBattlePointManager.getCrossbattlePointRaceInfo(this.activityCfgid, timePointCfgid, true);
/*     */     
/* 193 */     if (xCrossbattlePointRaceInfo == null)
/*     */     {
/* 195 */       onFailed(8);
/* 196 */       return false;
/*     */     }
/*     */     
/* 199 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 200 */     long lastTime = TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/* 201 */     long startTime = CrossBattlePointManager.getStartTime(cfg, xCrossbattlePointRaceInfo, zone);
/* 202 */     if (startTime > now)
/*     */     {
/* 204 */       Map<String, Object> extras = new HashMap();
/* 205 */       extras.put("time_point_cfgid", Integer.valueOf(timePointCfgid));
/* 206 */       onFailed(-2, extras);
/* 207 */       return false;
/*     */     }
/* 209 */     long delay = CrossBattlePointManager.getDelay(now, startTime, lastTime);
/* 210 */     if (delay <= 0L)
/*     */     {
/* 212 */       Map<String, Object> extras = new HashMap();
/* 213 */       extras.put("time_point_cfgid", Integer.valueOf(timePointCfgid));
/* 214 */       onFailed(-2, extras);
/* 215 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 219 */     List<Integer> preTimePoints = new ArrayList();
/* 220 */     for (int i = 0; i < cfg.timePoints.size(); i++)
/*     */     {
/* 222 */       TimePointInfo timePointInfo = (TimePointInfo)cfg.timePoints.get(i);
/* 223 */       if (timePointInfo.timePoint == timePointCfgid) {
/*     */         break;
/*     */       }
/*     */       
/* 227 */       preTimePoints.add(Integer.valueOf(timePointInfo.timePoint));
/*     */     }
/*     */     
/*     */ 
/* 231 */     if (!RoleStatusInterface.setStatus(teamNormals, 1441, true))
/*     */     {
/* 233 */       return false;
/*     */     }
/*     */     
/* 236 */     List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos = new ArrayList();
/* 237 */     RolePointRaceMarkingInfo leaderPointRaceMarkingInfo = CrossBattlePointManager.createRolePointRaceMarkingInfo(this.roleid);
/* 238 */     rolePointRaceMarkingInfos.add(leaderPointRaceMarkingInfo);
/* 239 */     for (Iterator i$ = teamNormals.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 241 */       if (roleid != this.roleid)
/*     */       {
/*     */ 
/*     */ 
/* 245 */         RolePointRaceMarkingInfo rolePointRaceMarkingInfo = CrossBattlePointManager.createRolePointRaceMarkingInfo(roleid);
/* 246 */         rolePointRaceMarkingInfos.add(rolePointRaceMarkingInfo);
/*     */       }
/*     */     }
/* 249 */     byte backup = (byte)(xCrossbattlePointRaceInfo.getBackup_zones().contains(Integer.valueOf(zone)) ? 1 : 0);
/* 250 */     PointRaceInfo pointRaceInfo = new PointRaceInfo(this.activityCfgid, zone, timePointCfgid, startTime, cfg.durationInMinute, preTimePoints, this.index, backup);
/*     */     
/* 252 */     long pointRaceContextid = CrossServerInterface.joinPointRace(corpsid, this.roleid, rolePointRaceMarkingInfos, pointRaceInfo);
/*     */     
/* 254 */     if (pointRaceContextid < 0L)
/*     */     {
/* 256 */       onFailed(-7);
/* 257 */       GameServer.logger().info(String.format("[crossbattlepoint]PCPointRaceReady.processImp@unknown error|activity_cfgid|roleid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/* 260 */       return false;
/*     */     }
/*     */     
/* 263 */     for (Iterator i$ = teamNormals.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 265 */       Role2pointracecontextid.insert(Long.valueOf(roleid), Long.valueOf(pointRaceContextid));
/*     */     }
/*     */     
/* 268 */     SPointRaceReadySuccess msg = new SPointRaceReadySuccess();
/* 269 */     msg.activity_cfgid = this.activityCfgid;
/* 270 */     msg.index = this.index;
/* 271 */     OnlineManager.getInstance().sendMulti(msg, teamNormals);
/*     */     
/* 273 */     GameServer.logger().info(String.format("[crossbattlepoint]PPointRaceReady.processImp@success|roleid=%d|activity_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 276 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 281 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 286 */     SPointRaceReadyFail resp = new SPointRaceReadyFail();
/* 287 */     resp.retcode = retcode;
/* 288 */     resp.activity_cfgid = this.activityCfgid;
/* 289 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 291 */     StringBuffer logBuilder = new StringBuffer();
/* 292 */     logBuilder.append("[crossbattlepoint]PPointRaceReady.onFailed@point race ready failed");
/* 293 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 294 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 295 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 297 */     if (extraParams != null)
/*     */     {
/* 299 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 301 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 305 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */