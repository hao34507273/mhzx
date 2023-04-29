/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ public class PetEquipConditionManager
/*     */ {
/*  13 */   private static PetEquipConditionManager instance = new PetEquipConditionManager();
/*     */   
/*     */   public static PetEquipConditionManager getInstance()
/*     */   {
/*  17 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  25 */   private final Map<Integer, PetEquipConditionIndex> subid2PetEquipConditionIndex = new java.util.HashMap();
/*     */   
/*  27 */   private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public void addItem(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  31 */     if (xMarketItem == null)
/*     */     {
/*  33 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  38 */       this.lock.writeLock().lock();
/*  39 */       PetEquipConditionIndex petEquipConditionIndex = (PetEquipConditionIndex)this.subid2PetEquipConditionIndex.get(Integer.valueOf(subid));
/*  40 */       if (petEquipConditionIndex == null)
/*     */       {
/*  42 */         petEquipConditionIndex = new PetEquipConditionIndex();
/*  43 */         this.subid2PetEquipConditionIndex.put(Integer.valueOf(subid), petEquipConditionIndex);
/*     */       }
/*  45 */       petEquipConditionIndex.addItem(marketId, xMarketItem, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  50 */       String logStr = String.format("[marketsearch]PetEquipConditionManager.addItem@error occured on addItem|subid=%d|marketId=%d|isPub=%d", new Object[] { Integer.valueOf(subid), Long.valueOf(marketId), Integer.valueOf(isPub ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/*  54 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  58 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItem(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  64 */     if (xMarketItem == null)
/*     */     {
/*  66 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  71 */       this.lock.writeLock().lock();
/*     */       
/*  73 */       PetEquipConditionIndex petEquipConditionIndex = (PetEquipConditionIndex)this.subid2PetEquipConditionIndex.get(Integer.valueOf(subid));
/*  74 */       if (petEquipConditionIndex != null)
/*     */       {
/*  76 */         petEquipConditionIndex.removeItem(marketId, xMarketItem, isPub);
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  82 */       String logStr = String.format("[marketsearch]PetEquipConditionManager.removeItem@error occured on removeItem|subid=%d|marketId=%disPub=%d", new Object[] { Integer.valueOf(subid), Long.valueOf(marketId), Integer.valueOf(isPub ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/*  86 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  90 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.Set<Long> siftByCondition(int subid, PetEquipCondition petEquipCondition, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/*  99 */       this.lock.readLock().lock();
/*     */       
/* 101 */       PetEquipConditionIndex petEquipConditionIndex = (PetEquipConditionIndex)this.subid2PetEquipConditionIndex.get(Integer.valueOf(subid));
/* 102 */       java.util.Set localSet1; if (petEquipConditionIndex != null)
/*     */       {
/* 104 */         return petEquipConditionIndex.siftByCondition(petEquipCondition, isPub);
/*     */       }
/* 106 */       return java.util.Collections.emptySet();
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 111 */       String logStr = String.format("[marketsearch]PetEquipConditionManager.siftByCondition@error occured on siftByCondition|subid=%d|condition=%s|ispub=%d", new Object[] { petEquipCondition.toString(), Integer.valueOf(isPub ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/* 115 */       MarketInterface.getLogger().error(logStr, e);
/* 116 */       return java.util.Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 120 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetEquipConditionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */