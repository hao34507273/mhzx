/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ 
/*    */ public class ChatGiftSendArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final long chatGiftId;
/*    */   
/*    */   public final int channelType;
/*    */   public final long channelValue;
/*    */   public final int moneyType;
/*    */   public final int moneyNum;
/*    */   
/*    */   public ChatGiftSendArg(long roleId, long chatGiftId, int channelType, long channelValue, int moneyType, int moneyNum)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.chatGiftId = chatGiftId;
/* 19 */     this.channelType = channelType;
/* 20 */     this.channelValue = channelValue;
/* 21 */     this.moneyType = moneyType;
/* 22 */     this.moneyNum = moneyNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftSendArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */