/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.BackGameActivityInfo;
/*    */ 
/*    */ public class PGM_GetBackGameActivityJoinRecharge extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   
/*    */   public PGM_GetBackGameActivityJoinRecharge(long targetRoleId, long gmRoleId, int activityId)
/*    */   {
/* 14 */     this.targetRoleId = targetRoleId;
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     BackGameActivityInfo xBackGameActivityInfo = xtable.Role2backgameactivity.get(Long.valueOf(this.targetRoleId));
/* 23 */     if ((xBackGameActivityInfo == null) || (xBackGameActivityInfo.getActivity_id() != this.activityId))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "[回流活动]没有该活动信息");
/* 26 */       return false;
/*    */     }
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "[回流活动]加入回流活动时的充值额度是：" + xBackGameActivityInfo.getJoin_recharge());
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PGM_GetBackGameActivityJoinRecharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */