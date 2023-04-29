/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ class ServerLevelObserver
/*    */   extends Observer
/*    */ {
/*    */   ServerLevelObserver(long intervalSeconds)
/*    */   {
/* 10 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 17 */     new TimeOutPro().execute();
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\ServerLevelObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */