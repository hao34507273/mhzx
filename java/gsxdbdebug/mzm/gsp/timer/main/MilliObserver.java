/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MilliObserver
/*    */   extends BaseMilliObserver
/*    */ {
/*    */   public MilliObserver(long intervalMilliSeconds)
/*    */   {
/* 12 */     super(intervalMilliSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public final void stopTimer()
/*    */   {
/* 18 */     super.stopTimer();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\MilliObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */