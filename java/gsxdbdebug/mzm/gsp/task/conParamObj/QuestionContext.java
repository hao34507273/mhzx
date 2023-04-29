/*    */ package mzm.gsp.task.conParamObj;
/*    */ 
/*    */ public class QuestionContext
/*    */ {
/*    */   private final int taskId;
/*    */   private final int questionLibId;
/*    */   
/*    */   public QuestionContext(int taskId, int questionLibId)
/*    */   {
/* 10 */     this.taskId = taskId;
/* 11 */     this.questionLibId = questionLibId;
/*    */   }
/*    */   
/*    */   public int getTaskId()
/*    */   {
/* 16 */     return this.taskId;
/*    */   }
/*    */   
/*    */   public int getQuestionLibId()
/*    */   {
/* 21 */     return this.questionLibId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\conParamObj\QuestionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */