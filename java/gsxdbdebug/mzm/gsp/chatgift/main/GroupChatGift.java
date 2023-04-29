/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.group.main.GroupInterface;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GroupChatGift
/*     */   extends BaseChatGift
/*     */ {
/*     */   GroupChatGift(int channelType)
/*     */   {
/*  24 */     super(channelType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void checkAndDeleteChatGiftWithTypeRuleCfg() {}
/*     */   
/*     */ 
/*     */   protected boolean removeWithCfgBeforeAddChatGift()
/*     */   {
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean checkChannelMaxRoleNum(long channelValue, int chatGiftNum)
/*     */   {
/*  39 */     if (!checkChatGiftNumCfg(chatGiftNum)) {
/*  40 */       return false;
/*     */     }
/*  42 */     List<Long> groupRoleList = GroupInterface.getGroupMemberList(channelValue, false);
/*  43 */     if (groupRoleList == null) {
/*  44 */       ChatGiftManager.logDebug("GroupChatGift.checkChannelMaxNum@groupRoleList is null!|chatGiftNum=%d|channelValue=%d", new Object[] { Integer.valueOf(chatGiftNum), Long.valueOf(channelValue) });
/*  45 */       return false;
/*     */     }
/*  47 */     int size = groupRoleList.size();
/*     */     
/*  49 */     if (size >= ChatGiftConsts.getInstance().minNum) {
/*  50 */       if (chatGiftNum > size) {
/*  51 */         ChatGiftManager.logDebug("GroupChatGift.checkChannelMaxNum@more then size!|size=%d|chatGiftNum=%d", new Object[] { Integer.valueOf(size), Integer.valueOf(chatGiftNum) });
/*  52 */         return false;
/*     */       }
/*     */     }
/*  55 */     else if (chatGiftNum > ChatGiftConsts.getInstance().minNum) {
/*  56 */       ChatGiftManager.logDebug("GroupChatGift.checkChannelMaxNum@more then minsize!|size=%d|chatGiftNum=%d", new Object[] { Integer.valueOf(size), Integer.valueOf(chatGiftNum) });
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean checkChatAndSend(long roleId, long channelId, Octets content)
/*     */   {
/*  65 */     return ChatInterface.chatInGroup(roleId, channelId, 4, content);
/*     */   }
/*     */   
/*     */   protected boolean checkRoleInChannel(long roleId, long channelId)
/*     */   {
/*  70 */     return GroupInterface.isRoleInGroup(roleId, channelId, false);
/*     */   }
/*     */   
/*     */   protected Set<Long> getChannelRoleSet(long roleId, long channelId)
/*     */   {
/*  75 */     Set<Long> roleSet = new HashSet();
/*  76 */     List<Long> groupRoleList = GroupInterface.getGroupMemberList(channelId, false);
/*  77 */     if (groupRoleList == null) {
/*  78 */       ChatGiftManager.logDebug("GroupChatGift.getChannelRoleSet@GroupMemberList null!|channelId=%d|", new Object[] { Long.valueOf(channelId) });
/*  79 */       return roleSet;
/*     */     }
/*  81 */     roleSet.addAll(groupRoleList);
/*  82 */     return roleSet;
/*     */   }
/*     */   
/*     */   protected ChatGiftIdList getChannelChatGiftListWithChannelLock(long channelValue, boolean isRemain)
/*     */   {
/*  87 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean addRewardWithSendChatGift(ChatGift xChatGift)
/*     */   {
/*  92 */     return true;
/*     */   }
/*     */   
/*     */   protected Long getRoleChannelIdWithChannelSet(long roleId, Set<Long> channelIdSet)
/*     */   {
/*  97 */     for (Long channelId : channelIdSet) {
/*  98 */       if (GroupInterface.isRoleInGroup(roleId, channelId.longValue(), false)) {
/*  99 */         setCurChannelId(channelId.longValue());
/* 100 */         return channelId;
/*     */       }
/*     */     }
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   protected Long getChannelId(long roleId)
/*     */   {
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   protected Long checkChannelId(long roleId, long channelId)
/*     */   {
/* 113 */     if (GroupInterface.isRoleInGroup(roleId, channelId, false)) {
/* 114 */       setCurChannelId(channelId);
/* 115 */       return Long.valueOf(channelId);
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\GroupChatGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */