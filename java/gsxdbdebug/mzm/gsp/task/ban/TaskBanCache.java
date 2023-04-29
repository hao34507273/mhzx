/*     */ package mzm.gsp.task.ban;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class TaskBanCache
/*     */ {
/*  17 */   private final Map<Integer, Set<Integer>> banGraphId2TaskIds = new HashMap();
/*     */   
/*  19 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   private final int banType;
/*     */   
/*     */   TaskBanCache(int banType)
/*     */   {
/*  25 */     this.banType = banType;
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
/*     */   boolean isTaskForbidden(int graphId, int taskId)
/*     */   {
/*  39 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  42 */       Set<Integer> taskIds = (Set)this.banGraphId2TaskIds.get(Integer.valueOf(graphId));
/*  43 */       boolean bool; if (taskIds == null)
/*     */       {
/*  45 */         return false;
/*     */       }
/*  47 */       if (taskIds.size() == 0)
/*     */       {
/*     */ 
/*  50 */         return true;
/*     */       }
/*  52 */       return taskIds.contains(Integer.valueOf(taskId));
/*     */     }
/*     */     finally
/*     */     {
/*  56 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void banAllGraph(int graphId)
/*     */   {
/*  68 */     banTasks(graphId, new HashSet());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void banAllGraph(Set<Integer> graphIds)
/*     */   {
/*  78 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/*  80 */       banAllGraph(graphId);
/*     */     }
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
/*     */   Set<Integer> banTasks(int graphId, Set<Integer> taskIds)
/*     */   {
/*  95 */     if ((graphId <= 0) || (taskIds == null))
/*     */     {
/*  97 */       GameServer.logger().error(String.format("[task]TaskBanCache.isTaskForbidden@ param illegal!|graphId=%d|taskIds=%s", new Object[] { Integer.valueOf(graphId), taskIds == null ? "NULL" : taskIds.toString() }));
/*     */       
/*     */ 
/* 100 */       return null;
/*     */     }
/* 102 */     this.lock.writeLock().lock();
/*     */     
/*     */     try
/*     */     {
/* 106 */       boolean newAddGraph = false;
/* 107 */       Set<Integer> oldBanTaskIds = (Set)this.banGraphId2TaskIds.get(Integer.valueOf(graphId));
/* 108 */       if (oldBanTaskIds == null)
/*     */       {
/* 110 */         oldBanTaskIds = new HashSet();
/* 111 */         this.banGraphId2TaskIds.put(Integer.valueOf(graphId), oldBanTaskIds);
/* 112 */         newAddGraph = true;
/*     */       }
/* 114 */       handleCacheBanTaskIds(taskIds, newAddGraph, oldBanTaskIds);
/* 115 */       return oldBanTaskIds;
/*     */     }
/*     */     finally
/*     */     {
/* 119 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private void handleCacheBanTaskIds(Set<Integer> taskIds, boolean newAddGraph, Set<Integer> oldBanTaskIds)
/*     */   {
/* 125 */     if (taskIds.size() == 0)
/*     */     {
/*     */ 
/* 128 */       oldBanTaskIds.clear();
/* 129 */       return;
/*     */     }
/* 131 */     if (newAddGraph)
/*     */     {
/* 133 */       oldBanTaskIds.addAll(taskIds);
/* 134 */       return;
/*     */     }
/* 136 */     if (oldBanTaskIds.size() == 0)
/*     */     {
/*     */ 
/* 139 */       return;
/*     */     }
/* 141 */     oldBanTaskIds.addAll(taskIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getBanType()
/*     */   {
/* 152 */     return this.banType;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\TaskBanCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */