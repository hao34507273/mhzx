/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import mzm.gsp.drawandguess.AnswerInfo;
/*     */ import mzm.gsp.drawandguess.DrawLineInfo;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessRuleCfg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrawAndGuessContext
/*     */   implements IDrawAndGuessContext
/*     */ {
/*     */   public final int activityCfgId;
/*     */   final Queue<Integer> qusetionQueue;
/*     */   final Map<Long, Integer> jifenInfo;
/*     */   private final Queue<AnswerInfo> answerQueue;
/*     */   private final Map<Integer, DrawLineInfo> drawInfoMap;
/*     */   private int totalPoint;
/*     */   
/*     */   public DrawAndGuessContext(int activityCfgId, Queue<Integer> qusetionQueue, Map<Long, Integer> jifenInfo)
/*     */   {
/*  47 */     this.activityCfgId = activityCfgId;
/*  48 */     this.qusetionQueue = qusetionQueue;
/*  49 */     this.jifenInfo = jifenInfo;
/*     */     
/*  51 */     this.answerQueue = new ConcurrentLinkedQueue();
/*  52 */     this.drawInfoMap = new LinkedHashMap(64);
/*  53 */     this.totalPoint = 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Queue<AnswerInfo> getAnswerQueue()
/*     */   {
/*  59 */     return this.answerQueue;
/*     */   }
/*     */   
/*     */   public Map<Integer, DrawLineInfo> getDrawInfoMap()
/*     */   {
/*  64 */     return this.drawInfoMap;
/*     */   }
/*     */   
/*     */   public int getTotalPoint()
/*     */   {
/*  69 */     return this.totalPoint;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean draw(DrawLineInfo drawLineInfo)
/*     */   {
/*  83 */     DrawLineInfo beforeDrawLineInfo = (DrawLineInfo)this.drawInfoMap.get(Integer.valueOf(drawLineInfo.line_id));
/*     */     
/*  85 */     if (beforeDrawLineInfo != null)
/*     */     {
/*     */ 
/*  88 */       if ((drawLineInfo.color > 0) || (drawLineInfo.size > 0))
/*     */       {
/*  90 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  95 */       beforeDrawLineInfo.point_list.addAll(drawLineInfo.point_list);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 100 */       this.drawInfoMap.put(Integer.valueOf(drawLineInfo.line_id), drawLineInfo);
/*     */     }
/* 102 */     this.totalPoint += drawLineInfo.point_list.size();
/* 103 */     drawLineInfo.action_id = this.totalPoint;
/* 104 */     if (beforeDrawLineInfo != null) {
/* 105 */       beforeDrawLineInfo.action_id = this.totalPoint;
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void clear()
/*     */   {
/* 113 */     this.drawInfoMap.clear();
/* 114 */     this.totalPoint = 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void answer(AnswerInfo answerInfo)
/*     */   {
/* 120 */     if (this.answerQueue.size() >= 30)
/*     */     {
/* 122 */       this.answerQueue.poll();
/*     */     }
/* 124 */     this.answerQueue.offer(answerInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getQuestionCfgid()
/*     */   {
/* 130 */     if ((this.qusetionQueue != null) && (this.qusetionQueue.peek() != null))
/*     */     {
/* 132 */       return ((Integer)this.qusetionQueue.poll()).intValue();
/*     */     }
/* 134 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Long, Integer> getJifenInfo()
/*     */   {
/* 140 */     return this.jifenInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public void addJifen(long drawerId, List<Long> suc_roleids)
/*     */   {
/* 146 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(this.activityCfgId);
/* 147 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/* 149 */       return;
/*     */     }
/* 151 */     SDrawAndGuessRuleCfg sDrawAndGuessRuleCfg = SDrawAndGuessRuleCfg.get(sDrawAndGuessActivityCfg.ruleId);
/* 152 */     if (sDrawAndGuessRuleCfg == null)
/*     */     {
/* 154 */       return;
/*     */     }
/*     */     
/*     */ 
/* 158 */     for (int index = 0; index < suc_roleids.size(); index++)
/*     */     {
/* 160 */       long suc_roleid = ((Long)suc_roleids.get(index)).longValue();
/* 161 */       Integer oldJifen = (Integer)this.jifenInfo.get(Long.valueOf(suc_roleid));
/* 162 */       if (index == 0)
/*     */       {
/* 164 */         this.jifenInfo.put(Long.valueOf(suc_roleid), Integer.valueOf((oldJifen == null ? 0 : oldJifen.intValue()) + sDrawAndGuessRuleCfg.firstRightJifen));
/*     */       }
/*     */       else
/*     */       {
/* 168 */         this.jifenInfo.put(Long.valueOf(suc_roleid), Integer.valueOf((oldJifen == null ? 0 : oldJifen.intValue()) + sDrawAndGuessRuleCfg.otherRightJifen));
/*     */       }
/*     */     }
/* 171 */     Integer oldJifen = (Integer)this.jifenInfo.get(Long.valueOf(drawerId));
/* 172 */     this.jifenInfo.put(Long.valueOf(drawerId), Integer.valueOf((oldJifen == null ? 0 : oldJifen.intValue()) + sDrawAndGuessRuleCfg.drawerRightJifen * suc_roleids.size()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */