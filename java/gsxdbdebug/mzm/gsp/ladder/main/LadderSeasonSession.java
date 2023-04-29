/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ class LadderSeasonSession extends Session
/*    */ {
/*    */   public LadderSeasonSession(long interval, long seasonEndTime) {
/*  8 */     super(interval, seasonEndTime);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 13 */     LadderRankManager.getInstance().onSeasonStart(getOwerId());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderSeasonSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */