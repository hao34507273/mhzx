/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnlineTreasureBoxEndObserver
/*    */   extends Observer
/*    */ {
/*    */   public OnlineTreasureBoxEndObserver(long treasureBoxEndTime)
/*    */   {
/* 12 */     super(treasureBoxEndTime);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 18 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 19 */       return false;
/*    */     }
/* 21 */     new POnEndOnlineTreasureBox().execute();
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureBoxEndObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */