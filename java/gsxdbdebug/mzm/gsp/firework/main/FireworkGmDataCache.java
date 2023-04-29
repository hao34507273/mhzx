/*     */ package mzm.gsp.firework.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*     */ 
/*     */ public class FireworkGmDataCache
/*     */ {
/*  12 */   private static final FireworkGmDataCache instance = new FireworkGmDataCache();
/*     */   
/*     */   public static FireworkGmDataCache getInstance()
/*     */   {
/*  16 */     return instance;
/*     */   }
/*     */   
/*  19 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*  21 */   private volatile boolean isGmed = false;
/*     */   
/*  23 */   private final Map<Integer, ActivityData> activityGMDatas = new HashMap();
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
/*     */   public boolean isGmed()
/*     */   {
/*  37 */     return this.isGmed;
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
/*     */   String setNewData(int activityId, int findLastInterval, int triggerCount, int triggerShowNeedCount)
/*     */   {
/*  51 */     this.isGmed = true;
/*  52 */     ActivityData activityData = getActivityGMData(activityId);
/*  53 */     activityData.setCache(findLastInterval, triggerCount, triggerShowNeedCount);
/*  54 */     return activityData.getActivityDataString();
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
/*     */   ActivityData getActivityGMData(int activityId)
/*     */   {
/*  69 */     ActivityData activityData = null;
/*     */     
/*  71 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  74 */       activityData = (ActivityData)this.activityGMDatas.get(Integer.valueOf(activityId));
/*     */     }
/*     */     finally
/*     */     {
/*  78 */       this.lock.readLock().unlock();
/*     */     }
/*  80 */     if (activityData != null)
/*     */     {
/*  82 */       return activityData;
/*     */     }
/*     */     
/*  85 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  88 */       activityData = (ActivityData)this.activityGMDatas.get(Integer.valueOf(activityId));
/*  89 */       ActivityData localActivityData1; if (activityData != null)
/*     */       {
/*  91 */         return activityData;
/*     */       }
/*     */       
/*  94 */       activityData = new ActivityData(activityId);
/*  95 */       this.activityGMDatas.put(Integer.valueOf(activityId), activityData);
/*  96 */       return activityData;
/*     */     }
/*     */     finally
/*     */     {
/* 100 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class ActivityData
/*     */   {
/*     */     private final int activityId;
/* 108 */     private volatile int findLastInterval = -1;
/* 109 */     private volatile int triggerCount = -1;
/* 110 */     private volatile int triggerShowNeedCount = -1;
/*     */     
/* 112 */     private final ReadWriteLock ActivityDatalock = new ReentrantReadWriteLock();
/*     */     
/*     */     public ActivityData(int activityId)
/*     */     {
/* 116 */       this.activityId = activityId;
/*     */     }
/*     */     
/*     */     void setCache(int findLastInteral, int triggerCount, int triggerShowNeedCount)
/*     */     {
/* 121 */       this.ActivityDatalock.writeLock().lock();
/*     */       try
/*     */       {
/* 124 */         this.findLastInterval = findLastInteral;
/* 125 */         this.triggerCount = triggerCount;
/* 126 */         this.triggerShowNeedCount = triggerShowNeedCount;
/*     */       }
/*     */       finally
/*     */       {
/* 130 */         this.ActivityDatalock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     public int get_FindLastInterval(SFireworkCfg cfg)
/*     */     {
/* 136 */       this.ActivityDatalock.readLock().lock();
/*     */       try
/*     */       {
/* 139 */         return this.findLastInterval <= 0 ? cfg.findTime : this.findLastInterval;
/*     */       }
/*     */       finally
/*     */       {
/* 143 */         this.ActivityDatalock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     public int get_TriggerCount(SFireworkCfg cfg)
/*     */     {
/* 149 */       this.ActivityDatalock.readLock().lock();
/*     */       try
/*     */       {
/* 152 */         return this.triggerCount <= 0 ? cfg.totalCount : this.triggerCount;
/*     */       }
/*     */       finally
/*     */       {
/* 156 */         this.ActivityDatalock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     public int get_TriggerShowNeedCount(SFireworkCfg cfg)
/*     */     {
/* 162 */       this.ActivityDatalock.readLock().lock();
/*     */       try
/*     */       {
/* 165 */         return this.triggerShowNeedCount <= 0 ? cfg.needCount : this.triggerShowNeedCount;
/*     */       }
/*     */       finally
/*     */       {
/* 169 */         this.ActivityDatalock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     String getActivityDataString()
/*     */     {
/* 175 */       SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/* 176 */       if (cfg == null)
/*     */       {
/* 178 */         return String.format("该活动不存在！|活动id=%d", new Object[] { Integer.valueOf(this.activityId) });
/*     */       }
/*     */       
/* 181 */       StringBuffer sb = new StringBuffer();
/* 182 */       this.ActivityDatalock.readLock().lock();
/*     */       try
/*     */       {
/* 185 */         sb.append("找烟花时长:");
/* 186 */         sb.append(this.findLastInterval <= 0 ? cfg.findTime : this.findLastInterval);
/* 187 */         sb.append("秒|");
/* 188 */         sb.append("采集物个数:");
/* 189 */         sb.append(this.triggerCount <= 0 ? cfg.totalCount : this.triggerCount);
/* 190 */         sb.append("|");
/* 191 */         sb.append("烟花表演所需采集物个数:");
/* 192 */         sb.append(this.triggerShowNeedCount <= 0 ? cfg.needCount : this.triggerShowNeedCount);
/*     */       }
/*     */       finally
/*     */       {
/* 196 */         this.ActivityDatalock.readLock().unlock();
/*     */       }
/* 198 */       return sb.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   int getFindLastInterval(SFireworkCfg cfg)
/*     */   {
/* 204 */     if (!isGmed())
/*     */     {
/* 206 */       return cfg.findTime;
/*     */     }
/* 208 */     return getActivityGMData(cfg.activityId).get_FindLastInterval(cfg);
/*     */   }
/*     */   
/*     */   int getTriggerCount(SFireworkCfg cfg)
/*     */   {
/* 213 */     if (!isGmed())
/*     */     {
/* 215 */       return cfg.totalCount;
/*     */     }
/* 217 */     return getActivityGMData(cfg.activityId).get_TriggerCount(cfg);
/*     */   }
/*     */   
/*     */   int getTriggerShowNeedCount(SFireworkCfg cfg)
/*     */   {
/* 222 */     if (!isGmed())
/*     */     {
/* 224 */       return cfg.needCount;
/*     */     }
/* 226 */     return getActivityGMData(cfg.activityId).get_TriggerShowNeedCount(cfg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireworkGmDataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */