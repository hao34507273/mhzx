/*    */ package mzm.gsp.question.session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CheckAnswerResultEnum
/*    */ {
/* 11 */   RIGHT(1), 
/* 12 */   WRONG(2), 
/* 13 */   ARG_NOT_MATCH(3), 
/* 14 */   INVALID_SESSION_ID(4);
/*    */   
/*    */   public final int value;
/*    */   
/*    */   private CheckAnswerResultEnum(int value) {
/* 19 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\session\CheckAnswerResultEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */