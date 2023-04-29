/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.gratefuldelivery.SNotifySpecialEffect;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DeliveryStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMSetSendCardCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int count;
/*    */   
/*    */   public PGMSetSendCardCount(long roleId, int activityId, int count)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.activityId = activityId;
/* 26 */     this.count = count;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/* 34 */     if (sDeliveryCfg == null) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!ActivityInterface.isActivityOpen(this.activityId)) {
/* 43 */       return false;
/*    */     }
/* 45 */     if (this.count < 0) {
/* 46 */       return false;
/*    */     }
/* 48 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, true);
/* 49 */     if (xDeliveryStatus == null)
/* 50 */       return false;
/* 51 */     xDeliveryStatus.setSend_card_count(this.count);
/*    */     
/* 53 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/* 54 */     msg.result = Integer.MAX_VALUE;
/* 55 */     msg.args.add(String.format("发送贺卡总次数已设置为%d次", new Object[] { Integer.valueOf(this.count) }));
/* 56 */     OnlineManager.getInstance().send(this.roleId, msg);
/*    */     
/*    */ 
/* 59 */     if (this.count == sDeliveryCfg.sendCardTargetCount)
/*    */     {
/* 61 */       SNotifySpecialEffect sNotifySpecialEffect = new SNotifySpecialEffect();
/* 62 */       sNotifySpecialEffect.activity_id = this.activityId;
/* 63 */       OnlineManager.getInstance().sendAll(sNotifySpecialEffect);
/*    */       
/* 65 */       GratefulDeliveryManager.info(this, ".processImp()@special effect triggered|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityId) });
/*    */     }
/*    */     
/* 68 */     GratefulDeliveryManager.info(this, ".processImp()@done|activity_cfgid=%d|send_card_count=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.count) });
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PGMSetSendCardCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */