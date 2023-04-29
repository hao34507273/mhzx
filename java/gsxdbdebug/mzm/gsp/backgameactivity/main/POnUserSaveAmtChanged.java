/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.backgameactivity.SSynRechargeInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedProcedure;
/*    */ import xbean.BackGameActivityInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnUserSaveAmtChanged extends SaveAmtChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     String userId = ((SaveAmtChangedArg)this.arg).userid;
/* 17 */     long roleId = mzm.gsp.qingfu.main.QingfuInterface.getSuitableRoleId(userId);
/*    */     
/* 19 */     Set<Long> roleIdSet = mzm.gsp.role.main.RoleInterface.getRoleSet(userId);
/* 20 */     if ((roleIdSet == null) || (roleIdSet.isEmpty()))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/* 25 */     lock(Basic.getTable(), roleIdSet);
/*    */     
/*    */ 
/* 28 */     BackGameActivityInfo xBackGameActivityInfo = BackGameActivityManager.getRoleCurrentBackGameActivityInfo(roleId);
/*    */     
/* 30 */     if (xBackGameActivityInfo == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     int backGameActivityId = xBackGameActivityInfo.getActivity_id();
/* 36 */     SSynRechargeInfo synRechargeInfo = new SSynRechargeInfo();
/* 37 */     synRechargeInfo.activityid = backGameActivityId;
/* 38 */     BackGameActivityManager.getRechargeInfo(userId, roleId, roleIdSet, xBackGameActivityInfo, synRechargeInfo.rechargeinfo);
/* 39 */     OnlineManager.getInstance().send(roleId, synRechargeInfo);
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\POnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */