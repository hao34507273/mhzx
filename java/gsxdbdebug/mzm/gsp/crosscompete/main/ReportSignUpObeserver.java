/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ReportSignUpObeserver
/*    */   extends Observer
/*    */ {
/*    */   ReportSignUpObeserver(long seconds)
/*    */   {
/* 14 */     super(seconds);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 19 */     NoneRealTimeTaskManager.getInstance().addTask(new PReportSignUp(this));
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\ReportSignUpObeserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */