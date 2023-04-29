/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2chessgameinfo;
/*    */ 
/*    */ public class PGM_EndChess
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int result;
/*    */   
/*    */   public PGM_EndChess(long roleId, int result)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.result = result;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */   {
/* 23 */     if ((this.result != 1) && (this.result != 2) && (this.result != 3))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.roleId, "参数为 1 获胜，2 失败，3 平局");
/* 26 */       return false;
/*    */     }
/* 28 */     if (!OpenInterface.getOpenStatus(396))
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleId, "功能开关未打开");
/* 31 */       return false;
/*    */     }
/* 33 */     Long chessGameId = Role2chessgameinfo.get(Long.valueOf(this.roleId));
/* 34 */     if (null == chessGameId)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有在游戏中");
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     ChessGameManager.chessGameFinishByGM(this.roleId, chessGameId.longValue());
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\PGM_EndChess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */