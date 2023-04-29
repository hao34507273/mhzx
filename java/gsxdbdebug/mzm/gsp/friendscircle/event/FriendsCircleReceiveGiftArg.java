/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ 
/*    */ public class FriendsCircleReceiveGiftArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final long sendGiftRoleId;
/*    */   
/*    */   public final int giftItemCfgId;
/*    */   public final int giftNum;
/*    */   
/*    */   public FriendsCircleReceiveGiftArg(long roleId, long sendGiftRoleId, int giftItemCfgId, int giftNum)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.sendGiftRoleId = sendGiftRoleId;
/* 17 */     this.giftItemCfgId = giftItemCfgId;
/* 18 */     this.giftNum = giftNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCircleReceiveGiftArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */