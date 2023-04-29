/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.chat.GetChatGiftSimpleInfo;
/*     */ import mzm.gsp.chat.SChatGiftResult;
/*     */ import mzm.gsp.chat.SGetChatGiftListRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetChatGiftListReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int channelType;
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetChatGiftListReq(long roleId, int channelType)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.channelType = channelType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(this.roleId, this.channelType)) {
/*  34 */       return false;
/*     */     }
/*  36 */     if ((this.channelType == -1) || (this.channelType == 10))
/*     */     {
/*  38 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  39 */       sChatGiftResult.result = 16;
/*  40 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(this.channelType);
/*  45 */     Long channelId = baseChatGift.getChannelId(this.roleId);
/*  46 */     if (channelId == null) {
/*  47 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  48 */       sChatGiftResult.result = 15;
/*  49 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  50 */       ChatGiftManager.logDebug("PCGetChatGiftListReq.processImp@can not get chatgiftlist data!|channelType=%d|roleId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.roleId) });
/*  51 */       return false;
/*     */     }
/*  53 */     if (!baseChatGift.checkRoleInChannel(this.roleId, channelId.longValue())) {
/*  54 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  55 */       sChatGiftResult.result = 14;
/*  56 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  57 */       ChatGiftManager.logDebug("PCGetChatGiftListReq.processImp@can not get channelType!|channelType=%d|roleId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.roleId) });
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     SGetChatGiftListRes sGetChatGiftRes = new SGetChatGiftListRes();
/*     */     
/*  64 */     ChatGiftIdList xChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(channelId.longValue(), false);
/*  65 */     if (xChatGiftIdList == null)
/*     */     {
/*  67 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetChatGiftRes);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     Map<Long, ChatGift> chatGiftMap = ChatGiftManager.getChatGiftMap(xChatGiftIdList);
/*  72 */     if (chatGiftMap.size() == 0)
/*     */     {
/*  74 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetChatGiftRes);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     baseChatGift.setChatGifts(chatGiftMap);
/*  79 */     baseChatGift.setxChatGiftIdList(xChatGiftIdList);
/*     */     
/*  81 */     baseChatGift.checkAndDeleteInvalidChatGift();
/*  82 */     for (Map.Entry<Long, ChatGift> chatGiftEntry : baseChatGift.getChatGifts().entrySet()) {
/*  83 */       GetChatGiftSimpleInfo getChatGiftSimpleInfo = new GetChatGiftSimpleInfo();
/*  84 */       getChatGiftSimpleInfo.chatgiftid = ((Long)chatGiftEntry.getKey()).longValue();
/*  85 */       getChatGiftSimpleInfo.chatgiftstr = ((ChatGift)chatGiftEntry.getValue()).getDescstr();
/*     */       
/*  87 */       getChatGiftSimpleInfo.rolename = RoleInterface.getName(((ChatGift)chatGiftEntry.getValue()).getRoleid());
/*  88 */       if (((ChatGift)chatGiftEntry.getValue()).getRole2money() == null) {
/*  89 */         getChatGiftSimpleInfo.iscanget = 1;
/*     */       }
/*  91 */       else if (((ChatGift)chatGiftEntry.getValue()).getRole2money().size() >= ((ChatGift)chatGiftEntry.getValue()).getNum()) {
/*  92 */         getChatGiftSimpleInfo.iscanget = 0;
/*     */       }
/*  94 */       else if (((ChatGift)chatGiftEntry.getValue()).getRole2money().containsKey(Long.valueOf(this.roleId))) {
/*  95 */         getChatGiftSimpleInfo.iscanget = 0;
/*     */       } else {
/*  97 */         getChatGiftSimpleInfo.iscanget = 1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 102 */       sGetChatGiftRes.chatgiftlist.add(getChatGiftSimpleInfo);
/*     */     }
/*     */     
/* 105 */     OnlineManager.getInstance().send(this.roleId, sGetChatGiftRes);
/*     */     
/* 107 */     ChatGiftManager.logInfo("PCGetChatGiftListReq.processImp@get chatgiftinfolist success!|channelValue=%d|roleId=%d", new Object[] { Long.valueOf(channelId.longValue()), Long.valueOf(this.roleId) });
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\PCGetChatGiftListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */