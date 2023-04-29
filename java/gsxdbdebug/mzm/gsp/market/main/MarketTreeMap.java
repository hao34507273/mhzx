/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ 
/*     */ public class MarketTreeMap
/*     */ {
/*   9 */   private TreeMap<Integer, Integer> price2numMap = new TreeMap();
/*  10 */   private ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   public void addPriceNum(int price, int num)
/*     */   {
/*  15 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  18 */       if (this.price2numMap.get(Integer.valueOf(price)) == null)
/*     */       {
/*  20 */         this.price2numMap.put(Integer.valueOf(price), Integer.valueOf(num));
/*     */       }
/*     */       else
/*     */       {
/*  24 */         this.price2numMap.put(Integer.valueOf(price), Integer.valueOf(((Integer)this.price2numMap.get(Integer.valueOf(price))).intValue() + num));
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  30 */       String logStr = String.format("[market]MarketTreeMap.addPriceNum@addPriceNum error|price=%d|num=%d", new Object[] { Integer.valueOf(price), Integer.valueOf(num) });
/*     */       
/*  32 */       MarketManager.logger.error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*  37 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void decPriceNum(int price, int num)
/*     */   {
/*  45 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  48 */       Integer curNum = (Integer)this.price2numMap.get(Integer.valueOf(price));
/*  49 */       if (curNum != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  55 */         if (curNum.intValue() - num <= 0)
/*     */         {
/*  57 */           this.price2numMap.remove(Integer.valueOf(price));
/*     */         }
/*     */         else
/*     */         {
/*  61 */           this.price2numMap.put(Integer.valueOf(price), Integer.valueOf(curNum.intValue() - num));
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  69 */       String logStr = String.format("[market]MarketTreeMap.decPriceNum@decPriceNum error|price=%d|num=%d", new Object[] { Integer.valueOf(price), Integer.valueOf(num) });
/*     */       
/*  71 */       MarketManager.logger.error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*  76 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer first()
/*     */   {
/*  83 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*     */       Integer localInteger1;
/*  87 */       if (this.price2numMap.isEmpty())
/*     */       {
/*  89 */         return Integer.valueOf(0);
/*     */       }
/*  91 */       return (Integer)this.price2numMap.firstKey();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  95 */       String logStr = String.format("[market]MarketTreeMap.first@get min price error", new Object[0]);
/*     */       
/*  97 */       MarketManager.logger.error(logStr, e);
/*  98 */       return Integer.valueOf(0);
/*     */     }
/*     */     finally
/*     */     {
/* 102 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer last()
/*     */   {
/* 109 */     this.lock.readLock().lock();
/*     */     try {
/*     */       Integer localInteger1;
/* 112 */       if (this.price2numMap.isEmpty())
/*     */       {
/* 114 */         return Integer.valueOf(0);
/*     */       }
/* 116 */       return (Integer)this.price2numMap.lastKey();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 120 */       String logStr = String.format("[market]MarketTreeMap.last@get max price error", new Object[0]);
/*     */       
/* 122 */       MarketManager.logger.error(logStr, e);
/* 123 */       return Integer.valueOf(0);
/*     */     }
/*     */     finally
/*     */     {
/* 127 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getTotalNum()
/*     */   {
/* 134 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 137 */       int c = 0;
/* 138 */       for (java.util.Iterator i$ = this.price2numMap.values().iterator(); i$.hasNext();) { int i = ((Integer)i$.next()).intValue();
/*     */         
/* 140 */         c += i;
/*     */       }
/* 142 */       return c;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 147 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */