/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.SSyncGangAnswer;
/*    */ import mzm.gsp.question.SSyncQuestionNormalResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.EveryDayQuestionAnswerInfo;
/*    */ import xbean.QuestionInfo;
/*    */ import xtable.Role2question;
/*    */ 
/*    */ public class PGangHelpAnswerReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int questionId;
/*    */   private int pageIdx;
/*    */   private long callerId;
/*    */   private String answerString;
/*    */   
/*    */   public PGangHelpAnswerReq(long roleId, int questionId, int pageIdx, long callerId, String answerString)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.questionId = questionId;
/* 27 */     this.pageIdx = pageIdx;
/* 28 */     this.callerId = callerId;
/* 29 */     this.answerString = answerString;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 37 */       String logStr = String.format("[everydayquestion]PGangHelpAnswerReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 39 */       EveryDayQuestionManager.getInstance().logger.info(logStr);
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     String behelpuserid = RoleInterface.getUserId(this.callerId);
/* 44 */     if ((behelpuserid == null) || ("".equals(behelpuserid)))
/*    */     {
/*    */ 
/* 47 */       String logstr = String.format("[everydayquestion]PGangHelpAnswerReq.processImp@caller roleid error|roleid=%d|callerId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.callerId) });
/*    */       
/*    */ 
/* 50 */       EveryDayQuestionManager.getInstance().logger.error(logstr);
/*    */       
/* 52 */       return false;
/*    */     }
/* 54 */     int behelplevel = RoleInterface.getLevel(this.callerId);
/* 55 */     long gangId = GangInterface.getGangId(this.roleId);
/* 56 */     if (gangId <= 0L)
/*    */     {
/* 58 */       return false;
/*    */     }
/* 60 */     QuestionInfo questionInfo = Role2question.select(Long.valueOf(this.callerId));
/* 61 */     EveryDayQuestionAnswerInfo everyDayQuestionAnswerInfo = questionInfo.getEverydayinfo();
/* 62 */     if (everyDayQuestionAnswerInfo.getCurrentquestionidx() >= everyDayQuestionAnswerInfo.getQuestionlist().size())
/*    */     {
/* 64 */       SSyncQuestionNormalResult result = new SSyncQuestionNormalResult();
/* 65 */       result.result = 0;
/* 66 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 67 */       return false;
/*    */     }
/* 69 */     int questionid = ((Integer)everyDayQuestionAnswerInfo.getQuestionlist().get(everyDayQuestionAnswerInfo.getCurrentquestionidx())).intValue();
/* 70 */     if ((everyDayQuestionAnswerInfo.getCurrentanswerpageidx() != this.pageIdx) || (questionid != this.questionId))
/*    */     {
/* 72 */       SSyncQuestionNormalResult result = new SSyncQuestionNormalResult();
/* 73 */       result.result = 0;
/* 74 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 75 */       return false;
/*    */     }
/* 77 */     SSyncGangAnswer sSyncGangAnswer = new SSyncGangAnswer();
/* 78 */     sSyncGangAnswer.questionid = this.questionId;
/* 79 */     sSyncGangAnswer.pageindex = this.pageIdx;
/* 80 */     sSyncGangAnswer.roleid = this.callerId;
/* 81 */     sSyncGangAnswer.answerroleid = this.roleId;
/* 82 */     sSyncGangAnswer.answerstring = this.answerString;
/*    */     
/* 84 */     GangInterface.brocastInGang(sSyncGangAnswer, gangId);
/* 85 */     QuestionInterface.tlogHelpAnswerQuestion(this.roleId, behelpuserid, this.callerId, behelplevel, questionid);
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGangHelpAnswerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */