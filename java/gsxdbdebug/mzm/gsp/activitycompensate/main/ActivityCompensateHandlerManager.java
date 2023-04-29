/*     */ package mzm.gsp.activitycompensate.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ 
/*     */ class ActivityCompensateHandlerManager
/*     */ {
/*  15 */   private final Map<Integer, ActivityCompensateHandler> activityType2Handler = new HashMap();
/*     */   
/*  17 */   private final Map<Integer, Set<Integer>> switchid2Activities = new HashMap();
/*     */   
/*  19 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*  21 */   private static final ActivityCompensateHandlerManager instance = new ActivityCompensateHandlerManager();
/*     */   
/*     */   static ActivityCompensateHandlerManager getInstance() {
/*  24 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void addHandler(int activityType, ActivityCompensateHandler handler)
/*     */   {
/*  31 */     this.lock.writeLock().lock();
/*     */     try {
/*  33 */       ActivityCompensateHandler old = (ActivityCompensateHandler)this.activityType2Handler.put(Integer.valueOf(activityType), handler);
/*  34 */       if (old != null) {
/*  35 */         String str = String.format("ActivityCompensateHandlerManager.addHandler@duplicated handlers|acitivity_type=%d|old_handler=%s|new_handler=%s", new Object[] { Integer.valueOf(activityType), old, handler });
/*     */         
/*     */ 
/*  38 */         ActivityCompensateManager.logger.error(str);
/*  39 */         throw new RuntimeException(str);
/*     */       }
/*     */     }
/*     */     finally {
/*  43 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void registerActivitySwitches(int activityid, Collection<Integer> switches) {
/*  48 */     this.lock.writeLock().lock();
/*     */     try {
/*  50 */       for (i$ = switches.iterator(); i$.hasNext();) { int switchid = ((Integer)i$.next()).intValue();
/*  51 */         Set<Integer> activities = (Set)this.switchid2Activities.get(Integer.valueOf(switchid));
/*  52 */         if (activities == null) {
/*  53 */           activities = new java.util.HashSet();
/*  54 */           this.switchid2Activities.put(Integer.valueOf(switchid), activities);
/*     */         }
/*  56 */         activities.add(Integer.valueOf(activityid));
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/*  60 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   ActivityCompensateHandler getHandler(int activityType)
/*     */   {
/*  66 */     this.lock.readLock().lock();
/*     */     try {
/*  68 */       return (ActivityCompensateHandler)this.activityType2Handler.get(Integer.valueOf(activityType));
/*     */     }
/*     */     finally {
/*  71 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean containsActivity(int activityType) {
/*  76 */     this.lock.readLock().lock();
/*     */     try {
/*  78 */       return this.activityType2Handler.containsKey(Integer.valueOf(activityType));
/*     */     }
/*     */     finally {
/*  81 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Map<Integer, ActivityCompensateHandler> getAllHandlers()
/*     */   {
/*  87 */     this.lock.readLock().lock();
/*     */     try {
/*  89 */       return new HashMap(this.activityType2Handler);
/*     */     }
/*     */     finally {
/*  92 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   List<Integer> getActivitiesBySwitchid(int switchid) {
/*  97 */     List<Integer> activityList = new ArrayList();
/*  98 */     this.lock.readLock().lock();
/*     */     try {
/* 100 */       Set<Integer> activitySet = (Set)this.switchid2Activities.get(Integer.valueOf(switchid));
/* 101 */       if (activitySet != null) {
/* 102 */         activityList.addAll(activitySet);
/*     */       }
/*     */     }
/*     */     finally {
/* 106 */       this.lock.readLock().unlock();
/*     */     }
/* 108 */     return activityList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\ActivityCompensateHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */