/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
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
/*     */ public class TeamMatchLogManager
/*     */ {
/*     */   static final int MATCH_TYPE__TEAM = 1;
/*     */   static final int MATCH_TYPE__SINGLE = 2;
/*     */   private static final String TLOG_TEAMMATCH = "TeamMatch";
/*     */   private static final String TLOG_MEMBERGETMATCH = "MemberGetMatch";
/*     */   private static final String TLOG_CANCEL_MATCH = "CancelMatch";
/*     */   
/*     */   public static boolean addTeamMatchLog(long roleId, int activityId, int index, int matchType, int teamMemberNum)
/*     */   {
/*  32 */     tlogTeamMatch(roleId, activityId, index, matchType, teamMemberNum);
/*     */     
/*  34 */     return true;
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
/*     */   public static void logGetMatch(long roleId, int activityId, int index, long otherId, int matchType, int teamMemberNum)
/*     */   {
/*  49 */     tlogGetMatch(roleId, activityId, index, otherId, matchType, teamMemberNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean zLogTeamMatch(long roleId, int activityId)
/*     */   {
/*  61 */     int platform = RoleInterface.getPlatform(roleId);
/*  62 */     String channel = RoleInterface.getChannel(roleId);
/*  63 */     String mac = RoleInterface.getMac(roleId);
/*  64 */     String userId = RoleInterface.getUserId(roleId);
/*  65 */     int level = RoleInterface.getLevel(roleId);
/*     */     
/*  67 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userId, Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(activityId) });
/*  68 */     LogManager.getInstance().addLog("teammatch", logStr);
/*     */     
/*  70 */     return true;
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
/*     */   public static void tlogTeamMatch(long roleId, int matchCfgId, int index, int matchType, int teamMemberNum)
/*     */   {
/*  84 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  85 */     String userid = RoleInterface.getUserId(roleId);
/*  86 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  88 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(0), Integer.valueOf(matchCfgId), Integer.valueOf(index), Integer.valueOf(matchType), Integer.valueOf(teamMemberNum) });
/*     */     
/*  90 */     TLogManager.getInstance().addLog(roleId, "TeamMatch", logStr);
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
/*     */   public static void tlogGetMatch(long roleId, int activityId, int index, long otherId, int matchType, int teamMemberNum)
/*     */   {
/* 104 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 105 */     String userid = RoleInterface.getUserId(roleId);
/* 106 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 108 */     String otherUserid = RoleInterface.getUserId(otherId);
/* 109 */     int otherlevel = RoleInterface.getLevel(otherId);
/*     */     
/* 111 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(index), otherUserid, Long.valueOf(otherId), Integer.valueOf(otherlevel), Integer.valueOf(matchType), Integer.valueOf(teamMemberNum) });
/*     */     
/* 113 */     TLogManager.getInstance().addLog(roleId, "MemberGetMatch", logStr);
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
/*     */   public static void tlogCancelMatch(long roleId, int matchCfgId, int index, CancelMatchType type, int matchType)
/*     */   {
/* 129 */     if ((type == CancelMatchType.JOIN_TEAM_SUC_CANCEL) || (type == CancelMatchType.TEAM_FULL_SUC_CANCEL))
/*     */     {
/* 131 */       return;
/*     */     }
/*     */     
/* 134 */     switch (matchType)
/*     */     {
/*     */     case 1: 
/* 137 */       matchType = 1;
/* 138 */       break;
/*     */     
/*     */     case 0: 
/* 141 */       matchType = 2;
/* 142 */       break;
/*     */     
/*     */     default: 
/* 145 */       return;
/*     */     }
/*     */     
/* 148 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 149 */     String userid = RoleInterface.getUserId(roleId);
/* 150 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 152 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(matchCfgId), Integer.valueOf(index), Integer.valueOf(matchType), Integer.valueOf(type.value) });
/*     */     
/* 154 */     TLogManager.getInstance().addLog(roleId, "CancelMatch", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\TeamMatchLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */