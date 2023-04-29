/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.question.event.PlayerAnswerQuestionProcedure;
/*    */ import mzm.gsp.question.event.QuestionArg;
/*    */ import mzm.gsp.question.main.QuestionInterface;
/*    */ 
/*    */ public class POnPlayerAnswerQuestion extends PlayerAnswerQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     int activityId = QuestionInterface.getZhuXianQiYuanActivityId();
/* 12 */     return LevelGuideManager.finishActivity(((QuestionArg)this.arg).roleId, activityId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnPlayerAnswerQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */