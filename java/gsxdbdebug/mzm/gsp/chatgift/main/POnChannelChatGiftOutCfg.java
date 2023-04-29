/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ChatGiftIdList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnChannelChatGiftOutCfg
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long chatGiftId;
/*    */   private final int channelType;
/*    */   private final long channelId;
/*    */   
/*    */   POnChannelChatGiftOutCfg(int channelType, long channelInfo, long chatGiftId)
/*    */   {
/* 18 */     this.channelType = channelType;
/* 19 */     this.channelId = channelInfo;
/* 20 */     this.chatGiftId = chatGiftId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!ChatGiftManager.isChatGiftSwitchOpen(this.channelType)) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(this.channelType);
/* 30 */     if (baseChatGift == null) {
/* 31 */       ChatGiftManager.logDebug("POnChannelChatGiftTimeOut.processImp@BaseChatGift is null|channelType=%d|chatGiftId=%d|chatGiftId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.channelId), Long.valueOf(this.chatGiftId) });
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     ChatGiftIdList xChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(this.channelId, true);
/* 36 */     if ((xChatGiftIdList == null) || (xChatGiftIdList.getChatgiftlist().size() == 0)) {
/* 37 */       ChatGiftManager.logDebug("POnChannelChatGiftTimeOut.processImp@ChatGiftIdList is null!|channelType=%d|chatGiftId=%d|chatGiftId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.channelId), Long.valueOf(this.chatGiftId) });
/* 38 */       return true;
/*    */     }
/*    */     
/* 41 */     if (!xChatGiftIdList.getChatgiftlist().contains(Long.valueOf(this.chatGiftId))) {
/* 42 */       ChatGiftManager.logDebug("POnChannelChatGiftTimeOut.processImp@ChatGiftIdList is null!|channelType=%d|chatGiftId=%d|chatGiftId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.channelId), Long.valueOf(this.chatGiftId) });
/* 43 */       return false;
/*    */     }
/* 45 */     xChatGiftIdList.getChatgiftlist().remove(Long.valueOf(this.chatGiftId));
/* 46 */     ChatGiftManager.logInfo("POnChannelChatGiftTimeOut.processImp@remove success!|channelType=%d|chatGiftId=%d|chatGiftId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.channelId), Long.valueOf(this.chatGiftId) });
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnChannelChatGiftOutCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */