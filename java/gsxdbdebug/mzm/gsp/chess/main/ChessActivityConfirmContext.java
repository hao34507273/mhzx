/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ 
/*    */ public class ChessActivityConfirmContext implements TeamConfirmContext
/*    */ {
/*    */   private final int activityCfgId;
/*    */   private final int chessGameCfgId;
/*    */   
/*    */   public ChessActivityConfirmContext(int activityCfgId, int chessGameCfgId)
/*    */   {
/* 12 */     this.activityCfgId = activityCfgId;
/* 13 */     this.chessGameCfgId = chessGameCfgId;
/*    */   }
/*    */   
/*    */   public int getChessGameCfgId()
/*    */   {
/* 18 */     return this.chessGameCfgId;
/*    */   }
/*    */   
/*    */   public int getActivityCfgId()
/*    */   {
/* 23 */     return this.activityCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessActivityConfirmContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */