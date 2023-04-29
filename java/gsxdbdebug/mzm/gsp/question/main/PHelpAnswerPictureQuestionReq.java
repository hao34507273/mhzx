/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.SHelpAnswerPictureQuestionRes;
/*    */ import mzm.gsp.question.SSyncHelpAnswerPictureQuestion;
/*    */ import mzm.gsp.question.confbean.SPictureQuestionLevelCfg;
/*    */ import xbean.PictureInfo;
/*    */ import xbean.PictureQuestionInfo;
/*    */ import xbean.RolePictureQuestionInfo;
/*    */ import xtable.Role2picturequestion;
/*    */ 
/*    */ public class PHelpAnswerPictureQuestionReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int answerNum;
/*    */   private int questionId;
/*    */   
/*    */   public PHelpAnswerPictureQuestionReq(long roleId, int answerNum, int questionId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.answerNum = answerNum;
/* 23 */     this.questionId = questionId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 31 */       String logStr = String.format("[picquestion]PHelpAnswerPictureQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/*    */ 
/* 34 */       PictureQuestionManager.logger.info(logStr);
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     RolePictureQuestionInfo xRoleQuestionInfo = Role2picturequestion.get(Long.valueOf(this.roleId));
/* 39 */     if (xRoleQuestionInfo == null)
/* 40 */       return false;
/* 41 */     long picId = xRoleQuestionInfo.getPicinfoid();
/* 42 */     PictureInfo xPictureInfo = xtable.Picturequestion.get(Long.valueOf(picId));
/* 43 */     if (xPictureInfo == null)
/* 44 */       return false;
/* 45 */     if (xPictureInfo.getQuestionlist().size() <= xPictureInfo.getQuestionidx())
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     PictureQuestionInfo xQuestion = (PictureQuestionInfo)xPictureInfo.getQuestionlist().get(xPictureInfo.getQuestionidx());
/* 50 */     if (xQuestion.getQuestionid() != this.questionId)
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/* 55 */     if ((cfg.helpCount != -1) && (xRoleQuestionInfo.getUsehelpnum() >= cfg.helpCount))
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     xRoleQuestionInfo.setUsehelpnum(xRoleQuestionInfo.getUsehelpnum() + 1);
/* 60 */     SHelpAnswerPictureQuestionRes res = new SHelpAnswerPictureQuestionRes();
/* 61 */     if (cfg.helpCount == -1)
/*    */     {
/* 63 */       res.remainhelpercount = -1;
/*    */     }
/*    */     else
/*    */     {
/* 67 */       res.remainhelpercount = (cfg.helpCount - xRoleQuestionInfo.getUsehelpnum());
/*    */     }
/* 69 */     OnlineManager.getInstance().send(this.roleId, res);
/* 70 */     SSyncHelpAnswerPictureQuestion sSyncHelpAnswerPictureQuestion = new SSyncHelpAnswerPictureQuestion();
/* 71 */     sSyncHelpAnswerPictureQuestion.answer = this.answerNum;
/* 72 */     sSyncHelpAnswerPictureQuestion.answerproviderid = this.roleId;
/* 73 */     sSyncHelpAnswerPictureQuestion.questionitemid = this.questionId;
/* 74 */     OnlineManager.getInstance().sendMulti(sSyncHelpAnswerPictureQuestion, xPictureInfo.getRoleidlist());
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PHelpAnswerPictureQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */