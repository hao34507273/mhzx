/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import mzm.gsp.gratefuldelivery.SNotifySpecialEffect;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SGreetingCard2Activity;
/*    */ import mzm.gsp.greetingcard.event.SendCardEventArg;
/*    */ import mzm.gsp.greetingcard.event.SendCardEventProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.DeliveryStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnSendGreetingCard
/*    */   extends SendCardEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     SGreetingCard2Activity card2Activity = SGreetingCard2Activity.get(((SendCardEventArg)this.arg).cardItemCfgId);
/* 21 */     if (card2Activity == null)
/* 22 */       return false;
/* 23 */     int activityId = card2Activity.activityId;
/* 24 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(activityId);
/* 25 */     if (sDeliveryCfg == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(activityId, true);
/*    */     
/* 30 */     if (xDeliveryStatus == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     xDeliveryStatus.setSend_card_count(xDeliveryStatus.getSend_card_count() + 1);
/*    */     
/*    */ 
/* 36 */     if (xDeliveryStatus.getSend_card_count() == sDeliveryCfg.sendCardTargetCount)
/*    */     {
/* 38 */       SNotifySpecialEffect sNotifySpecialEffect = new SNotifySpecialEffect();
/* 39 */       sNotifySpecialEffect.activity_id = activityId;
/* 40 */       OnlineManager.getInstance().sendAll(sNotifySpecialEffect);
/*    */       
/* 42 */       GratefulDeliveryManager.info(this, ".processImp()@special effect activated|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) });
/*    */     }
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\POnSendGreetingCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */