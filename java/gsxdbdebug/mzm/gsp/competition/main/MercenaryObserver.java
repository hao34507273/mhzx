/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MercenaryObserver
/*    */   extends Observer
/*    */ {
/*    */   MercenaryObserver(long intervalSeconds)
/*    */   {
/* 14 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 19 */     NoneRealTimeTaskManager.getInstance().addTask(new RUpdateMercenary(this));
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\MercenaryObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */