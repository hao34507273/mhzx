/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*    */ import mzm.gsp.question.event.RoleAnswerOneQYXTQuestionArg;
/*    */ import mzm.gsp.question.event.RoleAnswerOneQYXTQuestionProcedure;
/*    */ 
/*    */ public class POnRoleAnswerOneQYXTQuestion
/*    */   extends RoleAnswerOneQYXTQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((RoleAnswerOneQYXTQuestionArg)this.arg).roleId, 2400, Integer.valueOf(SQYXTQuestionConst.getInstance().ACTIVITY_ID), "POnRoleAnswerOneQYXTQuestion.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleAnswerOneQYXTQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */