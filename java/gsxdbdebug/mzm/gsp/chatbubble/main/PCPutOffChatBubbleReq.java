/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.chatbubble.SPutOffChatBubbleRsp;
/*    */ import mzm.gsp.chatbubble.confbean.ChatBubbleConsts;
/*    */ import mzm.gsp.chatbubble.confbean.SChatBubbleCfg;
/*    */ import mzm.gsp.chatbubble.event.ChatBubbleChange;
/*    */ import mzm.gsp.chatbubble.event.ChatBubbleChangeArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleChatBubbleInfo;
/*    */ import xtable.Role2chatbubbleinfo;
/*    */ 
/*    */ public class PCPutOffChatBubbleReq extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCPutOffChatBubbleReq(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(457))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1813, true))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(Long.valueOf(this.roleId));
/* 41 */     if (xRoleChatBubbleInfo == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     int curChatBubbleCfgId = xRoleChatBubbleInfo.getCurchatbubblecfgid();
/* 47 */     if ((curChatBubbleCfgId == ChatBubbleConsts.getInstance().defaultChatBubbleCfgId) || (SChatBubbleCfg.get(curChatBubbleCfgId) == null))
/*    */     {
/*    */ 
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     SPutOffChatBubbleRsp putOffChatBubbleRsp = new SPutOffChatBubbleRsp();
/* 54 */     putOffChatBubbleRsp.chatbubblecfgid = curChatBubbleCfgId;
/*    */     
/*    */ 
/* 57 */     xRoleChatBubbleInfo.setCurchatbubblecfgid(ChatBubbleConsts.getInstance().defaultChatBubbleCfgId);
/*    */     
/*    */ 
/* 60 */     ChatBubbleTLogManager.tLogChange(this.roleId, curChatBubbleCfgId, ChatBubbleConsts.getInstance().defaultChatBubbleCfgId);
/*    */     
/*    */ 
/*    */ 
/* 64 */     TriggerEventsManger.getInstance().triggerEvent(new ChatBubbleChange(), new ChatBubbleChangeArg(this.roleId, curChatBubbleCfgId, ChatBubbleConsts.getInstance().defaultChatBubbleCfgId));
/*    */     
/*    */ 
/*    */ 
/* 68 */     OnlineManager.getInstance().send(this.roleId, putOffChatBubbleRsp);
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\PCPutOffChatBubbleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */