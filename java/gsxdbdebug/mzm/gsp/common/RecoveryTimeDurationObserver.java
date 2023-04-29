/*    */ package mzm.gsp.common;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RecoveryTimeDurationObserver
/*    */   extends TimeCommonDurationObserver
/*    */ {
/* 17 */   private static final Logger logger = Logger.getLogger(RecoveryTimeDurationObserver.class);
/*    */   private MilliObserver observer;
/*    */   
/*    */   public RecoveryTimeDurationObserver(int timeDurationCfgId) {
/* 21 */     super(timeDurationCfgId);
/* 22 */     long nextStartInterval = getIntervalMilliSeconds();
/* 23 */     if (nextStartInterval > 0L) {
/* 24 */       STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(timeDurationCfgId);
/* 25 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 26 */       long beforeStartTime = TimeCommonUtil.getBeforeStartTime(now, durationCommonCfg.timeCommonCfgId);
/* 27 */       long lastMills = TimeUnit.DAYS.toMillis(durationCommonCfg.lastDay) + TimeUnit.HOURS.toMillis(durationCommonCfg.lastHour) + TimeUnit.MINUTES.toMillis(durationCommonCfg.lastMinute);
/*    */       
/*    */ 
/* 30 */       long beforeLastTime = beforeStartTime + lastMills - now;
/* 31 */       if ((beforeStartTime < now) && (beforeLastTime > 0L)) {
/* 32 */         if (logger.isDebugEnabled())
/* 33 */           logger.debug("detected recovery duration observer restart!");
/* 34 */         onReStartTimeOut();
/* 35 */         this.observer = new MilliObserver(beforeLastTime)
/*    */         {
/*    */           public boolean update() {
/* 38 */             if (RecoveryTimeDurationObserver.logger.isDebugEnabled())
/* 39 */               RecoveryTimeDurationObserver.logger.debug("detected recovery duration observer restart last time out!");
/* 40 */             RecoveryTimeDurationObserver.this.onLastTimeOut();
/* 41 */             RecoveryTimeDurationObserver.this.releaseObserver();
/* 42 */             return false;
/*    */           }
/*    */         };
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public long getLogicStartTime() {
/* 50 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 51 */     STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(this.timeDurationCfgId);
/* 52 */     long beforeStartTime = TimeCommonUtil.getBeforeStartTime(now, durationCommonCfg.timeCommonCfgId);
/* 53 */     return beforeStartTime;
/*    */   }
/*    */   
/*    */   public long getLogicEndTime() {
/* 57 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 58 */     STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(this.timeDurationCfgId);
/* 59 */     long beforeStartTime = TimeCommonUtil.getBeforeStartTime(now, durationCommonCfg.timeCommonCfgId);
/* 60 */     long lastMills = TimeUnit.DAYS.toMillis(durationCommonCfg.lastDay) + TimeUnit.HOURS.toMillis(durationCommonCfg.lastHour) + TimeUnit.MINUTES.toMillis(durationCommonCfg.lastMinute);
/*    */     
/*    */ 
/* 63 */     long beforeLastTime = beforeStartTime + lastMills;
/* 64 */     return beforeLastTime;
/*    */   }
/*    */   
/*    */   private void releaseObserver() {
/* 68 */     this.observer = null;
/*    */   }
/*    */   
/*    */   public abstract void onReStartTimeOut();
/*    */   
/*    */   public void stopEndTimer()
/*    */   {
/* 75 */     super.stopEndTimer();
/* 76 */     if (this.observer != null) {
/* 77 */       this.observer.stopTimer();
/* 78 */       this.observer = null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\RecoveryTimeDurationObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */