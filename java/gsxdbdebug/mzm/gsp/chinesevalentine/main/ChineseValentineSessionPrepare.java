/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ 
/*    */ public class ChineseValentineSessionPrepare
/*    */   extends MilliSession
/*    */ {
/*    */   final long gameId;
/*    */   
/*    */   public ChineseValentineSessionPrepare(long interval, long gameId)
/*    */   {
/* 12 */     super(interval, gameId);
/* 13 */     this.gameId = gameId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     ChineseValentineManager.startCommand(this.gameId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineSessionPrepare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */