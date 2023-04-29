/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.chatbubble.SSynChatBubbleInfo;
/*    */ import mzm.gsp.chatbubble.confbean.SChatBubbleCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.RoleChatBubbleInfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     RoleChatBubbleInfo xRoleChatBubbleInfo = xtable.Role2chatbubbleinfo.get((Long)this.arg);
/* 21 */     if (xRoleChatBubbleInfo == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     SSynChatBubbleInfo synChatBubbleInfo = new SSynChatBubbleInfo();
/*    */     
/* 28 */     Map<Integer, xbean.ChatBubbleInfo> xCfgId2chatBubbleInfoMap = xRoleChatBubbleInfo.getCfgid2info();
/*    */     
/*    */ 
/* 31 */     long curTimeStampInSeconds = TimeUnit.MILLISECONDS.toSeconds(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 37 */     Iterator<Map.Entry<Integer, xbean.ChatBubbleInfo>> iterator = xCfgId2chatBubbleInfoMap.entrySet().iterator();
/*    */     
/* 39 */     while (iterator.hasNext())
/*    */     {
/* 41 */       Map.Entry<Integer, xbean.ChatBubbleInfo> entry = (Map.Entry)iterator.next();
/* 42 */       int chatBubbleCfgId = ((Integer)entry.getKey()).intValue();
/* 43 */       xbean.ChatBubbleInfo xChatBubbleInfo = (xbean.ChatBubbleInfo)entry.getValue();
/*    */       
/* 45 */       SChatBubbleCfg chatBubbleCfg = SChatBubbleCfg.get(chatBubbleCfgId);
/* 46 */       if (chatBubbleCfg != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 51 */         long leftTimeInSecond = xChatBubbleInfo.getExpiretimestamp() - curTimeStampInSeconds;
/* 52 */         if ((xChatBubbleInfo.getExpiretimestamp() != 0L) && (leftTimeInSecond <= 0L))
/*    */         {
/* 54 */           ChatBubbleManager.handleExpiredChatBubble(((Long)this.arg).longValue(), xRoleChatBubbleInfo, chatBubbleCfgId, iterator);
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 59 */           mzm.gsp.chatbubble.ChatBubbleInfo chatBubbleInfo = new mzm.gsp.chatbubble.ChatBubbleInfo();
/* 60 */           chatBubbleInfo.chatbubblecfgid = chatBubbleCfgId;
/* 61 */           chatBubbleInfo.expiretimestamp = xChatBubbleInfo.getExpiretimestamp();
/* 62 */           chatBubbleInfo.ison = (xRoleChatBubbleInfo.getCurchatbubblecfgid() == chatBubbleCfgId ? 1 : 2);
/*    */           
/* 64 */           synChatBubbleInfo.chatbubbleinfos.add(chatBubbleInfo);
/*    */           
/* 66 */           if (xChatBubbleInfo.getExpiretimestamp() != 0L)
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 72 */             Session oldSession = Session.getSession(xChatBubbleInfo.getSessionid());
/* 73 */             if ((oldSession == null) || (oldSession.getOwerId() != ((Long)this.arg).longValue()))
/*    */             {
/*    */ 
/*    */ 
/*    */ 
/* 78 */               ChatBubbleExpireSession chatBubbleExpireSession = new ChatBubbleExpireSession(leftTimeInSecond, ((Long)this.arg).longValue(), chatBubbleCfgId);
/* 79 */               xChatBubbleInfo.setSessionid(chatBubbleExpireSession.getSessionId());
/*    */             }
/*    */           } } } }
/* 82 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), synChatBubbleInfo);
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */