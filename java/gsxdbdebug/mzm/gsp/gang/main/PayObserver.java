/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PayObserver
/*    */   extends DateObserver
/*    */ {
/*    */   PayObserver(int timeCommonCfgId)
/*    */   {
/* 14 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 19 */     NoneRealTimeTaskManager.getInstance().addTask(new PPayAllGangs());
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */