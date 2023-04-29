/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import mzm.gsp.question.event.RoleAnswerOneQYXTQuestionArg;
/*    */ import mzm.gsp.question.event.RoleAnswerOneQYXTQuestionProcedure;
/*    */ import mzm.gsp.question.main.QYXTQuestionActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnAnswerOneQYXTQuestion
/*    */   extends RoleAnswerOneQYXTQuestionProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return LostAwardManager.onActivityCountAdd(((RoleAnswerOneQYXTQuestionArg)this.arg).roleId, QYXTQuestionActivity.getQYXTActivityCfgId(), ((RoleAnswerOneQYXTQuestionArg)this.arg).count);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnAnswerOneQYXTQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */