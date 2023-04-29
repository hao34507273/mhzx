/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
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
/*     */ public class BackGameActivityTlogManager
/*     */ {
/*     */   static void addJoinBackGameActivityTlog(long roleId, int activityId, int onlineHour, long lastLoginTime)
/*     */   {
/*  22 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  23 */     String userid = RoleInterface.getUserId(roleId);
/*  24 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  25 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(onlineHour), Long.valueOf(lastLoginTime) });
/*     */     
/*  27 */     TLogManager.getInstance().addLog(roleId, "JoinBackGameActivity", logStr);
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
/*     */   static void addBackGameActivitySignTlog(long roleId, int activityId, long joinActivityTime, int signIndex)
/*     */   {
/*  41 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  42 */     String userid = RoleInterface.getUserId(roleId);
/*  43 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  44 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime), Integer.valueOf(signIndex) });
/*     */     
/*  46 */     TLogManager.getInstance().addLog(roleId, "BackGameActivitySign", logStr);
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
/*     */   static void addBackGameActivityPointAwardGetTlog(long roleId, int activityId, long joinActivityTime, int backGamePoint, int dayIndex, int awardIndex)
/*     */   {
/*  61 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  62 */     String userid = RoleInterface.getUserId(roleId);
/*  63 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  64 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime), Integer.valueOf(awardIndex), Integer.valueOf(backGamePoint), Integer.valueOf(dayIndex) });
/*     */     
/*  66 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityPointAwardGet", logStr);
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
/*     */   static void addBackGameActivityExpAwardGetTlog(long roleId, int activityId, long joinActivityTime, int awardIndex, int loginDay)
/*     */   {
/*  81 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  82 */     String userid = RoleInterface.getUserId(roleId);
/*  83 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  84 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime), Integer.valueOf(awardIndex), Integer.valueOf(loginDay) });
/*     */     
/*  86 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityExpAwardGet", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addBackGameActivityExpTaskAcceptTlog(long roleId, int activityId, long joinActivityTime)
/*     */   {
/*  98 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  99 */     String userid = RoleInterface.getUserId(roleId);
/* 100 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 101 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime) });
/* 102 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityExpTaskAccept", logStr);
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
/*     */   static void addBackGameActivityExpTaskFinishTlog(long roleId, int activityId, long joinActivityTime, int graphId, int taskId)
/*     */   {
/* 117 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 118 */     String userid = RoleInterface.getUserId(roleId);
/* 119 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 120 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime), Integer.valueOf(graphId), Integer.valueOf(taskId) });
/*     */     
/* 122 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityExpTaskFinish", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addBackGameActivityAwardGetTlog(long roleId, int activityId, long joinActivityTime)
/*     */   {
/* 134 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 135 */     String userid = RoleInterface.getUserId(roleId);
/* 136 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 137 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime) });
/* 138 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityAwardGet", logStr);
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
/*     */   static void addBackGameActivityGiftBuyTlog(long roleId, int activityId, long joinActivityTime, int giftItemCfgId, int buyCount)
/*     */   {
/* 153 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 154 */     String userid = RoleInterface.getUserId(roleId);
/* 155 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 156 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(joinActivityTime), Integer.valueOf(giftItemCfgId), Integer.valueOf(buyCount) });
/*     */     
/* 158 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityGiftBuy", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void addBackGameActivityRechargeTLog(long roleId, int activityId, long initRechargeCount, long beforeRechargeCount, long afterRechargeCount, Map<Integer, Integer> beforeManekiTokenCfgId2count, Map<Integer, Integer> afterManekiTokenCfgId2count)
/*     */   {
/* 165 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 166 */     String userid = RoleInterface.getUserId(roleId);
/* 167 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 169 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%s|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(initRechargeCount), Long.valueOf(beforeRechargeCount), Long.valueOf(afterRechargeCount), beforeManekiTokenCfgId2count.toString(), afterManekiTokenCfgId2count.toString() });
/*     */     
/*     */ 
/* 172 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityRechargeLog", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void addBackGameActivityUseManekiTokenTLog(long roleId, int activityId, Map<Integer, Integer> beforeManekiTokenCfgId2count, Map<Integer, Integer> afterManekiTokenCfgId2count)
/*     */   {
/* 178 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 179 */     String userid = RoleInterface.getUserId(roleId);
/* 180 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 182 */     String logStr = String.format("%s|%s|%d|%d|%d|%s|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), beforeManekiTokenCfgId2count.toString(), afterManekiTokenCfgId2count.toString() });
/*     */     
/* 184 */     TLogManager.getInstance().addLog(roleId, "BackGameActivityUseManekiTokenLog", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\BackGameActivityTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */