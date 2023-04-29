/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*     */ import mzm.gsp.chatgift.event.ChannelChatGiftOutCfgEvent;
/*     */ import mzm.gsp.chatgift.event.ChatGiftOutCfgArg;
/*     */ import mzm.gsp.chatgift.event.ChatGiftTimeOutArg;
/*     */ import mzm.gsp.chatgift.event.ChatGiftTimeOutEvent;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BaseChatGift
/*     */ {
/*     */   private int channelType;
/*     */   private long curChannelId;
/*     */   private ChatGiftIdList xChatGiftIdList;
/*  30 */   private Map<Long, ChatGift> chatGifts = new HashMap();
/*     */   
/*     */   public int getChannelType() {
/*  33 */     return this.channelType;
/*     */   }
/*     */   
/*     */   public ChatGiftIdList getxChatGiftIdList() {
/*  37 */     return this.xChatGiftIdList;
/*     */   }
/*     */   
/*     */   public Map<Long, ChatGift> getChatGifts() {
/*  41 */     return this.chatGifts;
/*     */   }
/*     */   
/*     */   public void setxChatGiftIdList(ChatGiftIdList xChatGiftIdList) {
/*  45 */     this.xChatGiftIdList = xChatGiftIdList;
/*     */   }
/*     */   
/*     */   public void setChatGifts(Map<Long, ChatGift> chatGifts) {
/*  49 */     this.chatGifts = chatGifts;
/*     */   }
/*     */   
/*  52 */   BaseChatGift(int channelType) { this.channelType = channelType; }
/*     */   
/*     */   public long getCurChannelId()
/*     */   {
/*  56 */     return this.curChannelId;
/*     */   }
/*     */   
/*     */   public void setCurChannelId(long curChannelId) {
/*  60 */     this.curChannelId = curChannelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void checkAndDeleteInvalidChatGift()
/*     */   {
/*  68 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  69 */     if ((getChatGifts() == null) || (getChatGifts().size() == 0)) {
/*  70 */       return;
/*     */     }
/*  72 */     if ((getxChatGiftIdList() == null) || (getxChatGiftIdList().getChatgiftlist() == null) || (getxChatGiftIdList().getChatgiftlist().size() == 0)) {
/*  73 */       return;
/*     */     }
/*  75 */     Set<Long> deleteChatGiftIdSet = new HashSet();
/*  76 */     Iterator<Map.Entry<Long, ChatGift>> chatIterator = getChatGifts().entrySet().iterator();
/*  77 */     while (chatIterator.hasNext()) {
/*  78 */       Map.Entry<Long, ChatGift> entry = (Map.Entry)chatIterator.next();
/*  79 */       ChatGift xChatGift = (ChatGift)entry.getValue();
/*  80 */       long chatGiftId = ((Long)entry.getKey()).longValue();
/*     */       
/*  82 */       if (curTime - xChatGift.getStarttime() >= ChatGift_GfgManager.getChatGiftOutTime()) {
/*  83 */         chatIterator.remove();
/*  84 */         getxChatGiftIdList().getChatgiftlist().remove(Long.valueOf(chatGiftId));
/*  85 */         deleteChatGiftIdSet.add(Long.valueOf(chatGiftId));
/*     */       }
/*  87 */       else if (!getxChatGiftIdList().getChatgiftlist().contains(Long.valueOf(chatGiftId))) {
/*  88 */         chatIterator.remove();
/*     */       }
/*     */     }
/*     */     
/*  92 */     if (deleteChatGiftIdSet.size() > 0)
/*     */     {
/*  94 */       ChatGiftTimeOutArg arg = new ChatGiftTimeOutArg(deleteChatGiftIdSet);
/*  95 */       TriggerEventsManger.getInstance().triggerEvent(new ChatGiftTimeOutEvent(), arg);
/*     */     }
/*  97 */     checkAndDeleteChatGiftWithTypeRuleCfg();
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
/*     */   public boolean addChatGift(int channelType, long chatGiftId, ChatGiftIdList xChatGiftIdList, ChatGift xChatGift)
/*     */   {
/* 110 */     if (channelType == 10) {
/* 111 */       return true;
/*     */     }
/* 113 */     if (xChatGiftIdList == null) {
/* 114 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@xChatGiftIdList is null!|chatType=%d|chatGiftId=%d", new Object[] { Integer.valueOf(channelType), Long.valueOf(chatGiftId) });
/* 115 */       return false;
/*     */     }
/* 117 */     if (xChatGift == null) {
/* 118 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@chatgift is null!|chatType=%d|chatGiftId=%d", new Object[] { Integer.valueOf(channelType), Long.valueOf(chatGiftId) });
/* 119 */       return false;
/*     */     }
/* 121 */     if (getChannelType() != channelType) {
/* 122 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@chatgift type error !|wantType=%d|curType=%d", new Object[] { Integer.valueOf(channelType), Integer.valueOf(getChannelType()) });
/* 123 */       return false;
/*     */     }
/* 125 */     setxChatGiftIdList(xChatGiftIdList);
/*     */     
/* 127 */     checkAndDeleteInvalidChatGift();
/*     */     
/* 129 */     if ((getChatGifts() != null) && (getChatGifts().containsKey(Long.valueOf(chatGiftId)))) {
/* 130 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@cur ChatGifts contains chatgiftid !|chatType=%d|chatGiftId=%d", new Object[] { Integer.valueOf(channelType), Long.valueOf(chatGiftId) });
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     if ((getxChatGiftIdList() != null) && (getxChatGiftIdList().getChatgiftlist().contains(Long.valueOf(chatGiftId)))) {
/* 135 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@cur ChatGiftIdList contains chatgiftid !|chatType=%d|chatGiftId=%d", new Object[] { Integer.valueOf(channelType), Long.valueOf(chatGiftId) });
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     boolean res = removeWithCfgBeforeAddChatGift();
/* 140 */     if (!res) {
/* 141 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@check add error!|chatType=%d|chatGiftId=%d", new Object[] { Integer.valueOf(channelType), Long.valueOf(chatGiftId) });
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     getxChatGiftIdList().getChatgiftlist().add(Long.valueOf(chatGiftId));
/* 146 */     getChatGifts().put(Long.valueOf(chatGiftId), xChatGift);
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void deleteMoreChatGift(int deleteNum, long channelId)
/*     */   {
/* 155 */     Set<Long> deleteChatGiftIdSet = new HashSet();
/* 156 */     while (deleteNum > 0) {
/* 157 */       deleteNum--;
/* 158 */       Long chatGiftId = (Long)getxChatGiftIdList().getChatgiftlist().remove(0);
/* 159 */       if (chatGiftId != null) {
/* 160 */         getChatGifts().remove(Long.valueOf(chatGiftId.longValue()));
/* 161 */         deleteChatGiftIdSet.add(chatGiftId);
/*     */       }
/*     */     }
/* 164 */     if (deleteChatGiftIdSet.size() > 0)
/*     */     {
/* 166 */       ChatGiftOutCfgArg arg = new ChatGiftOutCfgArg(deleteChatGiftIdSet, getChannelType(), channelId);
/* 167 */       TriggerEventsManger.getInstance().triggerEvent(new ChannelChatGiftOutCfgEvent(), arg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean checkChatGiftNumCfg(int chatGiftNum)
/*     */   {
/* 178 */     if ((chatGiftNum < ChatGiftConsts.getInstance().minNum) || (chatGiftNum > ChatGiftConsts.getInstance().maxNum)) {
/* 179 */       ChatGiftManager.logDebug("BaseChatGift.addChatGift@chatGiftNum error !|chatGiftNum=%d", new Object[] { Integer.valueOf(chatGiftNum) });
/* 180 */       return false;
/*     */     }
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   protected abstract void checkAndDeleteChatGiftWithTypeRuleCfg();
/*     */   
/*     */   protected abstract boolean removeWithCfgBeforeAddChatGift();
/*     */   
/*     */   protected abstract Long getChannelId(long paramLong);
/*     */   
/*     */   protected abstract Long checkChannelId(long paramLong1, long paramLong2);
/*     */   
/*     */   protected abstract Long getRoleChannelIdWithChannelSet(long paramLong, Set<Long> paramSet);
/*     */   
/*     */   protected abstract boolean checkRoleInChannel(long paramLong1, long paramLong2);
/*     */   
/*     */   protected abstract boolean checkChannelMaxRoleNum(long paramLong, int paramInt);
/*     */   
/*     */   protected abstract boolean checkChatAndSend(long paramLong1, long paramLong2, Octets paramOctets);
/*     */   
/*     */   protected abstract Set<Long> getChannelRoleSet(long paramLong1, long paramLong2);
/*     */   
/*     */   protected abstract ChatGiftIdList getChannelChatGiftListWithChannelLock(long paramLong, boolean paramBoolean);
/*     */   
/*     */   protected abstract boolean addRewardWithSendChatGift(ChatGift paramChatGift);
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\BaseChatGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */