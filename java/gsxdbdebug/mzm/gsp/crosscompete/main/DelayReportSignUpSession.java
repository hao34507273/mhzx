/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DelayReportSignUpSession
/*    */   extends Session
/*    */ {
/*    */   DelayReportSignUpSession(int seconds)
/*    */   {
/* 16 */     super(seconds, -1L);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     ReportSignUpObeserver observer = new ReportSignUpObeserver(60L);
/*    */     
/* 23 */     NoneRealTimeTaskManager.getInstance().addTask(new PReportSignUp(observer));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\DelayReportSignUpSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */