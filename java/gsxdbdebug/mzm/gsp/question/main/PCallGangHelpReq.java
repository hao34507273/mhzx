/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.gang.SSyncGangHelp;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.SCallGangHelpRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.EveryDayQuestionAnswerInfo;
/*    */ import xbean.QuestionInfo;
/*    */ import xtable.Role2question;
/*    */ 
/*    */ public class PCallGangHelpReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int questionId;
/*    */   private int pageIdx;
/*    */   
/*    */   public PCallGangHelpReq(long roleId, int questionId, int pageIdx)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.questionId = questionId;
/* 24 */     this.pageIdx = pageIdx;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 32 */       String logStr = String.format("[everydayquestion]PCallGangHelpReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 34 */       EveryDayQuestionManager.getInstance().logger.info(logStr);
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     QuestionInfo xQuestionInfo = Role2question.get(Long.valueOf(this.roleId));
/* 39 */     EveryDayQuestionAnswerInfo xEveryDayInfo = xQuestionInfo.getEverydayinfo();
/* 40 */     if (!xEveryDayInfo.getQuestionlist().contains(Integer.valueOf(this.questionId)))
/*    */     {
/* 42 */       String logstr = String.format("[everydayquestion]PCallGangHelpReq.processImp@call gang help questionid error|roleid=%d|questionid=%d|pageindex=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionId), Integer.valueOf(this.pageIdx) });
/*    */       
/*    */ 
/* 45 */       EveryDayQuestionManager.getInstance().logger.error(logstr);
/*    */       
/* 47 */       return false;
/*    */     }
/* 49 */     int num = xEveryDayInfo.getUsehelpnum();
/* 50 */     if (num >= EveryDayQuestionManager.getInstance().getUseHelpLimit())
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     xEveryDayInfo.setUsehelpnum(num + 1);
/* 55 */     SCallGangHelpRes res = new SCallGangHelpRes();
/* 56 */     res.usecount = xEveryDayInfo.getUsehelpnum();
/* 57 */     OnlineManager.getInstance().send(this.roleId, res);
/* 58 */     long gangId = GangInterface.getGangId(this.roleId);
/* 59 */     if (gangId <= 0L)
/*    */     {
/* 61 */       return false;
/*    */     }
/* 63 */     SSyncGangHelp sSyncGangHelp = new SSyncGangHelp();
/* 64 */     sSyncGangHelp.helpertype = 2;
/* 65 */     sSyncGangHelp.paramlong.put(Integer.valueOf(14), Long.valueOf(this.roleId));
/* 66 */     sSyncGangHelp.paramint.put(Integer.valueOf(15), Integer.valueOf(this.questionId));
/* 67 */     sSyncGangHelp.paramint.put(Integer.valueOf(16), Integer.valueOf(this.pageIdx));
/* 68 */     GangInterface.brocastInGang(sSyncGangHelp, gangId);
/* 69 */     QuestionInterface.tlogAskQuestionHelp(this.roleId, this.questionId);
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PCallGangHelpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */