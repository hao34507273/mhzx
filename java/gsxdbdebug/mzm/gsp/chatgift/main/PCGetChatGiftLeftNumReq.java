/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chat.SChatGiftResult;
/*    */ import mzm.gsp.chat.SGetChatGiftLeftNumReq;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ChatGift;
/*    */ import xbean.ChatGiftIdList;
/*    */ 
/*    */ public class PCGetChatGiftLeftNumReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetChatGiftLeftNumReq(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(this.roleId, -1)) {
/* 26 */       ChatGiftManager.logDebug("POnRoleLogin.processImp@RoleChatGift is close|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     RoleChatGift roleChatGift = (RoleChatGift)ChatGiftFactory.getChatGift(-1);
/* 32 */     if (!roleChatGift.checkRoleInChannel(this.roleId, this.roleId)) {
/* 33 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 34 */       sChatGiftResult.result = 14;
/* 35 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 36 */       ChatGiftManager.logDebug("PCGetChatGiftLeftNumReq.processImp@can not get rolechatgift!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     ChatGiftIdList xChatGiftIdList = roleChatGift.getChannelChatGiftListWithChannelLock(this.roleId, true);
/*    */     
/* 42 */     Map<Long, ChatGift> chatGiftMap = ChatGiftManager.getChatGiftMap(xChatGiftIdList);
/* 43 */     roleChatGift.setChatGifts(chatGiftMap);
/* 44 */     roleChatGift.setxChatGiftIdList(xChatGiftIdList);
/*    */     
/* 46 */     roleChatGift.checkAndDeleteInvalidChatGift();
/*    */     
/* 48 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 49 */     int sendNum = 0;
/* 50 */     for (ChatGift xChatGift : roleChatGift.getChatGifts().values())
/*    */     {
/* 52 */       if (!DateTimeUtils.needDailyReset(xChatGift.getStarttime(), now, 0))
/*    */       {
/* 54 */         sendNum++;
/*    */       }
/*    */     }
/* 57 */     int leftNum = ChatGift_GfgManager.getRoleMaxChatGiftNum() - sendNum;
/* 58 */     if (leftNum < 0) {
/* 59 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 60 */       sChatGiftResult.result = 1;
/* 61 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 62 */       ChatGiftManager.logDebug("PCGetChatGiftLeftNumReq.processImp@send max error!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     SGetChatGiftLeftNumReq sGetChatGiftLeftNumReq = new SGetChatGiftLeftNumReq();
/* 67 */     sGetChatGiftLeftNumReq.leftnum = leftNum;
/* 68 */     OnlineManager.getInstance().send(this.roleId, sGetChatGiftLeftNumReq);
/* 69 */     ChatGiftManager.logInfo("PCGetChatGiftLeftNumReq.processImp@get leftnum success!|leftnum=%d|roleId=%d", new Object[] { Integer.valueOf(leftNum), Long.valueOf(this.roleId) });
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\PCGetChatGiftLeftNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */