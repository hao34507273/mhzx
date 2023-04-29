/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RequireRoamServersObserver
/*    */   extends Observer
/*    */ {
/*    */   private boolean firstTime;
/*    */   
/*    */   RequireRoamServersObserver(boolean firstTime, long seconds)
/*    */   {
/* 16 */     super(seconds);
/* 17 */     this.firstTime = firstTime;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 22 */     NoneRealTimeTaskManager.getInstance().addTask(new PRequireRoamServers(this.firstTime, this));
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\RequireRoamServersObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */