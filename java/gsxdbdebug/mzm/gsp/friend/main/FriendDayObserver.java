/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FriendDayObserver
/*    */   extends DateObserver
/*    */ {
/*    */   FriendDayObserver(DateObserver.MyDate myDate)
/*    */   {
/* 17 */     super(myDate);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 22 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */       {
/* 26 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld()) {
/* 27 */           NoneRealTimeTaskManager.getInstance().addTask(new FriendDataDayProcedure(roleId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 31 */     });
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\FriendDayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */