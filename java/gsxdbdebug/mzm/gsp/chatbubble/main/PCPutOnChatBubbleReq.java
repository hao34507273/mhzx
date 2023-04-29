/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.chatbubble.SPutOnChatBubbleRsp;
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
/*    */ public class PCPutOnChatBubbleReq extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int chatBubbleCfgId;
/*    */   
/*    */   public PCPutOnChatBubbleReq(long roleId, int chatBubbleCfgId)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.chatBubbleCfgId = chatBubbleCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!OpenInterface.getOpenStatus(457))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1812, true))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     SChatBubbleCfg chatBubbleCfg = SChatBubbleCfg.get(this.chatBubbleCfgId);
/* 43 */     if (chatBubbleCfg == null)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     SPutOnChatBubbleRsp putOnChatBubbleRsp = new SPutOnChatBubbleRsp();
/* 49 */     putOnChatBubbleRsp.chatbubblecfgid = this.chatBubbleCfgId;
/*    */     
/* 51 */     RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(Long.valueOf(this.roleId));
/*    */     
/* 53 */     if ((xRoleChatBubbleInfo == null) && (this.chatBubbleCfgId != ChatBubbleConsts.getInstance().defaultChatBubbleCfgId))
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     if ((xRoleChatBubbleInfo == null) && (this.chatBubbleCfgId == ChatBubbleConsts.getInstance().defaultChatBubbleCfgId))
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     int curChatBubbleCfgId = xRoleChatBubbleInfo.getCurchatbubblecfgid();
/* 64 */     if (curChatBubbleCfgId == this.chatBubbleCfgId)
/*    */     {
/* 66 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 70 */     if (this.chatBubbleCfgId == ChatBubbleConsts.getInstance().defaultChatBubbleCfgId)
/*    */     {
/*    */ 
/* 73 */       ChatBubbleTLogManager.tLogChange(this.roleId, curChatBubbleCfgId, this.chatBubbleCfgId);
/*    */       
/* 75 */       xRoleChatBubbleInfo.setCurchatbubblecfgid(this.chatBubbleCfgId);
/*    */       
/* 77 */       TriggerEventsManger.getInstance().triggerEvent(new ChatBubbleChange(), new ChatBubbleChangeArg(this.roleId, curChatBubbleCfgId, this.chatBubbleCfgId));
/*    */       
/* 79 */       OnlineManager.getInstance().send(this.roleId, putOnChatBubbleRsp);
/* 80 */       return true;
/*    */     }
/*    */     
/* 83 */     boolean ret = ChatBubbleManager.judgeExpire(this.roleId, xRoleChatBubbleInfo, this.chatBubbleCfgId, null, true);
/* 84 */     if (!ret)
/*    */     {
/* 86 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 90 */     ChatBubbleTLogManager.tLogChange(this.roleId, curChatBubbleCfgId, this.chatBubbleCfgId);
/*    */     
/* 92 */     xRoleChatBubbleInfo.setCurchatbubblecfgid(this.chatBubbleCfgId);
/*    */     
/* 94 */     TriggerEventsManger.getInstance().triggerEvent(new ChatBubbleChange(), new ChatBubbleChangeArg(this.roleId, curChatBubbleCfgId, this.chatBubbleCfgId));
/*    */     
/* 96 */     OnlineManager.getInstance().send(this.roleId, putOnChatBubbleRsp);
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\PCPutOnChatBubbleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */