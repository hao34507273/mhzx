/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatInWorldObManager
/*    */ {
/* 13 */   public static int TYPE__WORLD_QUESTION = 1;
/*    */   
/* 15 */   private static Map<Integer, WorldChatHandler> chatInWorldObMap = new ConcurrentHashMap();
/*    */   
/*    */   public static Map<Integer, WorldChatHandler> getChatInWorldObMap() {
/* 18 */     return chatInWorldObMap;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean registerChatInWorldImpl(int type, WorldChatHandler worldChatOber)
/*    */   {
/* 27 */     if (chatInWorldObMap.containsKey(Integer.valueOf(type))) {
/* 28 */       return false;
/*    */     }
/* 30 */     chatInWorldObMap.put(Integer.valueOf(type), worldChatOber);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean unRegisterChatInWorldImpl(int type)
/*    */   {
/* 40 */     if (!chatInWorldObMap.containsKey(Integer.valueOf(type))) {
/* 41 */       return true;
/*    */     }
/* 43 */     chatInWorldObMap.remove(Integer.valueOf(type));
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatInWorldObManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */