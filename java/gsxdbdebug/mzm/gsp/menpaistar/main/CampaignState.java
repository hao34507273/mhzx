/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class CampaignState
/*    */ {
/*    */   private boolean canJoin;
/*    */   private long lastChampion;
/* 10 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/*    */   public CampaignState(boolean canJoin)
/*    */   {
/* 14 */     this(canJoin, 0L);
/*    */   }
/*    */   
/*    */   public CampaignState(boolean canJoin, long lastChampion)
/*    */   {
/* 19 */     this.canJoin = canJoin;
/* 20 */     this.lastChampion = lastChampion;
/*    */   }
/*    */   
/*    */   public boolean canJoin()
/*    */   {
/* 25 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 28 */       return this.canJoin;
/*    */     }
/*    */     finally
/*    */     {
/* 32 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void canJoin(boolean canJoin)
/*    */   {
/* 38 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 41 */       this.canJoin = canJoin;
/*    */     }
/*    */     finally
/*    */     {
/* 45 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public long getLastChampion()
/*    */   {
/* 51 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 54 */       return this.lastChampion;
/*    */     }
/*    */     finally
/*    */     {
/* 58 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void setLastChampion(long lastChampion)
/*    */   {
/* 64 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 67 */       this.lastChampion = lastChampion;
/*    */     }
/*    */     finally
/*    */     {
/* 71 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\CampaignState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */