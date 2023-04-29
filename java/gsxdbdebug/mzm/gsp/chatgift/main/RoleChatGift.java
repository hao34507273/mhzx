/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ChatGift;
/*    */ import xbean.ChatGiftIdList;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2chatgiftinfolist;
/*    */ 
/*    */ 
/*    */ public class RoleChatGift
/*    */   extends BaseChatGift
/*    */ {
/*    */   RoleChatGift(int channelType)
/*    */   {
/* 19 */     super(channelType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void checkAndDeleteChatGiftWithTypeRuleCfg() {}
/*    */   
/*    */ 
/*    */   protected boolean removeWithCfgBeforeAddChatGift()
/*    */   {
/* 29 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 30 */     int curNum = 0;
/* 31 */     for (ChatGift xChatGift : getChatGifts().values())
/*    */     {
/* 33 */       if (!DateTimeUtils.needDailyReset(xChatGift.getStarttime(), now, 0))
/*    */       {
/* 35 */         curNum++;
/*    */       }
/*    */     }
/* 38 */     if (curNum >= ChatGift_GfgManager.getRoleMaxChatGiftNum()) {
/* 39 */       ChatGiftManager.logInfo("RoleChatGift.addChatGiftWithTypeRuleCfg@chatgift max num!|curNum=%d|maxNum=%d", new Object[] { Integer.valueOf(curNum), Integer.valueOf(ChatGift_GfgManager.getRoleMaxChatGiftNum()) });
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean checkChannelMaxRoleNum(long channelValue, int chatGiftNum)
/*    */   {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean checkChatAndSend(long roleId, long channelId, Octets content)
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean checkRoleInChannel(long roleId, long channelId)
/*    */   {
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   protected Set<Long> getChannelRoleSet(long roleId, long channelId)
/*    */   {
/* 62 */     return new HashSet();
/*    */   }
/*    */   
/*    */   protected ChatGiftIdList getChannelChatGiftListWithChannelLock(long channelValue, boolean isRemain)
/*    */   {
/* 67 */     ChatGiftIdList xChatGiftIdList = null;
/* 68 */     if (isRemain) {
/* 69 */       xChatGiftIdList = Role2chatgiftinfolist.get(Long.valueOf(channelValue));
/* 70 */       if (xChatGiftIdList == null) {
/* 71 */         xChatGiftIdList = Pod.newChatGiftIdList();
/* 72 */         Role2chatgiftinfolist.insert(Long.valueOf(channelValue), xChatGiftIdList);
/*    */       }
/*    */     } else {
/* 75 */       xChatGiftIdList = Role2chatgiftinfolist.select(Long.valueOf(channelValue));
/*    */     }
/* 77 */     return xChatGiftIdList;
/*    */   }
/*    */   
/*    */   protected boolean addRewardWithSendChatGift(ChatGift xChatGift)
/*    */   {
/* 82 */     return true;
/*    */   }
/*    */   
/*    */   protected Long getRoleChannelIdWithChannelSet(long roleId, Set<Long> channelIdSet)
/*    */   {
/* 87 */     return new Long(1L);
/*    */   }
/*    */   
/*    */   protected Long getChannelId(long roleId)
/*    */   {
/* 92 */     return new Long(1L);
/*    */   }
/*    */   
/*    */   protected Long checkChannelId(long roleId, long channelId)
/*    */   {
/* 97 */     return new Long(1L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\RoleChatGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */