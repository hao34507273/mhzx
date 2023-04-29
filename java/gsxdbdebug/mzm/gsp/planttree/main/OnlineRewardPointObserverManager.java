/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OnlineRewardPointObserverManager
/*     */ {
/*  15 */   private static OnlineRewardPointObserverManager instance = new OnlineRewardPointObserverManager();
/*     */   
/*     */   static OnlineRewardPointObserverManager getInstance()
/*     */   {
/*  19 */     return instance;
/*     */   }
/*     */   
/*  22 */   private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
/*  23 */   private final Map<Long, RoleOnlineRewardPointObservers> observers = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void startObserver(long roleid, int activityCfgid)
/*     */   {
/*  34 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  37 */       RoleOnlineRewardPointObservers roleObservers = (RoleOnlineRewardPointObservers)this.observers.get(Long.valueOf(roleid));
/*  38 */       if (roleObservers != null)
/*     */       {
/*  40 */         roleObservers.startObserver(activityCfgid); return;
/*     */       }
/*     */       
/*     */     }
/*     */     finally
/*     */     {
/*  46 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */     
/*  49 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  52 */       RoleOnlineRewardPointObservers roleObservers = (RoleOnlineRewardPointObservers)this.observers.get(Long.valueOf(roleid));
/*  53 */       if (roleObservers != null)
/*     */       {
/*  55 */         roleObservers.startObserver(activityCfgid);
/*     */       }
/*     */       else {
/*  58 */         roleObservers = new RoleOnlineRewardPointObservers(roleid);
/*  59 */         this.observers.put(Long.valueOf(roleid), roleObservers);
/*  60 */         roleObservers.startObserver(activityCfgid);
/*     */       }
/*     */     }
/*     */     finally {
/*  64 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void stopObserver(long roleid, int activityCfgid)
/*     */   {
/*  76 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  79 */       RoleOnlineRewardPointObservers roleObservers = (RoleOnlineRewardPointObservers)this.observers.get(Long.valueOf(roleid));
/*  80 */       if (roleObservers != null)
/*     */       {
/*  82 */         roleObservers.stopObserver(activityCfgid);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  87 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void stopAllObserver(long roleid)
/*     */   {
/*  98 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 101 */       RoleOnlineRewardPointObservers roleObservers = (RoleOnlineRewardPointObservers)this.observers.get(Long.valueOf(roleid));
/* 102 */       if (roleObservers != null)
/*     */       {
/* 104 */         roleObservers.stopAllObserver();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 109 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\OnlineRewardPointObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */