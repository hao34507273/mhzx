/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.question.event.PlayerAnswerQuestionProcedure;
/*    */ import mzm.gsp.question.event.QuestionArg;
/*    */ import mzm.gsp.question.main.QuestionInterface;
/*    */ 
/*    */ public class POnPlayerAnswerQuestion
/*    */   extends PlayerAnswerQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((QuestionArg)this.arg).roleId, 2400, Integer.valueOf(QuestionInterface.getZhuXianQiYuanActivityId()), "POnPlayerAnswerQuestion.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPlayerAnswerQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */