/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*    */ 
/*    */ 
/*    */ public class ShimenInterface
/*    */ {
/*    */   public static int getShimenActivityId()
/*    */   {
/* 11 */     return ShimenActivityCfgConsts.getInstance().ACTIVITYID;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getShimenFinishCount(String userid, long roleId, boolean retainRoleLock)
/*    */   {
/* 25 */     return ActivityInterface.getActivityCount(userid, roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, retainRoleLock);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getCanGetStorageExp(long roleid, int finishCount)
/*    */   {
/* 40 */     return (int)(ShimenManager.getDayRestShimenExp(roleid, finishCount) * ShimenManager.getRate());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getShimeExpByRing(long roleid, int ring)
/*    */   {
/* 53 */     return (int)(ShimenManager.getShimenExpByRing(roleid, ring) * ShimenManager.getRate());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean autoFinishShiMen(String userId, long roleId)
/*    */   {
/* 64 */     return ShimenManager.autoFinishShiMen(userId, roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\ShimenInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */