/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POfferQuestionSession
/*    */   extends Session
/*    */ {
/*    */   public POfferQuestionSession(long intervalSeconds)
/*    */   {
/* 13 */     super(intervalSeconds, -1L);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 18 */     new POfferQuestion().execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\POfferQuestionSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */