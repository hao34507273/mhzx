/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class BestPartner
/*    */ {
/*  8 */   private static final BestPartner instance = new BestPartner();
/*    */   
/*    */   public static BestPartner getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 19 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/*    */   private int partnerCfgid;
/*    */   
/*    */   public int getPartnerCfgid()
/*    */   {
/* 25 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 28 */       return this.partnerCfgid;
/*    */     }
/*    */     finally
/*    */     {
/* 32 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void setPartnerCfgid(int partnerCfgid)
/*    */   {
/* 38 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 41 */       this.partnerCfgid = partnerCfgid;
/*    */     }
/*    */     finally
/*    */     {
/* 45 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\BestPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */