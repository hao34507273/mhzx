/*    */ package hub;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PingPongManager
/*    */   implements Runnable
/*    */ {
/*  8 */   private static PingPongManager instance = new PingPongManager();
/*    */   
/*    */   public static PingPongManager getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void init()
/*    */   {
/* 22 */     new PingPongObserver();
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 27 */     GHubClientManager instance = GHubClientManager.getInstance();
/* 28 */     if (instance != null)
/*    */     {
/* 30 */       instance.sendPing();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PingPongManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */