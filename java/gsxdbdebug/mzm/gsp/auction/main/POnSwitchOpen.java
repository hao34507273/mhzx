/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import mzm.gsp.auction.confbean.AuctionConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnSwitchOpen extends LogicProcedure
/*    */ {
/*    */   final int activityId;
/*    */   
/*    */   public POnSwitchOpen(int activityId)
/*    */   {
/* 13 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     AuctionManager.initActivityData(this.activityId, AuctionConsts.getInstance().SWITCH_CLOSE_REFUND_MAIL_ID, LogReason.AUCTION_SWITCH_OPEN_REFUND);
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\POnSwitchOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */