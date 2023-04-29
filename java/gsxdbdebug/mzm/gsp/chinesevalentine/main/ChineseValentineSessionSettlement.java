/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class ChineseValentineSessionSettlement extends MilliSession
/*    */ {
/*    */   public ChineseValentineSessionSettlement(long interval, long gameId)
/*    */   {
/* 11 */     super(interval, gameId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 17 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 22 */         long gameId = ChineseValentineSessionSettlement.this.getOwerId();
/* 23 */         int leftRound = ChineseValentineManager.getGameLeftRoundCount(gameId);
/* 24 */         if (leftRound >= 1)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 31 */           ChineseValentineManager.startPrepare(gameId);
/*    */         }
/* 33 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineSessionSettlement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */