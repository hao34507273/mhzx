/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*     */ import mzm.gsp.chat.confbean.ChatGiftLevelCfg;
/*     */ import mzm.gsp.chatgift.event.ChatGiftSettle;
/*     */ import mzm.gsp.chatgift.event.ChatGiftSettleArg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import xbean.ChannelSet;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ import xtable.Chatgifttable;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleChatGiftTimeOut
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long chatGiftId;
/*     */   private final long roleId;
/*     */   
/*     */   POnRoleChatGiftTimeOut(long roleId, long chatGiftId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.chatGiftId = chatGiftId;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  40 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(this.roleId, -1)) {
/*  41 */       ChatGiftManager.logDebug("POnRoleChatGiftTimeOut.processImp@RoleChatGift is close|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     RoleChatGift roleChatGift = (RoleChatGift)ChatGiftFactory.getChatGift(-1);
/*  46 */     if (roleChatGift == null) {
/*  47 */       ChatGiftManager.logDebug("POnRoleLogin.processImp@RoleChatGift is null|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     ChatGiftIdList xChatGiftIdList = roleChatGift.getChannelChatGiftListWithChannelLock(this.roleId, true);
/*  52 */     if (xChatGiftIdList == null) {
/*  53 */       ChatGiftManager.logDebug("POnRoleChatGiftTimeOut.processImp@ChatGiftIdList is null!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     ChatGift xChatGift = Chatgifttable.get(Long.valueOf(this.chatGiftId));
/*     */     
/*  59 */     if (xChatGift == null) {
/*  60 */       ChatGiftManager.logDebug("POnRoleChatGiftTimeOut.processImp@ChatGift is null!|roleid=%d|chatGiftId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.chatGiftId) });
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     if (xChatGift.getRole2money().size() < xChatGift.getNum()) {
/*  66 */       int totalMoney = ChatGiftManager.getTotalGainMoney(xChatGift);
/*     */       
/*  68 */       ChatGiftLevelCfg chatGiftLevelCfg = ChatGiftLevelCfg.get(xChatGift.getType());
/*  69 */       if (chatGiftLevelCfg == null) {
/*  70 */         ChatGiftManager.logDebug("POnRoleChatGiftTimeOut.processImp@ChatGiftLevelCfg not exist!|roleid=%d|chatGiftId=%d|chatGiftCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.chatGiftId), Integer.valueOf(xChatGift.getType()) });
/*  71 */         return false;
/*     */       }
/*  73 */       int returnMoney = chatGiftLevelCfg.giftMoneyNum - totalMoney;
/*  74 */       if (returnMoney <= 0) {
/*  75 */         ChatGiftManager.logDebug("POnRoleChatGiftTimeOut.processImp@returnMoney error !|roleid=%d|chatGiftId=%d|chatGiftCfgId=%d|returnMoney=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.chatGiftId), Integer.valueOf(xChatGift.getType()), Integer.valueOf(returnMoney) });
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       TLogArg logArg = new TLogArg(LogReason.CHATGIFT_AUTOBACK_ADD, xChatGift.getType());
/*  80 */       MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*  81 */       if (chatGiftLevelCfg.giftMoneyType == 3) {
/*  82 */         mailAttachment.setSilver(returnMoney);
/*  83 */         logArg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf(returnMoney));
/*  84 */       } else if (chatGiftLevelCfg.giftMoneyType == 2) {
/*  85 */         mailAttachment.setGold(returnMoney);
/*  86 */         logArg.addCurrencytype2num(CurrencyType.CURRENCY_SILVE, Integer.valueOf(returnMoney));
/*     */       } else {
/*  88 */         ChatGiftManager.logDebug("POnRoleChatGiftTimeOut.processImp@cant find moneytype error !|roleid=%d|chatGiftId=%d|giftMoneyType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.chatGiftId), Integer.valueOf(chatGiftLevelCfg.giftMoneyType) });
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       MailInterface.synBuildAndSendMail(this.roleId, ChatGiftConsts.getInstance().autoBackMail, new ArrayList(), new ArrayList(), mailAttachment, logArg);
/*     */       
/*     */ 
/*  95 */       ChatGiftManager.addAutoBackChatGiftTlog(xChatGift, RoleInterface.getUserId(this.roleId), RoleInterface.getLevel(this.roleId), this.chatGiftId, returnMoney, xChatGift.getNum() - xChatGift.getRole2money().size(), chatGiftLevelCfg.giftMoneyType);
/*     */     }
/*  97 */     Chatgifttable.remove(Long.valueOf(this.chatGiftId));
/*     */     
/*  99 */     if (xChatGiftIdList.getChatgiftlist().contains(Long.valueOf(this.chatGiftId)))
/*     */     {
/* 101 */       xChatGiftIdList.getChatgiftlist().remove(Long.valueOf(this.chatGiftId)); }
/*     */     ChatGiftLevelCfg cfg;
/* 103 */     if (!xChatGift.getRole2money().isEmpty())
/*     */     {
/* 105 */       cfg = ChatGiftLevelCfg.get(xChatGift.getType());
/* 106 */       if (cfg == null)
/*     */       {
/* 108 */         return false;
/*     */       }
/* 110 */       Map<Integer, ChannelSet> channelMap = xChatGift.getChannelinfo();
/* 111 */       if ((channelMap != null) && (channelMap.size() > 0))
/*     */       {
/* 113 */         for (Map.Entry<Integer, ChannelSet> channelEntry : channelMap.entrySet())
/*     */         {
/* 115 */           TriggerEventsManger.getInstance().triggerEvent(new ChatGiftSettle(), new ChatGiftSettleArg(((Integer)channelEntry.getKey()).intValue(), cfg.giftMoneyType, xChatGift.getRole2money()));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 121 */     ChatGiftManager.logInfo("POnRoleChatGiftTimeOut.processImp@chatgift time out and delete!|roleid=%d|chatGiftId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.chatGiftId) });
/*     */     
/* 123 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnRoleChatGiftTimeOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */