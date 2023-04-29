/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chatgift.event.ChatGiftSendArg;
/*    */ import mzm.gsp.chatgift.event.ChatGiftSendEventProcedure;
/*    */ import xbean.ChatGift;
/*    */ import xbean.ChatGiftIdList;
/*    */ import xtable.Chatgifttable;
/*    */ 
/*    */ 
/*    */ public class POnChatGiftSendEvent
/*    */   extends ChatGiftSendEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!ChatGiftManager.isChatGiftSwitchOpen(((ChatGiftSendArg)this.arg).channelType)) {
/* 19 */       return false;
/*    */     }
/* 21 */     if (((ChatGiftSendArg)this.arg).channelType == 10) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     ChatGift xChatGift = Chatgifttable.select(Long.valueOf(((ChatGiftSendArg)this.arg).chatGiftId));
/* 26 */     if (xChatGift == null) {
/* 27 */       ChatGiftManager.logDebug("POnChatGiftSendEvent.processImp@ChatGift is null|chatGiftId=%d", new Object[] { Long.valueOf(((ChatGiftSendArg)this.arg).chatGiftId) });
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(((ChatGiftSendArg)this.arg).channelType);
/* 32 */     if (baseChatGift == null) {
/* 33 */       ChatGiftManager.logDebug("POnChatGiftSendEvent.processImp@BaseChatGift is null|channelType=%d", new Object[] { Integer.valueOf(((ChatGiftSendArg)this.arg).channelType) });
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     Long channelId = baseChatGift.checkChannelId(((ChatGiftSendArg)this.arg).roleId, ((ChatGiftSendArg)this.arg).channelValue);
/* 38 */     if (channelId == null) {
/* 39 */       ChatGiftManager.logDebug("POnChatGiftSendEvent.processImp@channelId is null|roleId=%d", new Object[] { Long.valueOf(((ChatGiftSendArg)this.arg).roleId) });
/* 40 */       return false;
/*    */     }
/* 42 */     if (channelId.longValue() != ((ChatGiftSendArg)this.arg).channelValue) {
/* 43 */       ChatGiftManager.logDebug("POnChatGiftSendEvent.processImp@channelId is not match|channelId=%d|channelValue=%d", new Object[] { Long.valueOf(channelId.longValue()), Long.valueOf(((ChatGiftSendArg)this.arg).channelValue) });
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     ChatGiftIdList xChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(channelId.longValue(), false);
/* 48 */     if (xChatGiftIdList == null)
/*    */     {
/* 50 */       xChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(channelId.longValue(), true);
/* 51 */       baseChatGift.getxChatGiftIdList().getChatgiftlist().add(Long.valueOf(((ChatGiftSendArg)this.arg).chatGiftId));
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     Map<Long, ChatGift> chatGiftMap = ChatGiftManager.getChatGiftMap(xChatGiftIdList);
/* 56 */     baseChatGift.setChatGifts(chatGiftMap);
/*    */     
/* 58 */     xChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(channelId.longValue(), true);
/* 59 */     baseChatGift.setxChatGiftIdList(xChatGiftIdList);
/* 60 */     if (!baseChatGift.getxChatGiftIdList().getChatgiftlist().contains(Long.valueOf(((ChatGiftSendArg)this.arg).chatGiftId))) {
/* 61 */       baseChatGift.getxChatGiftIdList().getChatgiftlist().add(Long.valueOf(((ChatGiftSendArg)this.arg).chatGiftId));
/*    */     }
/*    */     
/* 64 */     baseChatGift.checkAndDeleteInvalidChatGift();
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnChatGiftSendEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */