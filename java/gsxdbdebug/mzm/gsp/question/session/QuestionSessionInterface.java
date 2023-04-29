/*    */ package mzm.gsp.question.session;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.question.main.QuestionTypeEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuestionSessionInterface
/*    */ {
/*    */   public static long createQuestionSession(long ownerid, QuestionTypeEnum questionType, int questionid, int pageIndex, int answerNum, int rightAnswerIndex)
/*    */   {
/* 34 */     return QuestionSessionManager.getInstance().createQuestionSession(ownerid, questionType, questionid, pageIndex, answerNum, rightAnswerIndex);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Integer> getAnswerRandomSequence(long sessionid)
/*    */   {
/* 48 */     return QuestionSessionManager.getInstance().getAnswerRandomSequence(sessionid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static CheckAnswerResultEnum checkAnswer(long sessionid, long ownerid, QuestionTypeEnum questionType, int questionid, int pageIndex, int answerIndex)
/*    */   {
/* 72 */     return QuestionSessionManager.getInstance().checkAnswer(sessionid, ownerid, questionType, questionid, pageIndex, answerIndex);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\session\QuestionSessionInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */