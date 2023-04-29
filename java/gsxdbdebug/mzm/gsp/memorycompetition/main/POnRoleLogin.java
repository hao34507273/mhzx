/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.memorycompetition.QuestionInfo;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionQuestionStart;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionStart;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xbean.MemoryQuestion;
/*     */ import xbean.RolesMemoryQuestion;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  23 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*  24 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  26 */     Long xMemoryCompetitionId = xtable.Role2memorycompetition.get(Long.valueOf(roleId));
/*  27 */     if (xMemoryCompetitionId == null)
/*     */     {
/*  29 */       return false;
/*     */     }
/*     */     
/*  32 */     MemoryCompetitionInfo xMemoryCompetitionInfo = xtable.Memorycompetition.get(xMemoryCompetitionId);
/*  33 */     if (xMemoryCompetitionInfo == null)
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     int memoryCompetitionCfgId = xMemoryCompetitionInfo.getMemory_competition_cfg_id();
/*  39 */     SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(memoryCompetitionCfgId);
/*  40 */     if (competitionCfg == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     MemoryCompetitionPrepareObserver prepareObserver = xMemoryCompetitionInfo.getRoles_current_prepare_question_observer();
/*  46 */     if (prepareObserver != null)
/*     */     {
/*  48 */       SMemoryCompetitionStart competitionStart = new SMemoryCompetitionStart();
/*  49 */       competitionStart.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/*     */       
/*  51 */       Map<Integer, Integer> mappintDate = competitionStart.mapping_date;
/*  52 */       for (Map.Entry<Integer, Integer> entry : xMemoryCompetitionInfo.getMapping().entrySet())
/*     */       {
/*  54 */         int questionId = ((Integer)entry.getKey()).intValue();
/*  55 */         int answer = ((Integer)entry.getValue()).intValue();
/*  56 */         if (!mappintDate.containsKey(Integer.valueOf(answer)))
/*     */         {
/*     */ 
/*     */ 
/*  60 */           mappintDate.put(Integer.valueOf(questionId), Integer.valueOf(answer));
/*     */         }
/*     */       }
/*  63 */       long elpasedTime = DateTimeUtils.getCurrTimeInMillis() - prepareObserver.getBegineTime();
/*  64 */       competitionStart.left_seconds = (competitionCfg.mapping_answer_show_seconds - (int)(elpasedTime / 1000L));
/*     */       
/*  66 */       OnlineManager.getInstance().send(roleId, competitionStart);
/*  67 */       return true;
/*     */     }
/*     */     
/*  70 */     MemoryCompetitionQuestionObserver questionObserver = xMemoryCompetitionInfo.getRoles_current_question_observer();
/*  71 */     if (questionObserver == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     SMemoryCompetitionQuestionStart questionStart = new SMemoryCompetitionQuestionStart();
/*  77 */     questionStart.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/*     */     
/*  79 */     long elpasedTime = DateTimeUtils.getCurrTimeInMillis() - questionObserver.getBeginTime();
/*  80 */     questionStart.left_seconds = (competitionCfg.question_answer_seconds - (int)(elpasedTime / 1000L));
/*  81 */     questionStart.memory_competition_cfg_id = memoryCompetitionCfgId;
/*  82 */     Integer aleardySeekHelpTimes = (Integer)xMemoryCompetitionInfo.getRoles_seek_help_times_map().get(Long.valueOf(roleId));
/*  83 */     if (aleardySeekHelpTimes == null)
/*     */     {
/*  85 */       questionStart.left_seek_help_times = competitionCfg.seek_help_times;
/*     */     }
/*     */     else
/*     */     {
/*  89 */       questionStart.left_seek_help_times = (competitionCfg.seek_help_times - aleardySeekHelpTimes.intValue());
/*     */     }
/*     */     
/*  92 */     for (Map.Entry<Long, MemoryCompetitionQuestionObserver.QuestionAnswerState> entry : questionObserver.getRole2AnswerStateMap().entrySet())
/*     */     {
/*  94 */       long gameRoleId = ((Long)entry.getKey()).longValue();
/*  95 */       MemoryCompetitionQuestionObserver.QuestionAnswerState questionAnswerState = (MemoryCompetitionQuestionObserver.QuestionAnswerState)entry.getValue();
/*     */       
/*  97 */       QuestionInfo questionInfo = new QuestionInfo();
/*  98 */       questionInfo.option_list.addAll(questionAnswerState.getOptionList());
/*  99 */       questionInfo.question_id = questionAnswerState.getQuestionId();
/*     */       
/* 101 */       questionStart.roles_question_map.put(Long.valueOf(gameRoleId), questionInfo);
/*     */     }
/*     */     
/* 104 */     questionStart.score = xMemoryCompetitionInfo.getCurrent_score();
/* 105 */     questionStart.now_round_num = xMemoryCompetitionInfo.getCurrent_round_num();
/* 106 */     questionStart.total_round_num = competitionCfg.question_num;
/*     */     
/* 108 */     for (Map.Entry<Long, RolesMemoryQuestion> entry : xMemoryCompetitionInfo.getRoles_answered_question_map().entrySet())
/*     */     {
/* 110 */       long gameRoleId = ((Long)entry.getKey()).longValue();
/* 111 */       int rightNum = 0;
/* 112 */       for (MemoryQuestion xMemoryQuestion : ((RolesMemoryQuestion)entry.getValue()).getQuestion_list())
/*     */       {
/* 114 */         if (xMemoryQuestion.getAnswer_result())
/*     */         {
/* 116 */           rightNum++;
/*     */         }
/*     */       }
/* 119 */       questionStart.roles_right_num_map.put(Long.valueOf(gameRoleId), Integer.valueOf(rightNum));
/*     */     }
/*     */     
/* 122 */     OnlineManager.getInstance().send(roleId, questionStart);
/*     */     
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */