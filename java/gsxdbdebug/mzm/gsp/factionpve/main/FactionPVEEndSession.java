/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FactionPVEEndSession
/*    */   extends MilliSession
/*    */ {
/*    */   FactionPVEEndSession(long factionid, long millis)
/*    */   {
/* 14 */     super(millis, factionid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     NoneRealTimeTaskManager.getInstance().addTask(new RFactionPVEEnd(getOwerId(), 3));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */