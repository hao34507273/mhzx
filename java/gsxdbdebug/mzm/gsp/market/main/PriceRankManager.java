/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PriceRankManager
/*     */ {
/*  16 */   private static final Map<Integer, SubtypeMarketRankManager> subid2PubRankManager = new HashMap();
/*     */   
/*  18 */   private static final Map<Integer, SubtypeMarketRankManager> subid2SellRankManager = new HashMap();
/*     */   
/*     */ 
/*     */   static void init(int subid, int capacity)
/*     */   {
/*  23 */     subid2PubRankManager.put(Integer.valueOf(subid), new SubtypeMarketRankManager(capacity, MarketManager.getPageSize()));
/*  24 */     subid2SellRankManager.put(Integer.valueOf(subid), new SubtypeMarketRankManager(capacity, MarketManager.getPageSize()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SubtypeMarketRankManager getPubRankManager(int subid)
/*     */   {
/*  35 */     return (SubtypeMarketRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SubtypeMarketRankManager getSellRankManager(int subid)
/*     */   {
/*  46 */     return (SubtypeMarketRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */   }
/*     */   
/*     */   static boolean rankSell(int subid, long marketId, int price)
/*     */   {
/*  51 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */     
/*  53 */     if (rankManager == null)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     return rankManager.rank(new MarketPriceChart(marketId, price));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean rankPub(int subid, long marketId, int price)
/*     */   {
/*  66 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */     
/*  68 */     if (rankManager == null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     return rankManager.rank(new MarketPriceChart(marketId, price));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean deleteSell(int subid, long marketId)
/*     */   {
/*  81 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */     
/*  83 */     if (rankManager == null)
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     return rankManager.delete(Long.valueOf(marketId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean deletePub(int subid, long marketId)
/*     */   {
/*  96 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */     
/*  98 */     if (rankManager == null)
/*     */     {
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     return rankManager.delete(Long.valueOf(marketId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static int getSellSize(int subid)
/*     */   {
/* 111 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */     
/* 113 */     if (rankManager == null)
/*     */     {
/* 115 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 119 */     return rankManager.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static int getPubSize(int subid)
/*     */   {
/* 126 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */     
/* 128 */     if (rankManager == null)
/*     */     {
/* 130 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 134 */     return rankManager.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static List<MarketPriceChart> getByPage(int subid, int pageIndex, boolean isPub, boolean isAsc)
/*     */   {
/* 141 */     if (isPub)
/*     */     {
/* 143 */       SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */       
/* 145 */       if (rankManager == null)
/*     */       {
/* 147 */         return Collections.emptyList();
/*     */       }
/*     */       
/*     */ 
/* 151 */       if (isAsc)
/*     */       {
/* 153 */         return rankManager.getAscendRankObjs(pageIndex);
/*     */       }
/*     */       
/*     */ 
/* 157 */       return rankManager.getDesendRankObjs(pageIndex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */     SubtypeMarketRankManager rankManager = (SubtypeMarketRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */     
/* 166 */     if (rankManager == null)
/*     */     {
/* 168 */       return Collections.emptyList();
/*     */     }
/*     */     
/*     */ 
/* 172 */     if (isAsc)
/*     */     {
/* 174 */       return rankManager.getAscendRankObjs(pageIndex);
/*     */     }
/*     */     
/*     */ 
/* 178 */     return rankManager.getDesendRankObjs(pageIndex);
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
/*     */ 
/*     */ 
/*     */   static int getPrice(int subid, long marketId, boolean isPub)
/*     */   {
/* 196 */     SubtypeMarketRankManager rankManager = null;
/* 197 */     if (isPub)
/*     */     {
/* 199 */       rankManager = (SubtypeMarketRankManager)subid2PubRankManager.get(Integer.valueOf(subid));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 204 */       rankManager = (SubtypeMarketRankManager)subid2SellRankManager.get(Integer.valueOf(subid));
/*     */     }
/*     */     
/* 207 */     if (rankManager == null)
/*     */     {
/* 209 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 213 */     MarketPriceChart marketPriceChart = (MarketPriceChart)rankManager.getObjByKey(Long.valueOf(marketId));
/* 214 */     if (marketPriceChart != null)
/*     */     {
/* 216 */       return marketPriceChart.getPrice();
/*     */     }
/*     */     
/*     */ 
/* 220 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PriceRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */