/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnlineTreasureRawardBoxObserver
/*    */   extends Observer
/*    */ {
/* 11 */   private int count = 0;
/*    */   
/* 13 */   public OnlineTreasureRawardBoxObserver(long treasureRwardBoxTime, int count) { super(treasureRwardBoxTime);
/* 14 */     this.count = count;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 19 */     if (this.count <= 0) {
/* 20 */       return false;
/*    */     }
/* 22 */     this.count -= 1;
/* 23 */     new PTreasureRawardBox().execute();
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureRawardBoxObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */