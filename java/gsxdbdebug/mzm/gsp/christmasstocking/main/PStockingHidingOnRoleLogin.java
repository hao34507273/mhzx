/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PStockingHidingOnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/* 16 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 17 */     if (null == userId)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     lock(Lockeys.get(User.getTable(), userId));
/* 22 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*    */     
/*    */ 
/* 25 */     if (!ChristmasStockingManager.isChristmasStockingHidingOpen(roleId))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/* 32 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/* 33 */     if (!res.isCanJoin())
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     ChristmasStockingManager.sendStokingHidingNotifyMail(roleId);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\PStockingHidingOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */