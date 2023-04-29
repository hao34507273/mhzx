/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.chat.crossserver.CrossServerChatInterface;
/*    */ import mzm.gsp.chat.crossserver.CrossServerChatType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossCompeteModule
/*    */   implements Module
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 32 */     CrossCompeteManager.init();
/*    */     
/* 34 */     ActivityInterface.registerActivityByLogicType(98, new CrossCompeteActivityHandler());
/*    */     
/*    */ 
/* 37 */     CrossServerChatInterface.registerCrossServerChatHandler(CrossServerChatType.CrossCompete, new CrossCompeteChatHandler());
/*    */     
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 45 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */