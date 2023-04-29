/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
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
/*     */ public class KnockOutTLogManager
/*     */ {
/*     */   public static void tlogKnockOutFightResult(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long corpsId, String corpsName, long opponentCorpsId, String opponentCorpsName, int fightResult)
/*     */   {
/*  19 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  20 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  21 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  22 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/*  24 */     String vGameAppid = "0";
/*  25 */     int PlatID = -1;
/*  26 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  27 */     String vopenid = "0";
/*     */     
/*  29 */     StringBuffer sbLog = new StringBuffer();
/*  30 */     sbLog.append(GameSvrId).append('|');
/*  31 */     sbLog.append(dtEventTime).append('|');
/*  32 */     sbLog.append("0").append('|');
/*  33 */     sbLog.append(-1).append('|');
/*  34 */     sbLog.append(iZoneAreaID).append('|');
/*  35 */     sbLog.append("0").append('|');
/*     */     
/*  37 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  38 */     sbLog.append(activityCfgId).append('|');
/*  39 */     sbLog.append(knockOutType).append('|');
/*  40 */     sbLog.append(fightZoneId).append('|');
/*     */     
/*  42 */     sbLog.append(fightStage).append('|');
/*  43 */     sbLog.append(fightIndexId).append('|');
/*  44 */     sbLog.append(corpsId).append('|');
/*  45 */     sbLog.append(corpsName).append('|');
/*  46 */     sbLog.append(opponentCorpsId).append('|');
/*  47 */     sbLog.append(opponentCorpsName).append('|');
/*  48 */     sbLog.append(fightResult);
/*     */     
/*  50 */     TLogManager.getInstance().addLog("KnockOutFightResultStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogKnockOutRankUp(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long corpsId, int isKnockOut)
/*     */   {
/*  56 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  57 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  58 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  59 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/*  61 */     String vGameAppid = "0";
/*  62 */     int PlatID = -1;
/*  63 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  64 */     String vopenid = "0";
/*     */     
/*  66 */     StringBuffer sbLog = new StringBuffer();
/*  67 */     sbLog.append(GameSvrId).append('|');
/*  68 */     sbLog.append(dtEventTime).append('|');
/*  69 */     sbLog.append("0").append('|');
/*  70 */     sbLog.append(-1).append('|');
/*  71 */     sbLog.append(iZoneAreaID).append('|');
/*  72 */     sbLog.append("0").append('|');
/*     */     
/*  74 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  75 */     sbLog.append(activityCfgId).append('|');
/*  76 */     sbLog.append(knockOutType).append('|');
/*  77 */     sbLog.append(fightZoneId).append('|');
/*     */     
/*  79 */     sbLog.append(fightStage).append('|');
/*  80 */     sbLog.append(fightIndexId).append('|');
/*  81 */     sbLog.append(corpsId).append('|');
/*  82 */     sbLog.append(isKnockOut);
/*     */     
/*  84 */     TLogManager.getInstance().addLog("KnockOutRankUpStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogKnockOutAward(int activityCfgId, int knockOutType, int fightZoneId, long corpsId, int fixAwardId, int mailAwardIndexId)
/*     */   {
/*  90 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  91 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  92 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  93 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/*  95 */     String vGameAppid = "0";
/*  96 */     int PlatID = -1;
/*  97 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  98 */     String vopenid = "0";
/*     */     
/* 100 */     StringBuffer sbLog = new StringBuffer();
/* 101 */     sbLog.append(GameSvrId).append('|');
/* 102 */     sbLog.append(dtEventTime).append('|');
/* 103 */     sbLog.append("0").append('|');
/* 104 */     sbLog.append(-1).append('|');
/* 105 */     sbLog.append(iZoneAreaID).append('|');
/* 106 */     sbLog.append("0").append('|');
/*     */     
/* 108 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 109 */     sbLog.append(activityCfgId).append('|');
/* 110 */     sbLog.append(knockOutType).append('|');
/* 111 */     sbLog.append(fightZoneId).append('|');
/*     */     
/* 113 */     sbLog.append(corpsId).append('|');
/* 114 */     sbLog.append(fixAwardId).append('|');
/* 115 */     sbLog.append(mailAwardIndexId);
/*     */     
/* 117 */     TLogManager.getInstance().addLog("KnockOutAwardStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogAwardKnockOutRole(long roleId, int activityCfgId, int knockoutType, int fightZoneId, long corpsId, int fixAwardId, int mailAwardIndexId)
/*     */   {
/* 126 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 127 */     String userId = RoleInterface.getUserId(roleId);
/*     */     
/* 129 */     StringBuilder sbLog = new StringBuilder();
/* 130 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 131 */     sbLog.append(userId).append('|');
/* 132 */     sbLog.append(roleId).append('|');
/* 133 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 135 */     sbLog.append(activityCfgId).append('|');
/* 136 */     sbLog.append(knockoutType).append('|');
/* 137 */     sbLog.append(fightZoneId).append('|');
/* 138 */     sbLog.append(fixAwardId).append('|');
/* 139 */     sbLog.append(corpsId).append('|');
/* 140 */     sbLog.append(mailAwardIndexId);
/*     */     
/* 142 */     TLogManager.getInstance().addLog(roleId, "KnockOutAwardRoleStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */