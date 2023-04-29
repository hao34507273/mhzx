/*    */ package mzm.gsp.common;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public abstract class TimeCommonDurationObserver
/*    */   extends DateObserver
/*    */ {
/*    */   protected final int timeDurationCfgId;
/*    */   private Session session;
/*    */   
/*    */   public TimeCommonDurationObserver(int timeDurationCfgId)
/*    */   {
/* 17 */     super(STimeDurationCommonCfg.get(timeDurationCfgId).timeCommonCfgId);
/* 18 */     this.timeDurationCfgId = timeDurationCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 33 */     STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(this.timeDurationCfgId);
/*    */     
/* 35 */     boolean ret = onStartTimeOut();
/* 36 */     long curTriggerTimeMil = getTimeoutTimestamp();
/*    */     
/* 38 */     long mill = TimeUnit.DAYS.toMillis(durationCommonCfg.lastDay) + TimeUnit.HOURS.toMillis(durationCommonCfg.lastHour) + TimeUnit.MINUTES.toMillis(durationCommonCfg.lastMinute);
/*    */     
/*    */ 
/* 41 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 42 */     if (curTime <= curTriggerTimeMil) {
/* 43 */       curTriggerTimeMil += mill;
/*    */     } else {
/* 45 */       long turn = Math.ceil((curTime - curTriggerTimeMil) * 1.0D / mill);
/* 46 */       curTriggerTimeMil += mill * turn;
/*    */     }
/* 48 */     long intervalSec = (curTriggerTimeMil - curTime) / 1000L;
/* 49 */     this.session = new TimeDurationEnd(Math.max(intervalSec, 0L), this.timeDurationCfgId);
/* 50 */     return ret;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected abstract boolean onStartTimeOut();
/*    */   
/*    */ 
/*    */   protected abstract void onLastTimeOut();
/*    */   
/*    */ 
/*    */   private class TimeDurationEnd
/*    */     extends Session
/*    */   {
/*    */     public TimeDurationEnd(long interval, long ownerId)
/*    */     {
/* 66 */       super(ownerId);
/*    */     }
/*    */     
/*    */     protected void onTimeOut()
/*    */     {
/* 71 */       TimeCommonDurationObserver.this.onLastTimeOut();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void stopEndTimer()
/*    */   {
/* 80 */     if (this.session != null) {
/* 81 */       this.session.stopTimer();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\TimeCommonDurationObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */