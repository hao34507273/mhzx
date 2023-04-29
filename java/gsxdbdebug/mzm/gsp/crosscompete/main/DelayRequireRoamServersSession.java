/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class DelayRequireRoamServersSession extends Session
/*    */ {
/*    */   private final boolean firstTime;
/*    */   
/*    */   DelayRequireRoamServersSession(int seconds, boolean firstTime)
/*    */   {
/* 12 */     super(seconds, -1L);
/* 13 */     this.firstTime = firstTime;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 18 */     RequireRoamServersObserver observer = new RequireRoamServersObserver(this.firstTime, 60L);
/*    */     
/* 20 */     NoneRealTimeTaskManager.getInstance().addTask(new PRequireRoamServers(this.firstTime, observer));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\DelayRequireRoamServersSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */