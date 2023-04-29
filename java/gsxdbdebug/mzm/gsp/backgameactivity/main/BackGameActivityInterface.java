/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import xbean.BackGameActivityInfo;
/*    */ 
/*    */ public class BackGameActivityInterface
/*    */ {
/*    */   public static void addPointOnFinishedActivity(long roleId, int activityId, int currentActivityTotalCount, int activityAddedCount) {
/*  8 */     BackGameActivityManager.addPointOnFinishedActivity(roleId, activityId, currentActivityTotalCount, activityAddedCount);
/*    */   }
/*    */   
/*    */   public static boolean isRoleInBackGameActivity(long roleId, int activityId)
/*    */   {
/* 13 */     return BackGameActivityManager.isRoleInBackGameActivity(roleId, activityId);
/*    */   }
/*    */   
/*    */   public static int getRoleCurrentBackGameActivityId(long roleId)
/*    */   {
/* 18 */     BackGameActivityInfo xBackGameActivityInfo = BackGameActivityManager.getRoleCurrentBackGameActivityInfo(roleId);
/*    */     
/* 20 */     if (xBackGameActivityInfo == null)
/*    */     {
/* 22 */       return -1;
/*    */     }
/* 24 */     return xBackGameActivityInfo.getActivity_id();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\BackGameActivityInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */