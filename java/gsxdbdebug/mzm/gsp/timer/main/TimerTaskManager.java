/*     */ package mzm.gsp.timer.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ class TimerTaskManager
/*     */ {
/*     */   private final int pollInterval;
/*     */   private final int removeInterval;
/*     */   private int removeCount;
/*     */   private long lastTime;
/*     */   private Map<Long, List<TimerObserver>> _time2ObList;
/*     */   private static volatile TimerTaskManager instance;
/*     */   
/*     */   static TimerTaskManager getInstance()
/*     */   {
/*  23 */     if (instance == null) {
/*  24 */       synchronized (TimerTaskManager.class) {
/*  25 */         if (instance == null) {
/*  26 */           instance = new TimerTaskManager(TimerArgs.getInstance().taskPollInterval, TimerArgs.getInstance().removeInvalidInterval);
/*     */         }
/*     */       }
/*     */     }
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */   TimerTaskManager(int pollInterval, int removeInterval)
/*     */   {
/*  35 */     this.pollInterval = pollInterval;
/*  36 */     this.removeInterval = removeInterval;
/*  37 */     this.removeCount = removeInterval;
/*  38 */     this.lastTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  40 */     this._time2ObList = new TreeMap();
/*     */   }
/*     */   
/*     */   long getAdjustedTime(long milliSeconds)
/*     */   {
/*  45 */     return milliSeconds;
/*     */   }
/*     */   
/*     */   void update(long nowMilliSeconds)
/*     */   {
/*  50 */     if (nowMilliSeconds - this.lastTime < this.pollInterval) {
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     this.lastTime = nowMilliSeconds;
/*  55 */     this.removeCount -= 1;
/*     */     
/*  57 */     long nowTime = this.lastTime;
/*     */     
/*  59 */     ArrayList<Long> removeKeys = new ArrayList();
/*  60 */     ArrayList<TimerObserver> executeObs = new ArrayList();
/*     */     
/*  62 */     synchronized (this._time2ObList) {
/*  63 */       for (Map.Entry<Long, List<TimerObserver>> entry : this._time2ObList.entrySet()) {
/*  64 */         if (((Long)entry.getKey()).longValue() <= nowTime) {
/*  65 */           for (TimerObserver ob : (List)entry.getValue()) {
/*  66 */             if (!ob.needToStop()) {
/*  67 */               executeObs.add(ob);
/*     */             }
/*     */           }
/*  70 */           removeKeys.add(entry.getKey());
/*     */         }
/*     */         else {
/*  73 */           if (this.removeCount >= 0) break;
/*  74 */           List<TimerObserver> removeList = new ArrayList();
/*  75 */           for (TimerObserver ob : (List)entry.getValue()) {
/*  76 */             if (ob.needToStop()) {
/*  77 */               removeList.add(ob);
/*     */             }
/*     */           }
/*  80 */           for (TimerObserver ob : removeList) {
/*  81 */             ((List)entry.getValue()).remove(ob);
/*     */           }
/*  83 */           if (((List)entry.getValue()).isEmpty()) {
/*  84 */             removeKeys.add(entry.getKey());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */       for (Iterator i$ = removeKeys.iterator(); i$.hasNext();) { long key = ((Long)i$.next()).longValue();
/*  96 */         this._time2ObList.remove(Long.valueOf(key));
/*     */       }
/*     */       
/*  99 */       if (this.removeCount < 0) {
/* 100 */         this.removeCount = this.removeInterval;
/*     */       }
/*     */     }
/*     */     
/* 104 */     ArrayList<TimerObserver> newObs = new ArrayList();
/* 105 */     for (TimerObserver ob : executeObs) {
/*     */       try {
/* 107 */         if (ob.update()) {
/* 108 */           newObs.add(ob);
/*     */         }
/*     */       } catch (Exception e) {
/* 111 */         TimerManager.logger.error("Observer update error.", e);
/*     */       }
/*     */     }
/*     */     
/* 115 */     synchronized (this._time2ObList) {
/* 116 */       for (TimerObserver ob : newObs) {
/* 117 */         attachTimerObserver(ob);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected final void attachTimerObserver(TimerObserver ob)
/*     */   {
/* 125 */     if (ob == null) {
/* 126 */       return;
/*     */     }
/* 128 */     long intervalMilliSeconds = ob.getIntervalMilliSeconds();
/* 129 */     if (intervalMilliSeconds < 0L) {
/* 130 */       return;
/*     */     }
/*     */     
/* 133 */     long timeout = DateTimeUtils.getCurrTimeInMillis() + intervalMilliSeconds;
/* 134 */     ob.setTimeoutTimestamp(timeout);
/*     */     
/* 136 */     synchronized (this._time2ObList) {
/* 137 */       List<TimerObserver> list = (List)this._time2ObList.get(Long.valueOf(timeout));
/* 138 */       if (list == null) {
/* 139 */         list = new java.util.LinkedList();
/* 140 */         this._time2ObList.put(Long.valueOf(timeout), list);
/*     */       }
/*     */       
/* 143 */       if (list.contains(ob)) {
/* 144 */         throw new RuntimeException("定时器严重错误！");
/*     */       }
/*     */       
/* 147 */       list.add(ob);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\TimerTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */