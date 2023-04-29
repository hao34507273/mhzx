/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.crossbattle.SChangeCrossBattleHistoryActivity;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleHistoryCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class PGM_SetCrossBattleHistoryActivity extends LogicRunnable
/*    */ {
/*    */   private final long roleId;
/*    */   private final int session;
/*    */   private final int activityCfgId;
/*    */   
/*    */   public PGM_SetCrossBattleHistoryActivity(long roleId, int session, int activityCfgId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.session = session;
/* 20 */     this.activityCfgId = activityCfgId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 26 */     SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.session);
/* 27 */     if (sCrossBattleHistoryCfg == null)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "该届在往届风采配置表中没有配置");
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     SActivityCfg sActivityCfg = SActivityCfg.get(this.activityCfgId);
/* 34 */     if (sActivityCfg == null)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.roleId, "活动配置不存在");
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     sCrossBattleHistoryCfg.activity_cfg_id = this.activityCfgId;
/*    */     
/* 42 */     GmManager.getInstance().sendResultToGM(this.roleId, "第" + this.session + "届服战往届风采配置活动id=" + this.activityCfgId);
/*    */     
/* 44 */     SChangeCrossBattleHistoryActivity sChangeCrossBattleHistoryActivity = new SChangeCrossBattleHistoryActivity();
/* 45 */     sChangeCrossBattleHistoryActivity.activity_cfg_id = this.activityCfgId;
/* 46 */     sChangeCrossBattleHistoryActivity.session = this.session;
/*    */     
/* 48 */     OnlineManager.getInstance().sendAll(sChangeCrossBattleHistoryActivity);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_SetCrossBattleHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */