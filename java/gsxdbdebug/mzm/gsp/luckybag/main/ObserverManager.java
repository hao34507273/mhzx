/*     */ package mzm.gsp.luckybag.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ 
/*     */ public class ObserverManager
/*     */ {
/*  13 */   private static final ObserverManager instance = new ObserverManager();
/*     */   
/*     */   public static ObserverManager getInstance()
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
/*     */   public boolean putIfAbsent(int activityCfgid, int commonTimeCfgid, Observer observer)
/*     */   {
/*  30 */     this.lock.lock();
/*     */     try
/*     */     {
/*  33 */       Map<Integer, Observer> activityObservers = (Map)this.refreshObservers.get(Integer.valueOf(activityCfgid));
/*  34 */       if (activityObservers == null)
/*     */       {
/*  36 */         activityObservers = new HashMap();
/*  37 */         this.refreshObservers.put(Integer.valueOf(activityCfgid), activityObservers);
/*     */       }
/*     */       boolean bool;
/*  40 */       if (!activityObservers.containsKey(Integer.valueOf(commonTimeCfgid)))
/*     */       {
/*  42 */         activityObservers.put(Integer.valueOf(commonTimeCfgid), observer);
/*  43 */         return true;
/*     */       }
/*  45 */       return false;
/*     */     }
/*     */     finally
/*     */     {
/*  49 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Observer remove(int activityCfgid, int commonTimeCfgid)
/*     */   {
/*  55 */     this.lock.lock();
/*     */     try
/*     */     {
/*  58 */       Map<Integer, Observer> activityObservers = (Map)this.refreshObservers.get(Integer.valueOf(activityCfgid));
/*  59 */       Observer localObserver; if (activityObservers == null)
/*     */       {
/*  61 */         return null;
/*     */       }
/*  63 */       return (Observer)activityObservers.remove(Integer.valueOf(commonTimeCfgid));
/*     */     }
/*     */     finally
/*     */     {
/*  67 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void stop(int activityCfgid)
/*     */   {
/*  73 */     this.lock.lock();
/*     */     try
/*     */     {
/*  76 */       Map<Integer, Observer> activityObservers = (Map)this.refreshObservers.remove(Integer.valueOf(activityCfgid));
/*  77 */       if (activityObservers != null)
/*     */       {
/*  79 */         Iterator<Observer> it = activityObservers.values().iterator();
/*  80 */         while (it.hasNext())
/*     */         {
/*  82 */           ((Observer)it.next()).stopTimer();
/*  83 */           it.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  89 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopAll()
/*     */   {
/*  95 */     this.lock.lock();
/*     */     try
/*     */     {
/*  98 */       Iterator<Map<Integer, Observer>> iterator = this.refreshObservers.values().iterator();
/*  99 */       while (iterator.hasNext())
/*     */       {
/* 101 */         Map<Integer, Observer> activityObservers = (Map)iterator.next();
/* 102 */         iterator.remove();
/*     */         
/* 104 */         Iterator<Observer> it = activityObservers.values().iterator();
/* 105 */         while (it.hasNext())
/*     */         {
/* 107 */           ((Observer)it.next()).stopTimer();
/* 108 */           it.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 114 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\ObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */