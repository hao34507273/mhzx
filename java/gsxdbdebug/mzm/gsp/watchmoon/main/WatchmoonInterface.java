/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
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
/*    */ public class WatchmoonInterface
/*    */ {
/*    */   public static int getWatchmoonCount(String userId, long roleid, boolean isLock)
/*    */   {
/* 19 */     return ActivityInterface.getActivityCount(userId, roleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\WatchmoonInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */