/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.question.event.PlayerFinishActivityProcedure;
/*    */ import mzm.gsp.question.event.QuestionArg;
/*    */ import xbean.EveryDayQuestionAnswerInfo;
/*    */ import xbean.QuestionInfo;
/*    */ import xtable.Role2question;
/*    */ 
/*    */ public class POnPlayerFinishActivity extends PlayerFinishActivityProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleId = ((QuestionArg)this.arg).roleId;
/* 14 */     if (mzm.gsp.idip.main.IdipManager.isZeroProfit(roleId))
/*    */     {
/* 16 */       String logstr = String.format("[everydayquestion]POnPlayerFinishActivity.processImpd@role is zero ptofit|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*    */       
/* 18 */       EveryDayQuestionManager.getInstance().logger.info(logstr);
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 23 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 25 */     QuestionInfo xQuestionInfo = Role2question.get(Long.valueOf(roleId));
/* 26 */     EveryDayQuestionAnswerInfo xEveryDayInfo = xQuestionInfo.getEverydayinfo();
/* 27 */     if (EveryDayQuestionManager.getInstance().isRightRateCanGetExtraReward(xEveryDayInfo.getRightnum()))
/*    */     {
/* 29 */       EveryDayQuestionManager.getInstance().awardExtraReward(userId, roleId);
/*    */     }
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\POnPlayerFinishActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */