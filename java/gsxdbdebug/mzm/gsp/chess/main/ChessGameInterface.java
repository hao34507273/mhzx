/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import xtable.Role2chessgameinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChessGameInterface
/*    */ {
/*    */   public static void startChessGame(List<Long> roleIds, int chessGameCfgId, IChessGameContext context)
/*    */   {
/* 16 */     ChessGameManager.startChessGame(roleIds, chessGameCfgId, context);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isInChessGame(Long roleId)
/*    */   {
/* 27 */     if (null == Role2chessgameinfo.get(roleId))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessGameInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */