/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ 
/*    */ public class ItemSubIdDropcCounter
/*    */ {
/* 12 */   private static final ItemSubIdDropcCounter instance = new ItemSubIdDropcCounter();
/*    */   
/*    */   public static ItemSubIdDropcCounter getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 24 */   private final Map<Integer, ItemSubidObject> itemSubid2object = new HashMap();
/*    */   
/* 26 */   private final MyReadWriteLock locker = new MyReadWriteLock(null);
/*    */   
/*    */   public ItemSubidObject getItemSubidObject(int itemSubId)
/*    */   {
/* 30 */     this.locker.readLock().lock();
/*    */     ItemSubidObject localItemSubidObject1;
/*    */     try {
/* 33 */       ItemSubidObject itemInfo = (ItemSubidObject)this.itemSubid2object.get(Integer.valueOf(itemSubId));
/* 34 */       if (itemInfo != null)
/*    */       {
/* 36 */         return itemInfo;
/*    */       }
/*    */       
/*    */     }
/*    */     finally
/*    */     {
/* 42 */       this.locker.readLock().unlock();
/*    */     }
/*    */     
/* 45 */     this.locker.writeLock().lock();
/*    */     try
/*    */     {
/* 48 */       ItemSubidObject itemInfo = (ItemSubidObject)this.itemSubid2object.get(Integer.valueOf(itemSubId));
/* 49 */       if (itemInfo != null)
/*    */       {
/* 51 */         return itemInfo;
/*    */       }
/*    */       
/*    */ 
/* 55 */       itemInfo = new ItemSubidObject(itemSubId, 0, 0, 0);
/* 56 */       this.itemSubid2object.put(Integer.valueOf(itemSubId), itemInfo);
/* 57 */       return itemInfo;
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 62 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   void initItemSubidObject(int itemSubId, int unHitCount, int dropCount, int historyDropCount)
/*    */   {
/* 69 */     this.locker.writeLock().lock();
/*    */     
/*    */     try
/*    */     {
/* 73 */       ItemSubidObject itemInfo = new ItemSubidObject(itemSubId, unHitCount, dropCount, historyDropCount);
/* 74 */       this.itemSubid2object.put(Integer.valueOf(itemSubId), itemInfo);
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 79 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   private static class MyReadWriteLock implements ReadWriteLock
/*    */   {
/* 85 */     private final ReadWriteLock locker = new ReentrantReadWriteLock();
/*    */     
/*    */ 
/*    */     public Lock readLock()
/*    */     {
/* 90 */       return this.locker.readLock();
/*    */     }
/*    */     
/*    */ 
/*    */     public Lock writeLock()
/*    */     {
/* 96 */       return this.locker.writeLock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\ItemSubIdDropcCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */