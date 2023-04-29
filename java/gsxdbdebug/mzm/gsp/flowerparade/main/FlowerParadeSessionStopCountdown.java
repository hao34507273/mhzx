/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class FlowerParadeSessionStopCountdown extends MilliSession
/*    */ {
/*    */   private int activityId;
/*    */   
/*    */   public FlowerParadeSessionStopCountdown(long intervalMilliSeconds, int activityId)
/*    */   {
/* 12 */     super(intervalMilliSeconds, activityId);
/* 13 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     Procedure.execute(new PFlowerParadeStopCountdownEnd(this.activityId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeSessionStopCountdown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */