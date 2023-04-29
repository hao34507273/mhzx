/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import xdb.Executor;
/*    */ 
/*    */ class LoginNotifyObserver extends mzm.gsp.timer.main.Observer
/*    */ {
/*    */   private long intervalSeconds;
/*    */   
/*    */   public LoginNotifyObserver(long intervalSeconds)
/*    */   {
/* 11 */     super(intervalSeconds);
/* 12 */     this.intervalSeconds = intervalSeconds;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 17 */     Executor.getInstance().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 21 */         LoginManager.getInstance().notifyLogin();
/*    */       }
/* 23 */     });
/* 24 */     int notifyLoginInterval = LoginManager.getInstance().getNotifyLoginInterval();
/* 25 */     if (notifyLoginInterval != this.intervalSeconds) {
/* 26 */       new LoginNotifyObserver(notifyLoginInterval);
/* 27 */       return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\LoginNotifyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */