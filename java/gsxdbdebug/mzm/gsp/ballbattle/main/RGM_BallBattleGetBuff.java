/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.ballbattle.confbean.SBallBattleGroundItemCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_BallBattleGetBuff
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int buffItemCfgId;
/*    */   
/*    */   public RGM_BallBattleGetBuff(long gmRoleId, long roleId, int buffItemCfgId)
/*    */   {
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.roleId = roleId;
/* 18 */     this.buffItemCfgId = buffItemCfgId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 24 */     SBallBattleGroundItemCfg cfg = SBallBattleGroundItemCfg.get(this.buffItemCfgId);
/* 25 */     if ((cfg == null) || (cfg.type == 0))
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d不是有效的基因道具ID", new Object[] { Integer.valueOf(this.buffItemCfgId) }));
/* 28 */       return;
/*    */     }
/* 30 */     boolean result = BallBattleGameInstance.forceGetBuffItem(this.roleId, this.buffItemCfgId);
/* 31 */     if (result)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "强制获取Buff操作已安排执行");
/*    */     }
/*    */     else
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("角色%d对应的游戏实例不存在", new Object[] { Long.valueOf(this.roleId) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\RGM_BallBattleGetBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */