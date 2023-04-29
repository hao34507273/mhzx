/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleChatBubbleInfo;
/*    */ import xtable.Role2chatbubbleinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatBubbleExpireSession
/*    */   extends Session
/*    */ {
/*    */   final int chatBubbleCfgId;
/*    */   
/*    */   public ChatBubbleExpireSession(long interval, long roleId, int chatBubbleCfgId)
/*    */   {
/* 20 */     super(interval, roleId);
/* 21 */     this.chatBubbleCfgId = chatBubbleCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     new ChatBubbleExpireProc().execute();
/*    */   }
/*    */   
/*    */   class ChatBubbleExpireProc extends LogicProcedure
/*    */   {
/*    */     ChatBubbleExpireProc() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 35 */       long roleId = ChatBubbleExpireSession.this.getOwerId();
/*    */       
/* 37 */       RoleChatBubbleInfo xRoleChatBubbleInfo = Role2chatbubbleinfo.get(Long.valueOf(roleId));
/* 38 */       ChatBubbleManager.judgeExpire(roleId, xRoleChatBubbleInfo, ChatBubbleExpireSession.this.chatBubbleCfgId, null, true);
/*    */       
/* 40 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\ChatBubbleExpireSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */