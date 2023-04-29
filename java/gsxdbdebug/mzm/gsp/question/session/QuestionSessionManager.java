/*     */ package mzm.gsp.question.session;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.question.main.QuestionTypeEnum;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuestionSessionManager
/*     */ {
/*  21 */   static Logger logger = Logger.getLogger("question");
/*     */   
/*  23 */   private static final QuestionSessionManager instance = new QuestionSessionManager();
/*     */   
/*     */   public static QuestionSessionManager getInstance()
/*     */   {
/*  27 */     return instance;
/*     */   }
/*     */   
/*  30 */   private long curSessionid = 0L;
/*  31 */   private final Map<Long, QuestionSession> sessions = new HashMap();
/*  32 */   private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   long createQuestionSession(long ownerid, QuestionTypeEnum questionType, int questionid, int pageIndex, int answerNum, int rightAnswerIndex)
/*     */   {
/*  37 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  40 */       QuestionSession questionSession = new QuestionSession(ownerid, questionType, questionid, pageIndex, answerNum, rightAnswerIndex);
/*     */       
/*  42 */       this.sessions.put(Long.valueOf(this.curSessionid), questionSession);
/*  43 */       String logStr = String.format("[question]QuestionSessionManager.createQuestionSession@create question session|sessionid=%d|ownerid=%d|question_type=%d|questionid=%d|page_index=%d|answernum=%d|right_answer_index=%d", new Object[] { Long.valueOf(this.curSessionid), Long.valueOf(ownerid), Integer.valueOf(questionType.value), Integer.valueOf(questionid), Integer.valueOf(pageIndex), Integer.valueOf(answerNum), Integer.valueOf(rightAnswerIndex) });
/*     */       
/*     */ 
/*  46 */       logger.info(logStr);
/*  47 */       return this.curSessionid++;
/*     */     }
/*     */     finally
/*     */     {
/*  51 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   List<Integer> getAnswerRandomSequence(long sessionid)
/*     */   {
/*  57 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  60 */       QuestionSession questionSession = (QuestionSession)this.sessions.get(Long.valueOf(sessionid));
/*  61 */       List localList; if (questionSession == null)
/*     */       {
/*  63 */         String logStr = String.format("[question]QuestionSessionManager.getAnswerRandomSequence@session is null|sessionid=%d", new Object[] { Long.valueOf(sessionid) });
/*     */         
/*  65 */         logger.error(logStr);
/*  66 */         return Collections.emptyList();
/*     */       }
/*  68 */       String logStr = String.format("[question]QuestionSessionManager.getAnswerRandomSequence@get answer random sequence success|sessionid=%d", new Object[] { Long.valueOf(sessionid) });
/*     */       
/*     */ 
/*  71 */       logger.info(logStr);
/*  72 */       return questionSession.getAnswerRandomSequence();
/*     */     }
/*     */     finally
/*     */     {
/*  76 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   CheckAnswerResultEnum checkAnswer(long sessionid, long ownerid, QuestionTypeEnum questionType, int questionid, int pageIndex, int answerIndex)
/*     */   {
/*  83 */     this.rwLock.readLock().lock();
/*     */     CheckAnswerResultEnum localCheckAnswerResultEnum1;
/*     */     try {
/*  86 */       QuestionSession questionSession = (QuestionSession)this.sessions.get(Long.valueOf(sessionid));
/*  87 */       if (questionSession == null)
/*     */       {
/*  89 */         String logStr = String.format("[question]QuestionSessionManager.checkAnswer@session is null|sessionid=%d|ownerid=%d|question_type=%d|questionid=%d|page_index=%d|answer_index=%d", new Object[] { Long.valueOf(sessionid), Long.valueOf(ownerid), Integer.valueOf(questionType.value), Integer.valueOf(questionid), Integer.valueOf(pageIndex), Integer.valueOf(answerIndex) });
/*     */         
/*     */ 
/*  92 */         logger.error(logStr);
/*  93 */         return CheckAnswerResultEnum.INVALID_SESSION_ID;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  98 */       this.rwLock.readLock().unlock();
/*     */     }
/* 100 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 103 */       QuestionSession questionSession = (QuestionSession)this.sessions.get(Long.valueOf(sessionid));
/* 104 */       if (questionSession == null)
/*     */       {
/* 106 */         String logStr = String.format("[question]QuestionSessionManager.checkAnswer@session is null|sessionid=%d|ownerid=%d|question_type=%d|questionid=%d|page_index=%d|answer_index=%d", new Object[] { Long.valueOf(sessionid), Long.valueOf(ownerid), Integer.valueOf(questionType.value), Integer.valueOf(questionid), Integer.valueOf(pageIndex), Integer.valueOf(answerIndex) });
/*     */         
/*     */ 
/* 109 */         logger.error(logStr);
/* 110 */         return CheckAnswerResultEnum.INVALID_SESSION_ID;
/*     */       }
/* 112 */       CheckAnswerResultEnum result = questionSession.checkAnswer(ownerid, questionType, questionid, pageIndex, answerIndex);
/*     */       
/* 114 */       if (result != CheckAnswerResultEnum.ARG_NOT_MATCH)
/*     */       {
/* 116 */         this.sessions.remove(Long.valueOf(sessionid));
/*     */       }
/* 118 */       String logStr = String.format("[question]QuestionSessionManager.checkAnswer@check answer result|sessionid=%d|ownerid=%d|question_type=%d|questionid=%d|page_index=%d|answer_index=%d|result=%d", new Object[] { Long.valueOf(sessionid), Long.valueOf(ownerid), Integer.valueOf(questionType.value), Integer.valueOf(questionid), Integer.valueOf(pageIndex), Integer.valueOf(answerIndex), Integer.valueOf(result.value) });
/*     */       
/*     */ 
/* 121 */       logger.info(logStr);
/* 122 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\session\QuestionSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */