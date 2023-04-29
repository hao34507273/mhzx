/*     */ package mzm.gsp.storageexp.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StorageStateCache
/*     */ {
/*  18 */   static int STATE_NULL = 0;
/*  19 */   static int STATE_ONLINE = 1;
/*  20 */   static int STATE_NORMAL = 2;
/*     */   
/*  22 */   private volatile Map<Long, Integer> role2State = new HashMap();
/*     */   
/*  24 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*  26 */   private static volatile StorageStateCache instance = null;
/*     */   
/*     */   public static StorageStateCache getInstance()
/*     */   {
/*  30 */     if (instance == null)
/*     */     {
/*  32 */       synchronized (StorageStateCache.class)
/*     */       {
/*     */ 
/*  35 */         if (instance == null)
/*     */         {
/*  37 */           instance = new StorageStateCache();
/*     */         }
/*     */       }
/*     */     }
/*  41 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getState(long roleId)
/*     */   {
/*  51 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  54 */       Integer state = (Integer)this.role2State.get(Long.valueOf(roleId));
/*  55 */       int i; if (state == null)
/*     */       {
/*  57 */         return STATE_NULL;
/*     */       }
/*  59 */       return state.intValue();
/*     */     }
/*     */     finally
/*     */     {
/*  63 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOnlineState(long roleId)
/*     */   {
/*  74 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  77 */       Integer state = (Integer)this.role2State.get(Long.valueOf(roleId));
/*  78 */       boolean bool; if (state == null)
/*     */       {
/*  80 */         return false;
/*     */       }
/*  82 */       return STATE_ONLINE == state.intValue();
/*     */     }
/*     */     finally
/*     */     {
/*  86 */       this.lock.readLock().unlock();
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
/*     */   public void setState(long roleId, int state)
/*     */   {
/*  99 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 102 */       this.role2State.put(Long.valueOf(roleId), Integer.valueOf(state));
/*     */     }
/*     */     finally
/*     */     {
/* 106 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void delState(long roleId)
/*     */   {
/* 117 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 120 */       this.role2State.remove(Long.valueOf(roleId));
/*     */     }
/*     */     finally
/*     */     {
/* 124 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\StorageStateCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */