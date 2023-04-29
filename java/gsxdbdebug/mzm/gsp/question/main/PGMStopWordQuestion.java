/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMStopWordQuestion
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private boolean issueecss;
/*    */   
/*    */   public PGMStopWordQuestion(long roleId, int issuc)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.issueecss = (issuc == 1);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     WordQuestionManager.getInstance().stopQuestion(this.roleId, this.issueecss);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGMStopWordQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */