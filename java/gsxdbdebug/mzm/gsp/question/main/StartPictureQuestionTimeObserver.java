/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Picturequestion;
/*    */ 
/*    */ 
/*    */ public class StartPictureQuestionTimeObserver
/*    */   extends Session
/*    */ {
/*    */   private long questionid;
/*    */   
/*    */   public StartPictureQuestionTimeObserver(long interval, long questionid)
/*    */   {
/* 15 */     super(interval, questionid);
/* 16 */     this.questionid = questionid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 23 */     new StartPictureQuestionTimeOutPro(this.questionid).execute();
/*    */   }
/*    */   
/*    */   private static class StartPictureQuestionTimeOutPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long questionid;
/*    */     
/*    */     public StartPictureQuestionTimeOutPro(long questionid)
/*    */     {
/* 33 */       this.questionid = questionid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 39 */       Integer state = Picturequestion.selectState(Long.valueOf(this.questionid));
/* 40 */       if ((state == null) || (state.intValue() != 0))
/*    */       {
/* 42 */         return false;
/*    */       }
/* 44 */       QuestionInterface.startPictureQuestion(this.questionid);
/* 45 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\StartPictureQuestionTimeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */