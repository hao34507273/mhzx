/*     */ package mzm.gsp.watchmoon.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.group.MapGroupType;
/*     */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*     */ import mzm.gsp.map.main.scene.zone.bounding.CylinderBounding;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.watchmoon.SAgreeWatchmoonFailedRes;
/*     */ import mzm.gsp.watchmoon.SInviteWatchmoonFailedRes;
/*     */ import mzm.gsp.watchmoon.SWatchmoonFailedRes;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonMapCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Watchmoon;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2watchmoon;
/*     */ 
/*     */ public class WatchmoonManager
/*     */ {
/*  35 */   static Logger logger = null;
/*     */   
/*     */ 
/*     */   static void init()
/*     */   {
/*  40 */     logger = Logger.getLogger("watchmoon");
/*  41 */     ActivityInterface.registerActivityByLogicType(34, new WatchmoonActivityInit());
/*     */     
/*  43 */     ActivityCompensateInterface.registerCompensateHandler(34, new WatchmoonActivityInit());
/*     */     
/*  45 */     for (SWatchmoonMapCfg watchmoonMapCfg : SWatchmoonMapCfg.getAll().values())
/*     */     {
/*  47 */       if (!MapInterface.isReachable(watchmoonMapCfg.mapid, watchmoonMapCfg.startposX, watchmoonMapCfg.startposY))
/*     */       {
/*  49 */         throw new RuntimeException("3565_赏月传送表.xlsx 赏月起始点位置不可达 id=" + watchmoonMapCfg.id);
/*     */       }
/*  51 */       if (!MapInterface.isReachable(watchmoonMapCfg.mapid, watchmoonMapCfg.endposX, watchmoonMapCfg.endposY))
/*     */       {
/*  53 */         throw new RuntimeException("3565_赏月传送表.xlsx 赏月目标点位置不可达 id=" + watchmoonMapCfg.id);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void postInit()
/*     */   {
/*  63 */     for (SWatchmoonMapCfg watchmoonMapCfg : SWatchmoonMapCfg.getAll().values())
/*     */     {
/*     */ 
/*  66 */       ZoneForm zf = new CylinderBounding(watchmoonMapCfg.endposX, watchmoonMapCfg.endposY, 0, watchmoonMapCfg.distance);
/*     */       
/*     */ 
/*  69 */       MapInterface.registerZoneEvent(watchmoonMapCfg.mapid, zf, 2, new WatchmoonZoneListener(), null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendSInviteWatchmoonFailedRes(long roleid, int code, long errorRoleid)
/*     */   {
/*  78 */     SInviteWatchmoonFailedRes res = new SInviteWatchmoonFailedRes();
/*  79 */     res.rescode = code;
/*  80 */     res.errorroleid = errorRoleid;
/*  81 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
/*     */   
/*     */   static void sendSAgreeWatchmoonFailedRes(long roleid, int code, long errorRoleid)
/*     */   {
/*  86 */     SAgreeWatchmoonFailedRes res = new SAgreeWatchmoonFailedRes();
/*  87 */     res.rescode = code;
/*  88 */     res.errorroleid = errorRoleid;
/*  89 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
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
/*     */   static boolean addWatchMoon(long roleid, int mapId, boolean isCouple, long partenerRoleid, long inviteTime)
/*     */   {
/* 105 */     Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/* 106 */     if (xWatchmoon == null)
/*     */     {
/* 108 */       xWatchmoon = xbean.Pod.newWatchmoon();
/* 109 */       Role2watchmoon.insert(Long.valueOf(roleid), xWatchmoon);
/*     */     }
/*     */     
/*     */ 
/* 113 */     xWatchmoon.setInvitetime(inviteTime);
/* 114 */     xWatchmoon.setMapid(mapId);
/* 115 */     xWatchmoon.setIscouple(isCouple);
/* 116 */     xWatchmoon.setPartenerroleid(partenerRoleid);
/*     */     
/* 118 */     return true;
/*     */   }
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
/*     */   static void setWatchMoon(Watchmoon xWatchmoon, int mapId, boolean isCouple, long partenerRoleid)
/*     */   {
/* 134 */     xWatchmoon.setMapid(mapId);
/* 135 */     xWatchmoon.setIscouple(isCouple);
/*     */     
/* 137 */     xWatchmoon.setPartenerroleid(partenerRoleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int randomMapid()
/*     */   {
/* 149 */     List<Integer> mapids = new ArrayList(SWatchmoonMapCfg.getAll().keySet());
/* 150 */     if (mapids.isEmpty())
/*     */     {
/* 152 */       return -1;
/*     */     }
/* 154 */     int r = Xdb.random().nextInt(mapids.size());
/* 155 */     return ((Integer)mapids.get(r)).intValue();
/*     */   }
/*     */   
/*     */   static boolean isWatchMoonSessionStart(long sessionId)
/*     */   {
/* 160 */     return (sessionId != 0L) && (Session.getSession(sessionId) != null) && ((Session.getSession(sessionId) instanceof WatchMoonSession));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean isFlySessionStart(long sessionId)
/*     */   {
/* 167 */     return (sessionId != 0L) && (Session.getSession(sessionId) != null) && ((Session.getSession(sessionId) instanceof FlySession));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGangIdSame(long roleid1, long roleid2)
/*     */   {
/* 180 */     long gangid1 = GangInterface.getGangId(roleid1);
/* 181 */     if (gangid1 == 0L)
/*     */     {
/* 183 */       return false;
/*     */     }
/* 185 */     long gangid2 = GangInterface.getGangId(roleid2);
/* 186 */     if (gangid2 == 0L)
/*     */     {
/* 188 */       return false;
/*     */     }
/* 190 */     return gangid1 == gangid2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void doWatchMoonFailed(List<Long> roleids)
/*     */   {
/* 200 */     boolean isRemovedGroup = false;
/*     */     Iterator i$;
/*     */     try {
/* 203 */       SWatchmoonFailedRes failRes = new SWatchmoonFailedRes();
/* 204 */       failRes.roleids.addAll(roleids);
/* 205 */       OnlineManager.getInstance().sendMultiAtOnce(failRes, failRes.roleids);
/* 206 */       long groupid = 0L;
/* 207 */       boolean iscouple = false;
/*     */       
/* 209 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/* 212 */         Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/* 213 */         if (xWatchmoon != null)
/*     */         {
/* 215 */           groupid = xWatchmoon.getGroupid();
/* 216 */           iscouple = xWatchmoon.getIscouple();
/*     */         }
/* 218 */         Role2watchmoon.remove(Long.valueOf(roleid));
/*     */       }
/* 220 */       RoleStatusInterface.unsetStatus(roleids, 28);
/*     */       
/* 222 */       if (groupid == 0L)
/*     */       {
/* 224 */         MapInterface.removeMapGroupByRoleid(((Long)roleids.get(0)).longValue());
/* 225 */         MapInterface.removeMapGroupByRoleid(((Long)roleids.get(1)).longValue());
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 230 */       else if (iscouple)
/*     */       {
/*     */ 
/* 233 */         MapInterface.removeMapGroup(MapGroupType.MGT_WATCH_MOON_XYXW_FLY, groupid, roleids);
/*     */       }
/*     */       else
/*     */       {
/* 237 */         MapInterface.removeMapGroup(MapGroupType.MGT_WATCH_MOON_SIDE_BY_SIDE_FLY, groupid, roleids);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 242 */       int count1 = ActivityInterface.getActivityCount(RoleInterface.getUserId(((Long)roleids.get(0)).longValue()), ((Long)roleids.get(0)).longValue(), SWatchmoonConsts.getInstance().ACTIVITY_ID, false);
/*     */       
/* 244 */       int count2 = ActivityInterface.getActivityCount(RoleInterface.getUserId(((Long)roleids.get(1)).longValue()), ((Long)roleids.get(1)).longValue(), SWatchmoonConsts.getInstance().ACTIVITY_ID, false);
/*     */       
/*     */ 
/* 247 */       tlogWatchMoon(((Long)roleids.get(0)).longValue(), count1, ((Long)roleids.get(1)).longValue(), RoleInterface.getLevel(((Long)roleids.get(1)).longValue()), count2, WatchmoonOperateEnum.FAIL.value);
/*     */       
/* 249 */       isRemovedGroup = true;
/*     */     } finally {
/*     */       Iterator i$;
/*     */       long roleid;
/* 253 */       if (!isRemovedGroup)
/*     */       {
/* 255 */         RoleStatusInterface.unsetStatus(roleids, 28);
/* 256 */         for (i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 258 */           MapInterface.removeMapGroupByRoleid(roleid);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
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
/*     */   static boolean isCoupleFly(long roleId1, long roleId2)
/*     */   {
/* 275 */     if (RoleInterface.getGender(roleId1) == RoleInterface.getGender(roleId2))
/*     */     {
/* 277 */       return false;
/*     */     }
/* 279 */     return (RoleInterface.getLevel(roleId1) >= SWatchmoonConsts.getInstance().MIN_LEVEL_FOR_COUPLE_FLY) && (RoleInterface.getLevel(roleId2) >= SWatchmoonConsts.getInstance().MIN_LEVEL_FOR_COUPLE_FLY);
/*     */   }
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
/*     */   static void tlogWatchMoon(long roleid, int count, long partnerRoleid, int partnerLevel, int partnerCount, int operatetype)
/*     */   {
/* 298 */     String logName = "Watchmoon";
/* 299 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 300 */     String userid = RoleInterface.getUserId(roleid);
/* 301 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 303 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(count), Long.valueOf(partnerRoleid), Integer.valueOf(partnerLevel), Integer.valueOf(partnerCount), Integer.valueOf(operatetype) });
/*     */     
/* 305 */     TLogManager.getInstance().addLog(roleid, logName, logStr);
/*     */   }
/*     */   
/*     */   static long getWatchmoonMaxLengthTime()
/*     */   {
/* 310 */     return TimeUnit.SECONDS.toMillis(SWatchmoonConsts.getInstance().MAX_FLY_TIME + SWatchmoonConsts.getInstance().PREPARE_FLY_TIME + SWatchmoonConsts.getInstance().STAY_TIME);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean isWatchmoonSwitchOpenForRole(long roleid, long partenerRoleId)
/*     */   {
/* 317 */     if (!OpenInterface.getOpenStatus(38))
/*     */     {
/* 319 */       return false;
/*     */     }
/* 321 */     if (OpenInterface.isBanPlay(roleid, 38))
/*     */     {
/* 323 */       OpenInterface.sendBanPlayMsg(roleid, 38);
/* 324 */       return false;
/*     */     }
/* 326 */     if (OpenInterface.isBanPlay(partenerRoleId, 38))
/*     */     {
/* 328 */       OpenInterface.sendBanPlayMsg(roleid, partenerRoleId, RoleInterface.getName(partenerRoleId), 38);
/*     */       
/* 330 */       return false;
/*     */     }
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void forceRemoveRoleState(long roleid)
/*     */   {
/* 338 */     if (RoleStatusInterface.containsStatus(roleid, 28))
/*     */     {
/* 340 */       RoleStatusInterface.unsetStatus(roleid, 28);
/* 341 */       MapInterface.removeMapGroupByRoleid(roleid);
/* 342 */       Role2watchmoon.remove(Long.valueOf(roleid));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\WatchmoonManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */