/*     */ package mzm.gsp.firework.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ 
/*     */ public class FObserverManager
/*     */ {
/*  13 */   private static final FObserverManager instance = new FObserverManager();
/*     */   
/*     */   public static FObserverManager getInstance()
/*     */   {
/*  17 */     return instance;
/*     */   }
/*     */   
/*  20 */   private Lock lock = new ReentrantLock();
/*     */   
/*  22 */   private Map<Integer, Map<Integer, Observer>> refreshObservers = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean putIfAbsent(int activityCfgid, int commonTimeCfgid, Observer observer)
/*     */   {
/*  30 */     this.lock.lock();
/*     */     try
/*     */     {
/*  33 */       Map<Integer, Observer> activityObservers = (Map)this.refreshObservers.get(Integer.valueOf(activityCfgid));
/*  34 */       if (activityObservers == null)
/*     */       {
/*  36 */         this.refreshObservers.put(Integer.valueOf(activityCfgid), activityObservers = new HashMap()); }
/*     */       boolean bool;
/*  38 */       if (activityObservers.containsKey(Integer.valueOf(commonTimeCfgid)))
/*     */       {
/*  40 */         return false;
/*     */       }
/*  42 */       activityObservers.put(Integer.valueOf(commonTimeCfgid), observer);
/*  43 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/*  47 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Observer remove(int activityCfgid, int commonTimeCfgid)
/*     */   {
/*  53 */     this.lock.lock();
/*     */     try
/*     */     {
/*  56 */       Map<Integer, Observer> activityObservers = (Map)this.refreshObservers.get(Integer.valueOf(activityCfgid));
/*  57 */       if (activityObservers == null)
/*     */       {
/*  59 */         return null;
/*     */       }
/*  61 */       Observer o = (Observer)activityObservers.remove(Integer.valueOf(commonTimeCfgid));
/*  62 */       if (o != null)
/*     */       {
/*  64 */         o.stopTimer();
/*     */       }
/*  66 */       return o;
/*     */     }
/*     */     finally
/*     */     {
/*  70 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void stop(int activityCfgid)
/*     */   {
/*  76 */     this.lock.lock();
/*     */     try
/*     */     {
/*  79 */       stopAllTimer((Map)this.refreshObservers.remove(Integer.valueOf(activityCfgid)));
/*     */     }
/*     */     finally
/*     */     {
/*  83 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void stopAll()
/*     */   {
/*  89 */     this.lock.lock();
/*     */     try
/*     */     {
/*  92 */       Iterator<Map<Integer, Observer>> it = this.refreshObservers.values().iterator();
/*  93 */       while (it.hasNext())
/*     */       {
/*  95 */         stopAllTimer((Map)it.next());
/*  96 */         it.remove();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 101 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private void stopAllTimer(Map<Integer, Observer> activityObservers)
/*     */   {
/* 107 */     if (activityObservers == null)
/*     */     {
/* 109 */       return;
/*     */     }
/* 111 */     for (Observer o : activityObservers.values())
/*     */     {
/* 113 */       o.stopTimer();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */