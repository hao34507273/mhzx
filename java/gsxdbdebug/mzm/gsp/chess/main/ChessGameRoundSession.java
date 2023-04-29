/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ class ChessGameRoundSession extends Session
/*    */ {
/*    */   private final long chessGameId;
/*    */   
/*    */   public ChessGameRoundSession(long interval, long chessGameId)
/*    */   {
/* 13 */     super(interval, chessGameId);
/* 14 */     this.chessGameId = chessGameId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 20 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */       {
/*    */ 
/* 26 */         ChessGameManager.sendNotifyRoundTimeOutToClient(ChessGameRoundSession.this.chessGameId);
/*    */         
/* 28 */         ChessGameManager.onGameRoundEnd(ChessGameRoundSession.this.chessGameId, false, ChessGameManager.OperationType.OTHER);
/*    */         
/* 30 */         String logstr = String.format("[chess]ChessGameRoundSession.onTimeOut@game round end by timeout|chessGameId=%d", new Object[] { Long.valueOf(ChessGameRoundSession.this.chessGameId) });
/*    */         
/* 32 */         ChessGameManager.logger.info(logstr);
/* 33 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessGameRoundSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */