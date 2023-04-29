/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ 
/*    */ public class ChatGiftGetArg
/*    */ {
/*    */   public final long chatGiftId;
/*    */   
/*    */   public final int channelType;
/*    */   
/*    */   public final long channelId;
/*    */   
/*    */   public final long chatGiftRoleId;
/*    */   public final long getRoldId;
/*    */   public final String getRoleName;
/*    */   public final int getMoneyType;
/*    */   public final int getMoney;
/*    */   
/*    */   public ChatGiftGetArg(long chatGiftId, int channelType, long chatGiftRoleId, long getRoldId, String getRoleName, int getMoneyType, int getMoney, long channelId)
/*    */   {
/* 20 */     this.chatGiftId = chatGiftId;
/* 21 */     this.channelType = channelType;
/* 22 */     this.chatGiftRoleId = chatGiftRoleId;
/* 23 */     this.getRoldId = getRoldId;
/* 24 */     this.getRoleName = getRoleName;
/* 25 */     this.getMoneyType = getMoneyType;
/* 26 */     this.getMoney = getMoney;
/* 27 */     this.channelId = channelId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftGetArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */