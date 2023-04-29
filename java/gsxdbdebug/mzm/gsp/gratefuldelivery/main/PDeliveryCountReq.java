/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.gratefuldelivery.SDeliveryCountRsp;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DeliveryStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PDeliveryCountReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   private final long roleId;
/*    */   
/*    */   public PDeliveryCountReq(int activityId, long roleId)
/*    */   {
/* 23 */     this.activityId = activityId;
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/* 32 */     if (sDeliveryCfg == null) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     String userId = RoleInterface.getUserId(this.roleId);
/* 41 */     if (userId == null)
/* 42 */       return false;
/* 43 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId).isCanJoin()) {
/* 44 */       return false;
/*    */     }
/* 46 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, false);
/* 47 */     if (xDeliveryStatus == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     int count = xDeliveryStatus.getDelivery_count();
/* 51 */     SDeliveryCountRsp sDeliveryCountRsp = new SDeliveryCountRsp();
/* 52 */     sDeliveryCountRsp.delivery_count = count;
/* 53 */     sDeliveryCountRsp.activity_id = this.activityId;
/* 54 */     OnlineManager.getInstance().send(this.roleId, sDeliveryCountRsp);
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PDeliveryCountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */