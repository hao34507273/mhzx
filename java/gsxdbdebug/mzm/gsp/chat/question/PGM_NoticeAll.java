/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_NoticeAll
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int questionId;
/*    */   
/*    */   public PGM_NoticeAll(int questionId)
/*    */   {
/* 15 */     this.questionId = questionId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     return new PNoticeAll(this.questionId).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PGM_NoticeAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */