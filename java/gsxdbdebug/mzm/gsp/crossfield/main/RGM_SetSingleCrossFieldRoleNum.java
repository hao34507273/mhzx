/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_SetSingleCrossFieldRoleNum
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int roleNum;
/*    */   
/*    */   public RGM_SetSingleCrossFieldRoleNum(long gmRoleid, int activityCfgid, int roleNum)
/*    */   {
/* 19 */     this.gmRoleid = gmRoleid;
/* 20 */     this.activityCfgid = activityCfgid;
/* 21 */     this.roleNum = roleNum;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 27 */     SCrossFieldCfg cfg = SCrossFieldCfg.get(this.activityCfgid);
/* 28 */     if (cfg == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("活动配置ID错误|活动配置ID=%d|玩家数量=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roleNum) }));
/*    */       
/* 32 */       return;
/*    */     }
/* 34 */     if (this.roleNum < 2)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家数量错误|活动配置ID=%d|玩家数量=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roleNum) }));
/*    */       
/* 38 */       return;
/*    */     }
/* 40 */     cfg.role_num = this.roleNum;
/* 41 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置单人跨服战场玩家数量成功|活动配置ID=%d|玩家数量=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roleNum) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\RGM_SetSingleCrossFieldRoleNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */