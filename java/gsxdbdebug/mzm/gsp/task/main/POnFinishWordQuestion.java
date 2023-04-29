/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.question.event.FinishWordQuestionProcedure;
/*    */ import mzm.gsp.question.event.WordQuestionArg;
/*    */ import mzm.gsp.task.conParamObj.QuestionContext;
/*    */ import mzm.gsp.task.conParamObj.QuestionParamObj;
/*    */ 
/*    */ public class POnFinishWordQuestion extends FinishWordQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Object context = ((WordQuestionArg)this.arg).attachObject;
/* 14 */     if (!(context instanceof QuestionContext))
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     QuestionParamObj obj = new QuestionParamObj(((WordQuestionArg)this.arg).roleList, ((WordQuestionArg)this.arg).isPass, ((WordQuestionArg)this.arg).rightNumMap, ((WordQuestionArg)this.arg).questionNum, ((WordQuestionArg)this.arg).attachObject);
/*    */     
/* 20 */     for (Iterator i$ = ((WordQuestionArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 22 */       TaskInterface.updateTaskCondition(roleId, 19, obj);
/*    */     }
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnFinishWordQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */