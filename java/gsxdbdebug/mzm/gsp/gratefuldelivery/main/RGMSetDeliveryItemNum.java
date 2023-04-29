/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ public class RGMSetDeliveryItemNum
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int min;
/*    */   private final int max;
/*    */   
/*    */   public RGMSetDeliveryItemNum(long roleId, int activityId, int min, int max)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.activityId = activityId;
/* 22 */     this.min = min;
/* 23 */     this.max = max;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     if ((this.min <= 0) || (this.max < this.min)) {
/* 30 */       return;
/*    */     }
/* 32 */     SDeliveryCfg cfg = SDeliveryCfg.get(this.activityId);
/* 33 */     if (cfg == null) {
/* 34 */       return;
/*    */     }
/* 36 */     cfg.minItemNum = this.min;
/* 37 */     cfg.maxItemNum = this.max;
/*    */     
/* 39 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/* 40 */     msg.result = Integer.MAX_VALUE;
/* 41 */     msg.args.add(String.format("传递道具的分配数量设置为%d~%d个", new Object[] { Integer.valueOf(this.min), Integer.valueOf(this.max) }));
/* 42 */     OnlineManager.getInstance().send(this.roleId, msg);
/*    */     
/* 44 */     GratefulDeliveryManager.info(this, ".processImp()@done|activity_cfgid=%d|min=%d|max=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.min), Integer.valueOf(this.max) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\RGMSetDeliveryItemNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */