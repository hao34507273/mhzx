/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.BackGameActivityUserMap;
/*    */ import xtable.User2backgameactivity;
/*    */ 
/*    */ public class PGM_ClearBackGameActivityUserInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   
/*    */   public PGM_ClearBackGameActivityUserInfo(long targetRoleId, long gmRoleId, int activityId)
/*    */   {
/* 15 */     this.targetRoleId = targetRoleId;
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.targetRoleId);
/* 24 */     BackGameActivityUserMap xBackGameActivityUserMap = User2backgameactivity.get(userId);
/* 25 */     if (xBackGameActivityUserMap == null)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "[回流活动]充值信息不存在");
/* 28 */       return false;
/*    */     }
/* 30 */     if (this.activityId == -1)
/*    */     {
/* 32 */       User2backgameactivity.delete(userId);
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "[回流活动]充值信息删除成功");
/* 34 */       return true;
/*    */     }
/*    */     
/* 37 */     Object object = xBackGameActivityUserMap.getActivityid2userinfo().remove(Integer.valueOf(this.activityId));
/* 38 */     if (object == null)
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "[回流活动]充值信息对应的活动Id不存在");
/* 41 */       return false;
/*    */     }
/* 43 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "[回流活动]充值信息删除成功");
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PGM_ClearBackGameActivityUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */