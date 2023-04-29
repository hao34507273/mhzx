/*     */ package mzm.gsp.loginaward.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.loginaward.LoginSignActivityInfo;
/*     */ import mzm.gsp.loginaward.SLoginSignActivityInfo;
/*     */ import mzm.gsp.loginaward.confbean.SBeginnerLoginSignCfg;
/*     */ import mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts;
/*     */ import mzm.gsp.loginaward.confbean.SLoginSignActivityAwardCfg;
/*     */ import mzm.gsp.loginaward.confbean.SLoginSignActivityAwardInfo;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LoginSignActivityInfos;
/*     */ import xbean.LoginSignInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2loginsignactivity;
/*     */ 
/*     */ public class LoginSignActivityManager
/*     */ {
/*  31 */   private static final Map<Integer, Integer> activityToFunid = new HashMap();
/*     */   
/*     */   static void init()
/*     */   {
/*  35 */     activityToFunid.put(Integer.valueOf(SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_CFG_ID), Integer.valueOf(177));
/*     */     
/*  37 */     activityToFunid.put(Integer.valueOf(SLoginAwardCfgConsts.getInstance().BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID), Integer.valueOf(438));
/*     */     
/*     */ 
/*  40 */     ActivityInterface.registerActivityByLogicType(62, new LoginSignActivityHandler(), false);
/*  41 */     ActivityInterface.registerActivityByLogicType(115, new BeginnerLoginSignHandler(), false);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isFunOpen(long roleid, int activityCfgid, boolean send)
/*     */   {
/*  47 */     Integer funid = (Integer)activityToFunid.get(Integer.valueOf(activityCfgid));
/*  48 */     if (funid == null)
/*     */     {
/*  50 */       GameServer.logger().error(String.format("[loginaward]LoginSignActivityManager.isFunOpen@funid is null|roleid=%d|activity_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */       
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!OpenInterface.getOpenStatus(funid.intValue()))
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     if (OpenInterface.isBanPlay(roleid, funid.intValue()))
/*     */     {
/*  62 */       if (send)
/*     */       {
/*  64 */         OpenInterface.sendBanPlayMsg(roleid, funid.intValue());
/*     */       }
/*  66 */       return false;
/*     */     }
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   static LoginSignInfo initData(String userid, long roleid, int activityCfgid)
/*     */   {
/*  73 */     LoginSignActivityInfos xLoginSignActivityInfos = Role2loginsignactivity.get(Long.valueOf(roleid));
/*  74 */     if (xLoginSignActivityInfos == null)
/*     */     {
/*  76 */       xLoginSignActivityInfos = Pod.newLoginSignActivityInfos();
/*  77 */       Role2loginsignactivity.insert(Long.valueOf(roleid), xLoginSignActivityInfos);
/*     */     }
/*     */     
/*  80 */     LoginSignInfo xLoginSignInfo = (LoginSignInfo)xLoginSignActivityInfos.getLogin_sign_infos().get(Integer.valueOf(activityCfgid));
/*  81 */     if (xLoginSignInfo == null)
/*     */     {
/*  83 */       xLoginSignInfo = Pod.newLoginSignInfo();
/*  84 */       xLoginSignActivityInfos.getLogin_sign_infos().put(Integer.valueOf(activityCfgid), xLoginSignInfo);
/*     */     }
/*     */     
/*  87 */     initXLoginSignInfo(xLoginSignInfo);
/*     */     
/*  89 */     GameServer.logger().info(String.format("[loginaward]LoginSignActivityManager.initData@initdata|userid=%s|roleid=%d|activity_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/*  92 */     return xLoginSignInfo;
/*     */   }
/*     */   
/*     */   private static void initXLoginSignInfo(LoginSignInfo xLoginSignInfo)
/*     */   {
/*  97 */     xLoginSignInfo.setLast_time(0L);
/*  98 */     xLoginSignInfo.setSortid(0);
/*  99 */     xLoginSignInfo.setStart_time(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   static LoginSignInfo getLoginSignActivityInfo(String userid, long roleid, int activityCfgid)
/*     */   {
/* 104 */     if (RoleInterface.getLevel(roleid) < SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT)
/*     */     {
/* 106 */       return null;
/*     */     }
/*     */     
/* 109 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */     {
/* 111 */       return null;
/*     */     }
/*     */     
/* 114 */     return getLoginSignInfo(roleid, activityCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */   static void boxLoginSignInfo(SLoginSignActivityInfo msg, int activityCfgid, LoginSignInfo xLoginSignInfo)
/*     */   {
/* 120 */     LoginSignActivityInfo activityInfo = new LoginSignActivityInfo();
/* 121 */     activityInfo.last_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xLoginSignInfo.getLast_time()));
/* 122 */     activityInfo.sortid = xLoginSignInfo.getSortid();
/* 123 */     activityInfo.start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xLoginSignInfo.getStart_time()));
/* 124 */     msg.activity_infos.put(Integer.valueOf(activityCfgid), activityInfo);
/*     */   }
/*     */   
/*     */   static int getAward(String userid, long roleid, int activityCfgid, int sortid)
/*     */   {
/* 129 */     if (RoleInterface.getLevel(roleid) < SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT)
/*     */     {
/* 131 */       return -4;
/*     */     }
/*     */     
/* 134 */     SLoginSignActivityAwardCfg loginSignActivityAwardCfg = SLoginSignActivityAwardCfg.get(activityCfgid);
/* 135 */     if (loginSignActivityAwardCfg == null)
/*     */     {
/* 137 */       return 1;
/*     */     }
/*     */     
/* 140 */     SLoginSignActivityAwardInfo awardInfo = (SLoginSignActivityAwardInfo)loginSignActivityAwardCfg.awardInfos.get(Integer.valueOf(sortid));
/* 141 */     if (awardInfo == null)
/*     */     {
/* 143 */       return 2;
/*     */     }
/*     */     
/* 146 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */     {
/* 148 */       return -1;
/*     */     }
/*     */     
/* 151 */     LoginSignInfo xLoginSignInfo = getLoginSignInfo(roleid, activityCfgid);
/* 152 */     if (xLoginSignInfo == null)
/*     */     {
/* 154 */       return 4;
/*     */     }
/*     */     
/* 157 */     int curSortid = xLoginSignInfo.getSortid();
/* 158 */     if (sortid <= curSortid)
/*     */     {
/*     */ 
/* 161 */       return -2;
/*     */     }
/*     */     
/* 164 */     if (sortid > curSortid + 1)
/*     */     {
/*     */ 
/* 167 */       return -3;
/*     */     }
/*     */     
/* 170 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 171 */     long lastTime = xLoginSignInfo.getLast_time();
/* 172 */     if (!DateTimeUtils.needDailyReset(lastTime, now, 0, 0))
/*     */     {
/* 174 */       return -3;
/*     */     }
/*     */     
/*     */ 
/* 178 */     xLoginSignInfo.setLast_time(now);
/* 179 */     xLoginSignInfo.setSortid(sortid);
/*     */     
/*     */ 
/* 182 */     int awardCfgid = awardInfo.awardCfgId;
/* 183 */     AwardReason awardReason = new AwardReason(LogReason.LOGIN_AWARD_LOGIN_SIGN, awardCfgid);
/* 184 */     awardReason.setAwardItemBind(true);
/*     */     
/* 186 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleid, true, true, awardReason);
/* 187 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 190 */       return 3;
/*     */     }
/*     */     
/*     */ 
/* 194 */     addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, 1, xLoginSignInfo.getStart_time(), 1);
/*     */     
/* 196 */     return 0;
/*     */   }
/*     */   
/*     */   private static LoginSignInfo getLoginSignInfo(long roleid, int activityCfgid)
/*     */   {
/* 201 */     LoginSignActivityInfos xLoginSignActivityInfos = Role2loginsignactivity.get(Long.valueOf(roleid));
/* 202 */     if (xLoginSignActivityInfos == null)
/*     */     {
/* 204 */       return null;
/*     */     }
/*     */     
/* 207 */     return (LoginSignInfo)xLoginSignActivityInfos.getLogin_sign_infos().get(Integer.valueOf(activityCfgid));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void addTlog(String userId, long roleId, int activityCfgId, int sortid, int awardCfgid, int status, long startTime, int activityType)
/*     */   {
/* 229 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 230 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 232 */     TLogManager.getInstance().addLog(userId, "LoginSignActivityForServer", new Object[] { vGameIp, userId, Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(activityCfgId), Integer.valueOf(sortid), Integer.valueOf(awardCfgid), Integer.valueOf(status), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(startTime)), Integer.valueOf(activityType) });
/*     */   }
/*     */   
/*     */ 
/*     */   static LoginSignInfo getBeginnerLoginSignInfo(String userid, long roleid, int activityCfgid)
/*     */   {
/* 238 */     SBeginnerLoginSignCfg cfg = SBeginnerLoginSignCfg.get(activityCfgid);
/* 239 */     if (cfg == null)
/*     */     {
/* 241 */       GameServer.logger().error(String.format("[loginaward]LoginSignActivityManager.boxBeginnerLoginSignInfo@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 245 */       return null;
/*     */     }
/*     */     
/* 248 */     LoginSignInfo xLoginSignInfo = getLoginSignInfo(roleid, activityCfgid);
/* 249 */     if (xLoginSignInfo == null)
/*     */     {
/* 251 */       int level = RoleInterface.getLevel(roleid);
/* 252 */       if (level == cfg.openLevel)
/*     */       {
/* 254 */         xLoginSignInfo = initData(userid, roleid, activityCfgid);
/*     */       }
/*     */     }
/* 257 */     if (xLoginSignInfo == null)
/*     */     {
/* 259 */       return null;
/*     */     }
/*     */     
/* 262 */     long endDay = getEndTime(xLoginSignInfo.getStart_time(), cfg.duration);
/* 263 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 264 */     if (now >= endDay)
/*     */     {
/* 266 */       return null;
/*     */     }
/*     */     
/* 269 */     return xLoginSignInfo;
/*     */   }
/*     */   
/*     */   static int getBeginnerLoginSignAward(String userid, long roleid, int activityCfgid, int sortid)
/*     */   {
/* 274 */     SLoginSignActivityAwardCfg loginSignActivityAwardCfg = SLoginSignActivityAwardCfg.get(activityCfgid);
/* 275 */     if (loginSignActivityAwardCfg == null)
/*     */     {
/* 277 */       return 1;
/*     */     }
/*     */     
/* 280 */     SLoginSignActivityAwardInfo awardInfo = (SLoginSignActivityAwardInfo)loginSignActivityAwardCfg.awardInfos.get(Integer.valueOf(sortid));
/* 281 */     if (awardInfo == null)
/*     */     {
/* 283 */       return 2;
/*     */     }
/*     */     
/* 286 */     SBeginnerLoginSignCfg cfg = SBeginnerLoginSignCfg.get(activityCfgid);
/* 287 */     if (cfg == null)
/*     */     {
/* 289 */       return 5;
/*     */     }
/*     */     
/* 292 */     LoginSignInfo xLoginSignInfo = getLoginSignInfo(roleid, activityCfgid);
/* 293 */     if (xLoginSignInfo == null)
/*     */     {
/* 295 */       return 4;
/*     */     }
/*     */     
/* 298 */     long endDay = getEndTime(xLoginSignInfo.getStart_time(), cfg.duration);
/* 299 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 300 */     if (now >= endDay)
/*     */     {
/* 302 */       return -5;
/*     */     }
/*     */     
/* 305 */     int curSortid = xLoginSignInfo.getSortid();
/* 306 */     if (sortid <= curSortid)
/*     */     {
/*     */ 
/* 309 */       return -2;
/*     */     }
/*     */     
/* 312 */     if (sortid > curSortid + 1)
/*     */     {
/*     */ 
/* 315 */       return -3;
/*     */     }
/*     */     
/* 318 */     long lastTime = xLoginSignInfo.getLast_time();
/* 319 */     if (!DateTimeUtils.needDailyReset(lastTime, now, 0, 0))
/*     */     {
/* 321 */       return -3;
/*     */     }
/*     */     
/*     */ 
/* 325 */     xLoginSignInfo.setLast_time(now);
/* 326 */     xLoginSignInfo.setSortid(sortid);
/*     */     
/*     */ 
/* 329 */     int awardCfgid = awardInfo.awardCfgId;
/* 330 */     AwardReason awardReason = new AwardReason(LogReason.LOGIN_AWARD_LOGIN_SIGN, awardCfgid);
/* 331 */     awardReason.setAwardItemBind(true);
/*     */     
/* 333 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleid, true, true, awardReason);
/* 334 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 337 */       return 3;
/*     */     }
/*     */     
/*     */ 
/* 341 */     addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, 1, xLoginSignInfo.getStart_time(), 2);
/*     */     
/* 343 */     return 0;
/*     */   }
/*     */   
/*     */   private static long getEndTime(long startTime, int duration)
/*     */   {
/* 348 */     long startDay = DateTimeUtils.getTimeInToday(startTime, 0, 0, 0);
/* 349 */     long endDay = startDay + TimeUnit.DAYS.toMillis(duration);
/* 350 */     return endDay;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\LoginSignActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */