/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrawAndGuessTLogManager
/*    */ {
/*    */   private static final String TLOG_DRAW_AND_GUESS_STARTED = "DrawAndGuessStartedLog";
/*    */   private static final String TLOG_DRAW_AND_GUESS_FINISHED = "DrawAndGuessFinishedLog";
/*    */   
/*    */   public static void tlogDrawAndGuessStarted(long drawandguessId, long drawerId, int questionCfgIid, int ruleCfgid, List<Long> memberIds)
/*    */   {
/* 34 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 35 */     String userid = RoleInterface.getUserId(drawerId);
/* 36 */     int rolelevel = RoleInterface.getLevel(drawerId);
/* 37 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*    */     
/* 39 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(drawerId), Integer.valueOf(rolelevel), Integer.valueOf(serverLevel), Long.valueOf(drawandguessId), Integer.valueOf(questionCfgIid), Integer.valueOf(ruleCfgid), memberIds.toString() });
/*    */     
/* 41 */     TLogManager.getInstance().addLog(drawerId, "DrawAndGuessStartedLog", logStr);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void tlogDrawAndGuessFinished(long drawandguessId, int questionCfgIid, long drawerId, List<Long> memberIds, List<Long> succMemberIds, Map<Long, Integer> jifenMap)
/*    */   {
/* 54 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 55 */     String userid = RoleInterface.getUserId(drawerId);
/* 56 */     int rolelevel = RoleInterface.getLevel(drawerId);
/* 57 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*    */     
/* 59 */     String jifen = "";
/* 60 */     if (jifenMap != null) {
/* 61 */       jifen = jifenMap.toString();
/*    */     }
/* 63 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%s|%s", new Object[] { vGameIP, userid, Long.valueOf(drawerId), Integer.valueOf(rolelevel), Integer.valueOf(serverLevel), Long.valueOf(drawandguessId), Integer.valueOf(questionCfgIid), memberIds.toString(), succMemberIds.toString(), jifen });
/*    */     
/* 65 */     TLogManager.getInstance().addLog(drawerId, "DrawAndGuessFinishedLog", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */