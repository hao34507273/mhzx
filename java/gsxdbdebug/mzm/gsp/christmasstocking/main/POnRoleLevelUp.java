/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(((RoleLevelUpArg)this.arg).roleId);
/* 15 */     if (null == userId)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     lock(Lockeys.get(User.getTable(), userId));
/* 20 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(((RoleLevelUpArg)this.arg).roleId)));
/*    */     
/*    */ 
/* 23 */     if (!ChristmasStockingManager.isChristmasStockingHidingOpen(((RoleLevelUpArg)this.arg).roleId))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/* 30 */     ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, ((RoleLevelUpArg)this.arg).roleId, activityId);
/* 31 */     if (!res.isCanJoin())
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     ChristmasStockingManager.sendStokingHidingNotifyMail(((RoleLevelUpArg)this.arg).roleId);
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */