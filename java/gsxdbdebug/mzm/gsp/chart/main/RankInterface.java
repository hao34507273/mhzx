/*     */ package mzm.gsp.chart.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chart.confbean.RankAwardBean;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeAwardCfg;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class RankInterface
/*     */ {
/*     */   public static boolean removeRoleidInAllRankForIDIP(long roleid, boolean isClear)
/*     */   {
/*  19 */     return RankCacheManager.removeRoleidInAllRank(roleid, isClear);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean removeRoleidInRankForIDIP(long roleid, int rankType, boolean isClear)
/*     */   {
/*  28 */     return RankCacheManager.removeRoleidInRank(roleid, rankType, isClear);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addRoleInAllRankForIDIP(long roleid)
/*     */   {
/*  37 */     RankCacheManager.addRoleRankInAllRank(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addRoleRankForIDIP(long roleid, int rankType)
/*     */   {
/*  46 */     RankCacheManager.addRoleRank(roleid, rankType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerRankAwardHandle(int rankType, RankAwardHandler rankAwardHandler)
/*     */   {
/*  56 */     RankCacheManager.registerRankAwardHandle(rankType, rankAwardHandler);
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
/*     */   public static void sendChartAward(String userid, long roleid, int chartType, int rank)
/*     */   {
/*  70 */     RankCacheManager.sendChartAward(userid, roleid, chartType, rank);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAwardRank(int rankType)
/*     */   {
/*  79 */     SChartSubTypeAwardCfg sChartSubTypeAwardCfg = SChartSubTypeAwardCfg.get(rankType);
/*  80 */     Map.Entry<Integer, RankAwardBean> entry = sChartSubTypeAwardCfg.awardMap.lastEntry();
/*  81 */     if (entry == null) {
/*  82 */       return -1;
/*     */     }
/*  84 */     return ((Integer)entry.getKey()).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInSameAwardTime(long latestAwardTime, int rankType)
/*     */   {
/*  95 */     SChartSubTypeCfg chartSubTypeCfg = SChartSubTypeCfg.get(rankType);
/*  96 */     if ((chartSubTypeCfg == null) || (chartSubTypeCfg.timeCommonCfgids.size() <= 0))
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[Rank]RankAwardHandler.isInSameAwardTime@do not exist chart cfg|chartType=%d", new Object[] { Integer.valueOf(rankType) }));
/*     */       
/*     */ 
/* 101 */       return true;
/*     */     }
/* 103 */     long beforeStartTime = 0L;
/*     */     
/* 105 */     long curTime = DateTimeUtils.getCurrTimeInMillis() + 10000L;
/* 106 */     for (Iterator i$ = chartSubTypeCfg.timeCommonCfgids.iterator(); i$.hasNext();) { int timeCommonCfgid = ((Integer)i$.next()).intValue();
/* 107 */       long tempBefroeTime = TimeCommonUtil.getBeforeStartTime(curTime, timeCommonCfgid);
/* 108 */       if (tempBefroeTime > beforeStartTime) {
/* 109 */         beforeStartTime = tempBefroeTime;
/*     */       }
/*     */     }
/* 112 */     if (beforeStartTime <= 0L) {
/* 113 */       GameServer.logger().error(String.format("[Rank]RankAwardHandler.isInSameAwardTime@do not exist timeCommon cfg|chartType=%d", new Object[] { Integer.valueOf(rankType) }));
/*     */       
/*     */ 
/* 116 */       return true;
/*     */     }
/*     */     
/* 119 */     return latestAwardTime + 2000L >= beforeStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMaxRank(long roleid, int rankType)
/*     */   {
/* 131 */     return RankCacheManager.getMaxRank(roleid, rankType);
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
/*     */   public static java.util.List<RoleRelatedChartObj> getRoleRelatedChartObjs(int rankType, int from, int to)
/*     */   {
/* 144 */     return RankCacheManager.getRoleRelatedChartObjs(rankType, from, to);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RankInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */