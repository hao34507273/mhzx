/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*    */ import mzm.gsp.coupledaily.SXinYouLingXiQuestionInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class QuestionIntervaMillObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private final long leaderRoleId;
/*    */   private final long partnerRoleId;
/*    */   private final int nextQuestionCfgId;
/*    */   
/*    */   public QuestionIntervaMillObserver(long leaderRoleId, long partnerRoleId, long intervalMilliSeconds, int nextQuestionCfgId)
/*    */   {
/* 24 */     super(intervalMilliSeconds);
/* 25 */     this.leaderRoleId = leaderRoleId;
/* 26 */     this.partnerRoleId = partnerRoleId;
/* 27 */     this.nextQuestionCfgId = nextQuestionCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 33 */     new PQuestionInterval(this.leaderRoleId, this.partnerRoleId, this.nextQuestionCfgId).execute();
/*    */     
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   private static class PQuestionInterval extends LogicProcedure
/*    */   {
/*    */     private final long leaderRoleId;
/*    */     private final long partnerRoleId;
/*    */     private final int nextQuestionCfgId;
/*    */     
/*    */     public PQuestionInterval(long leaderRoleId, long partnerRoleId, int nextQuestionCfgId)
/*    */     {
/* 46 */       this.leaderRoleId = leaderRoleId;
/* 47 */       this.partnerRoleId = partnerRoleId;
/* 48 */       this.nextQuestionCfgId = nextQuestionCfgId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 54 */       long nextQuestionSessionId = new XinYouLingXiAnswerSession(CoupleDailyActivityConst.getInstance().WAIT_COUPLE_ANSWER_TIME, this.leaderRoleId, this.partnerRoleId, DateTimeUtils.getCurrTimeInMillis()).getSessionId();
/*    */       
/*    */ 
/*    */ 
/* 58 */       SXinYouLingXiQuestionInfo sXinYouLingXiQuestionInfo = new SXinYouLingXiQuestionInfo();
/* 59 */       sXinYouLingXiQuestionInfo.questioncfgid = this.nextQuestionCfgId;
/* 60 */       sXinYouLingXiQuestionInfo.sessionid = nextQuestionSessionId;
/*    */       
/* 62 */       OnlineManager.getInstance().sendMulti(sXinYouLingXiQuestionInfo, Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*    */       
/*    */ 
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\QuestionIntervaMillObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */