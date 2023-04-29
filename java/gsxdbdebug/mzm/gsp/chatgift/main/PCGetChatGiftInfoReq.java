/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.chat.ChatGiftInfo;
/*     */ import mzm.gsp.chat.GetChatGiftInfo;
/*     */ import mzm.gsp.chat.SChatGiftResult;
/*     */ import mzm.gsp.chat.SGetChatGiftInfoRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import xbean.ChannelSet;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftRoleMoney;
/*     */ 
/*     */ public class PCGetChatGiftInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int channelType;
/*     */   private final long chatGiftId;
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetChatGiftInfoReq(long roleId, long chatGiftId, int channelType)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.channelType = channelType;
/*  28 */     this.chatGiftId = chatGiftId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(this.roleId, this.channelType)) {
/*  35 */       return false;
/*     */     }
/*  37 */     if (this.channelType == -1)
/*     */     {
/*  39 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  40 */       sChatGiftResult.result = 16;
/*  41 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     ChatGift xChatGift = xtable.Chatgifttable.select(Long.valueOf(this.chatGiftId));
/*  46 */     if (xChatGift == null) {
/*  47 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  48 */       sChatGiftResult.result = 17;
/*  49 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  50 */       ChatGiftManager.logDebug("PCGetChatGiftInfoReq.processImp@chatGiftId not exist!|chatGiftId=%d|roleId=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId) });
/*  51 */       return false;
/*     */     }
/*  53 */     ChannelSet xChannelSet = (ChannelSet)xChatGift.getChannelinfo().get(Integer.valueOf(this.channelType));
/*  54 */     if (xChannelSet == null) {
/*  55 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  56 */       sChatGiftResult.result = 18;
/*  57 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  58 */       ChatGiftManager.logDebug("PCGetChatGiftInfoReq.processImp@chatGiftId not have channelType!|chatGiftId=%d|channelType=%d", new Object[] { Long.valueOf(this.chatGiftId), Integer.valueOf(this.channelType) });
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if ((xChannelSet.getChanelids() == null) || (xChannelSet.getChanelids().size() == 0)) {
/*  63 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  64 */       sChatGiftResult.result = 18;
/*  65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  66 */       ChatGiftManager.logDebug("PCGetChatGiftInfoReq.processImp@ChannelSet not have channelid!|chatGiftId=%d", new Object[] { Long.valueOf(this.chatGiftId) });
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(this.channelType);
/*     */     
/*  72 */     Long channelId = baseChatGift.getRoleChannelIdWithChannelSet(this.roleId, xChannelSet.getChanelids());
/*  73 */     if (channelId == null) {
/*  74 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  75 */       sChatGiftResult.result = 14;
/*  76 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  77 */       ChatGiftManager.logDebug("PCGetChatGiftInfoReq.processImp@can not get channelType!|channelType=%d|roleId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.roleId) });
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     Role role = mzm.gsp.role.main.RoleInterface.getRole(xChatGift.getRoleid(), false);
/*     */     
/*  83 */     SGetChatGiftInfoRes sGetChatGiftRes = new SGetChatGiftInfoRes();
/*  84 */     sGetChatGiftRes.chatgiftinfo.roleid = xChatGift.getRoleid();
/*  85 */     sGetChatGiftRes.chatgiftinfo.rolelevel = role.getLevel();
/*  86 */     sGetChatGiftRes.chatgiftinfo.gender = role.getGender();
/*  87 */     sGetChatGiftRes.chatgiftinfo.menpai = role.getOccupationId();
/*  88 */     sGetChatGiftRes.chatgiftinfo.avatarid = AvatarInterface.getCurrentAvatar(xChatGift.getRoleid());
/*  89 */     sGetChatGiftRes.chatgiftinfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(xChatGift.getRoleid(), false);
/*  90 */     sGetChatGiftRes.chatgiftinfo.rolename = role.getName();
/*  91 */     sGetChatGiftRes.chatgiftinfo.chatgiftstr = xChatGift.getDescstr();
/*  92 */     sGetChatGiftRes.chatgiftinfo.chatgiftid = this.chatGiftId;
/*  93 */     sGetChatGiftRes.chatgiftinfo.chatgiftnum = xChatGift.getNum();
/*  94 */     sGetChatGiftRes.chatgiftinfo.chatgifttype = xChatGift.getType();
/*     */     
/*  96 */     if ((xChatGift.getRole2money() != null) && (xChatGift.getRole2money().size() > 0)) {
/*  97 */       for (Map.Entry<Long, ChatGiftRoleMoney> role2moneyEntry : xChatGift.getRole2money().entrySet()) {
/*  98 */         GetChatGiftInfo getChatGiftInfo = new GetChatGiftInfo();
/*  99 */         getChatGiftInfo.moneynum = ((ChatGiftRoleMoney)role2moneyEntry.getValue()).getMoneynum();
/* 100 */         getChatGiftInfo.roleid = ((Long)role2moneyEntry.getKey()).longValue();
/* 101 */         getChatGiftInfo.rolename = ((ChatGiftRoleMoney)role2moneyEntry.getValue()).getRolename();
/* 102 */         sGetChatGiftRes.chatgiftinfo.getchatgiftinfo.add(getChatGiftInfo);
/*     */       }
/*     */     }
/* 105 */     OnlineManager.getInstance().send(this.roleId, sGetChatGiftRes);
/*     */     
/* 107 */     ChatGiftManager.logInfo("PCGetChatGiftInfoReq.processImp@get chatgiftinfo success!|chatGiftId=%d|roleId=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId) });
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\PCGetChatGiftInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */