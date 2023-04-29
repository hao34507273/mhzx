/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TimerManager
/*    */ {
/* 15 */   static Logger logger = Logger.getLogger("timer");
/*    */   private static Timer gsTimer;
/*    */   
/*    */   static void init()
/*    */   {
/* 20 */     gsTimer = new Timer("gs timer", true);
/* 21 */     gsTimer.scheduleAtFixedRate(new GsTimerTask(null), 0L, TimerArgs.getInstance().timerInterval);
/*    */   }
/*    */   
/*    */   static void exit() {
/* 25 */     if (gsTimer != null) {
/* 26 */       gsTimer.cancel();
/*    */     }
/*    */   }
/*    */   
/*    */   static Timer getGsTimer() {
/* 31 */     return gsTimer;
/*    */   }
/*    */   
/*    */   private static class GsTimerTask extends TimerTask
/*    */   {
/*    */     public void run()
/*    */     {
/* 38 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*    */       try {
/* 40 */         TimerTaskManager.getInstance().update(now);
/*    */       }
/*    */       catch (Exception e) {
/* 43 */         TimerManager.logger.error("[gs timer]", e);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\TimerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */