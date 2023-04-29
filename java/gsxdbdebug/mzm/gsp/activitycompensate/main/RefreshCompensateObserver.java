/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class RefreshCompensateObserver extends mzm.gsp.timer.main.DateObserver
/*    */ {
/*    */   public RefreshCompensateObserver(int timeCommonCfgId)
/*    */   {
/*  9 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 14 */     NoneRealTimeTaskManager.getInstance().addTask(new RRefreshOnlineCompensates());
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\RefreshCompensateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */