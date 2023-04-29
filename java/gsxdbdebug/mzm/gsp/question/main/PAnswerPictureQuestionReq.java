/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PictureInfo;
/*    */ import xbean.PictureQuestionInfo;
/*    */ import xbean.RolePictureQuestionInfo;
/*    */ 
/*    */ public class PAnswerPictureQuestionReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int answerNum;
/*    */   
/*    */   public PAnswerPictureQuestionReq(long roleId, int answerNum)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.answerNum = answerNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 25 */       String logStr = String.format("[picquestion]PAnswerPictureQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 27 */       PictureQuestionManager.logger.info(logStr);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     RolePictureQuestionInfo xRoleInfo = xtable.Role2picturequestion.get(Long.valueOf(this.roleId));
/* 32 */     if (xRoleInfo == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     long picQuestionid = xRoleInfo.getPicinfoid();
/* 38 */     PictureInfo xPictureInfo = xtable.Picturequestion.get(Long.valueOf(picQuestionid));
/* 39 */     if (xPictureInfo == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     int idx = xPictureInfo.getQuestionidx();
/* 44 */     if (xPictureInfo.getQuestionlist().size() <= idx)
/*    */     {
/* 46 */       String logStr = String.format("[picquestion]PAnswerPictureQuestionReq.processImp@question id error|roleid=%d|idx=%d|size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(idx), Integer.valueOf(xPictureInfo.getQuestionlist().size()) });
/*    */       
/*    */ 
/* 49 */       PictureQuestionManager.logger.error(logStr);
/* 50 */       return false;
/*    */     }
/* 52 */     PictureQuestionInfo xPictureQuestionInfo = (PictureQuestionInfo)xPictureInfo.getQuestionlist().get(idx);
/*    */     
/* 54 */     if (xPictureQuestionInfo.getAnswerroleid() != this.roleId)
/*    */     {
/* 56 */       String logStr = String.format("[picquestion]PAnswerPictureQuestionReq.processImp@roleid not same|roleid=%d|answerroleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xPictureQuestionInfo.getAnswerroleid()) });
/*    */       
/*    */ 
/* 59 */       PictureQuestionManager.logger.error(logStr);
/* 60 */       return false;
/*    */     }
/*    */     
/*    */     boolean isRight;
/* 64 */     if (xPictureQuestionInfo.getRightanswer() == this.answerNum)
/*    */     {
/*    */ 
/* 67 */       String logStr = String.format("[picquestion]PAnswerPictureQuestionReq.processImp@Role picture quesrion answer right|roleid=%d|idx=%d|answerNum=%d|size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(idx), Integer.valueOf(this.answerNum), Integer.valueOf(xPictureInfo.getQuestionlist().size()) });
/*    */       
/*    */ 
/* 70 */       PictureQuestionManager.logger.info(logStr);
/*    */       
/* 72 */       xPictureInfo.setRightanswercount(xPictureInfo.getRightanswercount() + 1);
/* 73 */       boolean isRight = true;
/* 74 */       xRoleInfo.setRightnum(xRoleInfo.getRightnum() + 1);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 79 */       String logStr = String.format("[picquestion]PAnswerPictureQuestionReq.processImp@Role picture quesrion answer wrong|roleid=%d|idx=%d|answerNum=%d|rightAnswer=%d|size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(idx), Integer.valueOf(this.answerNum), Integer.valueOf(xPictureQuestionInfo.getRightanswer()), Integer.valueOf(xPictureInfo.getQuestionlist().size()) });
/*    */       
/*    */ 
/* 82 */       PictureQuestionManager.logger.info(logStr);
/* 83 */       isRight = false;
/*    */     }
/* 85 */     xRoleInfo.setTotalnum(xRoleInfo.getTotalnum() + 1);
/* 86 */     xPictureInfo.setQuestionidx(xPictureInfo.getQuestionidx() + 1);
/* 87 */     PictureQuestionManager.getInstance().moveToCurrentQuestion(picQuestionid, xPictureInfo, isRight, this.answerNum);
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PAnswerPictureQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */