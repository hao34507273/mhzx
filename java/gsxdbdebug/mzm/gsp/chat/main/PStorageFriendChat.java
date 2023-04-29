/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chat.SChatToSomeOne;
/*    */ import xbean.ChatDataInfo;
/*    */ import xbean.ChatDataListBean;
/*    */ import xbean.Pod;
/*    */ 
/*    */ public class PStorageFriendChat
/*    */   extends PStorageSbChat
/*    */ {
/*    */   public PStorageFriendChat(long roleId, SChatToSomeOne chatToSomeOne)
/*    */   {
/* 14 */     super(roleId, chatToSomeOne);
/*    */   }
/*    */   
/*    */   public void addChatMsgToXdb(ChatDataListBean xChatBean, SChatToSomeOne chatToSomeOne)
/*    */   {
/* 19 */     if (xChatBean == null) {
/* 20 */       return;
/*    */     }
/* 22 */     ChatDataInfo xChatDataInfo = (ChatDataInfo)xChatBean.getChatdatamap().get(Integer.valueOf(0));
/* 23 */     if (xChatDataInfo == null) {
/* 24 */       xChatDataInfo = Pod.newChatDataInfo();
/* 25 */       xChatBean.getChatdatamap().put(Integer.valueOf(0), xChatDataInfo);
/*    */     }
/* 27 */     super.addStorage(chatToSomeOne, xChatDataInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PStorageFriendChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */