/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.chat.SChatToSomeOne;
/*    */ import xbean.ChatDataInfo;
/*    */ import xbean.ChatDataListBean;
/*    */ import xbean.RoleChatInfo;
/*    */ import xtable.Role2chat;
/*    */ 
/*    */ public abstract class PStorageSbChat
/*    */ {
/*    */   private final long roleId;
/*    */   private final SChatToSomeOne chatToSomeOne;
/*    */   
/*    */   public PStorageSbChat(long roleId, SChatToSomeOne chatToSomeOne)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.chatToSomeOne = chatToSomeOne;
/*    */   }
/*    */   
/*    */   protected boolean doStorage() {
/* 21 */     ChatDataListBean xChatBean = getRoleChatStorageBean(this.roleId, true);
/* 22 */     if (xChatBean == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     addChatMsgToXdb(xChatBean, this.chatToSomeOne);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private ChatDataListBean getRoleChatStorageBean(long roleId, boolean remainRoleLock)
/*    */   {
/*    */     RoleChatInfo roleChatInfo;
/*    */     
/*    */     RoleChatInfo roleChatInfo;
/*    */     
/* 37 */     if (remainRoleLock) {
/* 38 */       roleChatInfo = Role2chat.get(Long.valueOf(roleId));
/*    */     } else {
/* 40 */       roleChatInfo = Role2chat.select(Long.valueOf(roleId));
/*    */     }
/* 42 */     if (roleChatInfo == null) {
/* 43 */       return null;
/*    */     }
/* 45 */     ChatDataListBean roleChatDataListBean = (ChatDataListBean)roleChatInfo.getChatinfo().get(Long.valueOf(roleId));
/* 46 */     if (roleChatDataListBean == null) {
/* 47 */       return null;
/*    */     }
/* 49 */     return roleChatDataListBean;
/*    */   }
/*    */   
/*    */   protected void addStorage(SChatToSomeOne chatToSomeOne, ChatDataInfo xChatDataInfo) {
/* 53 */     xbean.ChatDataBean xChatDataBean = xbean.Pod.newChatDataBean();
/* 54 */     xChatDataBean.setChatdata(chatToSomeOne);
/* 55 */     xChatDataInfo.getChatdatalist().add(xChatDataBean);
/*    */   }
/*    */   
/*    */   public abstract void addChatMsgToXdb(ChatDataListBean paramChatDataListBean, SChatToSomeOne paramSChatToSomeOne);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PStorageSbChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */