/*    */ package hub;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
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
/*    */ class PingPongObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   public PingPongObserver()
/*    */   {
/* 39 */     super(60000L);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 45 */     Xdb.executor().execute(PingPongManager.getInstance());
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PingPongObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */