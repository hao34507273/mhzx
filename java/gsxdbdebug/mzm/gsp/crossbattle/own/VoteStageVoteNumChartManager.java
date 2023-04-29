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
/*    */ public class VoteStageVoteNumChartManager
/*    */ {
/* 14 */   private static VoteStageVoteNumChartManager instance = new VoteStageVoteNumChartManager();
/*    */   
/*    */   public static VoteStageVoteNumChartManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private final Map<Integer, VoteStageVoteNumChart> charts = new HashMap();
/*    */   
/*    */   public void init()
/*    */   {
/* 25 */     for (SCrossBattleOwnCfg cfg : SCrossBattleOwnCfg.getAll().values())
/*    */     {
/* 27 */       this.charts.put(Integer.valueOf(cfg.activity_cfg_id), new VoteStageVoteNumChart(cfg.activity_cfg_id));
/*    */     }
/*    */   }
/*    */   
/*    */   public VoteStageVoteNumChart getChart(int activityCfgid)
/*    */   {
/* 33 */     return (VoteStageVoteNumChart)this.charts.get(Integer.valueOf(activityCfgid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\VoteStageVoteNumChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */