/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DeliveryStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMSetDeliveryCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int count;
/*    */   
/*    */   public PGMSetDeliveryCount(long roleId, int activityId, int count)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.activityId = activityId;
/* 25 */     this.count = count;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/* 33 */     if (sDeliveryCfg == null) {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!ActivityInterface.isActivityOpen(this.activityId)) {
/* 42 */       return false;
/*    */     }
/* 44 */     if (this.count < 0) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, true);
/* 49 */     if (xDeliveryStatus == null)
/* 50 */       return false;
/* 51 */     xDeliveryStatus.setDelivery_count(this.count);
/* 52 */     GratefulDeliveryManager.checkAndBroadcastReward(this.activityId);
/*    */     
/* 54 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/* 55 */     msg.result = Integer.MAX_VALUE;
/* 56 */     msg.args.add(String.format("总传递次数已设置为%d次", new Object[] { Integer.valueOf(this.count) }));
/* 57 */     OnlineManager.getInstance().send(this.roleId, msg);
/*    */     
/* 59 */     GratefulDeliveryManager.info(this, ".processImp()@done|activity_cfgid=%d|delivery_count=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.count) });
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PGMSetDeliveryCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */