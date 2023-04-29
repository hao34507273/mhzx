/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
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
/*     */ public class RoleLogManager
/*     */ {
/*     */   private static final String TLOG_ROLE_EXP_ADD = "PlayerExpAddFlow";
/*     */   private static final String TLOG_ROLE_EXP_CUT = "PlayerExpCutFlow";
/*     */   private static final String ZLOG_ROLE_EXP_ADD = "expget";
/*     */   
/*     */   public static void logRoleExpAdd(long roleId, int beforeLevel, int afterLevel, int expRealAdd, TLogArg arg, int showExp)
/*     */   {
/*  38 */     tLogRoleExpAdd(roleId, beforeLevel, afterLevel, expRealAdd, arg, showExp);
/*     */     
/*  40 */     zLogRoleExpAdd(roleId, beforeLevel, afterLevel, expRealAdd, arg, showExp);
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
/*     */   public static void tLogRoleExpAdd(long roleId, int beforeLevel, int afterLevel, int expRealAdd, TLogArg arg, int showExp)
/*     */   {
/*  55 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  56 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  58 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(beforeLevel), Integer.valueOf(afterLevel), Integer.valueOf(expRealAdd), Integer.valueOf(arg.getLogReason().value), Integer.valueOf(arg.getSubReason()), Integer.valueOf(showExp) });
/*     */     
/*  60 */     TLogManager.getInstance().addLog(roleId, "PlayerExpAddFlow", logStr);
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
/*     */   public static void tLogRoleExpCut(long roleId, int beforeLevel, int beforeExp, int afterLevel, int afterExp, int expRealCut, TLogArg arg)
/*     */   {
/*  74 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  75 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  77 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(beforeLevel), Integer.valueOf(beforeExp), Integer.valueOf(afterLevel), Integer.valueOf(afterExp), Integer.valueOf(expRealCut), Integer.valueOf(arg.getLogReason().value), Integer.valueOf(arg.getSubReason()) });
/*     */     
/*  79 */     TLogManager.getInstance().addLog(roleId, "PlayerExpCutFlow", logStr);
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
/*     */   public static void zLogRoleExpAdd(long roleId, int oldLevel, int newLevel, int expRealAdd, TLogArg arg, int showExp)
/*     */   {
/*  93 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  95 */     int platform = OnlineManager.getInstance().getPlatform(userid);
/*  96 */     String channel = RoleInterface.getChannel(userid);
/*  97 */     String mac = OnlineManager.getInstance().getMac(userid);
/*     */     
/*  99 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleId), Integer.valueOf(newLevel), Integer.valueOf(0), Integer.valueOf(arg.getLogReason().value), Integer.valueOf(expRealAdd), Integer.valueOf(showExp), Integer.valueOf(arg.getSubReason()) });
/*     */     
/* 101 */     LogManager.getInstance().addLog("expget", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */