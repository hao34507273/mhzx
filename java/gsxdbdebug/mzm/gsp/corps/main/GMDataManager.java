/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.corps.confbean.CorpsConsts;
/*    */ 
/*    */ public class GMDataManager
/*    */ {
/* 10 */   private static final GMDataManager instance = new GMDataManager();
/*    */   
/* 12 */   private volatile boolean isDebug = false;
/*    */   
/* 14 */   private int createMinPeopleNum = CorpsConsts.getInstance().MIN_GUY_NUM;
/*    */   
/* 16 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/*    */   static GMDataManager getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   int getCreateMinPeopleNum()
/*    */   {
/* 30 */     if (!this.isDebug)
/*    */     {
/* 32 */       return CorpsConsts.getInstance().MIN_GUY_NUM;
/*    */     }
/* 34 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 37 */       return this.createMinPeopleNum;
/*    */     }
/*    */     finally
/*    */     {
/* 41 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void setCreateMinPeopleNum(int num)
/*    */   {
/* 52 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 55 */       this.isDebug = true;
/* 56 */       this.createMinPeopleNum = num;
/*    */     }
/*    */     finally
/*    */     {
/* 60 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\GMDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */