/*     */ package mzm.gsp.chatbubble.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.chatbubble.confbean.ChatBubbleConsts;
/*     */ import mzm.gsp.chatbubble.confbean.SChatBubbleCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
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
/*     */ public class ChatBubbleInterface
/*     */ {
/*     */   public static int getRoleChatBubbleCfgId(long roleId, boolean isHoldRoleLock)
/*     */   {
/*  26 */     RoleChatBubbleInfo xRoleChatBubbleInfo = isHoldRoleLock ? Role2chatbubbleinfo.get(Long.valueOf(roleId)) : Role2chatbubbleinfo.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/*     */ 
/*  30 */     if (xRoleChatBubbleInfo == null)
/*     */     {
/*  32 */       return ChatBubbleConsts.getInstance().defaultChatBubbleCfgId;
/*     */     }
/*     */     
/*  35 */     int bubbleCfgId = xRoleChatBubbleInfo.getCurchatbubblecfgid();
/*  36 */     if (SChatBubbleCfg.get(bubbleCfgId) == null)
/*     */     {
/*  38 */       return ChatBubbleConsts.getInstance().defaultChatBubbleCfgId;
/*     */     }
/*  40 */     ChatBubbleInfo xChatBubbleInfo = (ChatBubbleInfo)xRoleChatBubbleInfo.getCfgid2info().get(Integer.valueOf(bubbleCfgId));
/*  41 */     if (xChatBubbleInfo == null)
/*     */     {
/*  43 */       return ChatBubbleConsts.getInstance().defaultChatBubbleCfgId;
/*     */     }
/*  45 */     if ((xChatBubbleInfo.getExpiretimestamp() != 0L) && (xChatBubbleInfo.getExpiretimestamp() <= TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis())))
/*     */     {
/*     */ 
/*  48 */       return ChatBubbleConsts.getInstance().defaultChatBubbleCfgId;
/*     */     }
/*  50 */     return bubbleCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getRoleAllChatBubbleCfgIds(long roleId)
/*     */   {
/*  61 */     Set<Integer> result = new HashSet();
/*     */     
/*  63 */     RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(Long.valueOf(roleId));
/*     */     
/*  65 */     if (xRoleChatBubbleInfo == null)
/*     */     {
/*  67 */       return result;
/*     */     }
/*     */     
/*  70 */     Map<Integer, ChatBubbleInfo> xCfgId2chatBubbleInfoMap = xRoleChatBubbleInfo.getCfgid2info();
/*     */     
/*     */ 
/*  73 */     long curTimeStampInSeconds = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/*     */ 
/*  77 */     Iterator<Map.Entry<Integer, ChatBubbleInfo>> iterator = xCfgId2chatBubbleInfoMap.entrySet().iterator();
/*     */     
/*  79 */     while (iterator.hasNext())
/*     */     {
/*  81 */       Map.Entry<Integer, ChatBubbleInfo> entry = (Map.Entry)iterator.next();
/*  82 */       int chatBubbleCfgId = ((Integer)entry.getKey()).intValue();
/*  83 */       ChatBubbleInfo xChatBubbleInfo = (ChatBubbleInfo)entry.getValue();
/*     */       
/*  85 */       SChatBubbleCfg chatBubbleCfg = SChatBubbleCfg.get(chatBubbleCfgId);
/*  86 */       if (chatBubbleCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  91 */         long leftTimeInSecond = xChatBubbleInfo.getExpiretimestamp() - curTimeStampInSeconds;
/*  92 */         if ((xChatBubbleInfo.getExpiretimestamp() != 0L) && (leftTimeInSecond <= 0L))
/*     */         {
/*  94 */           ChatBubbleManager.handleExpiredChatBubble(roleId, xRoleChatBubbleInfo, chatBubbleCfgId, iterator);
/*     */         }
/*     */         else
/*  97 */           result.add(Integer.valueOf(chatBubbleCfgId));
/*     */       } }
/*  99 */     return result;
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
/*     */   public static int removeChatBubbleForIDIP(long roleId, int chatBubbleCfgId, long seconds)
/*     */   {
/* 116 */     int idipRet = ChatBubbleManager.removeChatBubble(roleId, chatBubbleCfgId, seconds);
/* 117 */     if (idipRet == 0)
/*     */     {
/* 119 */       OnlineManager.getInstance().forceReconnect(roleId);
/*     */     }
/* 121 */     return idipRet;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\ChatBubbleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */