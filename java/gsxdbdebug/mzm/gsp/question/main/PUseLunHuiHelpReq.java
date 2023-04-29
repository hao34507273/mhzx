/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import xbean.EveryDayQuestionAnswerInfo;
/*    */ import xbean.QuestionInfo;
/*    */ 
/*    */ public final class PUseLunHuiHelpReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PUseLunHuiHelpReq(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 20 */       String logStr = String.format("[everydayquestion]PUseLunHuiHelpReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 22 */       EveryDayQuestionManager.getInstance().logger.info(logStr);
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (!EveryDayQuestionManager.getInstance().isZhuxianQiYuanSwitchOpenForRole(this.roleId))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!EveryDayQuestionManager.getInstance().isActivityStart())
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     QuestionInfo xQuestionInfo = xtable.Role2question.get(Long.valueOf(this.roleId));
/* 35 */     if (xQuestionInfo == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (xQuestionInfo.getEverydayinfo().getUsehelpnum() > EveryDayQuestionManager.getInstance().getUseHelpLimit())
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     xQuestionInfo.getEverydayinfo().setUsehelpnum(xQuestionInfo.getEverydayinfo().getUsehelpnum() + 1);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PUseLunHuiHelpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */