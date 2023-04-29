/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldSeasonCfg;
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldSeasonTimeCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldSeasonManager
/*    */ {
/*    */   static void postInit()
/*    */   {
/* 24 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 29 */     int currentSeason = CrossFieldManager.getCurrentSeason(now);
/* 30 */     int beginTimestamp = 0;
/* 31 */     if (currentSeason > 0)
/*    */     {
/* 33 */       SCrossFieldSeasonCfg cfg = SCrossFieldSeasonCfg.get(currentSeason);
/* 34 */       beginTimestamp = cfg.begin_timestamp;
/*    */     }
/* 36 */     TreeMap<Integer, SCrossFieldSeasonTimeCfg> treeMap = (TreeMap)SCrossFieldSeasonTimeCfg.getAll();
/* 37 */     Map.Entry<Integer, SCrossFieldSeasonTimeCfg> entry = treeMap.higherEntry(Integer.valueOf(beginTimestamp));
/* 38 */     if (entry == null)
/*    */     {
/* 40 */       return;
/*    */     }
/* 42 */     new SeasonSession(((SCrossFieldSeasonTimeCfg)entry.getValue()).begin_timestamp - now / 1000L, ((SCrossFieldSeasonTimeCfg)entry.getValue()).sort_id);
/*    */   }
/*    */   
/*    */   static class SeasonSession extends Session
/*    */   {
/*    */     private final int season;
/*    */     
/*    */     public SeasonSession(long interval, int season)
/*    */     {
/* 51 */       super(0L);
/* 52 */       this.season = season;
/* 53 */       CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldSeasonManager.SeasonSession@start season session|interval=%d|season=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(season) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     protected void onTimeOut()
/*    */     {
/* 62 */       SingleCrossFieldChartManager.getInstance().onSeasonStart(this.season);
/*    */       
/* 64 */       SCrossFieldSeasonCfg cfg = SCrossFieldSeasonCfg.get(this.season);
/* 65 */       if (cfg == null)
/*    */       {
/*    */ 
/* 68 */         return;
/*    */       }
/* 70 */       TreeMap<Integer, SCrossFieldSeasonTimeCfg> treeMap = (TreeMap)SCrossFieldSeasonTimeCfg.getAll();
/* 71 */       Map.Entry<Integer, SCrossFieldSeasonTimeCfg> entry = treeMap.higherEntry(Integer.valueOf(cfg.begin_timestamp));
/* 72 */       if (entry == null)
/*    */       {
/* 74 */         return;
/*    */       }
/* 76 */       new SeasonSession(((SCrossFieldSeasonTimeCfg)entry.getValue()).begin_timestamp - DateTimeUtils.getCurrTimeInMillis() / 1000L, ((SCrossFieldSeasonTimeCfg)entry.getValue()).sort_id);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\SingleCrossFieldSeasonManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */