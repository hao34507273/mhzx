/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.ChatGift;
/*    */ import xbean.ChatGiftIdList;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(((Long)this.arg).longValue(), -1)) {
/* 16 */       ChatGiftManager.logDebug("POnRoleLogoff.processImp@RoleChatGift is close|roleid=%d", new Object[] { Long.valueOf(((Long)this.arg).longValue()) });
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     RoleChatGift roleChatGift = (RoleChatGift)ChatGiftFactory.getChatGift(-1);
/* 21 */     if (roleChatGift == null) {
/* 22 */       ChatGiftManager.logDebug("POnRoleLogoff.processImp@RoleChatGift is null|roleid=%d", new Object[] { Long.valueOf(((Long)this.arg).longValue()) });
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     ChatGiftIdList xChatGiftIdList = roleChatGift.getChannelChatGiftListWithChannelLock(((Long)this.arg).longValue(), true);
/*    */     
/* 28 */     Map<Long, ChatGift> chatGiftMap = ChatGiftManager.getChatGiftMap(xChatGiftIdList);
/*    */     
/* 30 */     roleChatGift.setChatGifts(chatGiftMap);
/* 31 */     roleChatGift.setxChatGiftIdList(xChatGiftIdList);
/* 32 */     roleChatGift.checkAndDeleteInvalidChatGift();
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */