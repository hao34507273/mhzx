/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class WaitLeaveSesson
/*    */   extends MilliSession
/*    */ {
/*    */   private final int result;
/*    */   
/*    */   WaitLeaveSesson(long factionid, int result, long millis)
/*    */   {
/* 16 */     super(millis, factionid);
/* 17 */     this.result = result;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     NoneRealTimeTaskManager.getInstance().addTask(new RFactionPVEEnd(getOwerId(), this.result));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\WaitLeaveSesson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */