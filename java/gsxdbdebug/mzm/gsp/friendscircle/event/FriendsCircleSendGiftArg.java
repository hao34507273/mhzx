/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ 
/*    */ public class FriendsCircleSendGiftArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final long receiveGiftRoleId;
/*    */   
/*    */   public final int giftItemCfgId;
/*    */   
/*    */   public final int giftItemNum;
/*    */   
/*    */   public FriendsCircleSendGiftArg(long roleId, long receiveGiftRoleId, int giftItemCfgId, int giftItemNum)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.receiveGiftRoleId = receiveGiftRoleId;
/* 18 */     this.giftItemCfgId = giftItemCfgId;
/* 19 */     this.giftItemNum = giftItemNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCircleSendGiftArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */