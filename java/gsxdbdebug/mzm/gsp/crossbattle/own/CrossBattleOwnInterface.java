/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrossBattleOwnInterface
/*     */ {
/*     */   public static void init()
/*     */   {
/*  21 */     VoteStageVoteNumChartManager.getInstance().init();
/*  22 */     VoteStageAverageFightValueChartManager.getInstance().init();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void postInit() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void OnCrossBattleActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityCfgid)
/*     */   {
/*  42 */     CrossBattleOwnManager.OnCrossBattleActivityStart(activityStartType, activityCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void OnCrossBattleVoteStageStart(boolean startAgain, int activityCfgid)
/*     */   {
/*  54 */     CrossBattleOwnManager.OnCrossBattleVoteStageStart(startAgain, activityCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void OnCrossBattleRoundRobinStageStart(boolean startAgain, int activityCfgid)
/*     */   {
/*  66 */     CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart(startAgain, activityCfgid);
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
/*     */   public static void onActivityEnd(int activityCfgid) {}
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
/*     */   public static List<Long> getAllCrossBattleOwnPromotionCorpsids(int activityCfgid, boolean remainLock)
/*     */   {
/*  91 */     return CrossBattleOwnManager.getAllCrossBattleOwnPromotionCorpsids(activityCfgid, remainLock);
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
/*     */   public static boolean isCorpsPromotionInCrossBattleOwn(long corpsid, int activityCfgid, boolean remainLock)
/*     */   {
/* 108 */     return CrossBattleOwnManager.isCorpsPromotionInCrossBattleOwn(corpsid, activityCfgid, remainLock);
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
/*     */   public static List<Long> getCrossBattleRegisterRoleList(long corpsid, int activityCfgid, boolean remainLock)
/*     */   {
/* 126 */     return CrossBattleOwnManager.getCrossBattleRegisterRoleList(corpsid, activityCfgid, remainLock);
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
/*     */   public static QueryResult queryReportCrossBattleOwnResultInfoByIdip(int activityCfgid)
/*     */   {
/* 139 */     return CrossBattleOwnManager.queryReportCrossBattleOwnResultInfoByIdip(activityCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ClearResult clearCrossBattleOwnResultByIdip(int activityCfgid)
/*     */   {
/* 151 */     return CrossBattleOwnManager.clearCrossBattleOwnResultByIdip(activityCfgid);
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
/*     */ 
/*     */ 
/*     */   public static RestartResult restartRoundRobinRoundByIdip(int activityCfgid, int roundIndex, int restartLevel, long timestamp)
/*     */   {
/* 171 */     return CrossBattleOwnManager.restartRoundRobinRoundByIdip(activityCfgid, roundIndex, restartLevel, timestamp);
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
/*     */   public static CrossBattleOwnInfo getCrossBattleOwnInfo(int activityCfgid, boolean remainLock)
/*     */   {
/* 186 */     return CrossBattleOwnManager.getCrossBattleOwnInfo(activityCfgid, remainLock);
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
/*     */   public static Map<Long, List<Long>> getCrossBattleOwnPromotionCorpsRoleList(int activityCfgid, boolean remainLock)
/*     */   {
/* 202 */     Map<Long, List<Long>> roleLists = new HashMap();
/* 203 */     List<Long> corpsids = getAllCrossBattleOwnPromotionCorpsids(activityCfgid, remainLock);
/* 204 */     for (Iterator i$ = corpsids.iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/* 206 */       List<Long> roleids = getCrossBattleRegisterRoleList(corpsid, activityCfgid, remainLock);
/* 207 */       roleLists.put(Long.valueOf(corpsid), roleids == null ? new ArrayList() : roleids);
/*     */     }
/* 209 */     return roleLists;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleOwnInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */