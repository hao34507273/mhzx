/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_StopPic
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private boolean issuccess;
/*    */   
/*    */   public PGM_StopPic(long roleId, int issuc)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.issuccess = (issuc == 1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     QuestionInterface.stopPictureQuestion(this.roleId, this.issuccess);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGM_StopPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */