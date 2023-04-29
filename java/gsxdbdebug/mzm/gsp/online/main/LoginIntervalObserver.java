/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import xdb.Executor;
/*    */ 
/*    */ class LoginIntervalObserver extends mzm.gsp.timer.main.MilliObserver
/*    */ {
/*    */   private long intervalMilliSeconds;
/*    */   
/*    */   public LoginIntervalObserver(long intervalMilliSeconds)
/*    */   {
/* 11 */     super(intervalMilliSeconds);
/* 12 */     this.intervalMilliSeconds = intervalMilliSeconds;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 17 */     Executor.getInstance().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 21 */         EnterWorldManager.getInstance().tryEnterWorld();
/*    */       }
/* 23 */     });
/* 24 */     Executor.getInstance().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 28 */         LoginManager.getInstance().tryLogin();
/*    */       }
/* 30 */     });
/* 31 */     int loginInterval = LoginManager.getInstance().getTryLoginInterval();
/* 32 */     if (this.intervalMilliSeconds != loginInterval) {
/* 33 */       new LoginIntervalObserver(loginInterval);
/* 34 */       return false;
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\LoginIntervalObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */