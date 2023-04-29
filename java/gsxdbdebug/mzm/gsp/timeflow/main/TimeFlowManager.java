/*     */ package mzm.gsp.timeflow.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeFlowManager
/*     */ {
/*     */   private static final long TIME_FLOW_MIN_STEP_INTERVAL = 300000L;
/*  13 */   private static final TimeFlowManager instance = new TimeFlowManager();
/*     */   
/*     */   public static final TimeFlowManager getInstance()
/*     */   {
/*  17 */     return instance;
/*     */   }
/*     */   
/*  20 */   private Map<TimeFlowType, Map<Integer, TimeFlow>> timeFlows = new HashMap();
/*     */   
/*     */   public boolean addTimeFlow(TimeFlowType type, int subType, long limitTime, List<Long> absoluteSteps)
/*     */   {
/*  24 */     int size = absoluteSteps.size();
/*  25 */     if (size == 0)
/*     */     {
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     long baseTime = ((Long)absoluteSteps.get(0)).longValue();
/*  31 */     long triggerTime = 0L;
/*  32 */     long delta = 0L;
/*  33 */     long interval = 0L;
/*  34 */     for (int i = 0; i < size; interval += 300000L)
/*     */     {
/*  36 */       triggerTime = ((Long)absoluteSteps.get(i)).longValue();
/*  37 */       if (triggerTime >= limitTime)
/*     */       {
/*  39 */         return false;
/*     */       }
/*     */       
/*  42 */       delta = triggerTime - baseTime;
/*  43 */       if (delta < interval)
/*     */       {
/*  45 */         return false;
/*     */       }
/*  34 */       i++;
/*     */     }
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
/*  49 */     return doAddTimeFlow(type, subType, limitTime, absoluteSteps);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addTimeFlow(TimeFlowType type, int subType, long limitTime, long referenceTime, List<Long> relativeSteps)
/*     */   {
/*  55 */     int size = relativeSteps.size();
/*  56 */     if (size == 0)
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     List<Long> absoluteSteps = new ArrayList();
/*     */     
/*  63 */     long delta = 0L;
/*  64 */     long interval = 0L;
/*  65 */     long triggerTime = referenceTime;
/*  66 */     long baseTime = ((Long)relativeSteps.get(0)).longValue() + referenceTime;
/*  67 */     for (int i = 0; i < size; interval += 300000L)
/*     */     {
/*  69 */       triggerTime += ((Long)relativeSteps.get(i)).longValue();
/*  70 */       if (triggerTime >= limitTime)
/*     */       {
/*  72 */         return false;
/*     */       }
/*     */       
/*  75 */       delta = triggerTime - baseTime;
/*  76 */       if (delta < interval)
/*     */       {
/*  78 */         return false;
/*     */       }
/*     */       
/*  81 */       absoluteSteps.add(Long.valueOf(triggerTime));i++;
/*     */     }
/*     */     
/*  84 */     return doAddTimeFlow(type, subType, limitTime, absoluteSteps);
/*     */   }
/*     */   
/*     */   void onPostInit()
/*     */   {
/*  89 */     for (Map<Integer, TimeFlow> subTypeTimeFlowMap : this.timeFlows.values())
/*     */     {
/*  91 */       for (TimeFlow timeFlow : subTypeTimeFlowMap.values())
/*     */       {
/*  93 */         timeFlow.onPostInit();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean doAddTimeFlow(TimeFlowType type, int subType, long limitTime, List<Long> absoluteSteps)
/*     */   {
/* 101 */     Map<Integer, TimeFlow> subTypeTimeFlowMap = (Map)this.timeFlows.get(type);
/* 102 */     if (subTypeTimeFlowMap == null)
/*     */     {
/* 104 */       subTypeTimeFlowMap = new HashMap();
/* 105 */       this.timeFlows.put(type, subTypeTimeFlowMap);
/*     */ 
/*     */ 
/*     */     }
/* 109 */     else if (subTypeTimeFlowMap.containsKey(Integer.valueOf(subType)))
/*     */     {
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     subTypeTimeFlowMap.put(Integer.valueOf(subType), new TimeFlow(type, subType, limitTime, absoluteSteps));
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\main\TimeFlowManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */