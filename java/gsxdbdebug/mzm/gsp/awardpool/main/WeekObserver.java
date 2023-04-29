/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class WeekObserver extends mzm.gsp.timer.main.DateObserver
/*    */ {
/*    */   public WeekObserver(DateObserver.MyDate myDate)
/*    */   {
/* 11 */     super(myDate);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 18 */     Xdb.executor().execute(new RoleObserverTimeoutRunnable(2));
/* 19 */     Xdb.executor().execute(new ServerObserverTimeoutRunnable(2));
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\WeekObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */