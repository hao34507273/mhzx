/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import java.util.List;
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
/*    */ 
/*    */ class ChessGameTLogManager
/*    */ {
/*    */   static final String TLOG_CHESS_GAME_STARTED = "ChessGameStartedLog";
/*    */   static final String TLOG_CHESS_GAME_FINISHED = "ChessGameFinishedLog";
/*    */   
/*    */   public static void tlogChessGameStart(long roleId, List<Long> memberIds, int chessGameCfgId)
/*    */   {
/* 23 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 24 */     String userid = RoleInterface.getUserId(roleId);
/* 25 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 27 */     String logStr = String.format("%s|%s|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), memberIds.toString(), Integer.valueOf(chessGameCfgId) });
/*    */     
/* 29 */     TLogManager.getInstance().addLog(roleId, "ChessGameStartedLog", logStr);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void tlogChessGameFinished(long roleId, List<Long> memberIds, int chessGameCfgId, int round, int result, int reason)
/*    */   {
/* 45 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 46 */     String userid = RoleInterface.getUserId(roleId);
/* 47 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 49 */     String logStr = String.format("%s|%s|%d|%d|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), memberIds.toString(), Integer.valueOf(chessGameCfgId), Integer.valueOf(round), Integer.valueOf(result), Integer.valueOf(reason) });
/*    */     
/* 51 */     TLogManager.getInstance().addLog(roleId, "ChessGameFinishedLog", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessGameTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */