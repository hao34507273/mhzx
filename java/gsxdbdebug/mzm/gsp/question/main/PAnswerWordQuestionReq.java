/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.question.session.CheckAnswerResultEnum;
/*    */ import mzm.gsp.question.session.QuestionSessionInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleWordQuestionInfo;
/*    */ import xbean.WordQuestionInfo;
/*    */ import xtable.Role2wordquestion;
/*    */ 
/*    */ public class PAnswerWordQuestionReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int answerIdx;
/*    */   private int curQuestionId;
/*    */   private long sessionid;
/*    */   
/*    */   public PAnswerWordQuestionReq(long roleId, int answerIdx, int curQuestionId, long sessionid)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.answerIdx = answerIdx;
/* 22 */     this.curQuestionId = curQuestionId;
/* 23 */     this.sessionid = sessionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 31 */       String logStr = String.format("[wordquestion]PAnswerWordQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 33 */       WordQuestionManager.logger.info(logStr);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     Long wordQId = Role2wordquestion.get(Long.valueOf(this.roleId));
/* 38 */     if (wordQId == null)
/*    */     {
/* 40 */       String logStr = String.format("[wordquestion]PAnswerWordQuestionReq.processImp@wordQId is null|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 41 */       WordQuestionManager.logger.error(logStr);
/* 42 */       return false;
/*    */     }
/* 44 */     WordQuestionInfo xWordQuestionInfo = xtable.Wordquestion.get(wordQId);
/* 45 */     if (xWordQuestionInfo == null)
/*    */     {
/* 47 */       String logStr = String.format("[wordquestion]PAnswerWordQuestionReq.processImp@xWordQuestionInfo is null|roleid=%d|wordQId=%d", new Object[] { Long.valueOf(this.roleId), wordQId });
/*    */       
/*    */ 
/* 50 */       WordQuestionManager.logger.error(logStr);
/*    */       
/* 52 */       return false;
/*    */     }
/* 54 */     RoleWordQuestionInfo xRoleInfo = (RoleWordQuestionInfo)xWordQuestionInfo.getRolequestionmap().get(Long.valueOf(this.roleId));
/* 55 */     if (xRoleInfo == null)
/*    */     {
/* 57 */       String logStr = String.format("[wordquestion]PAnswerWordQuestionReq.processImp@xRoleInfo is null|roleid=%d|wordQId=%d", new Object[] { Long.valueOf(this.roleId), wordQId });
/*    */       
/* 59 */       WordQuestionManager.logger.error(logStr);
/*    */       
/* 61 */       return false;
/*    */     }
/* 63 */     int isRight = 0;
/* 64 */     CheckAnswerResultEnum result = QuestionSessionInterface.checkAnswer(this.sessionid, this.roleId, QuestionTypeEnum.WORD, this.curQuestionId, 0, this.answerIdx);
/*    */     
/* 66 */     if ((result == CheckAnswerResultEnum.INVALID_SESSION_ID) || (result == CheckAnswerResultEnum.ARG_NOT_MATCH))
/*    */     {
/* 68 */       return false;
/*    */     }
/* 70 */     if (result == CheckAnswerResultEnum.RIGHT)
/*    */     {
/* 72 */       isRight = 1;
/* 73 */       xRoleInfo.setRightnum(xRoleInfo.getRightnum() + 1);
/*    */     }
/* 75 */     xRoleInfo.setCuridx(xRoleInfo.getCuridx() + 1);
/* 76 */     WordQuestionItemSession session = (WordQuestionItemSession)WordQuestionItemSession.getSession(xRoleInfo.getSessionid());
/* 77 */     if (session != null)
/*    */     {
/* 79 */       session.stopTimer();
/*    */     }
/* 81 */     WordQuestionManager.getInstance().syncAnswerInfo(this.roleId, xWordQuestionInfo, isRight);
/* 82 */     if (xRoleInfo.getCuridx() >= xRoleInfo.getQuestionidlist().size())
/*    */     {
/* 84 */       WordQuestionManager.getInstance().detectedIsEnd(wordQId.longValue(), xWordQuestionInfo);
/*    */     }
/* 86 */     String logStr = String.format("[wordquestion]PAnswerWordQuestionReq.processImp@role answer word question success|roleid=%d|wordQId=%d|isRight=%d|answerIdx=%d", new Object[] { Long.valueOf(this.roleId), wordQId, Integer.valueOf(isRight), Integer.valueOf(this.answerIdx) });
/*    */     
/*    */ 
/* 89 */     WordQuestionManager.logger.info(logStr);
/*    */     
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PAnswerWordQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */