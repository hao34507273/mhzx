/*     */ package mzm.gsp.chatgift.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.chat.SGetChatGiftAddBangGong;
/*     */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*     */ import mzm.gsp.chat.confbean.ChatGiftLevelCfg;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gang.main.ModBangGongResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChatGift;
/*     */ import xbean.ChatGiftIdList;
/*     */ import xbean.GangDutyMembers;
/*     */ import xbean.GangMember;
/*     */ import xbean.Pod;
/*     */ import xtable.Gang2chatgiftlist;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ 
/*     */ public class GangChatGift
/*     */   extends BaseChatGift
/*     */ {
/*     */   GangChatGift(int channelType)
/*     */   {
/*  34 */     super(channelType);
/*     */   }
/*     */   
/*     */   protected void checkAndDeleteChatGiftWithTypeRuleCfg()
/*     */   {
/*  39 */     if (getChatGifts() == null) {
/*  40 */       ChatGiftManager.logDebug("GangChatGift.checkAndDeleteChatGiftWithTypeRuleCfg@getChatGifts is null!|channelType=%d", new Object[] { Integer.valueOf(getChannelType()) });
/*  41 */       return;
/*     */     }
/*  43 */     if (getxChatGiftIdList() == null) {
/*  44 */       ChatGiftManager.logDebug("GangChatGift.checkAndDeleteChatGiftWithTypeRuleCfg@getxChatGiftIdList is null!|roleId=%d", new Object[] { Integer.valueOf(getChannelType()) });
/*  45 */       return;
/*     */     }
/*  47 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  48 */     Iterator<Map.Entry<Long, ChatGift>> chatIterator = getChatGifts().entrySet().iterator();
/*  49 */     while (chatIterator.hasNext()) {
/*  50 */       Map.Entry<Long, ChatGift> entry = (Map.Entry)chatIterator.next();
/*  51 */       ChatGift xChatGift = (ChatGift)entry.getValue();
/*     */       
/*  53 */       if (curTime - xChatGift.getStarttime() >= ChatGift_GfgManager.getChatGiftOutTimeWithType(getChannelType())) {
/*  54 */         chatIterator.remove();
/*  55 */         long chatGiftId = ((Long)entry.getKey()).longValue();
/*  56 */         getxChatGiftIdList().getChatgiftlist().remove(Long.valueOf(chatGiftId));
/*  57 */         getChatGifts().remove(Long.valueOf(chatGiftId));
/*     */       }
/*     */     }
/*     */     
/*  61 */     int curNum = getxChatGiftIdList().getChatgiftlist().size();
/*  62 */     int maxNum = ChatGift_GfgManager.getChatGiftMaxChatGiftNumWithType(getChannelType());
/*  63 */     if (curNum > maxNum) {
/*  64 */       deleteMoreChatGift(curNum - maxNum, getCurChannelId());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean removeWithCfgBeforeAddChatGift()
/*     */   {
/*  71 */     int curNum = getxChatGiftIdList().getChatgiftlist().size();
/*  72 */     int maxNum = ChatGift_GfgManager.getChatGiftMaxChatGiftNumWithType(getChannelType());
/*  73 */     if (curNum >= maxNum) {
/*  74 */       deleteMoreChatGift(curNum - (maxNum - 1), getCurChannelId());
/*     */     }
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean checkChannelMaxRoleNum(long channelValue, int chatGiftNum)
/*     */   {
/*  81 */     if (!checkChatGiftNumCfg(chatGiftNum)) {
/*  82 */       return false;
/*     */     }
/*  84 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(channelValue));
/*  85 */     if (xGang == null) {
/*  86 */       ChatGiftManager.logDebug("GangChatGift.checkChannelMaxNum@Gang is null!|chatGiftNum=%d|gangId=%d", new Object[] { Integer.valueOf(chatGiftNum), Long.valueOf(channelValue) });
/*  87 */       return false;
/*     */     }
/*  89 */     int size = 0;
/*  90 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/*  91 */       size += xMembers.getMembers().size();
/*     */     }
/*  93 */     if (size >= ChatGiftConsts.getInstance().minNum) {
/*  94 */       if (chatGiftNum > size) {
/*  95 */         ChatGiftManager.logDebug("GangChatGift.checkChannelMaxNum@more then size!|size=%d|chatGiftNum=%d", new Object[] { Integer.valueOf(size), Integer.valueOf(chatGiftNum) });
/*  96 */         return false;
/*     */       }
/*     */     }
/*  99 */     else if (chatGiftNum > ChatGiftConsts.getInstance().minNum) {
/* 100 */       ChatGiftManager.logDebug("GangChatGift.checkChannelMaxNum@more then minsize!|size=%d|chatGiftNum=%d", new Object[] { Integer.valueOf(size), Integer.valueOf(chatGiftNum) });
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean checkChatAndSend(long roleId, long channelId, Octets content)
/*     */   {
/* 109 */     return ChatInterface.chatInFaction(roleId, 4, content);
/*     */   }
/*     */   
/*     */   protected boolean checkRoleInChannel(long roleId, long channelId)
/*     */   {
/* 114 */     Long channelValueId = checkChannelId(roleId, channelId);
/* 115 */     if (channelValueId == null) {
/* 116 */       ChatGiftManager.logDebug("GangChatGift.canGetChatGift@ganginfo error , not in gang!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   protected Set<Long> getChannelRoleSet(long roleId, long channelId)
/*     */   {
/* 124 */     Set<Long> roleSet = new HashSet();
/* 125 */     Long channelValueId = checkChannelId(roleId, channelId);
/* 126 */     if (channelValueId == null) {
/* 127 */       ChatGiftManager.logDebug("GangChatGift.getChannelRoleSet@ganginfo error , not in gang!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/* 128 */       return roleSet;
/*     */     }
/* 130 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(channelValueId.longValue()));
/* 131 */     if (xGang == null) {
/* 132 */       ChatGiftManager.logDebug("GangChatGift.getChannelRoleSet@Gang is null!|gangId=%d", new Object[] { Long.valueOf(channelValueId.longValue()) });
/* 133 */       return roleSet;
/*     */     }
/* 135 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 136 */       roleSet.addAll(xMembers.getMembers());
/*     */     }
/* 138 */     return roleSet;
/*     */   }
/*     */   
/*     */   protected ChatGiftIdList getChannelChatGiftListWithChannelLock(long channelValue, boolean isRemain)
/*     */   {
/* 143 */     xbean.Gang xGang = null;
/* 144 */     if (isRemain) {
/* 145 */       xGang = xtable.Gang.get(Long.valueOf(channelValue));
/*     */     } else {
/* 147 */       xGang = xtable.Gang.select(Long.valueOf(channelValue));
/*     */     }
/* 149 */     if (xGang == null) {
/* 150 */       ChatGiftManager.logDebug("GangChatGift.getChannelChatGiftListWithChannelLock@Gang is null!|gangId=%d", new Object[] { Long.valueOf(channelValue) });
/* 151 */       return null;
/*     */     }
/* 153 */     ChatGiftIdList xChatGiftIdList = null;
/* 154 */     if (isRemain) {
/* 155 */       xChatGiftIdList = Gang2chatgiftlist.get(Long.valueOf(channelValue));
/* 156 */       if (xChatGiftIdList == null) {
/* 157 */         xChatGiftIdList = Pod.newChatGiftIdList();
/* 158 */         Gang2chatgiftlist.insert(Long.valueOf(channelValue), xChatGiftIdList);
/*     */       }
/*     */     } else {
/* 161 */       xChatGiftIdList = Gang2chatgiftlist.select(Long.valueOf(channelValue));
/*     */     }
/* 163 */     return xChatGiftIdList;
/*     */   }
/*     */   
/*     */   protected boolean addRewardWithSendChatGift(ChatGift xChatGift)
/*     */   {
/* 168 */     if (xChatGift == null) {
/* 169 */       ChatGiftManager.logDebug("GangChatGift.sendGetReward@addBangGong fail!|roleid=%d|", new Object[] { Integer.valueOf(getChannelType()) });
/* 170 */       return false;
/*     */     }
/* 172 */     ChatGiftLevelCfg cGiftLevelCfg = ChatGiftLevelCfg.get(xChatGift.getType());
/* 173 */     if (cGiftLevelCfg == null) {
/* 174 */       ChatGiftManager.logDebug("GangChatGift.sendGetReward@ChatGiftLevelCfg fail!|roleid=%d|chatgifttype=%d", new Object[] { Long.valueOf(xChatGift.getRoleid()), Integer.valueOf(xChatGift.getType()) });
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     ModBangGongResult addBangGong = GangInterface.addBangGongWithinMax(xChatGift.getRoleid(), cGiftLevelCfg.getBanggong, new TLogArg(LogReason.CHATGIFT_SEND_COST, xChatGift.getType()));
/* 179 */     if (!addBangGong.isSucceed()) {
/* 180 */       ChatGiftManager.logDebug("GangChatGift.sendGetReward@addBangGong fail!|channelType=%d|getBanggong=%d", new Object[] { Integer.valueOf(getChannelType()), Integer.valueOf(cGiftLevelCfg.getBanggong) });
/* 181 */       return false;
/*     */     }
/*     */     
/* 184 */     SGetChatGiftAddBangGong sGetChatGiftAddBangGong = new SGetChatGiftAddBangGong();
/* 185 */     sGetChatGiftAddBangGong.addbanggong = cGiftLevelCfg.getBanggong;
/* 186 */     OnlineManager.getInstance().send(xChatGift.getRoleid(), sGetChatGiftAddBangGong);
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   protected Long getRoleChannelIdWithChannelSet(long roleId, Set<Long> channelIdSet)
/*     */   {
/* 192 */     for (Iterator i$ = channelIdSet.iterator(); i$.hasNext();) { channelId = (Long)i$.next();
/* 193 */       xbean.Gang xGang = xtable.Gang.select(Long.valueOf(channelId.longValue()));
/* 194 */       if ((xGang != null) && (xGang.getDuty2members() != null)) {
/* 195 */         for (GangDutyMembers xMembers : xGang.getDuty2members().values())
/* 196 */           if (xMembers.getMembers().contains(Long.valueOf(roleId))) {
/* 197 */             setCurChannelId(channelId.longValue());
/* 198 */             return channelId;
/*     */           }
/*     */       }
/*     */     }
/*     */     Long channelId;
/* 203 */     return null;
/*     */   }
/*     */   
/*     */   protected Long getChannelId(long roleId)
/*     */   {
/* 208 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 209 */     if (xGangMember == null) {
/* 210 */       ChatGiftManager.logDebug("GangChatGift.getChannelValue@GangMember is null , not in gang!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/* 211 */       return null;
/*     */     }
/* 213 */     Long gangId = Long.valueOf(xGangMember.getGangid());
/* 214 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId.longValue()));
/* 215 */     if (xGang == null) {
/* 216 */       ChatGiftManager.logDebug("GangChatGift.getChannelValue@Gang is null!|roleId=%d|gangId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId.longValue()) });
/* 217 */       return null;
/*     */     }
/* 219 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 220 */       if (xMembers.getMembers().contains(Long.valueOf(roleId))) {
/* 221 */         setCurChannelId(gangId.longValue());
/* 222 */         return gangId;
/*     */       }
/*     */     }
/* 225 */     return null;
/*     */   }
/*     */   
/*     */   protected Long checkChannelId(long roleId, long channelId)
/*     */   {
/* 230 */     Long gangId = null;
/* 231 */     if (channelId <= 0L) {
/* 232 */       GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 233 */       if (xGangMember == null) {
/* 234 */         ChatGiftManager.logDebug("GangChatGift.getChannelValue@GangMember is null , not in gang!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/* 235 */         return null;
/*     */       }
/* 237 */       gangId = Long.valueOf(xGangMember.getGangid());
/*     */     } else {
/* 239 */       gangId = Long.valueOf(channelId);
/*     */     }
/* 241 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId.longValue()));
/* 242 */     if (xGang == null) {
/* 243 */       ChatGiftManager.logDebug("GangChatGift.getChannelValue@Gang is null!|roleId=%d|gangId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId.longValue()) });
/* 244 */       return null;
/*     */     }
/* 246 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 247 */       if (xMembers.getMembers().contains(Long.valueOf(roleId))) {
/* 248 */         setCurChannelId(gangId.longValue());
/* 249 */         return gangId;
/*     */       }
/*     */     }
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\GangChatGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */