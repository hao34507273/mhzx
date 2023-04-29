/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RedgiftCountDownObserver
/*    */   extends Observer
/*    */ {
/*    */   public RedgiftCountDownObserver(long intervalSeconds)
/*    */   {
/* 15 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     new PsendRedgiftToOnlinetPlayer().execute();
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\RedgiftCountDownObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */