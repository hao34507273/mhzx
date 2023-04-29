/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ public class ServerLevelCache
/*     */ {
/*  14 */   private TreeMap<Integer, Long> serverLevel2startTime = new TreeMap(new Comparator()
/*     */   {
/*     */ 
/*     */     public int compare(Integer o1, Integer o2)
/*     */     {
/*  19 */       return o1.intValue() - o2.intValue() > 0 ? 1 : -1;
/*     */     }
/*  14 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  23 */   private static ServerLevelCache instance = new ServerLevelCache();
/*     */   
/*     */   public static ServerLevelCache getInstance()
/*     */   {
/*  27 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  35 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Long updateStartTime(int serverLevel, long startTime)
/*     */   {
/*  46 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  49 */       return (Long)this.serverLevel2startTime.put(Integer.valueOf(serverLevel), Long.valueOf(startTime));
/*     */     }
/*     */     finally
/*     */     {
/*  53 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getCeilStartTime(int serverLevel)
/*     */   {
/*  65 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  68 */       Map.Entry<Integer, Long> entry = this.serverLevel2startTime.ceilingEntry(Integer.valueOf(serverLevel));
/*  69 */       long l; if (entry == null)
/*     */       {
/*  71 */         return -1L;
/*     */       }
/*  73 */       return ((Long)entry.getValue()).longValue();
/*     */     }
/*     */     finally
/*     */     {
/*  77 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void initServerLevelStartTime(Map<Integer, Long> xServerLevel2startTime)
/*     */   {
/*  88 */     if ((xServerLevel2startTime == null) || (xServerLevel2startTime.size() == 0))
/*     */     {
/*  90 */       return;
/*     */     }
/*  92 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  95 */       this.serverLevel2startTime.clear();
/*  96 */       this.serverLevel2startTime.putAll(xServerLevel2startTime);
/*     */     }
/*     */     finally
/*     */     {
/* 100 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Map<Integer, Long> getAllServerLevelInfos()
/*     */   {
/* 106 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 109 */       return this.serverLevel2startTime;
/*     */     }
/*     */     finally
/*     */     {
/* 113 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   String getServerLevelInfoString()
/*     */   {
/* 119 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 122 */       StringBuffer sb = new StringBuffer();
/* 123 */       for (Map.Entry<Integer, Long> entry : this.serverLevel2startTime.entrySet())
/*     */       {
/* 125 */         sb.append(entry.getKey()).append("=").append(getTimeDate(((Long)entry.getValue()).longValue() * 1000L)).append("\r\n");
/*     */       }
/* 127 */       return sb.toString();
/*     */     }
/*     */     finally
/*     */     {
/* 131 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private String getTimeDate(long time)
/*     */   {
/* 137 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 138 */     String startDate = sdf.format(Long.valueOf(time));
/* 139 */     return startDate;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\ServerLevelCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */