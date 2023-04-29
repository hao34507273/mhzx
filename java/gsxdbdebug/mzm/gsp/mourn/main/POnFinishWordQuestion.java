/*    */ package mzm.gsp.mourn.main;
/*    */ 
/*    */ import mzm.gsp.question.event.FinishWordQuestionProcedure;
/*    */ import mzm.gsp.question.event.WordQuestionArg;
/*    */ import mzm.gsp.task.conParamObj.QuestionContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnFinishWordQuestion
/*    */   extends FinishWordQuestionProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     Object context = ((WordQuestionArg)this.arg).attachObject;
/* 20 */     if (!(context instanceof QuestionContext))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     QuestionContext taskQuestionContext = (QuestionContext)context;
/* 25 */     if (taskQuestionContext.getQuestionLibId() != 7)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (((WordQuestionArg)this.arg).isPass)
/*    */     {
/* 31 */       return true;
/*    */     }
/* 33 */     MournManager.sendMournNotice(((WordQuestionArg)this.arg).roleList, false, 3, new String[0]);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\POnFinishWordQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */