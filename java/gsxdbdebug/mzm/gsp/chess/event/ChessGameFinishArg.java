/*    */ package mzm.gsp.chess.event;
/*    */ 
/*    */ import mzm.gsp.chess.main.IChessGameContext;
/*    */ 
/*    */ 
/*    */ public class ChessGameFinishArg
/*    */ {
/*    */   public final int result;
/*    */   public final int reason;
/*    */   public final long roleIdA;
/*    */   public final long roleIdB;
/*    */   public final IChessGameContext context;
/*    */   
/*    */   public ChessGameFinishArg(int result, int reason, long roleIdA, long roleIdB, IChessGameContext context)
/*    */   {
/* 16 */     this.result = result;
/* 17 */     this.reason = reason;
/* 18 */     this.roleIdA = roleIdA;
/* 19 */     this.roleIdB = roleIdB;
/* 20 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\event\ChessGameFinishArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */