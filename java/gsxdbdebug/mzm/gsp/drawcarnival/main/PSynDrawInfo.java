/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.drawcarnival.SGetDrawInfoRsp;
/*    */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.DrawCarnivalGlobalInfo;
/*    */ import xbean.DrawCarnivalRoleActivityInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class PSynDrawInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PSynDrawInfo(long roleId)
/*    */   {
/* 17 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*    */     
/*    */ 
/* 26 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 28 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/*    */ 
/* 31 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, SDrawCarnivalConsts.getInstance().ACTIVITY_ID);
/*    */     
/* 33 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 40 */     xbean.DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = DrawCarnivalManager.getCurrentDrawCarnivalActivityInfoCreateIfNotExist(xDrawCarnivalGlobalInfo.getActivity_id2info());
/*    */     
/*    */ 
/*    */ 
/* 44 */     xbean.DrawCarnivalRoleInfo xDrawCarnivalRoleInfo = DrawCarnivalManager.getDrawCarnivalRoleInfoCreateIfNotExist(this.roleId);
/*    */     
/* 46 */     DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo = DrawCarnivalManager.getCurrentDrawCarnivalRoleActivityInfoCreateIfNotExist(this.roleId, xDrawCarnivalRoleInfo);
/*    */     
/* 48 */     DrawCarnivalManager.checkAndResetFreePasses(xDrawCarnivalRoleActivityInfo);
/*    */     
/* 50 */     SGetDrawInfoRsp sGetDrawInfoRsp = new SGetDrawInfoRsp();
/* 51 */     sGetDrawInfoRsp.award_pool_yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/* 52 */     DrawCarnivalManager.fillAwardWinnerInfo(xDrawCarnivalActivityInfo, sGetDrawInfoRsp.last_winner_info);
/* 53 */     DrawCarnivalManager.fillPassTypeId2freePassInfo(xDrawCarnivalRoleActivityInfo.getFree_pass_type_id2info(), sGetDrawInfoRsp.pass_type_id2info);
/*    */     
/*    */ 
/* 56 */     OnlineManager.getInstance().send(this.roleId, sGetDrawInfoRsp);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PSynDrawInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */