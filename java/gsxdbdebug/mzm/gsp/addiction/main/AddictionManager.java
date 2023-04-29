/*     */ package mzm.gsp.addiction.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.addiction.SKickOutInfo;
/*     */ import mzm.gsp.addiction.SReportOnlineTimeSuccess;
/*     */ import mzm.gsp.addiction.confbean.SAddictionConsts;
/*     */ import mzm.gsp.addiction.pro.ProManager;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OnlineInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class AddictionManager
/*     */ {
/*  30 */   private static volatile AddictionCfgInfo addictionCfgInfo = null;
/*     */   
/*     */   static void init()
/*     */   {
/*  34 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  36 */       return;
/*     */     }
/*  38 */     configInit();
/*     */   }
/*     */   
/*     */   private static void configInit()
/*     */   {
/*  43 */     if (addictionCfgInfo != null)
/*     */     {
/*  45 */       return;
/*     */     }
/*     */     
/*  48 */     if (!ProManager.queryGameConfig())
/*     */     {
/*  50 */       new QueryGameConfigObserver(TimeUnit.MINUTES.toSeconds(5L));
/*  51 */       GameServer.logger().info("[addiction]AddictionManager.configInit@config init start observer");
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isFunOpen()
/*     */   {
/*  57 */     if (!OpenInterface.getOpenStatus(195))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid, boolean send)
/*     */   {
/*  67 */     if (!OpenInterface.getOpenStatus(195))
/*     */     {
/*  69 */       return false;
/*     */     }
/*  71 */     if (OpenInterface.isBanPlay(roleid, 195))
/*     */     {
/*  73 */       if (send)
/*     */       {
/*  75 */         OpenInterface.sendBanPlayMsg(roleid, 195);
/*     */       }
/*  77 */       return false;
/*     */     }
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   public static void setConfig(AddictionCfgInfo cfgInfo)
/*     */   {
/*  84 */     addictionCfgInfo = cfgInfo;
/*     */   }
/*     */   
/*     */   public static AddictionCfgInfo getConfig()
/*     */   {
/*  89 */     return addictionCfgInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void onFunOpen() {}
/*     */   
/*     */ 
/*     */   static void onFunClose() {}
/*     */   
/*     */ 
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/* 102 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, false);
/*     */   }
/*     */   
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 107 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 108 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 109 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 111 */     StringBuilder logStr = new StringBuilder();
/* 112 */     logStr.append(vGameIp);
/* 113 */     logStr.append("|").append(userid);
/* 114 */     logStr.append("|").append(roleid);
/* 115 */     logStr.append("|").append(roleLevel);
/*     */     
/* 117 */     for (Object colum : logColumns)
/*     */     {
/* 119 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 122 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onFightEnd(Collection<Long> roleids)
/*     */   {
/* 133 */     if (!isFunOpen())
/*     */     {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if ((roleids == null) || (roleids.isEmpty()))
/*     */     {
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     Map<Long, String> role2Userids = new HashMap();
/* 144 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 146 */       role2Userids.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid));
/*     */     }
/*     */     
/*     */ 
/* 150 */     Lockeys.lock(Lockeys.get(User.getTable(), role2Userids.values()));
/* 151 */     Lockeys.lock(Lockeys.get(Basic.getTable(), role2Userids.keySet()));
/*     */     
/* 153 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 154 */     for (Map.Entry<Long, String> entry : role2Userids.entrySet())
/*     */     {
/* 156 */       long roleid = ((Long)entry.getKey()).longValue();
/* 157 */       OnlineInfo xOnlineInfo = xtable.Role2onlineinfo.get(Long.valueOf(roleid));
/* 158 */       if (xOnlineInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 163 */         long lastTime = xOnlineInfo.getLastcalcuatetime();
/* 164 */         if (needDailyReset(lastTime, now))
/*     */         {
/* 166 */           xOnlineInfo.setReport_count(0);
/* 167 */           xOnlineInfo.setPeriod_time(0);
/* 168 */           xOnlineInfo.setSingle_online(0);
/* 169 */           xOnlineInfo.setKickout_type(0);
/* 170 */           xOnlineInfo.setRest_time(0);
/*     */         }
/*     */         
/* 173 */         if (xOnlineInfo.getKickout_type() > 0)
/*     */         {
/* 175 */           String userid = (String)entry.getValue();
/* 176 */           int kickType = xOnlineInfo.getKickout_type();
/* 177 */           forbidUserAndSendMsg(userid, roleid, xOnlineInfo);
/*     */           
/* 179 */           if (kickType == 1)
/*     */           {
/* 181 */             ProManager.reportRemind(userid, roleid, 3, TimeUnit.MILLISECONDS.toSeconds(now));
/*     */           }
/*     */           else
/*     */           {
/* 185 */             ProManager.reportRemind(userid, roleid, 4, TimeUnit.MILLISECONDS.toSeconds(now)); }
/*     */         }
/*     */       }
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */   
/*     */   static boolean needDailyReset(long lastTime, long time)
/*     */   {
/* 194 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SAddictionConsts.getInstance().RESET_TIME_CFG_ID);
/* 195 */     if (timeCommonCfg == null)
/*     */     {
/* 197 */       GameServer.logger().error(String.format("[addiction]AddictionManager.needDailyReset@time common cfg is null|cfgid=%d", new Object[] { Integer.valueOf(SAddictionConsts.getInstance().RESET_TIME_CFG_ID) }));
/*     */       
/*     */ 
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     return DateTimeUtils.needDailyReset(lastTime, time, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*     */   }
/*     */   
/*     */   static long resetTime(long time)
/*     */   {
/* 208 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SAddictionConsts.getInstance().RESET_TIME_CFG_ID);
/* 209 */     if (timeCommonCfg == null)
/*     */     {
/* 211 */       GameServer.logger().error(String.format("[addiction]AddictionManager.needDailyReset@time common cfg is null|cfgid=%d", new Object[] { Integer.valueOf(SAddictionConsts.getInstance().RESET_TIME_CFG_ID) }));
/*     */       
/*     */ 
/* 214 */       return -1L;
/*     */     }
/* 216 */     long resetTime = DateTimeUtils.getDailyResetTime(time, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/* 217 */     if (time == resetTime)
/*     */     {
/* 219 */       return -1L;
/*     */     }
/* 221 */     long nextUpdateTime = resetTime + 86400000L;
/* 222 */     return TimeUnit.MILLISECONDS.toSeconds(nextUpdateTime - time);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void forbidUserAndSendMsg(String userid, long roleid, OnlineInfo xOnlineInfo)
/*     */   {
/* 234 */     int kickoutType = xOnlineInfo.getKickout_type();
/*     */     
/* 236 */     SKickOutInfo msg = new SKickOutInfo();
/* 237 */     msg.identity = xOnlineInfo.getIs_adult();
/* 238 */     msg.kickout_type = kickoutType;
/* 239 */     msg.online_time = xOnlineInfo.getSingle_online();
/* 240 */     msg.reason = 2058;
/* 241 */     msg.rest_time = xOnlineInfo.getRest_time();
/* 242 */     if (kickoutType == 2)
/*     */     {
/* 244 */       msg.total_online_time = xOnlineInfo.getAccumu_time();
/*     */     }
/*     */     
/*     */ 
/* 248 */     OnlineManager.getInstance().sendAtOnce(roleid, msg);
/*     */     
/* 250 */     mzm.gsp.online.main.ForbidInfoManager.forbidUser(userid, xOnlineInfo.getRest_time(), SAddictionConsts.getInstance().FORBID_TIP, 2058, false);
/*     */     
/*     */ 
/*     */ 
/* 254 */     xOnlineInfo.setSingle_online(0);
/* 255 */     xOnlineInfo.setReport_count(0);
/* 256 */     xOnlineInfo.setPeriod_time(0);
/* 257 */     xOnlineInfo.setRest_time(0);
/* 258 */     xOnlineInfo.setKickout_type(0);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void sendReportOnlineTimeSuccess(long roleid, boolean remind, int remindType, int onlineTime, int leftTime)
/*     */   {
/* 264 */     SReportOnlineTimeSuccess rsp = new SReportOnlineTimeSuccess();
/* 265 */     rsp.remind = ((byte)(remind ? 1 : 0));
/* 266 */     rsp.remind_type = remindType;
/* 267 */     rsp.online_time = onlineTime;
/* 268 */     rsp.left_time = leftTime;
/* 269 */     OnlineManager.getInstance().send(roleid, rsp);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\AddictionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */