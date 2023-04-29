/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ 
/*    */ public class ChineseValentineSessionCommand
/*    */   extends MilliSession
/*    */ {
/*    */   public ChineseValentineSessionCommand(long interval, long gameId)
/*    */   {
/* 10 */     super(interval, gameId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 16 */     long gameId = getOwerId();
/* 17 */     ChineseValentineManager.startSettlement(gameId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineSessionCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */