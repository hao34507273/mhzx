/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_BallBattleStop extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public RGM_BallBattleStop(long gmRoleId, long roleId)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     boolean result = BallBattleGameInstance.forceStopGameInstance(this.roleId);
/* 21 */     if (result)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "强制停止游戏实例操作已安排执行");
/*    */     }
/*    */     else
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("角色%d对应的游戏实例不存在", new Object[] { Long.valueOf(this.roleId) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\RGM_BallBattleStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */