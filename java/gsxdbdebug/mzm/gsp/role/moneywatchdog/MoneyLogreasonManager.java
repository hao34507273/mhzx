/*     */ package mzm.gsp.role.moneywatchdog;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.util.Pair;
/*     */ 
/*     */ public class MoneyLogreasonManager
/*     */ {
/*  14 */   private static final MoneyLogreasonManager instance = new MoneyLogreasonManager();
/*     */   
/*     */   static MoneyLogreasonManager getInstance()
/*     */   {
/*  18 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  24 */   private Map<Integer, Map<Integer, Integer>> logreason2DBType = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*  28 */   private Set<Integer> registerDBTypes = new HashSet();
/*     */   
/*  30 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void registerLogReason2DBType(int mainReason, int subReason, int dbType)
/*     */   {
/*  43 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  46 */       if (this.registerDBTypes.contains(Integer.valueOf(dbType)))
/*     */       {
/*  48 */         throw new RuntimeException(String.format("[role]MoneyLogreasonManager.addLogReason2DBType@ DBType already registered!|reasonValue=%d|subReason=%d|dbType=%d", new Object[] { Integer.valueOf(mainReason), Integer.valueOf(subReason), Integer.valueOf(dbType) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  53 */       Map<Integer, Integer> subMap = (Map)this.logreason2DBType.get(Integer.valueOf(mainReason));
/*  54 */       if (subMap == null)
/*     */       {
/*  56 */         subMap = new HashMap();
/*  57 */         this.logreason2DBType.put(Integer.valueOf(mainReason), subMap);
/*     */       }
/*  59 */       Integer orgValue = (Integer)subMap.get(Integer.valueOf(subReason));
/*  60 */       if (orgValue != null)
/*     */       {
/*  62 */         throw new RuntimeException(String.format("[role]MoneyLogreasonManager.addLogReason2DBType@ logreason already registered!|reasonValue=%d|subReason=%d|dbType=%d|orgValue=%d", new Object[] { Integer.valueOf(mainReason), Integer.valueOf(subReason), Integer.valueOf(dbType), Integer.valueOf(orgValue.intValue()) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  67 */       subMap.put(Integer.valueOf(subReason), Integer.valueOf(dbType));
/*     */     }
/*     */     finally
/*     */     {
/*  71 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getDBType(int mainReason, int subReason)
/*     */   {
/*  88 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  91 */       Map<Integer, Integer> subMap = (Map)this.logreason2DBType.get(Integer.valueOf(mainReason));
/*  92 */       if (subMap == null)
/*     */       {
/*  94 */         return -1;
/*     */       }
/*  96 */       Integer dBType = (Integer)subMap.get(Integer.valueOf(subReason));
/*  97 */       int j; if (dBType != null)
/*     */       {
/*  99 */         return dBType.intValue();
/*     */       }
/* 101 */       dBType = (Integer)subMap.get(new Integer(-1));
/* 102 */       return dBType == null ? -1 : dBType.intValue();
/*     */     }
/*     */     finally
/*     */     {
/* 106 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getDBType(Pair<Integer, Integer> reasons)
/*     */   {
/* 123 */     if (reasons == null)
/*     */     {
/* 125 */       return -1;
/*     */     }
/* 127 */     return getDBType(((Integer)reasons.first).intValue(), ((Integer)reasons.second).intValue());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\MoneyLogreasonManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */