/*    */ package mzm.gsp.vote.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VoteHandManager
/*    */ {
/* 12 */   private static Map<Integer, SingleActivityHandler> singleActivityHandlers = new ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static SingleActivityHandler getActivityHandler(int activityId)
/*    */   {
/* 23 */     return (SingleActivityHandler)singleActivityHandlers.get(Integer.valueOf(activityId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void registerSingleActivityHandler(int activityId, SingleActivityHandler handler)
/*    */   {
/* 34 */     if (handler == null)
/*    */     {
/* 36 */       throw new RuntimeException(String.format("[vote]VoteHandManager.registerSingleActivityHandler@ hander want to be registered is null!|activityId=%d", new Object[] { Integer.valueOf(activityId) }));
/*    */     }
/*    */     
/*    */ 
/* 40 */     if (singleActivityHandlers.containsKey(Integer.valueOf(activityId)))
/*    */     {
/* 42 */       throw new RuntimeException(String.format("[vote]VoteHandManager.registerSingleActivityHandler@ activity is duplicate!|activityId=%d", new Object[] { Integer.valueOf(activityId) }));
/*    */     }
/*    */     
/* 45 */     singleActivityHandlers.put(Integer.valueOf(activityId), handler);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\VoteHandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */