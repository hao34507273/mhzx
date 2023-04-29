/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ 
/*     */ 
/*     */ public class ItemSubidObject
/*     */ {
/*     */   private final int itemSubid;
/*  12 */   private int unHitCount = 0;
/*  13 */   private int dropCount = 0;
/*  14 */   private int historyDropCount = 0;
/*     */   
/*     */   public ItemSubidObject(int itemSubId)
/*     */   {
/*  18 */     this.itemSubid = itemSubId;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemSubidObject(int itemSubId, int unHitCount, int dropCount, int historyDropCount)
/*     */   {
/*  24 */     this.itemSubid = itemSubId;
/*  25 */     this.unHitCount = unHitCount;
/*  26 */     this.dropCount = dropCount;
/*  27 */     this.historyDropCount = historyDropCount;
/*     */   }
/*     */   
/*     */ 
/*  31 */   private final ReadWriteLock lock = new MyReadWriteLock();
/*     */   
/*     */   public boolean canDrop(int preciousCfgId)
/*     */   {
/*  35 */     this.lock.readLock().lock();
/*     */     
/*     */     try
/*     */     {
/*  39 */       SPreciousDropCfg peCfg = SPreciousDropCfg.get(preciousCfgId);
/*  40 */       if (peCfg == null)
/*     */       {
/*  42 */         return false;
/*     */       }
/*     */       
/*  45 */       int serverMaxDropCount = 0;
/*  46 */       int serverDropNeedCount = 0;
/*  47 */       if (this.historyDropCount >= peCfg.serverMaxDropCount1)
/*     */       {
/*  49 */         serverMaxDropCount = peCfg.serverMaxDropCount2;
/*  50 */         serverDropNeedCount = peCfg.serverDropNeedCount2;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  55 */         serverMaxDropCount = peCfg.serverMaxDropCount1;
/*  56 */         serverDropNeedCount = peCfg.serverDropNeedCount1;
/*     */       }
/*     */       boolean bool2;
/*  59 */       if (this.dropCount >= serverMaxDropCount)
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       if (this.unHitCount < serverDropNeedCount)
/*     */       {
/*  66 */         return false;
/*     */       }
/*     */       
/*  69 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/*  73 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getUnHitCount()
/*     */   {
/*  79 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  82 */       return this.unHitCount;
/*     */     }
/*     */     finally
/*     */     {
/*  86 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getDropCount()
/*     */   {
/*  92 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  95 */       return this.dropCount;
/*     */     }
/*     */     finally
/*     */     {
/*  99 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getHistoryDropCount()
/*     */   {
/* 105 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 108 */       return this.historyDropCount;
/*     */     }
/*     */     finally
/*     */     {
/* 112 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addDropCount()
/*     */   {
/* 118 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 121 */       this.unHitCount = 0;
/* 122 */       this.dropCount += 1;
/* 123 */       this.historyDropCount += 1;
/*     */       
/* 125 */       AwardPoolManager.tlogServerDrop(this.itemSubid, this.dropCount, this.historyDropCount, this.unHitCount, true);
/* 126 */       Itemsubid2countDBSaver.writeRecdor(this.itemSubid, this.unHitCount, this.dropCount, this.historyDropCount);
/*     */     }
/*     */     finally
/*     */     {
/* 130 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addUnHitCount()
/*     */   {
/* 136 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 139 */       this.unHitCount += 1;
/* 140 */       AwardPoolManager.tlogServerDrop(this.itemSubid, this.dropCount, this.historyDropCount, this.unHitCount, false);
/* 141 */       Itemsubid2countDBSaver.writeRecdor(this.itemSubid, this.unHitCount, this.dropCount, this.historyDropCount);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 146 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setUnHitCount(int count)
/*     */   {
/* 152 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 155 */       this.unHitCount = count;
/*     */       
/* 157 */       Itemsubid2countDBSaver.writeRecdor(this.itemSubid, this.unHitCount, this.dropCount, this.historyDropCount);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 162 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void resetItemSubIdObject()
/*     */   {
/* 168 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 171 */       this.unHitCount = 0;
/* 172 */       this.dropCount = 0;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 177 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void resetItemSubIdObject(int unHitCount, int dropCount, int historyDropCount)
/*     */   {
/* 183 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 186 */       this.unHitCount = unHitCount;
/* 187 */       this.dropCount = dropCount;
/* 188 */       this.historyDropCount = historyDropCount;
/* 189 */       Itemsubid2countDBSaver.writeRecdor(this.itemSubid, unHitCount, dropCount, historyDropCount);
/*     */     }
/*     */     finally
/*     */     {
/* 193 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static class MyReadWriteLock implements ReadWriteLock
/*     */   {
/* 199 */     private final Lock locker = new ReentrantLock();
/*     */     
/*     */ 
/*     */     public Lock readLock()
/*     */     {
/* 204 */       return this.locker;
/*     */     }
/*     */     
/*     */ 
/*     */     public Lock writeLock()
/*     */     {
/* 210 */       return this.locker;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\ItemSubidObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */