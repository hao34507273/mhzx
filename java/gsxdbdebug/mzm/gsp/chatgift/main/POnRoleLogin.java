/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chat.SChatGiftResult;
/*    */ import mzm.gsp.chat.SGetChatGiftLeftNumReq;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ChatGift;
/*    */ import xbean.ChatGiftIdList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(((Long)this.arg).longValue(), -1)) {
/* 21 */       ChatGiftManager.logDebug("POnRoleLogin.processImp@RoleChatGift is close|roleid=%d", new Object[] { Long.valueOf(((Long)this.arg).longValue()) });
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     RoleChatGift roleChatGift = (RoleChatGift)ChatGiftFactory.getChatGift(-1);
/* 26 */     if (roleChatGift == null) {
/* 27 */       ChatGiftManager.logDebug("POnRoleLogin.processImp@RoleChatGift is null|roleid=%d", new Object[] { Long.valueOf(((Long)this.arg).longValue()) });
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     ChatGiftIdList xChatGiftIdList = roleChatGift.getChannelChatGiftListWithChannelLock(((Long)this.arg).longValue(), true);
/*    */     
/* 33 */     Map<Long, ChatGift> chatGiftMap = ChatGiftManager.getChatGiftMap(xChatGiftIdList);
/*    */     
/* 35 */     roleChatGift.setChatGifts(chatGiftMap);
/* 36 */     roleChatGift.setxChatGiftIdList(xChatGiftIdList);
/* 37 */     roleChatGift.checkAndDeleteInvalidChatGift();
/*    */     
/* 39 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 40 */     int sendNum = 0;
/* 41 */     for (ChatGift xChatGift_tmp : roleChatGift.getChatGifts().values())
/*    */     {
/* 43 */       if (!DateTimeUtils.needDailyReset(xChatGift_tmp.getStarttime(), now, 0))
/*    */       {
/* 45 */         sendNum++;
/*    */       }
/*    */     }
/* 48 */     int leftNum = ChatGift_GfgManager.getRoleMaxChatGiftNum() - sendNum;
/* 49 */     if (leftNum < 0) {
/* 50 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 51 */       sChatGiftResult.result = 1;
/* 52 */       OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), sChatGiftResult);
/* 53 */       ChatGiftManager.logDebug("POnRoleLogin.processImp@send max error!|roleId=%d", new Object[] { Long.valueOf(((Long)this.arg).longValue()) });
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     SGetChatGiftLeftNumReq sGetChatGiftLeftNumReq = new SGetChatGiftLeftNumReq();
/* 58 */     sGetChatGiftLeftNumReq.leftnum = leftNum;
/* 59 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sGetChatGiftLeftNumReq);
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */