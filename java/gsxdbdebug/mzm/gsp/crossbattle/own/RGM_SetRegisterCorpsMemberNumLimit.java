/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_SetRegisterCorpsMemberNumLimit
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int upper_limit;
/*    */   private final int lower_limit;
/*    */   
/*    */   public RGM_SetRegisterCorpsMemberNumLimit(long gmRoleid, int activityCfgid, int upper_limit, int lower_limit)
/*    */   {
/* 21 */     this.gmRoleid = gmRoleid;
/* 22 */     this.activityCfgid = activityCfgid;
/* 23 */     this.upper_limit = upper_limit;
/* 24 */     this.lower_limit = lower_limit;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 30 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/* 31 */     if (cfg == null)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("活动数据不存在", new Object[0]));
/* 34 */       return;
/*    */     }
/* 36 */     if ((this.upper_limit <= 0) || (this.lower_limit <= 0) || (this.upper_limit < this.lower_limit))
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("限制数据错误", new Object[0]));
/* 39 */       return;
/*    */     }
/* 41 */     cfg.register_corps_member_num_upper_limit = this.upper_limit;
/* 42 */     cfg.register_corps_member_num_lower_limit = this.lower_limit;
/* 43 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置跨服战本服报名战队人数限制成功|活动配置ID=%d|上限=%d|下限=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.upper_limit), Integer.valueOf(this.lower_limit) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RGM_SetRegisterCorpsMemberNumLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */