/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ 
/*    */ public class JingjiRankCache
/*    */ {
/* 11 */   private static final JingjiRankCache instance = new JingjiRankCache();
/*    */   
/*    */   public static JingjiRankCache getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 23 */   private final List<RoleJingjiChart> roleJingjiChartList = new ArrayList();
/*    */   
/*    */   private long updateTime;
/* 26 */   private final Lock locker = new ReentrantLock();
/*    */   
/*    */   public void updateJingjiCache(List<RoleJingjiChart> roleJingjiCharts, long updateTime)
/*    */   {
/*    */     try
/*    */     {
/* 32 */       this.locker.lock();
/* 33 */       clearCache();
/* 34 */       this.roleJingjiChartList.addAll(roleJingjiCharts);
/* 35 */       this.updateTime = updateTime;
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 40 */       this.locker.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public List<RoleJingjiChart> getAndClearRoleJingjiChartList(long curTime)
/*    */   {
/*    */     try
/*    */     {
/* 48 */       this.locker.lock();
/* 49 */       List<RoleJingjiChart> localList; if ((this.roleJingjiChartList.isEmpty()) || (null == this.roleJingjiChartList))
/*    */       {
/* 51 */         clearCache();
/* 52 */         return null;
/*    */       }
/* 54 */       if (curTime < this.updateTime)
/*    */       {
/* 56 */         clearCache();
/* 57 */         return null;
/*    */       }
/*    */       
/*    */       Object list;
/* 61 */       if (Math.abs(curTime - this.updateTime) <= TimeUnit.MINUTES.toMillis(20L))
/*    */       {
/* 63 */         list = new ArrayList(this.roleJingjiChartList);
/* 64 */         clearCache();
/* 65 */         return (List<RoleJingjiChart>)list;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 70 */       clearCache();
/* 71 */       return null;
/*    */ 
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/*    */ 
/*    */ 
/* 79 */       this.locker.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   private void clearCache()
/*    */   {
/* 85 */     this.roleJingjiChartList.clear();
/* 86 */     this.updateTime = 0L;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiRankCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */