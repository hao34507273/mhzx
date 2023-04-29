/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.gratefuldelivery.SAvailableFriendRsp;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAvailableFriendReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   private final long roleId;
/*    */   
/*    */   public PAvailableFriendReq(int activityId, long roleId)
/*    */   {
/* 26 */     this.activityId = activityId;
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/* 35 */     if (sDeliveryCfg == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     String userId = RoleInterface.getUserId(this.roleId);
/* 44 */     if (userId == null)
/* 45 */       return false;
/* 46 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId).isCanJoin()) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     if (!GratefulDeliveryManager.hasItem(this.activityId, this.roleId)) {
/* 51 */       return false;
/*    */     }
/* 53 */     LinkedList<Long> friendList = new LinkedList(GratefulDeliveryManager.getAvailableFriends(this.activityId, this.roleId));
/*    */     
/* 55 */     SAvailableFriendRsp sAvailableFriendRsp = new SAvailableFriendRsp();
/* 56 */     sAvailableFriendRsp.roles = friendList;
/* 57 */     sAvailableFriendRsp.activity_id = this.activityId;
/* 58 */     OnlineManager.getInstance().send(this.roleId, sAvailableFriendRsp);
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PAvailableFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */