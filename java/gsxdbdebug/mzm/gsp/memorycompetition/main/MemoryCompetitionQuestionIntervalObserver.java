/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.memorycompetition.QuestionIdList;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionEndNotify;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndArg.MemoryQuestionInfo;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xbean.MemoryQuestion;
/*     */ import xbean.RolesMemoryQuestion;
/*     */ import xtable.Memorycompetition;
/*     */ 
/*     */ public class MemoryCompetitionQuestionIntervalObserver extends mzm.gsp.timer.main.MilliObserver
/*     */ {
/*     */   private final long memoryCompetitionId;
/*     */   
/*     */   public MemoryCompetitionQuestionIntervalObserver(long intervalMilliSeconds, long memoryCompetitionId)
/*     */   {
/*  25 */     super(intervalMilliSeconds);
/*  26 */     this.memoryCompetitionId = memoryCompetitionId;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  32 */     new PMemoryCompetitionQuestionInterval(this.memoryCompetitionId).execute();
/*     */     
/*  34 */     return false;
/*     */   }
/*     */   
/*     */   static class PMemoryCompetitionQuestionInterval extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long memoryCompetitionId;
/*     */     
/*     */     public PMemoryCompetitionQuestionInterval(long memoryCompetitionId)
/*     */     {
/*  43 */       this.memoryCompetitionId = memoryCompetitionId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  49 */       MemoryCompetitionInfo xMemoryCompetitionInfo = Memorycompetition.get(Long.valueOf(this.memoryCompetitionId));
/*  50 */       if (xMemoryCompetitionInfo == null)
/*     */       {
/*  52 */         return false;
/*     */       }
/*     */       
/*  55 */       SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/*  56 */       if (competitionCfg == null)
/*     */       {
/*  58 */         return false;
/*     */       }
/*     */       
/*  61 */       if (xMemoryCompetitionInfo.getCurrent_round_num() >= competitionCfg.question_num)
/*     */       {
/*  63 */         new MemoryCompetitionQuestionIntervalObserver.PMemoryCompetitionEnd(this.memoryCompetitionId).execute();
/*  64 */         return true;
/*     */       }
/*     */       
/*  67 */       MemoryCompetitionManager.startQuestion(this.memoryCompetitionId, xMemoryCompetitionInfo, competitionCfg);
/*  68 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class PMemoryCompetitionEnd
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long memoryCompetitionId;
/*     */     
/*     */     public PMemoryCompetitionEnd(long memoryCompetitionId)
/*     */     {
/*  79 */       this.memoryCompetitionId = memoryCompetitionId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  85 */       List<Long> roleIdList = Memorycompetition.selectRole_id_list(Long.valueOf(this.memoryCompetitionId));
/*  86 */       if (roleIdList == null)
/*     */       {
/*  88 */         return false;
/*     */       }
/*     */       
/*  91 */       lock(xtable.Role2properties.getTable(), roleIdList);
/*     */       
/*  93 */       MemoryCompetitionInfo xMemoryCompetitionInfo = Memorycompetition.get(Long.valueOf(this.memoryCompetitionId));
/*  94 */       if (xMemoryCompetitionInfo == null)
/*     */       {
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/* 100 */       if (competitionCfg == null)
/*     */       {
/* 102 */         return false;
/*     */       }
/*     */       
/* 105 */       if (xMemoryCompetitionInfo.getCurrent_round_num() >= competitionCfg.question_num)
/*     */       {
/* 107 */         onGameEnd(this.memoryCompetitionId, xMemoryCompetitionInfo);
/*     */       }
/* 109 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void onGameEnd(long memoryCompetitionId, MemoryCompetitionInfo xMemoryCompetitionInfo)
/*     */     {
/* 120 */       SMemoryCompetitionEndNotify endNotify = new SMemoryCompetitionEndNotify();
/* 121 */       endNotify.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/*     */       
/* 123 */       Map<Long, List<MemoryCompetitionGameEndArg.MemoryQuestionInfo>> rolesMemoryQuestionInfoMap = new HashMap();
/* 124 */       for (Map.Entry<Long, RolesMemoryQuestion> entry : xMemoryCompetitionInfo.getRoles_answered_question_map().entrySet())
/*     */       {
/* 126 */         long roleId = ((Long)entry.getKey()).longValue();
/* 127 */         List<MemoryQuestion> xQuestionInfoList = ((RolesMemoryQuestion)entry.getValue()).getQuestion_list();
/*     */         
/* 129 */         List<MemoryCompetitionGameEndArg.MemoryQuestionInfo> memoryQuestionInfoList = new ArrayList();
/* 130 */         QuestionIdList questionIdList = new QuestionIdList();
/* 131 */         for (MemoryQuestion xMemoryQuestion : xQuestionInfoList)
/*     */         {
/* 133 */           MemoryCompetitionGameEndArg.MemoryQuestionInfo memoryQuestionInfo = new MemoryCompetitionGameEndArg.MemoryQuestionInfo(xMemoryQuestion.getQuestion_id(), xMemoryQuestion.getAnswer_result(), xMemoryQuestion.getAnswer_time());
/*     */           
/*     */ 
/* 136 */           memoryQuestionInfoList.add(memoryQuestionInfo);
/* 137 */           if (xMemoryQuestion.getAnswer_id() != -1)
/*     */           {
/* 139 */             questionIdList.quesition_id_list.add(Integer.valueOf(xMemoryQuestion.getAnswer_id()));
/*     */           }
/*     */           else
/*     */           {
/* 143 */             Integer rightAnswer = (Integer)xMemoryCompetitionInfo.getMapping().get(Integer.valueOf(xMemoryQuestion.getQuestion_id()));
/* 144 */             if (rightAnswer != null)
/*     */             {
/* 146 */               questionIdList.quesition_id_list.add(rightAnswer);
/*     */             }
/*     */           }
/*     */         }
/* 150 */         endNotify.roles_answer_map.put(Long.valueOf(roleId), questionIdList);
/*     */         
/* 152 */         rolesMemoryQuestionInfoMap.put(Long.valueOf(roleId), memoryQuestionInfoList);
/*     */       }
/* 154 */       for (Iterator i$ = xMemoryCompetitionInfo.getRole_id_list().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 156 */         xtable.Role2memorycompetition.remove(Long.valueOf(roleId));
/*     */       }
/*     */       
/*     */ 
/* 160 */       Memorycompetition.remove(Long.valueOf(memoryCompetitionId));
/*     */       
/* 162 */       mzm.gsp.online.main.OnlineManager.getInstance().sendMulti(endNotify, xMemoryCompetitionInfo.getRole_id_list());
/*     */       
/* 164 */       mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndArg gameEndArg = new mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndArg(xMemoryCompetitionInfo.getRole_id_list(), xMemoryCompetitionInfo.getActivity_cfg_id(), xMemoryCompetitionInfo.getMemory_competition_cfg_id(), xMemoryCompetitionInfo.getCurrent_score(), rolesMemoryQuestionInfoMap);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndEvent(), gameEndArg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\MemoryCompetitionQuestionIntervalObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */