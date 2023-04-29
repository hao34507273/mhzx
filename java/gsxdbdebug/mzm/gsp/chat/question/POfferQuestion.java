/*     */ package mzm.gsp.chat.question;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.SQuestionContext;
/*     */ import mzm.gsp.activity.confbean.WorldQuestionConsts;
/*     */ import mzm.gsp.chat.main.ChatInWorldObManager;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WorldQuestionBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class POfferQuestion
/*     */   extends LogicProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     int questionId = questionComingNotice();
/*  30 */     if (questionId <= 0)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     new PQuestionOverSession(getAnswerTime());
/*     */     
/*  37 */     ChatInterface.registerWorldChat(ChatInWorldObManager.TYPE__WORLD_QUESTION, new POnChatInWorldHandler());
/*     */     
/*  39 */     logStartQuestion(questionId);
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   private void logStartQuestion(int questionId)
/*     */   {
/*  45 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  46 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  47 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  48 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/*  50 */     String vGameAppid = "0";
/*  51 */     int PlatID = -1;
/*  52 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  53 */     String vopenid = "0";
/*     */     
/*  55 */     StringBuffer sb = new StringBuffer();
/*  56 */     sb.append(GameSvrId).append('|');
/*  57 */     sb.append(dtEventTime).append('|');
/*  58 */     sb.append("0").append('|');
/*  59 */     sb.append(-1).append('|');
/*  60 */     sb.append(iZoneAreaID).append('|');
/*  61 */     sb.append("0").append('|');
/*     */     
/*  63 */     sb.append(questionId);
/*     */     
/*  65 */     TLogManager.getInstance().addLog("WorldQuestionStart", sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int questionComingNotice()
/*     */   {
/*  77 */     WorldQuestionBean xWQBean = WorldQuestion.getInstance().getWorldQuestionBean(true);
/*  78 */     if (xWQBean == null)
/*     */     {
/*  80 */       return -1;
/*     */     }
/*  82 */     updateXQuestionBean(xWQBean);
/*  83 */     sendQuestionToAll(xWQBean.getQuestionid());
/*  84 */     return xWQBean.getQuestionid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateXQuestionBean(WorldQuestionBean xWQBean)
/*     */   {
/*  94 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  95 */     xWQBean.setGoing(true);
/*  96 */     xWQBean.setLasttime(now);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendQuestionToAll(int questionId)
/*     */   {
/* 106 */     SQuestionContext pro = new SQuestionContext();
/* 107 */     pro.questionid = questionId;
/* 108 */     OnlineManager.getInstance().sendAll(pro);
/* 109 */     GameServer.logger().info(String.format("[worldQuestion]POfferQuestion.sendQuestionToAll@世界答题开始！|questionId=%d", new Object[] { Integer.valueOf(questionId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getAnswerTime()
/*     */   {
/* 120 */     return WorldQuestionConsts.getInstance().ANSWER_TIME;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\POfferQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */