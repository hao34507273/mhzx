/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ 
/*    */ public class MonthObserver extends DateObserver
/*    */ {
/*    */   public MonthObserver(DateObserver.MyDate myDate)
/*    */   {
/* 10 */     super(myDate);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 16 */     new RoleObserverTimeoutRunnable(3).execute();
/* 17 */     new ServerObserverTimeoutRunnable(3).execute();
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\MonthObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */