/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class UseActivateCardContextManager
/*    */ {
/*  8 */   private static final UseActivateCardContextManager instance = new UseActivateCardContextManager();
/*    */   
/*    */   public static final UseActivateCardContextManager getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/* 15 */   private final Map<String, Protocol> contexts = new java.util.concurrent.ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void addContext(String userId, Protocol protocol)
/*    */   {
/* 24 */     this.contexts.put(userId, protocol);
/*    */   }
/*    */   
/*    */   void removeContext(String userId)
/*    */   {
/* 29 */     this.contexts.remove(userId);
/*    */   }
/*    */   
/*    */   Protocol getProtocol(String userId)
/*    */   {
/* 34 */     return (Protocol)this.contexts.get(userId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\UseActivateCardContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */