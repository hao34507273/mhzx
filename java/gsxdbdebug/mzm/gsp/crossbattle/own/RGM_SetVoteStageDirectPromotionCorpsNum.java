/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_SetVoteStageDirectPromotionCorpsNum
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int corps_num;
/*    */   
/*    */   public RGM_SetVoteStageDirectPromotionCorpsNum(long gmRoleid, int activityCfgid, int corps_num)
/*    */   {
/* 19 */     this.gmRoleid = gmRoleid;
/* 20 */     this.activityCfgid = activityCfgid;
/* 21 */     this.corps_num = corps_num;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 27 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/* 28 */     if (cfg == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("活动数据不存在", new Object[0]));
/* 31 */       return;
/*    */     }
/* 33 */     if (this.corps_num <= 0)
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("战队数量错误", new Object[0]));
/* 36 */       return;
/*    */     }
/* 38 */     cfg.vote_stage_direct_promotion_corps_num = this.corps_num;
/* 39 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置跨服战投票阶段直接晋级战队数量成功|活动配置ID=%d|战队数量=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.corps_num) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RGM_SetVoteStageDirectPromotionCorpsNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */