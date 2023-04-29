/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.chat.ChatGiftOctets;
/*     */ import mzm.gsp.chat.SChatGiftResult;
/*     */ import mzm.gsp.chat.SGetChatGiftLeftNumReq;
/*     */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*     */ import mzm.gsp.chat.confbean.ChatGiftLevelCfg;
/*     */ import mzm.gsp.chatgift.event.ChatGiftSendArg;
/*     */ import mzm.gsp.chatgift.event.ChatGiftSendEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import xbean.ChannelSet;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ import xbean.Pod;
/*     */ import xtable.Chatgifttable;
/*     */ 
/*     */ public class PCChatGiftReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int channelType;
/*     */   private final int chatGiftType;
/*     */   private final int chatGiftNum;
/*     */   private String chatGiftStr;
/*     */   private final long curYuanBao;
/*     */   private final long roleId;
/*     */   private final long channelId;
/*     */   
/*     */   public PCChatGiftReq(long roleId, int channelType, int chatGiftType, int chatGiftNum, String chatGiftStr, long curYuanBao, long channelId)
/*     */   {
/*  45 */     this.roleId = roleId;
/*  46 */     this.channelType = channelType;
/*  47 */     this.chatGiftType = chatGiftType;
/*  48 */     this.chatGiftNum = chatGiftNum;
/*  49 */     this.chatGiftStr = chatGiftStr;
/*  50 */     this.curYuanBao = curYuanBao;
/*  51 */     this.channelId = channelId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     if (!ChatGiftManager.isChatGiftSwitchOpenForRole(this.roleId, this.channelType)) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!ChatGiftManager.checkRoleKuaFuStateCanUseFun(this.roleId)) {
/*  62 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@role in STATUS_ROAM status cannt use fun!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*  68 */     if (this.curYuanBao != QingfuInterface.getYuanbao(userid, true)) {
/*  69 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  70 */       sChatGiftResult.result = 5;
/*  71 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  72 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@cyuanbao not match syuanbao|roleid=%d|yuanBaoNum=%d|serverYuanBaoNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curYuanBao), Long.valueOf(QingfuInterface.getBalance(userid, false)) });
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     ChatGiftLevelCfg cGiftLevelCfg = ChatGiftLevelCfg.get(this.chatGiftType);
/*  77 */     if (cGiftLevelCfg == null) {
/*  78 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  79 */       sChatGiftResult.result = 3;
/*  80 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  81 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@ChatGiftLevelCfg not match!|roleid=%d|chatGiftType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.chatGiftType) });
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     int roleActive = ActiveInterface.getTotalActiveValue(this.roleId);
/*  86 */     if (roleActive < ChatGiftConsts.getInstance().needActiviteValue) {
/*  87 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/*  88 */       sChatGiftResult.result = 6;
/*  89 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/*  90 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@active not match!|roleid=%d|roleActive=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleActive) });
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     RoleChatGift roleChatGift = (RoleChatGift)ChatGiftFactory.getChatGift(-1);
/*  95 */     if (roleChatGift == null) {
/*  96 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@RoleChatGift is null|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     ChatGiftIdList xChatGiftIdList = roleChatGift.getChannelChatGiftListWithChannelLock(this.roleId, true);
/*     */     
/* 102 */     Map<Long, ChatGift> chatGiftMap = ChatGiftManager.getChatGiftMap(xChatGiftIdList);
/*     */     
/* 104 */     roleChatGift.setChatGifts(chatGiftMap);
/*     */     
/* 106 */     roleChatGift.setxChatGiftIdList(xChatGiftIdList);
/*     */     
/* 108 */     roleChatGift.checkAndDeleteInvalidChatGift();
/*     */     
/* 110 */     if (!roleChatGift.removeWithCfgBeforeAddChatGift())
/*     */     {
/* 112 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 113 */       sChatGiftResult.result = 1;
/* 114 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     BaseChatGift baseChatGift = ChatGiftFactory.getChatGift(this.channelType);
/* 120 */     if (baseChatGift == null) {
/* 121 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 122 */       sChatGiftResult.result = 7;
/* 123 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 124 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@BaseChatGift is null|channelType=%d", new Object[] { Integer.valueOf(this.channelType) });
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     Long channelValueId = baseChatGift.checkChannelId(this.roleId, this.channelId);
/* 129 */     if (channelValueId == null) {
/* 130 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 131 */       sChatGiftResult.result = 9;
/* 132 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 133 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@channel Invalid error|roleid=%d|chatType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.channelType) });
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     if (!baseChatGift.checkRoleInChannel(this.roleId, channelValueId.longValue())) {
/* 138 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 139 */       sChatGiftResult.result = 9;
/* 140 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 141 */       ChatGiftManager.logDebug("PCChatGiftReq.processImp@get data error|roleid=%d|chatType=%d|channelValue=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.channelType), Long.valueOf(channelValueId.longValue()) });
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     if (SensitiveInterface.isContentSensitive(this.chatGiftStr)) {
/* 146 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 147 */       sChatGiftResult.result = 0;
/* 148 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 149 */       return false;
/*     */     }
/* 151 */     this.chatGiftStr = this.chatGiftStr.trim();
/* 152 */     if ((this.chatGiftStr.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(this.chatGiftStr) / 2.0D) > ChatGiftConsts.getInstance().strLimitNum) || (!AvailableStringArgs.getInstance().isStringUsable(this.chatGiftStr))) {
/* 153 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 154 */       sChatGiftResult.result = 10;
/* 155 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     if (!baseChatGift.checkChannelMaxRoleNum(channelValueId.longValue(), this.chatGiftNum)) {
/* 160 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 161 */       sChatGiftResult.result = 11;
/* 162 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     long chatGiftId = UuidUtils.generateUuid(mzm.gsp.util.UuidUtils.UuidType.CHATGIFT);
/* 167 */     if (chatGiftId < 0L) {
/* 168 */       ChatGiftManager.logError("POnChannelChatGiftTimeOut.processImp@create chatgift error!|chatGiftType=%d|roleId=%d", new Object[] { Integer.valueOf(this.chatGiftType), Long.valueOf(this.roleId) });
/* 169 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 170 */       sChatGiftResult.result = 12;
/* 171 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 172 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 176 */     boolean costFlag = false;
/* 177 */     switch (cGiftLevelCfg.moneyType) {
/*     */     case 2: 
/* 179 */       costFlag = RoleInterface.cutGold(this.roleId, cGiftLevelCfg.moneyNum, new TLogArg(LogReason.CHATGIFT_SEND_COST, this.chatGiftType));
/* 180 */       break;
/*     */     case 1: 
/* 182 */       CostResult res = QingfuInterface.costYuanbao(userid, this.roleId, cGiftLevelCfg.moneyNum, mzm.gsp.qingfu.main.CostType.COST_UNBIND_YUANBAO_SEND_CHAT_GIFT, new TLogArg(LogReason.CHATGIFT_SEND_COST, this.chatGiftType));
/* 183 */       if (res == CostResult.Success) {
/* 184 */         costFlag = true;
/*     */       }
/*     */       break;
/*     */     default: 
/* 188 */       costFlag = false;
/*     */     }
/*     */     
/*     */     
/* 192 */     if (!costFlag) {
/* 193 */       ChatGiftManager.logDebug("POnChannelChatGiftTimeOut.processImp@money not enough!|moneyType=%d|nom=%d", new Object[] { Integer.valueOf(cGiftLevelCfg.moneyType), Integer.valueOf(cGiftLevelCfg.moneyNum) });
/* 194 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 195 */       sChatGiftResult.result = 2;
/* 196 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 197 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 201 */     ChatGift xChatGift = Pod.newChatGift();
/* 202 */     Chatgifttable.insert(Long.valueOf(chatGiftId), xChatGift);
/* 203 */     xChatGift.setRoleid(this.roleId);
/* 204 */     xChatGift.setDescstr(this.chatGiftStr);
/* 205 */     xChatGift.setNum(this.chatGiftNum);
/* 206 */     xChatGift.setStarttime(DateTimeUtils.getCurrTimeInMillis());
/* 207 */     xChatGift.setType(this.chatGiftType);
/*     */     
/*     */ 
/* 210 */     ChannelSet xChannelSet = Pod.newChannelSet();
/* 211 */     xChannelSet.getChanelids().add(channelValueId);
/* 212 */     xChatGift.getChannelinfo().put(Integer.valueOf(this.channelType), xChannelSet);
/*     */     
/* 214 */     if (!roleChatGift.addChatGift(-1, chatGiftId, xChatGiftIdList, xChatGift)) {
/* 215 */       ChatGiftManager.logDebug("POnChannelChatGiftTimeOut.processImp@add chatgift error!|moneyType=%d|nom=%d", new Object[] { Integer.valueOf(cGiftLevelCfg.moneyType), Integer.valueOf(cGiftLevelCfg.moneyNum) });
/* 216 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 217 */       sChatGiftResult.result = 12;
/* 218 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     ChatGiftIdList xChannelChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(channelValueId.longValue(), false);
/* 223 */     if (xChannelChatGiftIdList == null) {
/* 224 */       xChannelChatGiftIdList = baseChatGift.getChannelChatGiftListWithChannelLock(channelValueId.longValue(), true);
/*     */     }
/* 226 */     if (!baseChatGift.addChatGift(this.channelType, chatGiftId, xChannelChatGiftIdList, xChatGift)) {
/* 227 */       ChatGiftManager.logDebug("POnChannelChatGiftTimeOut.processImp@add chatgift error!|moneyType=%d|nom=%d", new Object[] { Integer.valueOf(cGiftLevelCfg.moneyType), Integer.valueOf(cGiftLevelCfg.moneyNum) });
/* 228 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 229 */       sChatGiftResult.result = 12;
/* 230 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 231 */       return false;
/*     */     }
/*     */     
/* 234 */     if (!baseChatGift.addRewardWithSendChatGift(xChatGift)) {
/* 235 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 236 */       sChatGiftResult.result = 23;
/* 237 */       OnlineManager.getInstance().sendAtOnce(xChatGift.getRoleid(), sChatGiftResult);
/* 238 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 242 */     Role role = RoleInterface.getRole(this.roleId, false);
/* 243 */     ChatGiftOctets chatGiftOctets = new ChatGiftOctets();
/* 244 */     chatGiftOctets.chatgiftid = chatGiftId;
/* 245 */     chatGiftOctets.chatgiftstr = this.chatGiftStr;
/*     */     
/* 247 */     boolean sendRes = baseChatGift.checkChatAndSend(this.roleId, this.channelId, new OctetsStream().marshal(chatGiftOctets));
/* 248 */     if (!sendRes) {
/* 249 */       SChatGiftResult sChatGiftResult = new SChatGiftResult();
/* 250 */       sChatGiftResult.result = 13;
/* 251 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sChatGiftResult);
/* 252 */       return false;
/*     */     }
/*     */     
/* 255 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 256 */     int sendNum = 0;
/* 257 */     for (ChatGift xChatGift_tmp : roleChatGift.getChatGifts().values())
/*     */     {
/* 259 */       if (!DateTimeUtils.needDailyReset(xChatGift_tmp.getStarttime(), now, 0))
/*     */       {
/* 261 */         sendNum++;
/*     */       }
/*     */     }
/* 264 */     int leftNum = ChatGift_GfgManager.getRoleMaxChatGiftNum() - sendNum;
/* 265 */     SGetChatGiftLeftNumReq sGetChatGiftLeftNumReq = new SGetChatGiftLeftNumReq();
/* 266 */     sGetChatGiftLeftNumReq.leftnum = leftNum;
/* 267 */     OnlineManager.getInstance().send(this.roleId, sGetChatGiftLeftNumReq);
/*     */     
/* 269 */     ChatGiftSendArg arg = new ChatGiftSendArg(this.roleId, chatGiftId, this.channelType, channelValueId.longValue(), cGiftLevelCfg.moneyType, cGiftLevelCfg.moneyNum);
/* 270 */     TriggerEventsManger.getInstance().triggerEvent(new ChatGiftSendEvent(), arg);
/*     */     
/* 272 */     ChatGiftManager.addSendChatGiftTlog(xChatGift, userid, role.getLevel(), chatGiftId, this.channelType, channelValueId.longValue(), this.chatGiftNum, cGiftLevelCfg);
/*     */     
/* 274 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\PCChatGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */