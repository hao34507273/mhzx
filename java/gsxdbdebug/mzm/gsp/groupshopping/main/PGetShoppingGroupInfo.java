/*    */ package mzm.gsp.groupshopping.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.groupshopping.SGetShoppingGroupInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ShoppingGroupInfo;
/*    */ import xtable.Shopping_group_info;
/*    */ 
/*    */ public class PGetShoppingGroupInfo extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long groupId;
/*    */   
/*    */   public PGetShoppingGroupInfo(long roleId, long groupId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.groupId = groupId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     int activityId = GroupShoppingManager.currentActivityId;
/* 28 */     if (activityId == 0) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (!GroupShoppingManager.isGroupShoppingOpen()) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (!GroupShoppingManager.isServerLevelEnough(activityId)) {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!GroupShoppingManager.canGetGroupShoppingInfo(this.roleId)) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     String userId = RoleInterface.getUserId(this.roleId);
/* 45 */     if (userId == null)
/* 46 */       return false;
/* 47 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin()) {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     final ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(Long.valueOf(this.groupId));
/* 52 */     if (xShoppingGroupInfo == null) {
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     if (xShoppingGroupInfo.getStatus() == 3) {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 65 */         SGetShoppingGroupInfoRes res = new SGetShoppingGroupInfoRes();
/* 66 */         GroupShoppingManager.fillShoppingGroupInfo(PGetShoppingGroupInfo.this.groupId, xShoppingGroupInfo, res.group_info);
/* 67 */         OnlineManager.getInstance().send(PGetShoppingGroupInfo.this.roleId, res);
/* 68 */         GroupShoppingLogger.info("PGetShoppingGroupInfo.processImp()@done|roleid=%d|group_id=%d", new Object[] { Long.valueOf(PGetShoppingGroupInfo.this.roleId), Long.valueOf(PGetShoppingGroupInfo.this.groupId) });
/* 69 */         return true;
/*    */       }
/* 71 */     }.execute();
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PGetShoppingGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */