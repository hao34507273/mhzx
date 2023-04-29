/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PQuestionOverSession
/*    */   extends Session
/*    */ {
/*    */   public PQuestionOverSession(long intervalSeconds)
/*    */   {
/* 13 */     super(intervalSeconds, -1L);
/*    */   }
/*    */   
/*    */   public void onTimeOut()
/*    */   {
/* 18 */     new PQuestionOver().execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PQuestionOverSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */