/*     */ package mzm.gsp.chat.question;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.SQuestionIsComingNotice;
/*     */ import mzm.gsp.activity.confbean.WorldQuestionConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WorldQuestionBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PNoticeAll
/*     */   extends LogicProcedure
/*     */ {
/*  20 */   private int questionId = -1;
/*     */   
/*     */ 
/*     */   public PNoticeAll() {}
/*     */   
/*     */ 
/*     */   public PNoticeAll(int questionId)
/*     */   {
/*  28 */     this.questionId = questionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!setQuestionId())
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     new POfferQuestionSession(getNotic2QuestionSec());
/*     */     
/*     */ 
/*  42 */     SQuestionIsComingNotice pro = new SQuestionIsComingNotice();
/*  43 */     OnlineManager.getInstance().sendAll(pro);
/*  44 */     GameServer.logger().info(String.format("[worldquestion]文曲星要下凡啦!", new Object[0]));
/*     */     
/*  46 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean setQuestionId()
/*     */   {
/*  58 */     WorldQuestionBean xWQBean = WorldQuestion.getInstance().getWorldQuestionBean(true);
/*  59 */     if (xWQBean == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     List<Integer> ownQuestions = xWQBean.getOldquestionids();
/*  64 */     int questionId = setQuestionId(xWQBean, ownQuestions);
/*  65 */     if (questionId <= 0)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     ownQuestions.add(Integer.valueOf(questionId));
/*  70 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int setQuestionId(WorldQuestionBean xWQBean, List<Integer> ownQuestions)
/*     */   {
/*  82 */     int qId = getNewQuestionId(ownQuestions);
/*  83 */     if (!WorldQuestion.getInstance().isQuestionExist(qId))
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[worldQuestion]PNoticeAll.setQuestionId@questionId not exist! |questionId=%d", new Object[] { Integer.valueOf(qId) }));
/*     */       
/*  87 */       return -1;
/*     */     }
/*  89 */     xWQBean.setQuestionid(qId);
/*  90 */     return qId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getNewQuestionId(List<Integer> ownQuestions)
/*     */   {
/* 101 */     if (this.questionId > 0)
/*     */     {
/* 103 */       return this.questionId;
/*     */     }
/* 105 */     int qId = QuestionSet.ranQustionIds(ownQuestions);
/* 106 */     if (qId > 0)
/*     */     {
/* 108 */       return qId;
/*     */     }
/* 110 */     GameServer.logger().error(String.format("[worldQuestion]PNoticeAll.getNewQuestionId@random question error！|ownQuestions=%s", new Object[] { ownQuestions.toString() }));
/*     */     
/*     */ 
/* 113 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNotic2QuestionSec()
/*     */   {
/* 123 */     return WorldQuestionConsts.getInstance().NOTIC_QUESTION_INTERVAL;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PNoticeAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */