/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketPet;
/*     */ 
/*     */ public class PetConditionManager
/*     */ {
/*  13 */   private static PetConditionManager instance = new PetConditionManager();
/*     */   
/*     */   public static PetConditionManager getInstance()
/*     */   {
/*  17 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  25 */   private final Map<Integer, PetConditionIndex> subid2PetConditionIndex = new java.util.HashMap();
/*     */   
/*  27 */   private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public void addPet(int subid, long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/*  31 */     if (xMarketPet == null)
/*     */     {
/*  33 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  38 */       this.lock.writeLock().lock();
/*  39 */       PetConditionIndex petConditionIndex = (PetConditionIndex)this.subid2PetConditionIndex.get(Integer.valueOf(subid));
/*  40 */       if (petConditionIndex == null)
/*     */       {
/*  42 */         petConditionIndex = new PetConditionIndex();
/*  43 */         this.subid2PetConditionIndex.put(Integer.valueOf(subid), petConditionIndex);
/*     */       }
/*  45 */       petConditionIndex.addPet(marketId, xMarketPet, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  50 */       String logStr = String.format("[marketsearch]PetConditionManager.addPet@error occured on addPet|subid=%d|marketId=%d|isPub=%d", new Object[] { Integer.valueOf(subid), Long.valueOf(marketId), Integer.valueOf(isPub ? 1 : 0) });
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
/*     */   public void removePet(int subid, long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/*  64 */     if (xMarketPet == null)
/*     */     {
/*  66 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  71 */       this.lock.writeLock().lock();
/*     */       
/*  73 */       PetConditionIndex petConditionIndex = (PetConditionIndex)this.subid2PetConditionIndex.get(Integer.valueOf(subid));
/*  74 */       if (petConditionIndex != null)
/*     */       {
/*     */ 
/*  77 */         petConditionIndex.removePet(marketId, xMarketPet, isPub);
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  83 */       String logStr = String.format("[marketsearch]PetConditionManager.removePet@error occured on removePet|subid=%d|marketId=%disPub=%d", new Object[] { Integer.valueOf(subid), Long.valueOf(marketId), Integer.valueOf(isPub ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/*  87 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  91 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.Set<Long> siftByCondition(int subid, PetCondition petCondition, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       this.lock.readLock().lock();
/*     */       
/* 102 */       PetConditionIndex petConditionIndex = (PetConditionIndex)this.subid2PetConditionIndex.get(Integer.valueOf(subid));
/* 103 */       java.util.Set localSet1; if (petConditionIndex != null)
/*     */       {
/*     */ 
/* 106 */         return petConditionIndex.siftByCondition(petCondition, isPub);
/*     */       }
/* 108 */       return java.util.Collections.emptySet();
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 113 */       String logStr = String.format("[marketsearch]PetConditionManager.siftByCondition@error occured on siftByCondition|subid=%d|condition=%s|ispub=%d", new Object[] { petCondition.toString(), Integer.valueOf(isPub ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/* 117 */       MarketInterface.getLogger().error(logStr, e);
/* 118 */       return java.util.Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 122 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetConditionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */