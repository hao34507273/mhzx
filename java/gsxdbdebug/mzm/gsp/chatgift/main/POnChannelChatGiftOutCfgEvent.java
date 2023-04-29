/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.chatgift.event.ChannelChatGiftOutCfgEventProcedure;
/*    */ import mzm.gsp.chatgift.event.ChatGiftOutCfgArg;
/*    */ import xbean.ChatGiftIdList;
/*    */ 
/*    */ 
/*    */ public class POnChannelChatGiftOutCfgEvent
/*    */   extends ChannelChatGiftOutCfgEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!ChatGiftManager.isChatGiftSwitchOpen(((ChatGiftOutCfgArg)this.arg).channelType)) {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(((ChatGiftOutCfgArg)this.arg).channelType);
/* 20 */     if (baseChatGift == null) {
/* 21 */       ChatGiftManager.logDebug("POnChannelChatGiftOutCfgEvent.processImp@BaseChatGift is null|channelType=%d|channelId=%d", new Object[] { Integer.valueOf(((ChatGiftOutCfgArg)this.arg).channelType), Long.valueOf(((ChatGiftOutCfgArg)this.arg).channelId) });
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     ChatGiftIdList xChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(((ChatGiftOutCfgArg)this.arg).channelId, true);
/* 26 */     if ((xChatGiftIdList == null) || (xChatGiftIdList.getChatgiftlist().size() == 0)) {
/* 27 */       ChatGiftManager.logDebug("POnChannelChatGiftOutCfgEvent.processImp@ChatGiftIdList is null!|channelType=%d|channelId=%d", new Object[] { Integer.valueOf(((ChatGiftOutCfgArg)this.arg).channelType), Long.valueOf(((ChatGiftOutCfgArg)this.arg).channelId) });
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     xChatGiftIdList.getChatgiftlist().removeAll(((ChatGiftOutCfgArg)this.arg).chatGiftIds);
/* 32 */     ChatGiftManager.logInfo("POnChannelChatGiftOutCfgEvent.processImp@remove success!|channelType=%d|channelId=%d", new Object[] { Integer.valueOf(((ChatGiftOutCfgArg)this.arg).channelType), Long.valueOf(((ChatGiftOutCfgArg)this.arg).channelId) });
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnChannelChatGiftOutCfgEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */