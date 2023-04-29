/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*     */ import mzm.gsp.chat.confbean.ChatGiftLevelCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChannelSet;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ import xbean.ChatGiftRoleMoney;
/*     */ import xdb.Xdb;
/*     */ import xtable.Chatgifttable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ChatGiftManager
/*     */ {
/*  38 */   private static final Logger logger = Logger.getLogger(ChatGiftManager.class);
/*     */   
/*  40 */   private static ChatGiftManager instance = new ChatGiftManager();
/*     */   
/*     */   public static final int ROLE_CHATGIFT_TYPE = -1;
/*     */   public static final int ROLE_CHATGIFT_BASE_RATE = 10000;
/*     */   
/*     */   public static ChatGiftManager getInstance()
/*     */   {
/*  47 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void postInit() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static Map<Long, ChatGift> getChatGiftMap(ChatGiftIdList xChatGiftIdList)
/*     */   {
/*  66 */     Map<Long, ChatGift> chatGiftMap = new HashMap();
/*  67 */     if ((xChatGiftIdList != null) && (xChatGiftIdList.getChatgiftlist().size() > 0)) {
/*  68 */       Iterator<Long> chatGiftIdIterator = xChatGiftIdList.getChatgiftlist().iterator();
/*  69 */       while (chatGiftIdIterator.hasNext()) {
/*  70 */         long chatGiftId = ((Long)chatGiftIdIterator.next()).longValue();
/*  71 */         ChatGift xChatGift = Chatgifttable.select(Long.valueOf(chatGiftId));
/*  72 */         if (xChatGift == null) {
/*  73 */           chatGiftIdIterator.remove();
/*     */         }
/*     */         else
/*  76 */           chatGiftMap.put(Long.valueOf(chatGiftId), xChatGift);
/*     */       }
/*     */     }
/*  79 */     return chatGiftMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static int getChatGiftMoney(long roleId, ChatGift xChatGift)
/*     */   {
/*  89 */     int totalMoneyNum = getTotalGainMoney(xChatGift);
/*  90 */     ChatGiftLevelCfg chatGiftLevelCfg = ChatGiftLevelCfg.get(xChatGift.getType());
/*  91 */     if (chatGiftLevelCfg == null) {
/*  92 */       logDebug("ChatGiftManager.getChatGiftMoney@ChatGift is null!", new Object[0]);
/*  93 */       return -1;
/*     */     }
/*  95 */     int leftMoneyNum = chatGiftLevelCfg.giftMoneyNum - totalMoneyNum;
/*  96 */     if (leftMoneyNum <= 0) {
/*  97 */       logDebug("ChatGiftManager.getChatGiftMoney@totalMoneyNum over cfgMoneynum!", new Object[0]);
/*  98 */       return -1;
/*     */     }
/* 100 */     int leftNum = xChatGift.getNum() - xChatGift.getRole2money().size();
/* 101 */     if (leftNum <= 0) {
/* 102 */       logDebug("ChatGiftManager.getChatGiftMoney@leftnum error!", new Object[0]);
/* 103 */       return -1;
/*     */     }
/* 105 */     if (leftNum == 1) {
/* 106 */       return leftMoneyNum;
/*     */     }
/* 108 */     int averageMoney = leftMoneyNum / leftNum;
/* 109 */     if (averageMoney == 0) {
/* 110 */       logDebug("ChatGiftManager.getChatGiftMoney@leftMoneyNum less 1 error!", new Object[0]);
/* 111 */       averageMoney = 1;
/* 112 */       return 1;
/*     */     }
/* 114 */     int prop = Xdb.random().nextInt(ChatGiftConsts.getInstance().getMoneyMaxLimit - ChatGiftConsts.getInstance().getMoneyMinLimit) + ChatGiftConsts.getInstance().getMoneyMinLimit;
/* 115 */     int getMoney = prop * averageMoney / 10000;
/* 116 */     if (getMoney == 0) {
/* 117 */       getMoney = 1;
/*     */     }
/* 119 */     return getMoney;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static int getTotalGainMoney(ChatGift xChatGift)
/*     */   {
/* 130 */     int totalMoneyNum = 0;
/* 131 */     if (xChatGift == null) {
/* 132 */       logDebug("ChatGiftManager.getTotalGainMoney@ChatGift is null!", new Object[0]);
/* 133 */       return totalMoneyNum;
/*     */     }
/* 135 */     for (ChatGiftRoleMoney xChatGiftRoleMoney : xChatGift.getRole2money().values()) {
/* 136 */       totalMoneyNum += xChatGiftRoleMoney.getMoneynum();
/*     */     }
/* 138 */     return totalMoneyNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static boolean checkChatGiftInChannel(ChatGift xChatGift, int channelType, long chatGiftTypeValue)
/*     */   {
/* 149 */     if (xChatGift == null) {
/* 150 */       logDebug("ChatGiftManager.checkChatGiftInChannel@ChatGift is null!", new Object[0]);
/* 151 */       return false;
/*     */     }
/* 153 */     if (xChatGift.getChannelinfo() == null) {
/* 154 */       logDebug("ChatGiftManager.checkChatGiftInChannel@ChatGift getChannelinfo is null!", new Object[0]);
/* 155 */       return false;
/*     */     }
/* 157 */     if (xChatGift.getChannelinfo().get(Integer.valueOf(channelType)) == null) {
/* 158 */       logDebug("ChatGiftManager.checkChatGiftInChannel@ChatGift channelType is null!", new Object[0]);
/* 159 */       return false;
/*     */     }
/* 161 */     if (((ChannelSet)xChatGift.getChannelinfo().get(Integer.valueOf(channelType))).getChanelids() == null) {
/* 162 */       logDebug("ChatGiftManager.checkChatGiftInChannel@ChatGift getChanelids is null!", new Object[0]);
/* 163 */       return false;
/*     */     }
/* 165 */     if (((ChannelSet)xChatGift.getChannelinfo().get(Integer.valueOf(channelType))).getChanelids().contains(Long.valueOf(chatGiftTypeValue))) {
/* 166 */       return true;
/*     */     }
/* 168 */     logDebug("ChatGiftManager.checkChatGiftInChannel@ChatGift not in channel!|channelType=%d|chatGiftTypeValue=%d", new Object[] { Integer.valueOf(channelType), Long.valueOf(chatGiftTypeValue) });
/* 169 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static void addSendChatGiftTlog(ChatGift xChatGift, String userId, int roleLevel, long chatGiftId, long channelType, long channelVaule, int chatGiftNum, ChatGiftLevelCfg chatGiftLevelCfg)
/*     */   {
/* 184 */     StringBuilder tlogStr = new StringBuilder();
/* 185 */     tlogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(xChatGift.getRoleid()).append("|").append(roleLevel).append("|").append(chatGiftId).append("|").append(xChatGift.getType()).append("|").append(channelType).append("|").append(channelVaule).append("|").append(chatGiftNum).append("|").append(chatGiftLevelCfg.moneyType).append("|").append(chatGiftLevelCfg.moneyNum).append("|").append(chatGiftLevelCfg.giftMoneyType).append("|").append(chatGiftLevelCfg.giftMoneyNum);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */     TLogManager.getInstance().addLog(xChatGift.getRoleid(), "ChatGiftSendTLog", tlogStr.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static void addGetChatGiftTlog(ChatGift xChatGift, long roleId, String userId, int roleLevel, long chatGiftId, long channelType, long channelVaule, int getMoney, int chatGiftLeftNum, int getMoneyType)
/*     */   {
/* 218 */     StringBuilder tlogStr = new StringBuilder();
/* 219 */     tlogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(roleId).append("|").append(roleLevel).append("|").append(chatGiftId).append("|").append(xChatGift.getType()).append("|").append(channelType).append("|").append(channelVaule).append("|").append(xChatGift.getRoleid()).append("|").append(getMoney).append("|").append(chatGiftLeftNum).append("|").append(getMoneyType);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 233 */     TLogManager.getInstance().addLog(roleId, "ChatGiftGetTLog", tlogStr.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static void addAutoBackChatGiftTlog(ChatGift xChatGift, String userId, int roleLevel, long chatGiftId, int backMoney, int leftNum, int getMoneyType)
/*     */   {
/* 249 */     StringBuilder tlogStr = new StringBuilder();
/* 250 */     tlogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(xChatGift.getRoleid()).append("|").append(roleLevel).append("|").append(chatGiftId).append("|").append(xChatGift.getType()).append("|").append(backMoney).append("|").append(leftNum).append("|").append(leftNum);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 261 */     TLogManager.getInstance().addLog(xChatGift.getRoleid(), "ChatGiftAutoBackTLog", tlogStr.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logDebug(String format, Object... args)
/*     */   {
/* 269 */     if (logger.isDebugEnabled()) {
/* 270 */       logger.debug(String.format(format, args));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logError(String format, Object... args)
/*     */   {
/* 280 */     logger.error(String.format(format, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logInfo(String format, Object... args)
/*     */   {
/* 289 */     logger.info(String.format(format, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static boolean isChatGiftSwitchOpenForRole(long roleid, int channelType)
/*     */   {
/* 299 */     int modelId = getChannelTypeModelId(channelType);
/* 300 */     if (modelId == -1) {
/* 301 */       logDebug("ChatGiftManager.isChatGiftSwitchOpenForRole@ChatGift channeltype error!|channelType=%d", new Object[] { Integer.valueOf(channelType) });
/* 302 */       return false;
/*     */     }
/* 304 */     if (OpenInterface.isBanPlay(roleid, 166))
/*     */     {
/* 306 */       OpenInterface.sendCloseProtocol(roleid, 166, null);
/* 307 */       return false;
/*     */     }
/* 309 */     if (OpenInterface.isBanPlay(roleid, modelId))
/*     */     {
/* 311 */       OpenInterface.sendCloseProtocol(roleid, modelId, null);
/* 312 */       return false;
/*     */     }
/* 314 */     if (!isChatGiftSwitchOpen(modelId)) {
/* 315 */       return false;
/*     */     }
/* 317 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static int getChannelTypeModelId(int channelType)
/*     */   {
/* 326 */     switch (channelType) {
/*     */     case -1: 
/* 328 */       return 166;
/*     */     case 2: 
/* 330 */       return 167;
/*     */     case 10: 
/* 332 */       return 170;
/*     */     }
/*     */     
/*     */     
/* 336 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static boolean isChatGiftSwitchOpen(int modelId)
/*     */   {
/* 344 */     if (!OpenInterface.getOpenStatus(166))
/*     */     {
/* 346 */       return false;
/*     */     }
/* 348 */     if (!OpenInterface.getOpenStatus(modelId))
/*     */     {
/* 350 */       return false;
/*     */     }
/* 352 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkRoleKuaFuStateCanUseFun(long roleid)
/*     */   {
/* 362 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 194, true)) {
/* 363 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleid);
/* 364 */       GameServer.logger().error(String.format("[chatgift]ChatGiftManager.checkRoleKuaFuStateCanUseFun@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleid), statusSet }));
/*     */       
/*     */ 
/* 367 */       return false;
/*     */     }
/* 369 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\ChatGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */