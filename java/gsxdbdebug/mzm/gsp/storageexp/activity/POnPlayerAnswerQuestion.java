/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import mzm.gsp.question.event.PlayerAnswerQuestionProcedure;
/*    */ import mzm.gsp.question.event.QuestionArg;
/*    */ 
/*    */ public class POnPlayerAnswerQuestion extends PlayerAnswerQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     return LostAwardManager.onActivityCountAdd(((QuestionArg)this.arg).roleId, mzm.gsp.question.main.QuestionInterface.getZhuXianQiYuanActivityId(), ((QuestionArg)this.arg).activityCount);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnPlayerAnswerQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */