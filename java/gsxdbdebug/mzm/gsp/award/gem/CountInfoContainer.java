/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountInfoContainer
/*    */ {
/* 21 */   private final Map<Long, ItemCountInfo> gemKey2CountInfo = new HashMap();
/*    */   
/* 23 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 25 */   private static final CountInfoContainer instance = new CountInfoContainer();
/*    */   
/*    */   static CountInfoContainer getInstance()
/*    */   {
/* 29 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   ItemCountInfo getCountInfo(long gemKey)
/*    */   {
/* 44 */     ItemCountInfo countInfo = null;
/*    */     
/* 46 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 49 */       countInfo = (ItemCountInfo)this.gemKey2CountInfo.get(Long.valueOf(gemKey));
/*    */     }
/*    */     finally
/*    */     {
/* 53 */       this.lock.readLock().unlock();
/*    */     }
/* 55 */     if (countInfo != null)
/*    */     {
/* 57 */       return countInfo;
/*    */     }
/*    */     
/* 60 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 63 */       countInfo = (ItemCountInfo)this.gemKey2CountInfo.get(Long.valueOf(gemKey));
/* 64 */       ItemCountInfo localItemCountInfo1; if (countInfo != null)
/*    */       {
/* 66 */         return countInfo;
/*    */       }
/*    */       
/* 69 */       countInfo = new ItemCountInfo(gemKey);
/* 70 */       this.gemKey2CountInfo.put(Long.valueOf(gemKey), countInfo);
/* 71 */       return countInfo;
/*    */     }
/*    */     finally
/*    */     {
/* 75 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\CountInfoContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */