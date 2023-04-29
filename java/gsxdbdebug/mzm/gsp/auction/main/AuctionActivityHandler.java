/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.auction.confbean.AuctionConsts;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuctionActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 37 */     if (!OpenInterface.getOpenStatus(534))
/*    */     {
/* 39 */       return;
/*    */     }
/*    */     
/* 42 */     AuctionManager.initActivityData(activityid, AuctionConsts.getInstance().SERVER_CLOSE_REFUND_MAIL_ID, activityStartType == ActivityHandler.ActivityStartType.START_AGAIN ? LogReason.AUCTION_ACTIVITY_START_AGAIN_REFUND : LogReason.AUCTION_ACTIVITY_LAST_PERIOD_REFUND);
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */