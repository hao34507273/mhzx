/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrossBattleOwnTLogManager
/*     */ {
/*     */   public static final int ACTION_REGISTER = 1;
/*     */   public static final int ACTION_UNREGISTER = 2;
/*     */   public static final int ACTION_VOTE = 3;
/*     */   public static final int ACTION_CANVASS = 4;
/*     */   public static final int ACTION_REPORT = 5;
/*     */   public static final int ACTION_CLEAR = 6;
/*     */   public static final int REASON_PLAYER_OPERATE = 1;
/*     */   public static final int REASON_CORPS_MEMBER_NUM_DISSATISFIED = 2;
/*     */   
/*     */   static void addRegisterStageTLog(long roleid, int activityCfgid, int action, int reason, long corpsid)
/*     */   {
/*  30 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  31 */     String userid = RoleInterface.getUserId(roleid);
/*  32 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  33 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(action), Integer.valueOf(reason), Long.valueOf(corpsid) });
/*     */     
/*  35 */     TLogManager.getInstance().addLog(roleid, "RegisterStageInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void addVoteStageTLog(long roleid, int activityCfgid, int action, int reason, long targetCorpsid, int VoteNum)
/*     */   {
/*  41 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  42 */     String userid = RoleInterface.getUserId(roleid);
/*  43 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  44 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(action), Integer.valueOf(reason), Long.valueOf(targetCorpsid), Integer.valueOf(VoteNum) });
/*     */     
/*  46 */     TLogManager.getInstance().addLog(roleid, "VoteStageInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void addRoundRobinFightStateTLog(int activityCfgid, int roundIndex, long corpsAid, long corpsBid, int preFightState, int currentFightState)
/*     */   {
/*  52 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  53 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  54 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  55 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*  56 */     String vGameAppid = "0";
/*  57 */     int PlatID = -1;
/*  58 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  59 */     String vopenid = "0";
/*     */     
/*  61 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/*  63 */     String logStr = String.format("%s|%s|%s|%d|%d|%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", vGameIP, Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(preFightState), Integer.valueOf(currentFightState) });
/*     */     
/*  65 */     TLogManager.getInstance().addLog("RoundRobinFightStateInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */   static void addReportOwnResultTLog(int activityCfgid, int action, List<Long> corpsList)
/*     */   {
/*  70 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  71 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  72 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  73 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*  74 */     String vGameAppid = "0";
/*  75 */     int PlatID = -1;
/*  76 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  77 */     String vopenid = "0";
/*     */     
/*  79 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  80 */     String logStr = String.format("%s|%s|%s|%d|%d|%s|%s|%d|%d|%s", new Object[] { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", vGameIP, Integer.valueOf(activityCfgid), Integer.valueOf(action), listToString(corpsList) });
/*     */     
/*  82 */     TLogManager.getInstance().addLog("ReportOwnResultInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void addRestartRoundRobinRoundTLog(int activityCfgid, int roundIndex, int restartLevel, long timestamp)
/*     */   {
/*  88 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  89 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  90 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  91 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*  92 */     String vGameAppid = "0";
/*  93 */     int PlatID = -1;
/*  94 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  95 */     String vopenid = "0";
/*     */     
/*  97 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/*  99 */     String logStr = String.format("%s|%s|%s|%d|%d|%s|%s|%d|%d|%d|%d|", new Object[] { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", vGameIP, Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Integer.valueOf(restartLevel), Long.valueOf(timestamp) });
/*     */     
/* 101 */     TLogManager.getInstance().addLog("RestartRoundRobinRoundInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void addVoteStagePromotionTLog(int activityCfgid, List<Long> directPromotionCorpsList, List<Long> roundRobinCorpsList)
/*     */   {
/* 107 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 108 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 109 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 110 */     String dtEventTime = sdf.format(Long.valueOf(time));
/* 111 */     String vGameAppid = "0";
/* 112 */     int PlatID = -1;
/* 113 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 114 */     String vopenid = "0";
/*     */     
/* 116 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 117 */     String logStr = String.format("%s|%s|%s|%d|%d|%s|%s|%d|%s|%s", new Object[] { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", vGameIP, Integer.valueOf(activityCfgid), listToString(directPromotionCorpsList), listToString(roundRobinCorpsList) });
/*     */     
/* 119 */     TLogManager.getInstance().addLog("VoteStagePromotionInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */   static void addRegisterRoleListTLog(int activityCfgid, long corpsid, List<Long> roleList)
/*     */   {
/* 124 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 125 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 126 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 127 */     String dtEventTime = sdf.format(Long.valueOf(time));
/* 128 */     String vGameAppid = "0";
/* 129 */     int PlatID = -1;
/* 130 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 131 */     String vopenid = "0";
/*     */     
/* 133 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 134 */     String logStr = String.format("%s|%s|%s|%d|%d|%s|%s|%d|%d|%s", new Object[] { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", vGameIP, Integer.valueOf(activityCfgid), Long.valueOf(corpsid), listToString(roleList) });
/*     */     
/* 136 */     TLogManager.getInstance().addLog("RegisterRoleListInCrossBattleForServer", logStr);
/*     */   }
/*     */   
/*     */   private static String listToString(List<Long> list)
/*     */   {
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append("list@");
/* 143 */     for (Iterator i$ = list.iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/* 145 */       sb.append(corpsid).append(",");
/*     */     }
/* 147 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleOwnTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */