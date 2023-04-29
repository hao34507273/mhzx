/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossFieldTLogManager
/*    */ {
/*    */   public static final int ACTION_BEGIN_MATCH = 1;
/*    */   public static final int ACTION_MATCH_FAIL = 2;
/*    */   public static final int ACTION_MATCH_SUCCESS = 3;
/*    */   public static final int ACTION_CANCEL_MATCH = 4;
/*    */   public static final int ACTION_CANCEL_MATCH_FAIL = 5;
/*    */   public static final int ACTION_CANCEL_MATCH_SUCCESS = 6;
/*    */   public static final int FAIL_REASON_INVALID = -1;
/*    */   public static final int FAIL_REASON_UNKONWN_ERROR = 1;
/*    */   public static final int FAIL_REASON_GEN_TOKEN_FAIL = 2;
/*    */   public static final int FAIL_REASON_DATA_TRANSFOR_FAIL = 3;
/*    */   
/*    */   static void addMatchTLog(long roleid, int action, int activityCfgid, long gameServerContextid, long failReason)
/*    */   {
/* 29 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 30 */     String userid = RoleInterface.getUserId(roleid);
/* 31 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 32 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(action), Integer.valueOf(activityCfgid), Long.valueOf(gameServerContextid), Long.valueOf(failReason) });
/*    */     
/* 34 */     TLogManager.getInstance().addLog(roleid, "SingleCrossFieldMatchForServer", logStr);
/*    */   }
/*    */   
/*    */ 
/*    */   static void addDataBackTLog(long roleid, boolean isActiveLeave, boolean isSeasonValid, int season, int result, int changePoint, boolean isMVP)
/*    */   {
/* 40 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 41 */     String userid = RoleInterface.getUserId(roleid);
/* 42 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 43 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(isActiveLeave ? 1 : 0), Integer.valueOf(season), Integer.valueOf(isSeasonValid ? 1 : 0), Integer.valueOf(result), Integer.valueOf(changePoint), Integer.valueOf(isMVP ? 1 : 0) });
/*    */     
/* 45 */     TLogManager.getInstance().addLog(roleid, "SingleCrossFieldDataBackForServer", logStr);
/*    */   }
/*    */   
/*    */   static void addRankAwardTLog(long roleid, int season, int chartType, int rank)
/*    */   {
/* 50 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 51 */     String userid = RoleInterface.getUserId(roleid);
/* 52 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 53 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(season), Integer.valueOf(chartType), Integer.valueOf(rank) });
/* 54 */     TLogManager.getInstance().addLog(roleid, "SingleCrossFieldRankAwardForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\CrossFieldTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */