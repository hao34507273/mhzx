/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_SetPointRacePromotion extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int num;
/*    */   
/*    */   public RGM_SetPointRacePromotion(long gmRoleid, int activityCfgid, int num)
/*    */   {
/* 15 */     this.gmRoleid = gmRoleid;
/* 16 */     this.activityCfgid = activityCfgid;
/* 17 */     this.num = num;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 23 */     if (this.num < 1)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("数量不能小于1", new Object[0]));
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/* 30 */     if (cfg == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("积分赛配置数据不存在", new Object[0]));
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     cfg.promotionCorpsNum = this.num;
/*    */     
/* 38 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置积分赛晋级数量成功|数量=%d", new Object[] { Integer.valueOf(this.num) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\RGM_SetPointRacePromotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */