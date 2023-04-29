/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crossbattle.SSynCrossBattleCurrentActivityCfgid;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_SetCrossBattleCurrentActivityCfgid
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public RGM_SetCrossBattleCurrentActivityCfgid(long gmRoleid, int activityCfgid)
/*    */   {
/* 23 */     this.gmRoleid = gmRoleid;
/* 24 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 30 */     SActivityCfg cfg = ActivityInterface.getActivityCfg(this.activityCfgid);
/* 31 */     if ((cfg == null) || (cfg.activityLogicType != 97))
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("活动配置ID错误|活动配置ID=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/* 34 */       return;
/*    */     }
/* 36 */     if (CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID == this.activityCfgid)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("活动配置ID相同|活动配置ID=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/* 39 */       return;
/*    */     }
/* 41 */     CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID = this.activityCfgid;
/*    */     
/* 43 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置跨服战当前活动配置ID成功|活动配置ID=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */     
/* 45 */     SSynCrossBattleCurrentActivityCfgid protocol = new SSynCrossBattleCurrentActivityCfgid();
/* 46 */     protocol.activity_cfg_id = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/* 47 */     OnlineManager.getInstance().sendAllAtOnce(protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RGM_SetCrossBattleCurrentActivityCfgid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */