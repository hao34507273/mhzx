/*    */ package mzm.gsp.grow.hand;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TargetRegManager
/*    */ {
/* 11 */   private static Map<Integer, TargetHandle> handlers = new ConcurrentHashMap();
/*    */   
/*    */   public static Map<Integer, TargetHandle> getHandlers()
/*    */   {
/* 15 */     return handlers;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean registerTarget(int moduleType, TargetHandle handler)
/*    */   {
/* 27 */     if (handlers.containsKey(Integer.valueOf(moduleType)))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     handlers.put(Integer.valueOf(moduleType), handler);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void unRegisterTarget(int moduleType)
/*    */   {
/* 42 */     handlers.remove(Integer.valueOf(moduleType));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static TargetHandle getHanler(int moduleType)
/*    */   {
/* 52 */     return (TargetHandle)getHandlers().get(Integer.valueOf(moduleType));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\hand\TargetRegManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */