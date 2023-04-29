/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ 
/*    */ 
/*    */ public class OnlineTreasureBoxStartObserver
/*    */   extends DateObserver
/*    */ {
/*    */   private int treasureBoxRate;
/*    */   
/*    */   public OnlineTreasureBoxStartObserver(int treasureBoxTimeCfgId, int treasureBoxRate)
/*    */   {
/* 13 */     super(treasureBoxTimeCfgId);
/* 14 */     this.treasureBoxRate = treasureBoxRate;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 20 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     new POnlineTreasureBoxTimeOut(this.treasureBoxRate).execute();
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureBoxStartObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */