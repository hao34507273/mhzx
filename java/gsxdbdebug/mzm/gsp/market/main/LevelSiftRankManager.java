/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ class LevelSiftRankManager
/*     */ {
/*   8 */   private static final Map<Integer, SubtypeLevelRankManager> subid2PubRankManager = new java.util.HashMap();
/*     */   
/*  10 */   private static final Map<Integer, SubtypeLevelRankManager> subid2SellRankManager = new java.util.HashMap();
/*     */   
/*     */ 
/*     */   static void init(int subid, int capacity, int levelDelta)
/*     */   {
/*  15 */     subid2PubRankManager.put(Integer.valueOf(subid), new SubtypeLevelRankManager());
/*  16 */     subid2SellRankManager.put(Integer.valueOf(subid), new SubtypeLevelRankManager());
/*     */   }
/*     */   
/*     */   static void rankPub(int subid, long marketId, int level, int price)
/*     */   {
/*  21 */     SubtypeLevelRankManager subtypeLevelRankManager = (SubtypeLevelRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*  22 */     if (subtypeLevelRankManager != null)
/*     */     {
/*  24 */       subtypeLevelRankManager.rank(new MarketLevelPriceChart(marketId, level, price));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  29 */       String logStr = String.format("[market]LevelSiftRankManager.rankPub@null  error", new Object[0]);
/*     */       
/*  31 */       MarketManager.logger.error(logStr);
/*     */     }
/*     */   }
/*     */   
/*     */   static void rankSell(int subid, long marketId, int level, int price)
/*     */   {
/*  37 */     SubtypeLevelRankManager subtypeLevelRankManager = (SubtypeLevelRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*  38 */     if (subtypeLevelRankManager != null)
/*     */     {
/*  40 */       subtypeLevelRankManager.rank(new MarketLevelPriceChart(marketId, level, price));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  45 */       String logStr = String.format("[market]LevelSiftRankManager.rankSell@null  error", new Object[0]);
/*     */       
/*  47 */       MarketManager.logger.error(logStr);
/*     */     }
/*     */   }
/*     */   
/*     */   static void deletePub(int subid, long marketId, int level)
/*     */   {
/*  53 */     SubtypeLevelRankManager subtypeLevelRankManager = (SubtypeLevelRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */     
/*  55 */     if (subtypeLevelRankManager != null)
/*     */     {
/*  57 */       subtypeLevelRankManager.delete(marketId, level);
/*     */     }
/*     */     else
/*     */     {
/*  61 */       String logStr = String.format("[market]LevelSiftRankManager.deletePub@null  error", new Object[0]);
/*     */       
/*  63 */       MarketManager.logger.error(logStr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void deleteSell(int subid, long marketId, int level)
/*     */   {
/*  70 */     SubtypeLevelRankManager subtypeLevelRankManager = (SubtypeLevelRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*  71 */     if (subtypeLevelRankManager != null)
/*     */     {
/*  73 */       subtypeLevelRankManager.delete(marketId, level);
/*     */     }
/*     */     else
/*     */     {
/*  77 */       String logStr = String.format("[market]LevelSiftRankManager.deleteSell@null  error", new Object[0]);
/*     */       
/*  79 */       MarketManager.logger.error(logStr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static SubtypeLevelRankManager getPubRankManager(int subid)
/*     */   {
/*  86 */     return (SubtypeLevelRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */   }
/*     */   
/*     */   static SubtypeLevelRankManager getSellRankManager(int subid)
/*     */   {
/*  91 */     return (SubtypeLevelRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */   }
/*     */   
/*     */   static int getPubSize(int subid)
/*     */   {
/*  96 */     SubtypeLevelRankManager subtypeLevelRankManager = (SubtypeLevelRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*  97 */     if (subtypeLevelRankManager != null)
/*     */     {
/*  99 */       return subtypeLevelRankManager.getTotalSize();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 104 */     String logStr = String.format("[market]LevelSiftRankManager.getPubSize@null  error", new Object[0]);
/*     */     
/* 106 */     MarketManager.logger.error(logStr);
/* 107 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static int getSellSize(int subid)
/*     */   {
/* 114 */     SubtypeLevelRankManager subtypeLevelRankManager = (SubtypeLevelRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/* 115 */     if (subtypeLevelRankManager != null)
/*     */     {
/* 117 */       return subtypeLevelRankManager.getTotalSize();
/*     */     }
/*     */     
/*     */ 
/* 121 */     String logStr = String.format("[market]LevelSiftRankManager.getSellSize@null  error", new Object[0]);
/*     */     
/* 123 */     MarketManager.logger.error(logStr);
/* 124 */     return 0;
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
/*     */   public static int getPrice(int subid, int level, long marketId, boolean isPub)
/*     */   {
/* 138 */     SubtypeLevelRankManager subtypeLevelRankManager = null;
/* 139 */     if (isPub)
/*     */     {
/* 141 */       subtypeLevelRankManager = (SubtypeLevelRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */     }
/*     */     else
/*     */     {
/* 145 */       subtypeLevelRankManager = (SubtypeLevelRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */     }
/* 147 */     if (subtypeLevelRankManager == null)
/*     */     {
/* 149 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 153 */     return subtypeLevelRankManager.getPrice(level, marketId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\LevelSiftRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */