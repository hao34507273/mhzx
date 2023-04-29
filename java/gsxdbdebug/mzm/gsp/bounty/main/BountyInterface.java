/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.BountyConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BountyInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2bounty;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BountyInterface
/*    */ {
/*    */   public static int getBountyActivityId()
/*    */   {
/* 21 */     return BountyConsts.getInstance().ACTIVITYID;
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
/*    */ 
/*    */ 
/*    */   public static int getRankDoneTaskIdsNum(long roleId, int rank)
/*    */   {
/* 38 */     String userid = RoleInterface.getUserId(roleId);
/* 39 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 41 */     BountyInfo xBountyInfo = Role2bounty.get(Long.valueOf(roleId));
/* 42 */     if (xBountyInfo == null)
/*    */     {
/* 44 */       return 0;
/*    */     }
/*    */     
/* 47 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleId, BountyConsts.getInstance().ACTIVITYID);
/*    */     
/* 49 */     if (!res.isCanJoin())
/*    */     {
/* 51 */       GameServer.logger().warn(String.format("[bounty]BountyInterface.getRankDoneTaskIdsNum@ can not join activity!|roleId=%d|activityId=%d|errCode=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(BountyConsts.getInstance().ACTIVITYID), Integer.valueOf(res.getReasonValue()) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 56 */     return BountyManager.getRankDoneTaskIdsNum(xBountyInfo, rank);
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
/*    */   public static int getSingleCircleCanGetStorageExp(long roleId)
/*    */   {
/* 70 */     return BountyManager.getSingleCircleCanGetStorageExp(roleId);
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
/*    */ 
/*    */   public static int getOneBountyCanGetStorageExp(long roleId, int ring)
/*    */   {
/* 86 */     return BountyManager.getOneBountyCanGetStorageExp(roleId, ring);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\BountyInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */