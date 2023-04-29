/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VoteStageAverageFightValueChartManager
/*    */ {
/* 14 */   private static VoteStageAverageFightValueChartManager instance = new VoteStageAverageFightValueChartManager();
/*    */   
/*    */   public static VoteStageAverageFightValueChartManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private final Map<Integer, VoteStageAverageFightValueChart> charts = new HashMap();
/*    */   
/*    */   public void init()
/*    */   {
/* 25 */     for (SCrossBattleOwnCfg cfg : SCrossBattleOwnCfg.getAll().values())
/*    */     {
/* 27 */       this.charts.put(Integer.valueOf(cfg.activity_cfg_id), new VoteStageAverageFightValueChart(cfg.activity_cfg_id));
/*    */     }
/*    */   }
/*    */   
/*    */   public VoteStageAverageFightValueChart getChart(int activityCfgid)
/*    */   {
/* 33 */     return (VoteStageAverageFightValueChart)this.charts.get(Integer.valueOf(activityCfgid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\VoteStageAverageFightValueChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */