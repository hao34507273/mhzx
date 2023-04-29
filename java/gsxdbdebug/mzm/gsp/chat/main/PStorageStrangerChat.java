/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chat.SChatToSomeOne;
/*    */ import xbean.ChatDataInfo;
/*    */ import xbean.ChatDataListBean;
/*    */ import xbean.Pod;
/*    */ 
/*    */ public class PStorageStrangerChat
/*    */   extends PStorageSbChat
/*    */ {
/*    */   public PStorageStrangerChat(long roleId, SChatToSomeOne chatToSomeOne)
/*    */   {
/* 14 */     super(roleId, chatToSomeOne);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void addChatMsgToXdb(ChatDataListBean xChatBean, SChatToSomeOne chatToSomeOne)
/*    */   {
/* 21 */     if (xChatBean == null) {
/* 22 */       return;
/*    */     }
/* 24 */     ChatDataInfo xChatDataInfo = (ChatDataInfo)xChatBean.getChatdatamap().get(Integer.valueOf(1));
/* 25 */     if (xChatDataInfo == null) {
/* 26 */       xChatDataInfo = Pod.newChatDataInfo();
/* 27 */       xChatBean.getChatdatamap().put(Integer.valueOf(0), xChatDataInfo);
/*    */     }
/* 29 */     super.addStorage(chatToSomeOne, xChatDataInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PStorageStrangerChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */