/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Observer
/*    */   extends BaseObserver
/*    */ {
/*    */   public Observer(long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public final void stopTimer()
/*    */   {
/* 18 */     super.stopTimer();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */