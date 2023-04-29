/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PNoticeAllSession
/*    */   extends Session
/*    */ {
/*    */   public PNoticeAllSession(long interval)
/*    */   {
/* 13 */     super(interval, -1L);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 18 */     new PNoticeAll().execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PNoticeAllSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */