/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class DayObserver extends mzm.gsp.timer.main.DateObserver
/*    */ {
/*    */   public DayObserver(DateObserver.MyDate myDate)
/*    */   {
/* 11 */     super(myDate);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 19 */     Xdb.executor().execute(new RoleObserverTimeoutRunnable(1));
/* 20 */     Xdb.executor().execute(new ServerObserverTimeoutRunnable(1));
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\DayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */