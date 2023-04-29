/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return;
/*    */     }
/*    */     
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     String userid = RoleInterface.getUserId(((Long)this.arg).longValue());
/*    */     
/* 19 */     new POnRoleLoginForQingfu(userid, roleid).call();
/*    */     
/* 21 */     new POnRoleLoginForFirstRechargeActivity(userid, roleid).call();
/*    */     
/* 23 */     new POnRoleLoginForSaveAmtActivity(userid, roleid).call();
/*    */     
/* 25 */     new POnRoleLoginForAccumTotalCostActivity(userid, roleid).call();
/*    */     
/* 27 */     new POnRoleLoginForLevelGrowthFundActivity(userid, roleid).call();
/*    */     
/* 29 */     new POnRoleLoginForMonthCardActivity(userid, roleid).call();
/*    */     
/* 31 */     new POnRoleLoginForTimeLimitGiftActivity(userid, roleid).call();
/*    */     
/* 33 */     new POnRoleLoginForRMBGiftBagActivity(userid, roleid).call();
/*    */     
/* 35 */     new POnRoleLoginForSaveAmtRecord(userid).call();
/*    */     
/* 37 */     new POnRoleLoginForDailyGift(userid, roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */