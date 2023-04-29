/*    */ package mzm.gsp.chat.crossserver;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossServerChatHandlerManager
/*    */ {
/* 14 */   private static Map<Integer, List<CrossServerChatHandler>> channel2handlers = new HashMap();
/* 15 */   private static Map<Integer, CrossServerChatHandler> type2handler = new HashMap();
/* 16 */   static volatile boolean postInitFlag = false;
/*    */   
/*    */   static void registerHandler(CrossServerChatType chatType, CrossServerChatHandler handler)
/*    */   {
/* 20 */     if (postInitFlag)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     if (handler == null)
/*    */     {
/* 26 */       throw new RuntimeException(String.format("[chat]CrossServerChatHandlerManager.registerHandler@handler is null|cross_server_chat_type=%d", new Object[] { Integer.valueOf(chatType.getType()) }));
/*    */     }
/*    */     
/*    */ 
/* 30 */     if (type2handler.containsKey(Integer.valueOf(chatType.getType())))
/*    */     {
/* 32 */       throw new RuntimeException(String.format("[chat]CrossServerChatHandlerManager.registerHandler@duplicate register|cross_server_chat_type=%d", new Object[] { Integer.valueOf(chatType.getType()) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 37 */     List<CrossServerChatHandler> handlers = (List)channel2handlers.get(Integer.valueOf(chatType.getChannel()));
/* 38 */     if (handlers == null)
/*    */     {
/* 40 */       handlers = new ArrayList();
/* 41 */       channel2handlers.put(Integer.valueOf(chatType.getChannel()), handlers);
/*    */     }
/* 43 */     handlers.add(handler);
/* 44 */     type2handler.put(Integer.valueOf(chatType.getType()), handler);
/*    */   }
/*    */   
/*    */   static void postInit()
/*    */   {
/* 49 */     postInitFlag = true;
/*    */   }
/*    */   
/*    */   static CrossServerChatHandler getHandler(CrossServerChatType chatType)
/*    */   {
/* 54 */     return (CrossServerChatHandler)type2handler.get(Integer.valueOf(chatType.getType()));
/*    */   }
/*    */   
/*    */   static List<CrossServerChatHandler> getHandlers(int channel)
/*    */   {
/* 59 */     return (List)channel2handlers.get(Integer.valueOf(channel));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\crossserver\CrossServerChatHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */