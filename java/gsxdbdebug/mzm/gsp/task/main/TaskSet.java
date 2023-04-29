/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.confbean.SSubSet;
/*     */ import mzm.gsp.task.confbean.STaskSet;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskSet
/*     */ {
/*     */   private int taskSetId;
/*     */   
/*     */   public int getTaskSetId()
/*     */   {
/*  28 */     return this.taskSetId;
/*     */   }
/*     */   
/*     */   public void setTaskSetId(int taskSetId)
/*     */   {
/*  33 */     this.taskSetId = taskSetId;
/*     */   }
/*     */   
/*     */   STaskSet getStaskSet()
/*     */   {
/*  38 */     return STaskSet.get(getTaskSetId());
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
/*     */ 
/*     */   private Map<TaskSubSet, Integer> getSubSetMap()
/*     */   {
/*  53 */     Map<TaskSubSet, Integer> subSetMap = new HashMap();
/*  54 */     STaskSet staskSet = getStaskSet();
/*  55 */     for (SSubSet subSet : staskSet.subSets)
/*     */     {
/*     */ 
/*  58 */       TaskSubSet tasksubSet = new TaskSubSet();
/*  59 */       tasksubSet.setSubSet(subSet);
/*  60 */       subSetMap.put(tasksubSet, Integer.valueOf(subSet.refreshPercent));
/*     */     }
/*  62 */     return subSetMap;
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
/*     */   public Set<Integer> randomCanTakeTaskId(long roleId, Set<Integer> hasTaskIds, int graphId, int oldTaskId)
/*     */   {
/*  75 */     Set<Integer> allHasTaskIDs = new HashSet(hasTaskIds);
/*  76 */     Set<Integer> ret = new HashSet();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  81 */     int level = RoleInterface.getLevel(roleId);
/*  82 */     Map<TaskSubSet, Integer> copySubMap = new HashMap();
/*  83 */     Map<TaskSubSet, Integer> subSetMap = getSubSetMap();
/*  84 */     for (Map.Entry<TaskSubSet, Integer> entry : subSetMap.entrySet())
/*     */     {
/*  86 */       TaskSubSet subset = (TaskSubSet)entry.getKey();
/*  87 */       if (level >= subset.getSubSet().levelMin)
/*     */       {
/*  89 */         if ((subset.getSubSet().levelMax <= 0) || (subset.getSubSet().levelMax >= level))
/*     */         {
/*  91 */           copySubMap.put(subset, entry.getValue());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  97 */     int seed = initSeed(copySubMap);
/*  98 */     if (seed <= 0)
/*     */     {
/* 100 */       return ret;
/*     */     }
/*     */     
/*     */ 
/* 104 */     while ((ret.size() < 1) && (copySubMap.size() > 0))
/*     */     {
/* 106 */       TaskSubSet subSet = randomTaskSubSet(copySubMap, seed);
/* 107 */       if (subSet == null)
/*     */         break;
/* 109 */       Set<Integer> randomSet = subSet.randomCanTakeTaskId(roleId, allHasTaskIDs, graphId, oldTaskId);
/* 110 */       ret.addAll(randomSet);
/* 111 */       allHasTaskIDs.addAll(randomSet);
/* 112 */       copySubMap.remove(subSet);
/* 113 */       seed -= subSet.getSubSet().refreshPercent;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     if (ret.size() > 1)
/*     */     {
/* 122 */       Iterator<Integer> iter = ret.iterator();
/* 123 */       while ((iter.hasNext()) && (ret.size() > 1))
/*     */       {
/* 125 */         iter.remove();
/* 126 */         iter.next();
/*     */       }
/*     */     }
/* 129 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private TaskSubSet randomTaskSubSet(Map<TaskSubSet, Integer> subSetMap, int seed)
/*     */   {
/* 141 */     if ((subSetMap == null) || (subSetMap.size() <= 0))
/*     */     {
/* 143 */       return null;
/*     */     }
/* 145 */     Random random = Xdb.random();
/* 146 */     int ran = random.nextInt(seed);
/* 147 */     int valueNow = 0;
/* 148 */     for (Map.Entry<TaskSubSet, Integer> entry : subSetMap.entrySet())
/*     */     {
/* 150 */       valueNow += ((Integer)entry.getValue()).intValue();
/* 151 */       if (ran < valueNow)
/*     */       {
/* 153 */         return (TaskSubSet)entry.getKey();
/*     */       }
/*     */     }
/*     */     
/* 157 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int initSeed(Map<TaskSubSet, Integer> subSetMap)
/*     */   {
/* 168 */     int seed = 0;
/* 169 */     for (Map.Entry<TaskSubSet, Integer> entry : subSetMap.entrySet())
/*     */     {
/* 171 */       seed += ((Integer)entry.getValue()).intValue();
/*     */     }
/* 173 */     return seed;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */