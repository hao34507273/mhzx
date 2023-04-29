/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.chat.crossserver.CrossServerChatInterface;
/*    */ import mzm.gsp.chat.question.WorldQuestion;
/*    */ 
/*    */ 
/*    */ public class ChatModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 15 */     ChatArgs.init();
/* 16 */     RoleChatManager.init();
/* 17 */     WorldQuestion.getInstance().init();
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 38 */     RoleChatManager.postInit();
/* 39 */     WorldQuestion.getInstance().postInit();
/* 40 */     CrossServerChatInterface.postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */