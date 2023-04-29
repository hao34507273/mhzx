/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PSendStockingHidingNotifyMail extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   PSendStockingHidingNotifyMail(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userId = RoleInterface.getUserId(this.roleId);
/* 23 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/* 24 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId);
/* 25 */     if (!res.isCanJoin())
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     ChristmasStockingManager.sendStokingHidingNotifyMail(this.roleId);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\PSendStockingHidingNotifyMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */