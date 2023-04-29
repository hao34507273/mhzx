/*     */ package mzm.gsp.task.ban;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphBanCache
/*     */ {
/*  13 */   private final Set<Integer> banGraphIds = new HashSet();
/*     */   
/*  15 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   private final int banType;
/*     */   
/*     */   GraphBanCache(int banType)
/*     */   {
/*  21 */     this.banType = banType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isGraphForbidden(int graphId)
/*     */   {
/*  33 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  36 */       return this.banGraphIds.contains(Integer.valueOf(graphId));
/*     */     }
/*     */     finally
/*     */     {
/*  40 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void banGraph(int graphId)
/*     */   {
/*  52 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  55 */       this.banGraphIds.add(Integer.valueOf(graphId));
/*     */     }
/*     */     finally
/*     */     {
/*  59 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void banGraphs(Set<Integer> graphIds)
/*     */   {
/*  71 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  74 */       this.banGraphIds.addAll(graphIds);
/*     */     }
/*     */     finally
/*     */     {
/*  78 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void freeGraph(int graphId)
/*     */   {
/*  90 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  93 */       this.banGraphIds.remove(Integer.valueOf(graphId));
/*     */     }
/*     */     finally
/*     */     {
/*  97 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getBanType()
/*     */   {
/* 108 */     return this.banType;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\GraphBanCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */