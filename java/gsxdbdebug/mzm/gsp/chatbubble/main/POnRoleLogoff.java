/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import xbean.ChatBubbleInfo;
/*    */ import xbean.RoleChatBubbleInfo;
/*    */ 
/*    */ public class POnRoleLogoff extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     RoleChatBubbleInfo xRoleChatBubbleInfo = xtable.Role2chatbubbleinfo.get((Long)this.arg);
/* 13 */     if (xRoleChatBubbleInfo == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     Map<Integer, ChatBubbleInfo> xCfgId2chatBubbleInfoMap = xRoleChatBubbleInfo.getCfgid2info();
/* 18 */     for (Map.Entry<Integer, ChatBubbleInfo> entry : xCfgId2chatBubbleInfoMap.entrySet())
/*    */     {
/* 20 */       if (((ChatBubbleInfo)entry.getValue()).getExpiretimestamp() != 0L)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 25 */         mzm.gsp.timer.main.Session.removeSession(((ChatBubbleInfo)entry.getValue()).getSessionid(), ((Long)this.arg).longValue()); }
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */