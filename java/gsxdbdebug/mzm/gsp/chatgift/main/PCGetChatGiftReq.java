/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.chat.SChatGiftResult;
/*     */ import mzm.gsp.chat.SGetChatGiftRes;
/*     */ import mzm.gsp.chat.confbean.ChatGiftLevelCfg;
/*     */ import mzm.gsp.chatgift.event.ChatGiftGetArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.ChannelSet;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftRoleGetInfo;
/*     */ import xbean.ChatGiftRoleMoney;
/*     */ import xbean.ChatGiftTimeList;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2getchatgiftinfo;
/*     */ 
/*     */ public class PCGetChatGiftReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int channelType;
/*     */   private final long chatGiftId;
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetChatGiftReq(long roleId, long chatGiftId, int channelType)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.channelType = channelType;
/*  33 */     this.chatGiftId = chatGiftId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(this.roleId, this.channelType)) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!ChatGiftManager.checkRoleKuaFuStateCanUseFun(this.roleId)) {
/*  44 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@role in STATUS_ROAM status cannt use fun!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  45 */       return false;
/*     */     }
/*  47 */     if (this.channelType == -1)
/*     */     {
/*  49 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  50 */       sChatGiftResult.result = 16;
/*  51 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     ChatGiftRoleGetInfo xChatGiftRoleGetInfo = Role2getchatgiftinfo.get(Long.valueOf(this.roleId));
/*  56 */     ChatGiftTimeList xChatGiftTimeList = null;
/*  57 */     if (xChatGiftRoleGetInfo == null) {
/*  58 */       xChatGiftRoleGetInfo = Pod.newChatGiftRoleGetInfo();
/*  59 */       Role2getchatgiftinfo.add(Long.valueOf(this.roleId), xChatGiftRoleGetInfo);
/*     */     }
/*  61 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  62 */     xChatGiftTimeList = (ChatGiftTimeList)xChatGiftRoleGetInfo.getChatgiftrolegetinfo().get(Integer.valueOf(this.channelType));
/*     */     
/*  64 */     if ((xChatGiftTimeList != null) && (xChatGiftTimeList.getChatgifttimelist().size() > 0)) {
/*  65 */       Iterator<Long> timeIterator = xChatGiftTimeList.getChatgifttimelist().iterator();
/*  66 */       while (timeIterator.hasNext()) {
/*  67 */         Long timeTemp = (Long)timeIterator.next();
/*  68 */         if (curTime - timeTemp.longValue() >= ChatGift_GfgManager.getChatGiftOutTime()) {
/*  69 */           timeIterator.remove();
/*     */         }
/*     */       }
/*  72 */       if (xChatGiftTimeList.getChatgifttimelist().size() >= ChatGift_GfgManager.getChatGiftDayGetNumWithType(this.channelType)) {
/*  73 */         SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  74 */         sChatGiftResult.result = 24;
/*  75 */         OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  76 */         ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@day get chatgift limit!|chatGiftId=%d|roleId=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId) });
/*  77 */         return true;
/*     */       }
/*     */     } else {
/*  80 */       xChatGiftTimeList = Pod.newChatGiftTimeList();
/*  81 */       xChatGiftRoleGetInfo.getChatgiftrolegetinfo().put(Integer.valueOf(this.channelType), xChatGiftTimeList);
/*     */     }
/*     */     
/*     */ 
/*  85 */     ChatGift xChatGift = xtable.Chatgifttable.get(Long.valueOf(this.chatGiftId));
/*  86 */     if (xChatGift == null) {
/*  87 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  88 */       sChatGiftResult.result = 17;
/*  89 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  90 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@chatGiftId not exist!|chatGiftId=%d|roleId=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId) });
/*  91 */       return false;
/*     */     }
/*  93 */     ChannelSet xChannelSet = (ChannelSet)xChatGift.getChannelinfo().get(Integer.valueOf(this.channelType));
/*  94 */     if (xChannelSet == null) {
/*  95 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  96 */       sChatGiftResult.result = 18;
/*  97 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  98 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@chatGiftId not have channelType!|chatGiftId=%d|channelType=%d", new Object[] { Long.valueOf(this.chatGiftId), Integer.valueOf(this.channelType) });
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if ((xChannelSet.getChanelids() == null) || (xChannelSet.getChanelids().size() == 0)) {
/* 103 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 104 */       sChatGiftResult.result = 18;
/* 105 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 106 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@ChannelSet not have channelid!|chatGiftId=%d", new Object[] { Long.valueOf(this.chatGiftId) });
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(this.channelType);
/*     */     
/* 112 */     Long channelId = baseChatGift.getRoleChannelIdWithChannelSet(this.roleId, xChannelSet.getChanelids());
/* 113 */     if (channelId == null) {
/* 114 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 115 */       sChatGiftResult.result = 14;
/* 116 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 117 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@can not get channelType!|channelType=%d|roleId=%d", new Object[] { Integer.valueOf(this.channelType), Long.valueOf(this.roleId) });
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     if (xChatGift.getRole2money().size() >= xChatGift.getNum()) {
/* 123 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 124 */       sChatGiftResult.result = 20;
/* 125 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 126 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@chatGift is max num!|chatGiftId=%d|num=%d", new Object[] { Long.valueOf(this.chatGiftId), Integer.valueOf(xChatGift.getNum()) });
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     if (xChatGift.getRole2money().containsKey(Long.valueOf(this.roleId))) {
/* 131 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 132 */       sChatGiftResult.result = 19;
/* 133 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 134 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@chatGift have get!|chatGiftId=%d|roleId=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId) });
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     ChatGiftLevelCfg cGiftLevelCfg = ChatGiftLevelCfg.get(xChatGift.getType());
/* 139 */     if (cGiftLevelCfg == null) {
/* 140 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 141 */       sChatGiftResult.result = 3;
/* 142 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 143 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@ChatGiftLevelCfg not match!|roleid=%d|chatGiftId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.chatGiftId) });
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     int getMoney = ChatGiftManager.getChatGiftMoney(this.roleId, xChatGift);
/* 148 */     if (getMoney <= 0) {
/* 149 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 150 */       sChatGiftResult.result = 21;
/* 151 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 152 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@chatGift have get!|chatGiftId=%d|roleId=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId) });
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     ModMoneyResult addMoneyRes = null;
/* 157 */     switch (cGiftLevelCfg.giftMoneyType) {
/*     */     case 2: 
/* 159 */       addMoneyRes = RoleInterface.addGold(this.roleId, getMoney, new TLogArg(mzm.gsp.tlog.LogReason.CHATGIFT_GET_ADD, xChatGift.getType()), true);
/* 160 */       break;
/*     */     case 3: 
/* 162 */       addMoneyRes = RoleInterface.addSilver(this.roleId, getMoney, new TLogArg(mzm.gsp.tlog.LogReason.CHATGIFT_GET_ADD, xChatGift.getType()), true);
/* 163 */       break;
/*     */     default: 
/* 165 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@cGiftLevelCfg.giftMoneyType error!|chatGiftId=%d|roleId=%d|giftMoneyType=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId), Integer.valueOf(cGiftLevelCfg.giftMoneyType) });
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     if ((addMoneyRes != null) && (!addMoneyRes.isSucceed())) {
/* 170 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 171 */       sChatGiftResult.result = 22;
/* 172 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 173 */       ChatGiftManager.logDebug("PCGetChatGiftReq.processImp@addMoney error!|chatGiftId=%d|roleId=%d|moneyNum=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId), Integer.valueOf(getMoney) });
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     String roleName = RoleInterface.getName(this.roleId);
/* 178 */     ChatGiftRoleMoney xChatGiftRoleMoney = Pod.newChatGiftRoleMoney();
/* 179 */     xChatGiftRoleMoney.setRolename(roleName);
/* 180 */     xChatGiftRoleMoney.setMoneynum(getMoney);
/* 181 */     xChatGift.getRole2money().put(Long.valueOf(this.roleId), xChatGiftRoleMoney);
/*     */     
/* 183 */     xChatGiftTimeList.getChatgifttimelist().add(Long.valueOf(curTime));
/*     */     
/* 185 */     SGetChatGiftRes sGetChatGiftRes = new SGetChatGiftRes();
/* 186 */     sGetChatGiftRes.channeltype = this.channelType;
/* 187 */     sGetChatGiftRes.money = getMoney;
/* 188 */     sGetChatGiftRes.moneytype = cGiftLevelCfg.giftMoneyType;
/* 189 */     OnlineManager.getInstance().send(this.roleId, sGetChatGiftRes);
/*     */     
/* 191 */     ChatGiftGetArg arg = new ChatGiftGetArg(this.chatGiftId, this.channelType, xChatGift.getRoleid(), this.roleId, roleName, cGiftLevelCfg.giftMoneyType, getMoney, channelId.longValue());
/* 192 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.chatgift.event.ChatGiftGetEvent(), arg);
/*     */     
/* 194 */     ChatGiftManager.logInfo("PCGetChatGiftReq.processImp@get chatgift success!|chatGiftId=%d|roleId=%d|moneyNum=%d", new Object[] { Long.valueOf(this.chatGiftId), Long.valueOf(this.roleId), Integer.valueOf(getMoney) });
/*     */     
/* 196 */     ChatGiftManager.addGetChatGiftTlog(xChatGift, this.roleId, RoleInterface.getUserId(this.roleId), RoleInterface.getLevel(this.roleId), getMoney, getMoney, this.chatGiftId, getMoney, xChatGift.getNum() - xChatGift.getRole2money().size(), cGiftLevelCfg.giftMoneyType);
/* 197 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\PCGetChatGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */