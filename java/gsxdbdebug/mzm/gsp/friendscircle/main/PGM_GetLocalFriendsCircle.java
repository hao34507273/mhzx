/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ 
/*    */ public class PGM_GetLocalFriendsCircle extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetLocalFriendsCircle(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*    */     
/* 20 */     int currentTreasureBox = xRole2FriendsCircleInfo.getTreasure_box_num();
/*    */     
/* 22 */     int weekPopularityValue = FriendsCircleManager.getWeekPopularityValue(this.roleId, true);
/*    */     
/* 24 */     int totalPopularityValue = xRole2FriendsCircleInfo.getTotal_popularity_value();
/*    */     
/* 26 */     int totalReceiveGiftValue = xRole2FriendsCircleInfo.getReceive_gift_num();
/*    */     
/* 28 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前宝箱数" + currentTreasureBox + "当前周人气值 " + weekPopularityValue + "当前总人气值" + totalPopularityValue + "当前收到的总礼物数" + totalReceiveGiftValue);
/*    */     
/*    */ 
/*    */ 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_GetLocalFriendsCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */