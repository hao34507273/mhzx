/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_BallBattleMatchNumber extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int activityId;
/*    */   private final int minNumber;
/*    */   private final int defaultNumber;
/*    */   
/*    */   public RGM_BallBattleMatchNumber(long gmRoleId, int activityId, int minNumber, int defaultNumber)
/*    */   {
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.activityId = activityId;
/* 18 */     this.minNumber = minNumber;
/* 19 */     this.defaultNumber = defaultNumber;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 25 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(this.activityId);
/* 26 */     if (activityCfg == null)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("活动ID(%d)无效", new Object[] { Integer.valueOf(this.activityId) }));
/* 29 */       return;
/*    */     }
/* 31 */     if ((this.minNumber == -1) || (this.defaultNumber == -1))
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("当前设置: 最低匹配人数%d, 默认匹配人数%d", new Object[] { Integer.valueOf(activityCfg.minPlayerNumber), Integer.valueOf(activityCfg.defaultPlayerNumber) }));
/*    */       
/* 35 */       return;
/*    */     }
/* 37 */     if ((this.minNumber < 2) || (this.minNumber >= this.defaultNumber))
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数无效, 修改失败");
/* 40 */       return;
/*    */     }
/* 42 */     activityCfg.minPlayerNumber = this.minNumber;
/* 43 */     activityCfg.defaultPlayerNumber = this.defaultNumber;
/* 44 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("修改成功: 最低匹配人数%d, 默认匹配人数%d", new Object[] { Integer.valueOf(activityCfg.minPlayerNumber), Integer.valueOf(activityCfg.defaultPlayerNumber) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\RGM_BallBattleMatchNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */