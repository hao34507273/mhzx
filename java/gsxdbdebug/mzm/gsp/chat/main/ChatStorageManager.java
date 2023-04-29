/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.chat.ChatContent;
/*     */ import mzm.gsp.chat.SChatToSomeOne;
/*     */ import mzm.gsp.chat.SInitChannelInfo;
/*     */ import mzm.gsp.chat.confbean.ChatConsts;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.ChatDataBean;
/*     */ import xbean.ChatDataInfo;
/*     */ import xbean.ChatDataListBean;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleChatInfo;
/*     */ import xtable.Role2chat;
/*     */ 
/*     */ public class ChatStorageManager
/*     */ {
/*     */   public static void addChatInfo(long roleId, SChatToSomeOne chatToSomeOne, long strangerId)
/*     */   {
/*  22 */     checkBeforeStorageChat(strangerId);
/*  23 */     storageSbChatMsg(roleId, strangerId, chatToSomeOne);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkBeforeStorageChat(long strangerId)
/*     */   {
/*  33 */     ChatDataListBean roleChatDataListBean = getROleChatStorageXbean(strangerId);
/*  34 */     checkIsFull(roleChatDataListBean);
/*  35 */     checkLastChatTime(roleChatDataListBean);
/*     */   }
/*     */   
/*     */   private static ChatDataListBean getROleChatStorageXbean(long strangerId) {
/*  39 */     RoleChatInfo roleChatInfo = Role2chat.get(Long.valueOf(strangerId));
/*  40 */     if (roleChatInfo == null) {
/*  41 */       roleChatInfo = Pod.newRoleChatInfo();
/*  42 */       Role2chat.insert(Long.valueOf(strangerId), roleChatInfo);
/*  43 */       roleChatInfo = Role2chat.get(Long.valueOf(strangerId));
/*     */     }
/*     */     
/*  46 */     ChatDataListBean roleChatDataListBean = (ChatDataListBean)roleChatInfo.getChatinfo().get(Long.valueOf(strangerId));
/*  47 */     if (roleChatDataListBean == null) {
/*  48 */       roleChatDataListBean = Pod.newChatDataListBean();
/*  49 */       roleChatInfo.getChatinfo().put(Long.valueOf(strangerId), roleChatDataListBean);
/*  50 */       roleChatDataListBean = (ChatDataListBean)roleChatInfo.getChatinfo().get(Long.valueOf(strangerId));
/*     */     }
/*  52 */     return roleChatDataListBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void checkIsFull(ChatDataListBean chatDataListBean)
/*     */   {
/*  61 */     if (getStorageSize(chatDataListBean.getChatdatamap()) < RoleChatManager.getPrivateChatCountLimit()) {
/*  62 */       return;
/*     */     }
/*  64 */     rmOldStrangerChat(chatDataListBean);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void rmOldStrangerChat(ChatDataListBean chatDataListBean)
/*     */   {
/*  72 */     if (chatDataListBean == null) {
/*  73 */       return;
/*     */     }
/*  75 */     ChatDataInfo xChatDataInfo = (ChatDataInfo)chatDataListBean.getChatdatamap().get(Integer.valueOf(1));
/*     */     
/*  77 */     if (xChatDataInfo == null) {
/*  78 */       return;
/*     */     }
/*  80 */     List<ChatDataBean> xChatList = xChatDataInfo.getChatdatalist();
/*  81 */     if ((xChatList == null) || (xChatList.size() == 0)) {
/*  82 */       return;
/*     */     }
/*  84 */     xChatList.remove(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getStorageSize(Map<Integer, ChatDataInfo> xStorageInfo)
/*     */   {
/*  93 */     if (xStorageInfo == null) {
/*  94 */       return 0;
/*     */     }
/*  96 */     return getStrangerChatSize(xStorageInfo) + getFriendChatSize(xStorageInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getFriendChatSize(Map<Integer, ChatDataInfo> xStorageInfo)
/*     */   {
/* 106 */     ChatDataInfo xFriend = (ChatDataInfo)xStorageInfo.get(Integer.valueOf(0));
/* 107 */     if (xFriend == null) {
/* 108 */       xFriend = Pod.newChatDataInfo();
/* 109 */       xStorageInfo.put(Integer.valueOf(0), xFriend);
/*     */     }
/* 111 */     int xFriendSize = xFriend.getChatdatalist().size();
/* 112 */     return xFriendSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getStrangerChatSize(Map<Integer, ChatDataInfo> xStorageInfo)
/*     */   {
/* 122 */     ChatDataInfo xStranger = (ChatDataInfo)xStorageInfo.get(Integer.valueOf(1));
/* 123 */     if (xStranger == null) {
/* 124 */       xStranger = Pod.newChatDataInfo();
/* 125 */       xStorageInfo.put(Integer.valueOf(1), xStranger);
/*     */     }
/* 127 */     int xStrangerSize = xStranger.getChatdatalist().size();
/* 128 */     return xStrangerSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkLastChatTime(ChatDataListBean chatDataListBean)
/*     */   {
/* 137 */     if (chatDataListBean == null) {
/* 138 */       return false;
/*     */     }
/* 140 */     if (!needClear(chatDataListBean)) {
/* 141 */       return true;
/*     */     }
/* 143 */     clearChatStorage(chatDataListBean);
/* 144 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean needClear(ChatDataListBean chatDataListBean)
/*     */   {
/* 153 */     int intervalSec = ChatConsts.getInstance().SumOfflineWhisperRecordMax;
/* 154 */     Long lastChatTime = Long.valueOf(getLastChatTime(chatDataListBean));
/* 155 */     long currTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 156 */     if ((currTime - lastChatTime.longValue() * 1000L) / 1000L > intervalSec) {
/* 157 */       return true;
/*     */     }
/* 159 */     return false;
/*     */   }
/*     */   
/*     */   static long getLastChatTime(ChatDataListBean chatDataListBean) {
/* 163 */     return getLastChatTime(getLastChatTime(chatDataListBean, 1), getLastChatTime(chatDataListBean, 0));
/*     */   }
/*     */   
/*     */   private static long getLastChatTime(long sLastTime, long fLastTime)
/*     */   {
/* 168 */     if ((sLastTime < 0L) && (fLastTime < 0L)) {
/* 169 */       return -1L;
/*     */     }
/* 171 */     if (sLastTime < 0L) {
/* 172 */       return fLastTime;
/*     */     }
/* 174 */     if (fLastTime < 0L) {
/* 175 */       return sLastTime;
/*     */     }
/* 177 */     return Math.max(sLastTime, fLastTime);
/*     */   }
/*     */   
/*     */   private static long getLastChatTime(ChatDataListBean chatDataListBean, int type) {
/* 181 */     ChatDataInfo xChat = (ChatDataInfo)chatDataListBean.getChatdatamap().get(Integer.valueOf(type));
/* 182 */     if (xChat == null) {
/* 183 */       return -1L;
/*     */     }
/* 185 */     List<ChatDataBean> xChatList = xChat.getChatdatalist();
/* 186 */     if (xChatList == null) {
/* 187 */       return -1L;
/*     */     }
/* 189 */     int size = xChatList.size();
/* 190 */     if (size == 0) {
/* 191 */       return -1L;
/*     */     }
/* 193 */     ChatDataBean xChatDataBean = (ChatDataBean)xChatList.get(size - 1);
/* 194 */     return ((SChatToSomeOne)xChatDataBean.getChatdata(new SChatToSomeOne())).chatcontent.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearChatStorage(ChatDataListBean chatDataListBean)
/*     */   {
/* 203 */     ((ChatDataInfo)chatDataListBean.getChatdatamap().get(Integer.valueOf(1))).getChatdatalist().clear();
/* 204 */     ((ChatDataInfo)chatDataListBean.getChatdatamap().get(Integer.valueOf(0))).getChatdatalist().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean sendViaXtable(long roleId)
/*     */   {
/* 215 */     RoleChatInfo roleChatInfo = Role2chat.get(Long.valueOf(roleId));
/* 216 */     if (roleChatInfo == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     Map<Long, ChatDataListBean> chatMap = roleChatInfo.getChatinfo();
/* 220 */     if (chatMap == null) {
/* 221 */       return false;
/*     */     }
/*     */     
/* 224 */     sendOfflineChatMsg(roleId, chatMap);
/*     */     
/*     */ 
/* 227 */     chatMap.remove(Long.valueOf(roleId));
/* 228 */     return true;
/*     */   }
/*     */   
/*     */   private static void sendOfflineChatMsg(long roleId, Map<Long, ChatDataListBean> chatMap)
/*     */   {
/* 233 */     ChatDataListBean xListBean = (ChatDataListBean)chatMap.get(Long.valueOf(roleId));
/* 234 */     if (xListBean == null) {
/* 235 */       return;
/*     */     }
/* 237 */     for (ChatDataInfo xChatDataInfo : xListBean.getChatdatamap().values()) {
/* 238 */       for (ChatDataBean xChatDataBean : xChatDataInfo.getChatdatalist()) {
/* 239 */         OnlineManager.getInstance().send(roleId, (xio.Protocol)xChatDataBean.getChatdata(new SChatToSomeOne()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillInitChannelInfoPro(RoleChatInfo roleChatInfo, SInitChannelInfo sInitChannelInfo)
/*     */   {
/* 253 */     sInitChannelInfo.chatcfginfo.putAll(roleChatInfo.getChatcfg());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendInitMsg(long roleId, RoleChatInfo roleChatInfo)
/*     */   {
/* 263 */     SInitChannelInfo sInitChannelInfo = new SInitChannelInfo();
/* 264 */     fillInitChannelInfoPro(roleChatInfo, sInitChannelInfo);
/* 265 */     OnlineManager.getInstance().send(roleId, sInitChannelInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean storageSbChatMsg(long send, long recv, SChatToSomeOne chatToSomeOne)
/*     */   {
/* 277 */     boolean isFriend = FriendInterface.isFriend(send, recv, false);
/* 278 */     PStorageSbChat storageSbChat = null;
/* 279 */     if (isFriend) {
/* 280 */       storageSbChat = new PStorageFriendChat(recv, chatToSomeOne);
/*     */     } else {
/* 282 */       storageSbChat = new PStorageStrangerChat(recv, chatToSomeOne);
/*     */     }
/* 284 */     return storageSbChat.doStorage();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatStorageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */