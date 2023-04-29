/*    */ package mzm.gsp.question.session;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
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
/*    */ public class QuestionSession
/*    */ {
/*    */   private final long ownerid;
/*    */   private final QuestionTypeEnum questionType;
/*    */   private final int questionid;
/*    */   private final int pageIndex;
/*    */   private final ArrayList<Integer> answerRandomSequence;
/*    */   private final int rightAnswerIndex;
/*    */   
/*    */   public QuestionSession(long ownerid, QuestionTypeEnum questionType, int questionid, int pageIndex, int answerNum, int rightAnswerIndex)
/*    */   {
/* 27 */     this.ownerid = ownerid;
/* 28 */     this.questionType = questionType;
/* 29 */     this.questionid = questionid;
/* 30 */     this.pageIndex = pageIndex;
/* 31 */     this.answerRandomSequence = getRandomSequence(answerNum);
/* 32 */     this.rightAnswerIndex = rightAnswerIndex;
/*    */   }
/*    */   
/*    */ 
/*    */   CheckAnswerResultEnum checkAnswer(long ownerid, QuestionTypeEnum questionType, int questionid, int pageIndex, int answerIndex)
/*    */   {
/* 38 */     if ((this.ownerid >= 0L) && (this.ownerid != ownerid))
/* 39 */       return CheckAnswerResultEnum.ARG_NOT_MATCH;
/* 40 */     if ((this.questionType != questionType) || (this.questionid != questionid) || (this.pageIndex != pageIndex))
/* 41 */       return CheckAnswerResultEnum.ARG_NOT_MATCH;
/* 42 */     if ((answerIndex < 1) || (answerIndex > this.answerRandomSequence.size()))
/* 43 */       return CheckAnswerResultEnum.WRONG;
/* 44 */     if (((Integer)this.answerRandomSequence.get(answerIndex - 1)).intValue() != this.rightAnswerIndex)
/* 45 */       return CheckAnswerResultEnum.WRONG;
/* 46 */     return CheckAnswerResultEnum.RIGHT;
/*    */   }
/*    */   
/*    */   List<Integer> getAnswerRandomSequence()
/*    */   {
/* 51 */     return this.answerRandomSequence;
/*    */   }
/*    */   
/*    */   private ArrayList<Integer> getRandomSequence(int length)
/*    */   {
/* 56 */     ArrayList<Integer> randomArray = new ArrayList();
/* 57 */     for (int i = 1; i <= length; i++)
/*    */     {
/* 59 */       randomArray.add(Integer.valueOf(i));
/*    */     }
/* 61 */     Collections.shuffle(randomArray);
/* 62 */     return randomArray;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\session\QuestionSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */