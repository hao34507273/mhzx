/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import xbean.Activity;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCTakeRecommendAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   private final long roleId;
/*    */   
/*    */   public PCTakeRecommendAward(int activityId, long roleId)
/*    */   {
/* 13 */     this.activityId = activityId;
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 21 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/* 23 */     Activity xActivity = ActivityManager.getXActivity(userId, this.roleId, this.activityId);
/* 24 */     if (xActivity == null) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     return ActivityManager.takeRecommendAward(userId, this.roleId, this.activityId, xActivity);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PCTakeRecommendAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */