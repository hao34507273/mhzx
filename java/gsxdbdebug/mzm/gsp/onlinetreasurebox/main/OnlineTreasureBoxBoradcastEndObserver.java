/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnlineTreasureBoxBoradcastEndObserver
/*    */   extends Observer
/*    */ {
/*    */   public OnlineTreasureBoxBoradcastEndObserver(long treasureBoxBoradcastEndTime)
/*    */   {
/* 12 */     super(treasureBoxBoradcastEndTime);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 18 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 19 */       return false;
/*    */     }
/* 21 */     new POnStartOnlineTreasureBox().execute();
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureBoxBoradcastEndObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */