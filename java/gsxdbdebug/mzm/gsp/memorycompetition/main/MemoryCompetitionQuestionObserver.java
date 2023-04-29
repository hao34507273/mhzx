/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xtable.Memorycompetition;
/*     */ 
/*     */ public class MemoryCompetitionQuestionObserver extends MilliObserver
/*     */ {
/*  13 */   public static long NOT_ANSWER = 0L;
/*     */   
/*     */   private final long memoryCompetitionId;
/*     */   private final long beginTime;
/*     */   private final Map<Long, QuestionAnswerState> role2AnswerStateMap;
/*     */   
/*     */   public MemoryCompetitionQuestionObserver(long intervalMilliSeconds, long memoryCompetitionId, long beginTime, Map<Long, QuestionAnswerState> role2AnswerStateMap)
/*     */   {
/*  21 */     super(intervalMilliSeconds);
/*  22 */     this.memoryCompetitionId = memoryCompetitionId;
/*  23 */     this.beginTime = beginTime;
/*  24 */     this.role2AnswerStateMap = role2AnswerStateMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  30 */     new PMemoryCompetitionQuestion(this).execute();
/*  31 */     return false;
/*     */   }
/*     */   
/*     */   public long getMemoryCompetitionId()
/*     */   {
/*  36 */     return this.memoryCompetitionId;
/*     */   }
/*     */   
/*     */   public Map<Long, QuestionAnswerState> getRole2AnswerStateMap()
/*     */   {
/*  41 */     return this.role2AnswerStateMap;
/*     */   }
/*     */   
/*     */   public long getBeginTime()
/*     */   {
/*  46 */     return this.beginTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isAllAnswered()
/*     */   {
/*  56 */     for (Map.Entry<Long, QuestionAnswerState> entry : this.role2AnswerStateMap.entrySet())
/*     */     {
/*  58 */       QuestionAnswerState questionAnswerState = (QuestionAnswerState)entry.getValue();
/*  59 */       if (questionAnswerState.answerTime == NOT_ANSWER)
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   void setAnswer(long roleId, int answerId)
/*     */   {
/*  70 */     QuestionAnswerState questionAnswerState = (QuestionAnswerState)this.role2AnswerStateMap.get(Long.valueOf(roleId));
/*  71 */     if (questionAnswerState == null)
/*     */     {
/*  73 */       return;
/*     */     }
/*     */     
/*  76 */     if (questionAnswerState.answerTime != NOT_ANSWER)
/*     */     {
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     questionAnswerState.setAnswerId(answerId);
/*  82 */     questionAnswerState.setAnswerTime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   void setSeekHelpState(long roleId)
/*     */   {
/*  87 */     QuestionAnswerState questionAnswerState = (QuestionAnswerState)this.role2AnswerStateMap.get(Long.valueOf(roleId));
/*  88 */     if (questionAnswerState == null)
/*     */     {
/*  90 */       return;
/*     */     }
/*     */     
/*  93 */     questionAnswerState.setAleardySeekHelp(true);
/*     */   }
/*     */   
/*     */   boolean isAleardyAnswered(long roleId)
/*     */   {
/*  98 */     QuestionAnswerState questionAnswerState = (QuestionAnswerState)this.role2AnswerStateMap.get(Long.valueOf(roleId));
/*  99 */     if (questionAnswerState == null)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (questionAnswerState.getAnswerTime() == NOT_ANSWER)
/*     */     {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   boolean isAleardySeekHelp(long roleId)
/*     */   {
/* 114 */     QuestionAnswerState questionAnswerState = (QuestionAnswerState)this.role2AnswerStateMap.get(Long.valueOf(roleId));
/* 115 */     if (questionAnswerState == null)
/*     */     {
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     return questionAnswerState.isAleardySeekHelp;
/*     */   }
/*     */   
/*     */   boolean isAleardyBeHelped(long roleId)
/*     */   {
/* 125 */     QuestionAnswerState questionAnswerState = (QuestionAnswerState)this.role2AnswerStateMap.get(Long.valueOf(roleId));
/* 126 */     if (questionAnswerState == null)
/*     */     {
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     return questionAnswerState.isAleardyBeHelped;
/*     */   }
/*     */   
/*     */   void setHelpState(long roleId)
/*     */   {
/* 136 */     QuestionAnswerState questionAnswerState = (QuestionAnswerState)this.role2AnswerStateMap.get(Long.valueOf(roleId));
/* 137 */     if (questionAnswerState == null)
/*     */     {
/* 139 */       return;
/*     */     }
/* 141 */     questionAnswerState.isAleardyBeHelped = true;
/*     */   }
/*     */   
/*     */   private static class PMemoryCompetitionQuestion
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final MemoryCompetitionQuestionObserver questionObserver;
/*     */     
/*     */     public PMemoryCompetitionQuestion(MemoryCompetitionQuestionObserver questionObserver)
/*     */     {
/* 151 */       this.questionObserver = questionObserver;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 157 */       MemoryCompetitionInfo xMemoryCompetitionInfo = Memorycompetition.get(Long.valueOf(this.questionObserver.getMemoryCompetitionId()));
/* 158 */       if (xMemoryCompetitionInfo == null)
/*     */       {
/* 160 */         return false;
/*     */       }
/*     */       
/* 163 */       MemoryCompetitionQuestionObserver xQuestionObserver = xMemoryCompetitionInfo.getRoles_current_question_observer();
/* 164 */       if (xQuestionObserver == null)
/*     */       {
/* 166 */         return false;
/*     */       }
/*     */       
/* 169 */       if (xQuestionObserver != this.questionObserver)
/*     */       {
/* 171 */         return false;
/*     */       }
/*     */       
/* 174 */       if (this.questionObserver.isAllAnswered())
/*     */       {
/* 176 */         return false;
/*     */       }
/*     */       
/* 179 */       SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/* 180 */       if (competitionCfg == null)
/*     */       {
/* 182 */         return false;
/*     */       }
/*     */       
/* 185 */       MemoryCompetitionManager.onQuestionEnd(xMemoryCompetitionInfo, this.questionObserver, competitionCfg);
/*     */       
/* 187 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class QuestionAnswerState
/*     */   {
/*     */     private final int questionId;
/*     */     private final List<Integer> optionList;
/*     */     private long answerTime;
/* 196 */     private int answerId = -1;
/* 197 */     private boolean isAleardySeekHelp = false;
/* 198 */     private boolean isAleardyBeHelped = false;
/*     */     
/*     */     public QuestionAnswerState(int questionId, List<Integer> optionList, long answerTime)
/*     */     {
/* 202 */       this.questionId = questionId;
/* 203 */       this.optionList = optionList;
/* 204 */       this.answerTime = answerTime;
/*     */     }
/*     */     
/*     */     public int getQuestionId()
/*     */     {
/* 209 */       return this.questionId;
/*     */     }
/*     */     
/*     */     public long getAnswerTime()
/*     */     {
/* 214 */       return this.answerTime;
/*     */     }
/*     */     
/*     */     public void setAnswerTime(long answerTime)
/*     */     {
/* 219 */       this.answerTime = answerTime;
/*     */     }
/*     */     
/*     */     public int getAnswerId()
/*     */     {
/* 224 */       return this.answerId;
/*     */     }
/*     */     
/*     */     public void setAnswerId(int answerId)
/*     */     {
/* 229 */       this.answerId = answerId;
/*     */     }
/*     */     
/*     */     public boolean isAleardySeekHelp()
/*     */     {
/* 234 */       return this.isAleardySeekHelp;
/*     */     }
/*     */     
/*     */     public void setAleardySeekHelp(boolean isAleardySeekHelp)
/*     */     {
/* 239 */       this.isAleardySeekHelp = isAleardySeekHelp;
/*     */     }
/*     */     
/*     */     public boolean isAleardyBeHelped()
/*     */     {
/* 244 */       return this.isAleardyBeHelped;
/*     */     }
/*     */     
/*     */     public void setAleardyBeHelped(boolean isAleardyBeHelped)
/*     */     {
/* 249 */       this.isAleardyBeHelped = isAleardyBeHelped;
/*     */     }
/*     */     
/*     */     public List<Integer> getOptionList()
/*     */     {
/* 254 */       return this.optionList;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\MemoryCompetitionQuestionObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */