/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ 
/*    */ public class QuestionArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final boolean isRight;
/*    */   
/*    */   public final int activityCount;
/*    */   
/*    */   public QuestionArg(long roleId, boolean isRight, int activityCount)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.isRight = isRight;
/* 16 */     this.activityCount = activityCount;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\QuestionArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */