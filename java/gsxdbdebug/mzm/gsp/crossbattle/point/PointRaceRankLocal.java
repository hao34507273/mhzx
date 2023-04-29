/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.Pair;
/*    */ 
/*    */ public class PointRaceRankLocal
/*    */ {
/* 14 */   private static final PointRaceRankLocal instance = new PointRaceRankLocal();
/*    */   
/*    */   public static PointRaceRankLocal getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 26 */   private ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/* 28 */   private Map<QueryPointRaceInfo, Pair<List<CorpsPointRaceInfo>, Long>> cache = new HashMap();
/*    */   
/*    */   public Pair<List<CorpsPointRaceInfo>, Long> getChart(QueryPointRaceInfo queryPointRaceInfo)
/*    */   {
/* 32 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 35 */       return (Pair)this.cache.get(queryPointRaceInfo);
/*    */     }
/*    */     finally
/*    */     {
/* 39 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public Pair<List<CorpsPointRaceInfo>, Long> putChart(QueryPointRaceInfo queryPointRaceInfo, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*    */   {
/* 46 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 49 */       Pair<List<CorpsPointRaceInfo>, Long> pair = new Pair(corpsPointRaceInfos, Long.valueOf(DateTimeUtils.getCurrTimeInMillis()));
/*    */       
/*    */ 
/* 52 */       return (Pair)this.cache.put(queryPointRaceInfo, pair);
/*    */     }
/*    */     finally
/*    */     {
/* 56 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceRankLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */