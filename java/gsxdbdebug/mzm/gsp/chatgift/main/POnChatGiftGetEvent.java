/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.chat.SSyncGetChatGiftMoreMoney;
/*    */ import mzm.gsp.chat.SSyncGetChatGiftRes;
/*    */ import mzm.gsp.chatgift.event.ChatGiftGetArg;
/*    */ import mzm.gsp.chatgift.event.ChatGiftGetEventProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.ChatGift;
/*    */ import xbean.ChatGiftRoleMoney;
/*    */ import xtable.Chatgifttable;
/*    */ 
/*    */ public class POnChatGiftGetEvent
/*    */   extends ChatGiftGetEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if (!ChatGiftManager.isChatGiftSwitchOpen(((ChatGiftGetArg)this.arg).channelType)) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     String roleName = RoleInterface.getName(((ChatGiftGetArg)this.arg).chatGiftRoleId);
/*    */     
/* 27 */     SSyncGetChatGiftRes sSyncGetChatGiftRes = new SSyncGetChatGiftRes();
/* 28 */     sSyncGetChatGiftRes.channeltype = ((ChatGiftGetArg)this.arg).channelType;
/* 29 */     sSyncGetChatGiftRes.chatgiftid = ((ChatGiftGetArg)this.arg).chatGiftId;
/* 30 */     sSyncGetChatGiftRes.roleid = ((ChatGiftGetArg)this.arg).chatGiftRoleId;
/* 31 */     sSyncGetChatGiftRes.rolename = roleName;
/* 32 */     sSyncGetChatGiftRes.getroleid = ((ChatGiftGetArg)this.arg).getRoldId;
/* 33 */     sSyncGetChatGiftRes.getrolename = ((ChatGiftGetArg)this.arg).getRoleName;
/* 34 */     sSyncGetChatGiftRes.channelid = ((ChatGiftGetArg)this.arg).channelId;
/*    */     
/* 36 */     OnlineManager.getInstance().sendMulti(sSyncGetChatGiftRes, Arrays.asList(new Long[] { Long.valueOf(((ChatGiftGetArg)this.arg).chatGiftRoleId), Long.valueOf(((ChatGiftGetArg)this.arg).getRoldId) }));
/* 37 */     ChatGift xChatGift = Chatgifttable.select(Long.valueOf(((ChatGiftGetArg)this.arg).chatGiftId));
/*    */     
/* 39 */     if ((xChatGift != null) && (xChatGift.getRole2money().size() == xChatGift.getNum())) {
/* 40 */       SSyncGetChatGiftMoreMoney sSyncGetChatGiftMoreMoney = new SSyncGetChatGiftMoreMoney();
/* 41 */       sSyncGetChatGiftMoreMoney.chatgiftid = ((ChatGiftGetArg)this.arg).chatGiftId;
/* 42 */       sSyncGetChatGiftMoreMoney.channeltype = ((ChatGiftGetArg)this.arg).channelType;
/* 43 */       sSyncGetChatGiftMoreMoney.sendrolename = RoleInterface.getName(xChatGift.getRoleid());
/* 44 */       sSyncGetChatGiftMoreMoney.channelid = ((ChatGiftGetArg)this.arg).channelId;
/* 45 */       int tempMoney = 0;
/* 46 */       for (ChatGiftRoleMoney xChatGiftRoleMoney : xChatGift.getRole2money().values()) {
/* 47 */         if (xChatGiftRoleMoney.getMoneynum() > tempMoney) {
/* 48 */           sSyncGetChatGiftMoreMoney.getrolename = xChatGiftRoleMoney.getRolename();
/* 49 */           tempMoney = xChatGiftRoleMoney.getMoneynum();
/*    */         }
/*    */       }
/* 52 */       BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(((ChatGiftGetArg)this.arg).channelType);
/* 53 */       Set<Long> roleSet = baseChatGift.getChannelRoleSet(((ChatGiftGetArg)this.arg).getRoldId, ((ChatGiftGetArg)this.arg).channelId);
/* 54 */       OnlineManager.getInstance().sendMulti(sSyncGetChatGiftMoreMoney, roleSet);
/*    */     }
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnChatGiftGetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */