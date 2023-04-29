/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WorldQuestionBean;
/*    */ 
/*    */ 
/*    */ public class PGM_ClearOwnQuestions
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     WorldQuestionBean xWQBean = WorldQuestion.getInstance().getWorldQuestionBean(true);
/* 15 */     if (xWQBean == null) {
/* 16 */       return false;
/*    */     }
/* 18 */     xWQBean.getOldquestionids().clear();
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PGM_ClearOwnQuestions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */