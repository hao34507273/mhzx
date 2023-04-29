/*     */ package mzm.gsp.chatbubble.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.chatbubble.SNotifyChatBubbleExpire;
/*     */ import mzm.gsp.chatbubble.confbean.ChatBubbleConsts;
/*     */ import mzm.gsp.chatbubble.confbean.SChatBubbleCfg;
/*     */ import mzm.gsp.chatbubble.event.ChatBubbleChange;
/*     */ import mzm.gsp.chatbubble.event.ChatBubbleChangeArg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChatBubbleInfo;
/*     */ import xbean.RoleChatBubbleInfo;
/*     */ import xtable.Role2chatbubbleinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChatBubbleManager
/*     */ {
/*     */   static void handleExpiredChatBubble(long roleId, RoleChatBubbleInfo xRoleChatBubbleInfo, int expiredChatBubbleCfgId, Iterator<Map.Entry<Integer, ChatBubbleInfo>> iterator)
/*     */   {
/*  38 */     if (xRoleChatBubbleInfo == null)
/*     */     {
/*  40 */       return;
/*     */     }
/*     */     
/*  43 */     Map<Integer, ChatBubbleInfo> xCfgId2chatBubbleInfoMap = xRoleChatBubbleInfo.getCfgid2info();
/*  44 */     ChatBubbleInfo xChatBubbleInfo = (ChatBubbleInfo)xCfgId2chatBubbleInfoMap.get(Integer.valueOf(expiredChatBubbleCfgId));
/*  45 */     if (xChatBubbleInfo == null)
/*     */     {
/*  47 */       return;
/*     */     }
/*     */     
/*  50 */     int curChatBubbleCfgId = xRoleChatBubbleInfo.getCurchatbubblecfgid();
/*     */     
/*     */ 
/*  53 */     if (curChatBubbleCfgId == expiredChatBubbleCfgId)
/*     */     {
/*     */ 
/*  56 */       TriggerEventsManger.getInstance().triggerEvent(new ChatBubbleChange(), new ChatBubbleChangeArg(roleId, curChatBubbleCfgId, ChatBubbleConsts.getInstance().defaultChatBubbleCfgId));
/*     */       
/*     */ 
/*     */ 
/*  60 */       ChatBubbleTLogManager.tLogChange(roleId, curChatBubbleCfgId, ChatBubbleConsts.getInstance().defaultChatBubbleCfgId);
/*     */       
/*     */ 
/*  63 */       xRoleChatBubbleInfo.setCurchatbubblecfgid(ChatBubbleConsts.getInstance().defaultChatBubbleCfgId);
/*     */     }
/*     */     
/*  66 */     Session.removeSession(xChatBubbleInfo.getSessionid(), roleId);
/*     */     
/*     */ 
/*  69 */     if (iterator == null)
/*     */     {
/*  71 */       xCfgId2chatBubbleInfoMap.remove(Integer.valueOf(expiredChatBubbleCfgId));
/*     */     }
/*     */     else
/*     */     {
/*  75 */       iterator.remove();
/*     */     }
/*     */     
/*  78 */     long expireTimeStampInSeconds = xChatBubbleInfo.getExpiretimestamp();
/*     */     
/*     */ 
/*  81 */     ChatBubbleTLogManager.tLogExpire(roleId, expiredChatBubbleCfgId, expireTimeStampInSeconds);
/*     */     
/*     */ 
/*  84 */     List<String> contentArgs = new ArrayList(6);
/*  85 */     contentArgs.add(SChatBubbleCfg.get(expiredChatBubbleCfgId).name);
/*  86 */     Calendar calendar = DateTimeUtils.getCalendar();
/*  87 */     calendar.setTimeInMillis(TimeUnit.SECONDS.toMillis(expireTimeStampInSeconds));
/*  88 */     contentArgs.add(String.valueOf(calendar.get(1)));
/*  89 */     contentArgs.add(String.valueOf(calendar.get(2) + 1));
/*  90 */     contentArgs.add(String.valueOf(calendar.get(5)));
/*  91 */     contentArgs.add(String.valueOf(calendar.get(11)));
/*  92 */     contentArgs.add(String.valueOf(calendar.get(12)));
/*  93 */     MailInterface.asynBuildAndSendMail(roleId, ChatBubbleConsts.getInstance().expireMailId, new ArrayList(), contentArgs, new TLogArg(LogReason.CHAT_BUBBLE_EXPIRE_MAIL));
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
/*     */   static boolean judgeExpire(long roleId, RoleChatBubbleInfo xRoleChatBubbleInfo, int chatBubbleCfgId, Iterator<Map.Entry<Integer, ChatBubbleInfo>> iterator, boolean isSendProtocol)
/*     */   {
/* 109 */     ChatBubbleInfo xChatBubbleInfo = (ChatBubbleInfo)xRoleChatBubbleInfo.getCfgid2info().get(Integer.valueOf(chatBubbleCfgId));
/* 110 */     if (xChatBubbleInfo == null)
/*     */     {
/* 112 */       return false;
/*     */     }
/* 114 */     long curTimeStampInSeconds = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 116 */     long leftTimeInSecond = xChatBubbleInfo.getExpiretimestamp() - curTimeStampInSeconds;
/* 117 */     if ((xChatBubbleInfo.getExpiretimestamp() == 0L) || (leftTimeInSecond > 0L))
/*     */     {
/* 119 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 123 */     handleExpiredChatBubble(roleId, xRoleChatBubbleInfo, chatBubbleCfgId, iterator);
/*     */     
/* 125 */     if (isSendProtocol)
/*     */     {
/*     */ 
/* 128 */       SNotifyChatBubbleExpire notifyChatBubbleExpire = new SNotifyChatBubbleExpire();
/* 129 */       notifyChatBubbleExpire.chatbubblecfgid = chatBubbleCfgId;
/* 130 */       OnlineManager.getInstance().send(roleId, notifyChatBubbleExpire);
/*     */     }
/* 132 */     return false;
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
/*     */   static int removeChatBubble(long roleId, int chatBubbleCfgId, long seconds)
/*     */   {
/* 149 */     if (seconds < -1L)
/*     */     {
/* 151 */       return 64026;
/*     */     }
/*     */     
/* 154 */     RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(Long.valueOf(roleId));
/* 155 */     if (xRoleChatBubbleInfo == null)
/*     */     {
/* 157 */       return 64025;
/*     */     }
/* 159 */     ChatBubbleInfo xChatBubbleInfo = (ChatBubbleInfo)xRoleChatBubbleInfo.getCfgid2info().get(Integer.valueOf(chatBubbleCfgId));
/* 160 */     if (xChatBubbleInfo == null)
/*     */     {
/* 162 */       return 64025;
/*     */     }
/* 164 */     long beforeExpireTimeStamp = xChatBubbleInfo.getExpiretimestamp();
/*     */     
/* 166 */     removeChatBubble(roleId, chatBubbleCfgId, seconds, xRoleChatBubbleInfo, xChatBubbleInfo);
/*     */     
/* 168 */     ChatBubbleTLogManager.tLogRemove(roleId, chatBubbleCfgId, seconds, beforeExpireTimeStamp, xChatBubbleInfo.getExpiretimestamp());
/*     */     
/*     */ 
/* 171 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   static void removeChatBubble(long roleId, int chatBubbleCfgId, long seconds, RoleChatBubbleInfo xRoleChatBubbleInfo, ChatBubbleInfo xChatBubbleInfo)
/*     */   {
/* 177 */     if ((xChatBubbleInfo.getExpiretimestamp() == 0L) || (seconds == -1L))
/*     */     {
/* 179 */       handleExpiredChatBubble(roleId, xRoleChatBubbleInfo, chatBubbleCfgId, null);
/* 180 */       SNotifyChatBubbleExpire notifyChatBubbleExpire = new SNotifyChatBubbleExpire();
/* 181 */       notifyChatBubbleExpire.chatbubblecfgid = chatBubbleCfgId;
/* 182 */       OnlineManager.getInstance().send(roleId, notifyChatBubbleExpire);
/*     */       
/* 184 */       return;
/*     */     }
/* 186 */     xChatBubbleInfo.setExpiretimestamp(xChatBubbleInfo.getExpiretimestamp() - seconds);
/* 187 */     boolean ret = judgeExpire(roleId, xRoleChatBubbleInfo, chatBubbleCfgId, null, true);
/* 188 */     if (!ret)
/*     */     {
/* 190 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 195 */     Session.removeSession(xChatBubbleInfo.getSessionid(), roleId);
/*     */     
/* 197 */     ChatBubbleExpireSession chatBubbleExpireSession = new ChatBubbleExpireSession(xChatBubbleInfo.getExpiretimestamp() - TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()), roleId, chatBubbleCfgId);
/*     */     
/*     */ 
/* 200 */     xChatBubbleInfo.setSessionid(chatBubbleExpireSession.getSessionId());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\ChatBubbleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */