/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class OneByOneManager<Key>
/*     */ {
/*  17 */   private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*     */   
/*  19 */   private Map<Key, TaskOneByOne> oneByOneMap = new LinkedHashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addLogicProcedure(Key key, LogicProcedure logicProcedure)
/*     */   {
/*  28 */     getTaskOneByOne(key).add(logicProcedure);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addLogicRunnable(Key key, LogicRunnable logicRunnable)
/*     */   {
/*  38 */     getTaskOneByOne(key).add(logicRunnable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TaskOneByOne getTaskOneByOne(Key key)
/*     */   {
/*  48 */     boolean needAddOneByOne = false;
/*  49 */     TaskOneByOne taskOneByOne = null;
/*  50 */     this.readWriteLock.readLock().lock();
/*     */     try {
/*  52 */       taskOneByOne = (TaskOneByOne)this.oneByOneMap.get(key);
/*  53 */       if (taskOneByOne == null) {
/*  54 */         needAddOneByOne = true;
/*     */       } else {
/*  56 */         return taskOneByOne;
/*     */       }
/*     */     } finally {
/*  59 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/*  62 */     if (needAddOneByOne) {
/*  63 */       taskOneByOne = addTaskOneByOne(key);
/*     */     }
/*  65 */     return taskOneByOne;
/*     */   }
/*     */   
/*     */   private TaskOneByOne addTaskOneByOne(Key key) {
/*  69 */     TaskOneByOne taskOneByOne = null;
/*  70 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/*  72 */       taskOneByOne = (TaskOneByOne)this.oneByOneMap.get(key);
/*     */       int maxCacheSize;
/*  74 */       if (taskOneByOne == null)
/*     */       {
/*  76 */         maxCacheSize = getRecomendCacheSize();
/*  77 */         if (maxCacheSize > 0) {
/*  78 */           int subSize = this.oneByOneMap.size() - maxCacheSize;
/*  79 */           if (subSize > 0) {
/*  80 */             Iterator<Map.Entry<Key, TaskOneByOne>> iterator = this.oneByOneMap.entrySet().iterator();
/*  81 */             while ((iterator.hasNext()) && (subSize > 0)) {
/*  82 */               Map.Entry<Key, TaskOneByOne> entry = (Map.Entry)iterator.next();
/*  83 */               if (((TaskOneByOne)entry.getValue()).size() <= 0) {
/*  84 */                 iterator.remove();
/*  85 */                 subSize--;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*  90 */         taskOneByOne = new TaskOneByOne();
/*  91 */         this.oneByOneMap.put(key, taskOneByOne);
/*     */       }
/*     */       
/*  94 */       return taskOneByOne;
/*     */     } finally {
/*  96 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TaskOneByOne remTaskOneByOne(Key key)
/*     */   {
/* 107 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 109 */       return (TaskOneByOne)this.oneByOneMap.remove(key);
/*     */     } finally {
/* 111 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract int getRecomendCacheSize();
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\OneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */