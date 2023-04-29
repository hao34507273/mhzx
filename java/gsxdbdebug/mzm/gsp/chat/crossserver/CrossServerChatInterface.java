/*    */ package mzm.gsp.chat.crossserver;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossServerChatInterface
/*    */ {
/*    */   public static void registerCrossServerChatHandler(CrossServerChatType chatType, CrossServerChatHandler handler)
/*    */   {
/* 22 */     CrossServerChatHandlerManager.registerHandler(chatType, handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void postInit() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static CrossServerChatHandler getHandler(CrossServerChatType chatType)
/*    */   {
/* 42 */     return CrossServerChatHandlerManager.getHandler(chatType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<CrossServerChatHandler> getHandlers(int channel)
/*    */   {
/* 54 */     return CrossServerChatHandlerManager.getHandlers(channel);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\crossserver\CrossServerChatInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */