/*     */ package mzm.gsp.chatbubble.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.chatbubble.SUseChatBubbleItemError;
/*     */ import mzm.gsp.chatbubble.SUseChatBubbleItemRsp;
/*     */ import mzm.gsp.chatbubble.confbean.ChatBubbleConsts;
/*     */ import mzm.gsp.chatbubble.confbean.SChatBubbleCfg;
/*     */ import mzm.gsp.chatbubble.confbean.SChatBubbleItemCfg;
/*     */ import mzm.gsp.chatbubble.event.ChatBubbleUnlock;
/*     */ import mzm.gsp.chatbubble.event.ChatBubbleUnlockArg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ChatBubbleInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleChatBubbleInfo;
/*     */ import xtable.Role2chatbubbleinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCUseChatBubbleItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int bagId;
/*     */   final int grid;
/*     */   
/*     */   public PCUseChatBubbleItemReq(long roleId, int bagId, int grid)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.bagId = bagId;
/*  42 */     this.grid = grid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!OpenInterface.getOpenStatus(457))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1811, true))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     SUseChatBubbleItemError useChatBubbleItemError = new SUseChatBubbleItemError();
/*     */     
/*     */ 
/*  63 */     if (RoleInterface.getLevel(this.roleId) < ChatBubbleConsts.getInstance().minRoleLevel)
/*     */     {
/*  65 */       useChatBubbleItemError.errorcode = 2;
/*  66 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     BasicItem itemInBag = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/*  72 */     if (itemInBag == null)
/*     */     {
/*  74 */       useChatBubbleItemError.errorcode = 1;
/*  75 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     SChatBubbleItemCfg chatBubbleItemCfg = SChatBubbleItemCfg.get(itemInBag.getCfgId());
/*  80 */     if (chatBubbleItemCfg == null)
/*     */     {
/*  82 */       useChatBubbleItemError.errorcode = 1;
/*  83 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     SChatBubbleCfg chatBubbleCfg = SChatBubbleCfg.get(chatBubbleItemCfg.chatBubbleCfgId);
/*  88 */     if (chatBubbleCfg == null)
/*     */     {
/*  90 */       useChatBubbleItemError.errorcode = 1;
/*  91 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (chatBubbleCfg.showType == 2)
/*     */     {
/*  98 */       useChatBubbleItemError.errorcode = 3;
/*  99 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     if ((chatBubbleCfg.gender != 0) && (RoleInterface.getGender(this.roleId) != chatBubbleCfg.gender))
/*     */     {
/* 106 */       useChatBubbleItemError.errorcode = 4;
/* 107 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if ((chatBubbleCfg.menpai != 0) && (RoleInterface.getOccupationId(this.roleId) != chatBubbleCfg.menpai))
/*     */     {
/* 114 */       useChatBubbleItemError.errorcode = 5;
/* 115 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(Long.valueOf(this.roleId));
/* 121 */     if (xRoleChatBubbleInfo == null)
/*     */     {
/* 123 */       xRoleChatBubbleInfo = Pod.newRoleChatBubbleInfo();
/* 124 */       Role2chatbubbleinfo.insert(Long.valueOf(this.roleId), xRoleChatBubbleInfo);
/* 125 */       xRoleChatBubbleInfo.setCurchatbubblecfgid(ChatBubbleConsts.getInstance().defaultChatBubbleCfgId);
/*     */     }
/*     */     
/* 128 */     Map<Integer, ChatBubbleInfo> xRoleChatBubbleInfoCfgId2info = xRoleChatBubbleInfo.getCfgid2info();
/*     */     
/* 130 */     long curTimeStampInSeconds = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/* 133 */     long chatBubbleDurationInSeconds = TimeUnit.HOURS.toSeconds(chatBubbleCfg.duration);
/* 134 */     ChatBubbleInfo xChatBubbleInfo; if (xRoleChatBubbleInfoCfgId2info.containsKey(Integer.valueOf(chatBubbleCfg.id)))
/*     */     {
/* 136 */       if (chatBubbleCfg.duration == -1)
/*     */       {
/* 138 */         useChatBubbleItemError.errorcode = 6;
/* 139 */         OnlineManager.getInstance().sendAtOnce(this.roleId, useChatBubbleItemError);
/* 140 */         return false;
/*     */       }
/*     */       
/* 143 */       ChatBubbleInfo xChatBubbleInfo = (ChatBubbleInfo)xRoleChatBubbleInfoCfgId2info.get(Integer.valueOf(chatBubbleCfg.id));
/* 144 */       long oldExpireTimeStamp = xChatBubbleInfo.getExpiretimestamp();
/*     */       
/* 146 */       if (xChatBubbleInfo.getExpiretimestamp() <= curTimeStampInSeconds)
/*     */       {
/* 148 */         xChatBubbleInfo.setExpiretimestamp(curTimeStampInSeconds + chatBubbleDurationInSeconds);
/*     */       }
/*     */       else
/*     */       {
/* 152 */         xChatBubbleInfo.setExpiretimestamp(xChatBubbleInfo.getExpiretimestamp() + chatBubbleDurationInSeconds);
/*     */       }
/* 154 */       long leftTimeInSecond = xChatBubbleInfo.getExpiretimestamp() - curTimeStampInSeconds;
/* 155 */       Session.removeSession(xChatBubbleInfo.getSessionid(), this.roleId);
/* 156 */       ChatBubbleExpireSession chatBubbleExpireSession = new ChatBubbleExpireSession(leftTimeInSecond, this.roleId, chatBubbleCfg.id);
/* 157 */       xChatBubbleInfo.setSessionid(chatBubbleExpireSession.getSessionId());
/*     */       
/*     */ 
/* 160 */       ChatBubbleTLogManager.tLogRenewal(this.roleId, itemInBag.getTlogUuid(), chatBubbleCfg.id, oldExpireTimeStamp, xChatBubbleInfo.getExpiretimestamp());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 165 */       xChatBubbleInfo = Pod.newChatBubbleInfo();
/* 166 */       xRoleChatBubbleInfoCfgId2info.put(Integer.valueOf(chatBubbleCfg.id), xChatBubbleInfo);
/* 167 */       if (chatBubbleCfg.duration == -1)
/*     */       {
/* 169 */         xChatBubbleInfo.setExpiretimestamp(0L);
/*     */       }
/*     */       else
/*     */       {
/* 173 */         xChatBubbleInfo.setExpiretimestamp(curTimeStampInSeconds + chatBubbleDurationInSeconds);
/* 174 */         ChatBubbleExpireSession chatBubbleExpireSession = new ChatBubbleExpireSession(chatBubbleDurationInSeconds, this.roleId, chatBubbleCfg.id);
/*     */         
/* 176 */         xChatBubbleInfo.setSessionid(chatBubbleExpireSession.getSessionId());
/*     */       }
/*     */       
/*     */ 
/* 180 */       TriggerEventsManger.getInstance().triggerEvent(new ChatBubbleUnlock(), new ChatBubbleUnlockArg(this.roleId, chatBubbleCfg.id));
/*     */       
/*     */ 
/*     */ 
/* 184 */       ChatBubbleTLogManager.tLogUnLock(this.roleId, itemInBag.getTlogUuid(), chatBubbleCfg.id, xChatBubbleInfo.getExpiretimestamp());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 189 */     boolean ret = ItemInterface.removeItemByGrid(this.roleId, this.bagId, this.grid, 1, new TLogArg(LogReason.USE_CHAT_BUBBLE_ITEM));
/*     */     
/* 191 */     if (!ret)
/*     */     {
/* 193 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 197 */     SUseChatBubbleItemRsp useChatBubbleItemRsp = new SUseChatBubbleItemRsp();
/* 198 */     useChatBubbleItemRsp.chatbubbleinfo.ison = (xRoleChatBubbleInfo.getCurchatbubblecfgid() == chatBubbleCfg.id ? 1 : 2);
/*     */     
/* 200 */     useChatBubbleItemRsp.chatbubbleinfo.expiretimestamp = xChatBubbleInfo.getExpiretimestamp();
/* 201 */     useChatBubbleItemRsp.chatbubbleinfo.chatbubblecfgid = chatBubbleCfg.id;
/* 202 */     OnlineManager.getInstance().send(this.roleId, useChatBubbleItemRsp);
/*     */     
/* 204 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\PCUseChatBubbleItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */