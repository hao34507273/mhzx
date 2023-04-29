/*     */ package mzm.gsp.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*     */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeCommonUtil
/*     */ {
/*     */   public static DateObserver.MyDate createMaydate(int timeCommonCfgId)
/*     */   {
/*  25 */     STimeCommonCfg timeCommonCfg = STimeCommonCfg.get(timeCommonCfgId);
/*  26 */     if (timeCommonCfg == null) {
/*  27 */       throw new RuntimeException("不存在的timecommonCfgId:" + timeCommonCfgId);
/*     */     }
/*  29 */     if (isWeekCircle(timeCommonCfg)) {
/*  30 */       long startMinute = timeCommonCfg.activeHour * 60 + timeCommonCfg.activeMinute;
/*  31 */       DateObserver.MyDate myDate = new DateObserver.MyDate(timeCommonCfg.activeWeekDay, startMinute / 60.0D);
/*  32 */       return myDate; }
/*  33 */     if (isDayCircle(timeCommonCfg)) {
/*  34 */       long startMinute = timeCommonCfg.activeHour * 60 + timeCommonCfg.activeMinute;
/*  35 */       DateObserver.MyDate myDate = new DateObserver.MyDate(-1, -1, -1, startMinute / 60.0D);
/*  36 */       return myDate;
/*     */     }
/*  38 */     DateObserver.MyDate myDate = new DateObserver.MyDate(timeCommonCfg.activeMinute);
/*  39 */     return myDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkTimeCfgConflict(STimeDurationCommonCfg timeDurationCfg0, STimeDurationCommonCfg timeDurationCfg1)
/*     */   {
/*  51 */     STimeCommonCfg commonCfg0 = STimeCommonCfg.get(timeDurationCfg0.timeCommonCfgId);
/*  52 */     STimeCommonCfg commonCfg1 = STimeCommonCfg.get(timeDurationCfg1.timeCommonCfgId);
/*  53 */     if ((isDayCircle(commonCfg0)) && (!isDayCircle(commonCfg1))) {
/*  54 */       return true;
/*     */     }
/*  56 */     if ((isWeekCircle(commonCfg0)) && (!isWeekCircle(commonCfg1))) {
/*  57 */       return true;
/*     */     }
/*  59 */     if ((isHourCircle(commonCfg0)) && (!isHourCircle(commonCfg1))) {
/*  60 */       return true;
/*     */     }
/*  62 */     int oneHourMinute = 60;
/*  63 */     int oneDayMinue = 1440;
/*  64 */     int oneWeekMinute = 7 * oneDayMinue;
/*  65 */     if (isDayCircle(commonCfg0)) {
/*  66 */       long startMinute0 = commonCfg0.activeHour * 60L + commonCfg0.activeMinute;
/*  67 */       long endMinute0 = startMinute0 + getDurationMinute(timeDurationCfg0);
/*  68 */       long startMinute1 = commonCfg1.activeHour * 60L + commonCfg1.activeMinute;
/*  69 */       long endMinute1 = startMinute1 + getDurationMinute(timeDurationCfg1);
/*  70 */       if (checkTimeConflict(startMinute0, endMinute0, startMinute1, endMinute1)) {
/*  71 */         return true;
/*     */       }
/*  73 */       boolean checkAgain = false;
/*  74 */       if (endMinute0 > oneDayMinue) {
/*  75 */         startMinute0 = 0L;
/*  76 */         endMinute0 -= oneDayMinue;
/*  77 */         checkAgain = true;
/*     */       }
/*  79 */       if (endMinute1 > oneDayMinue) {
/*  80 */         startMinute1 = 0L;
/*  81 */         endMinute1 -= oneDayMinue;
/*  82 */         checkAgain = true;
/*     */       }
/*  84 */       if (checkAgain) {
/*  85 */         return checkTimeConflict(startMinute0, endMinute0, startMinute1, endMinute1);
/*     */       }
/*  87 */     } else if (isWeekCircle(commonCfg0)) {
/*  88 */       long startMinute0 = commonCfg0.activeWeekDay * oneDayMinue + commonCfg0.activeHour * 60L + commonCfg0.activeMinute;
/*     */       
/*  90 */       long endMinute0 = startMinute0 + getDurationMinute(timeDurationCfg0);
/*  91 */       long startMinute1 = commonCfg1.activeWeekDay * oneDayMinue + commonCfg1.activeHour * 60L + commonCfg1.activeMinute;
/*     */       
/*  93 */       long endMinute1 = startMinute1 + getDurationMinute(timeDurationCfg1);
/*  94 */       if (checkTimeConflict(startMinute0, endMinute0, startMinute1, endMinute1)) {
/*  95 */         return true;
/*     */       }
/*  97 */       boolean checkAgain = false;
/*  98 */       if (endMinute0 > oneWeekMinute) {
/*  99 */         startMinute0 = 0L;
/* 100 */         endMinute0 -= oneWeekMinute;
/* 101 */         checkAgain = true;
/*     */       }
/* 103 */       if (endMinute1 > oneWeekMinute) {
/* 104 */         startMinute1 = 0L;
/* 105 */         endMinute1 -= oneWeekMinute;
/* 106 */         checkAgain = true;
/*     */       }
/* 108 */       if (checkAgain) {
/* 109 */         return checkTimeConflict(startMinute0, endMinute0, startMinute1, endMinute1);
/*     */       }
/* 111 */     } else if (isHourCircle(commonCfg0)) {
/* 112 */       long startMinute0 = commonCfg0.activeMinute;
/* 113 */       long endMinute0 = startMinute0 + getDurationMinute(timeDurationCfg0);
/* 114 */       long startMinute1 = commonCfg1.activeMinute;
/* 115 */       long endMinute1 = startMinute1 + getDurationMinute(timeDurationCfg1);
/* 116 */       if (checkTimeConflict(startMinute0, endMinute0, startMinute1, endMinute1)) {
/* 117 */         return true;
/*     */       }
/* 119 */       boolean checkAgain = false;
/* 120 */       if (endMinute0 > oneHourMinute) {
/* 121 */         startMinute0 = 0L;
/* 122 */         endMinute0 -= oneHourMinute;
/* 123 */         checkAgain = true;
/*     */       }
/* 125 */       if (endMinute1 > oneHourMinute) {
/* 126 */         startMinute1 = 0L;
/* 127 */         endMinute1 -= oneHourMinute;
/* 128 */         checkAgain = true;
/*     */       }
/* 130 */       if (checkAgain) {
/* 131 */         return checkTimeConflict(startMinute0, endMinute0, startMinute1, endMinute1);
/*     */       }
/*     */     }
/*     */     
/* 135 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getDurationMinute(STimeDurationCommonCfg durationCommonCfg)
/*     */   {
/* 144 */     return TimeUnit.DAYS.toMinutes(durationCommonCfg.lastDay) + TimeUnit.HOURS.toMinutes(durationCommonCfg.lastHour) + durationCommonCfg.lastMinute;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkTimeConflict(long startTime0, long endTime0, long startTime1, long endTime1)
/*     */   {
/* 157 */     if (startTime0 < startTime1) {
/* 158 */       if (endTime0 > startTime1)
/* 159 */         return true;
/*     */     } else {
/* 161 */       if (startTime0 == startTime1)
/* 162 */         return true;
/* 163 */       if ((startTime0 > startTime1) && 
/* 164 */         (startTime0 < endTime1)) {
/* 165 */         return true;
/*     */       }
/*     */     }
/* 168 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getMinIntervalMinute(STimeCommonCfg timeCommonCfg1, STimeCommonCfg timeCommonCfg2)
/*     */   {
/* 179 */     if (isDayCircle(timeCommonCfg1)) {
/* 180 */       int totalMinute = 1440;
/* 181 */       long commonCfg1Minute = timeCommonCfg1.activeHour * 60 + timeCommonCfg1.activeMinute;
/*     */       
/* 183 */       long commonCfg2Minute = timeCommonCfg2.activeHour * 60 + timeCommonCfg2.activeMinute;
/*     */       
/* 185 */       if (commonCfg1Minute >= commonCfg2Minute) {
/* 186 */         long plus = commonCfg1Minute - commonCfg2Minute;
/* 187 */         long other = totalMinute - commonCfg1Minute + commonCfg2Minute;
/* 188 */         return Math.min(plus, other);
/*     */       }
/* 190 */       long plus = commonCfg2Minute - commonCfg1Minute;
/* 191 */       long other = totalMinute - commonCfg2Minute + commonCfg1Minute;
/* 192 */       return Math.min(plus, other);
/*     */     }
/* 194 */     if (isWeekCircle(timeCommonCfg1)) {
/* 195 */       long totalMinute = 10080L;
/* 196 */       long commonCfg1Minute = 1440 * timeCommonCfg1.activeWeekDay + timeCommonCfg1.activeHour * 60 + timeCommonCfg1.activeMinute;
/*     */       
/* 198 */       long commonCfg2Minute = 1440 * timeCommonCfg2.activeWeekDay + timeCommonCfg2.activeHour * 60 + timeCommonCfg2.activeMinute;
/*     */       
/* 200 */       if (commonCfg1Minute >= commonCfg2Minute) {
/* 201 */         long plus = commonCfg1Minute - commonCfg2Minute;
/* 202 */         long other = totalMinute - commonCfg1Minute + commonCfg2Minute;
/* 203 */         return Math.min(plus, other);
/*     */       }
/* 205 */       long plus = commonCfg2Minute - commonCfg1Minute;
/* 206 */       long other = totalMinute - commonCfg2Minute + commonCfg1Minute;
/* 207 */       return Math.min(plus, other);
/*     */     }
/*     */     
/* 210 */     if (isHourCircle(timeCommonCfg1)) {
/* 211 */       int totalMinute = 60;
/* 212 */       int commonCfg1Minute = timeCommonCfg1.activeMinute;
/* 213 */       int commonCfg2Minute = timeCommonCfg2.activeMinute;
/* 214 */       if (commonCfg1Minute >= commonCfg2Minute) {
/* 215 */         long plus = commonCfg1Minute - commonCfg2Minute;
/* 216 */         long other = totalMinute - commonCfg1Minute + commonCfg2Minute;
/* 217 */         return Math.min(plus, other);
/*     */       }
/* 219 */       long plus = commonCfg2Minute - commonCfg1Minute;
/* 220 */       long other = totalMinute - commonCfg2Minute + commonCfg1Minute;
/* 221 */       return Math.min(plus, other);
/*     */     }
/*     */     
/* 224 */     throw new RuntimeException("不存在支持的配置类型:程序确认是否增加了新的类型!!!");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getMinIntervalMinute(int timeCommonid1, int timeCommonid2)
/*     */     throws Exception
/*     */   {
/* 236 */     STimeCommonCfg timeCommonCfg1 = STimeCommonCfg.get(timeCommonid1);
/* 237 */     STimeCommonCfg timeCommonCfg2 = STimeCommonCfg.get(timeCommonid2);
/* 238 */     return getMinIntervalMinute(timeCommonCfg1, timeCommonCfg2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLimitTimeEnd(int timeLimitId)
/*     */   {
/* 248 */     STimeLimitCommonCfg timeLimitCommonCfg = STimeLimitCommonCfg.get(timeLimitId);
/* 249 */     return getLimitTimeEnd(timeLimitCommonCfg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLimitTimeEnd(STimeLimitCommonCfg timeLimitCommonCfg)
/*     */   {
/* 258 */     Calendar nowCalendar = Calendar.getInstance();
/* 259 */     nowCalendar.set(1, timeLimitCommonCfg.endYear);
/* 260 */     nowCalendar.set(2, timeLimitCommonCfg.endMonth - 1);
/* 261 */     nowCalendar.set(5, timeLimitCommonCfg.endDay);
/* 262 */     nowCalendar.set(11, timeLimitCommonCfg.endHour);
/* 263 */     nowCalendar.set(12, timeLimitCommonCfg.endMinute);
/* 264 */     nowCalendar.set(13, 0);
/* 265 */     nowCalendar.set(14, 0);
/* 266 */     return nowCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLimitTimeBegin(int timeLimitId)
/*     */   {
/* 276 */     STimeLimitCommonCfg timeLimitCommonCfg = STimeLimitCommonCfg.get(timeLimitId);
/* 277 */     return getLimitTimeBegin(timeLimitCommonCfg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLimitTimeBegin(STimeLimitCommonCfg timeLimitCommonCfg)
/*     */   {
/* 287 */     Calendar nowCalendar = Calendar.getInstance();
/* 288 */     nowCalendar.set(1, timeLimitCommonCfg.startYear);
/* 289 */     nowCalendar.set(2, timeLimitCommonCfg.startMonth - 1);
/* 290 */     nowCalendar.set(5, timeLimitCommonCfg.startDay);
/* 291 */     nowCalendar.set(11, timeLimitCommonCfg.startHour);
/* 292 */     nowCalendar.set(12, timeLimitCommonCfg.startMinute);
/* 293 */     nowCalendar.set(13, 0);
/* 294 */     nowCalendar.set(14, 0);
/* 295 */     return nowCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getBeforeStartTime(long curtime, int turn, int activityComonCfgId)
/*     */   {
/* 308 */     Calendar startCalendar = Calendar.getInstance();
/* 309 */     startCalendar.setTimeInMillis(curtime);
/* 310 */     startCalendar.set(13, 0);
/* 311 */     startCalendar.set(14, 0);
/* 312 */     STimeCommonCfg commonCfg = STimeCommonCfg.get(activityComonCfgId);
/* 313 */     if (commonCfg == null) {
/* 314 */       GameServer.logger().error("不存在的通用时间配置id:" + activityComonCfgId);
/* 315 */       return 0L;
/*     */     }
/* 317 */     if (isDayCircle(commonCfg)) {
/* 318 */       startCalendar.set(11, commonCfg.activeHour);
/* 319 */       startCalendar.set(12, commonCfg.activeMinute);
/* 320 */       long oriTime = startCalendar.getTimeInMillis();
/* 321 */       if (oriTime <= curtime) {
/* 322 */         return oriTime -= (turn - 1) * 86400000L;
/*     */       }
/* 324 */       return oriTime -= turn * 86400000L;
/*     */     }
/*     */     
/* 327 */     if (isWeekCircle(commonCfg))
/*     */     {
/* 329 */       startCalendar.set(7, commonCfg.activeWeekDay);
/* 330 */       startCalendar.set(11, commonCfg.activeHour);
/* 331 */       startCalendar.set(12, commonCfg.activeMinute);
/* 332 */       long oriTime = startCalendar.getTimeInMillis();
/* 333 */       if (oriTime <= curtime) {
/* 334 */         return oriTime -= (turn - 1) * 604800000L;
/*     */       }
/* 336 */       return oriTime -= turn * 604800000L;
/*     */     }
/*     */     
/* 339 */     if (isHourCircle(commonCfg)) {
/* 340 */       startCalendar.set(12, commonCfg.activeMinute);
/* 341 */       long oriTime = startCalendar.getTimeInMillis();
/* 342 */       if (oriTime <= curtime) {
/* 343 */         return oriTime -= (turn - 1) * 3600000L;
/*     */       }
/* 345 */       return oriTime -= turn * 3600000L;
/*     */     }
/*     */     
/* 348 */     return startCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getBeforeStartTime(long curtime, int activityComonCfgId)
/*     */   {
/* 359 */     return getBeforeStartTime(curtime, 1, activityComonCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFullTurn(long timeBegin, long timeEnd, STimeDurationCommonCfg timeDurationCommonCfg)
/*     */   {
/* 372 */     return getFullTurn(timeBegin, timeEnd, timeDurationCommonCfg, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFullTurn(long timeBegin, long timeEnd, STimeDurationCommonCfg timeDurationCommonCfg, boolean includeBegin)
/*     */   {
/* 386 */     STimeCommonCfg commonCfg = STimeCommonCfg.get(timeDurationCommonCfg.timeCommonCfgId);
/* 387 */     if (commonCfg == null) {
/* 388 */       return 0;
/*     */     }
/*     */     
/* 391 */     int turn = 0;
/*     */     
/* 393 */     long durationEndTimeMill = getDurationMinute(timeDurationCommonCfg) * 60L * 1000L;
/* 394 */     long nextStartTime = getNextStartTime(timeBegin, commonCfg.id, includeBegin);
/*     */     
/* 396 */     if (isDayCircle(commonCfg))
/*     */     {
/* 398 */       long nextEndTime = nextStartTime + durationEndTimeMill;
/* 399 */       if (timeEnd < nextEndTime) {
/* 400 */         return turn;
/*     */       }
/* 402 */       turn = (int)(turn + ((timeEnd - nextEndTime) / 86400000L + 1L));
/*     */ 
/*     */     }
/* 405 */     else if (isWeekCircle(commonCfg))
/*     */     {
/* 407 */       long nextEndTime = nextStartTime + durationEndTimeMill;
/* 408 */       if (timeEnd < nextEndTime) {
/* 409 */         return turn;
/*     */       }
/* 411 */       turn = (int)(turn + ((timeEnd - nextEndTime) / 604800000L + 1L));
/*     */ 
/*     */     }
/* 414 */     else if (isHourCircle(commonCfg))
/*     */     {
/* 416 */       long nextEndTime = nextStartTime + durationEndTimeMill;
/* 417 */       if (timeEnd < nextEndTime) {
/* 418 */         return turn;
/*     */       }
/* 420 */       turn = (int)(turn + ((timeEnd - nextEndTime) / 3600000L + 1L));
/*     */     }
/*     */     
/* 423 */     return turn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getNextStartTime(long curtime, int activityComonCfgId)
/*     */   {
/* 434 */     return getNextStartTime(curtime, activityComonCfgId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getNextStartTime(long curtime, int activityComonCfgId, boolean canEquialCurTime)
/*     */   {
/* 447 */     Calendar startCalendar = Calendar.getInstance();
/* 448 */     startCalendar.setTimeInMillis(curtime);
/* 449 */     startCalendar.set(13, 0);
/* 450 */     startCalendar.set(14, 0);
/* 451 */     STimeCommonCfg commonCfg = STimeCommonCfg.get(activityComonCfgId);
/* 452 */     if (isDayCircle(commonCfg)) {
/* 453 */       startCalendar.set(11, commonCfg.activeHour);
/* 454 */       startCalendar.set(12, commonCfg.activeMinute);
/* 455 */       long oriTime = startCalendar.getTimeInMillis();
/* 456 */       if ((canEquialCurTime) && 
/* 457 */         (oriTime == curtime)) {
/* 458 */         return oriTime;
/*     */       }
/*     */       
/* 461 */       if (oriTime > curtime) {
/* 462 */         return oriTime;
/*     */       }
/* 464 */       return oriTime + 86400000L;
/*     */     }
/* 466 */     if (isWeekCircle(commonCfg))
/*     */     {
/* 468 */       startCalendar.set(7, commonCfg.activeWeekDay);
/* 469 */       startCalendar.set(11, commonCfg.activeHour);
/* 470 */       startCalendar.set(12, commonCfg.activeMinute);
/* 471 */       long oriTime = startCalendar.getTimeInMillis();
/* 472 */       if ((canEquialCurTime) && 
/* 473 */         (oriTime == curtime)) {
/* 474 */         return oriTime;
/*     */       }
/*     */       
/* 477 */       if (oriTime > curtime) {
/* 478 */         return oriTime;
/*     */       }
/* 480 */       return oriTime + 604800000L;
/*     */     }
/*     */     
/* 483 */     if (isHourCircle(commonCfg))
/*     */     {
/* 485 */       startCalendar.set(12, commonCfg.activeMinute);
/* 486 */       long oriTime = startCalendar.getTimeInMillis();
/* 487 */       if ((canEquialCurTime) && 
/* 488 */         (oriTime == curtime)) {
/* 489 */         return oriTime;
/*     */       }
/*     */       
/* 492 */       if (oriTime > curtime) {
/* 493 */         return oriTime;
/*     */       }
/* 495 */       return oriTime + 3600000L;
/*     */     }
/*     */     
/* 498 */     return startCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLastStartTime(long curTime, int timeDurationCfgId)
/*     */   {
/* 510 */     return getLastStartTime(curTime, timeDurationCfgId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLastStartTime(long curTime, int timeDurationCfgId, boolean canInTimeDuration)
/*     */   {
/* 523 */     Calendar startCalendar = Calendar.getInstance();
/* 524 */     startCalendar.setTimeInMillis(curTime);
/* 525 */     startCalendar.set(13, 0);
/* 526 */     startCalendar.set(14, 0);
/* 527 */     STimeDurationCommonCfg durationCfg = STimeDurationCommonCfg.get(timeDurationCfgId);
/* 528 */     if (durationCfg == null) {
/* 529 */       return -1L;
/*     */     }
/* 531 */     STimeCommonCfg timeCfg = STimeCommonCfg.get(durationCfg.timeCommonCfgId);
/* 532 */     if (isDayCircle(timeCfg)) {
/* 533 */       startCalendar.set(11, timeCfg.activeHour);
/* 534 */       startCalendar.set(12, timeCfg.activeMinute);
/* 535 */       long startTime = startCalendar.getTimeInMillis();
/* 536 */       if (startTime > curTime) {
/* 537 */         startTime -= 86400000L;
/*     */       }
/* 539 */       long endTime = startTime + getDurationMillis(durationCfg);
/* 540 */       if (curTime > endTime) {
/* 541 */         return startTime;
/*     */       }
/* 543 */       if (canInTimeDuration) {
/* 544 */         return startTime;
/*     */       }
/* 546 */       return startTime - 86400000L; }
/* 547 */     if (isWeekCircle(timeCfg)) {
/* 548 */       startCalendar.set(7, timeCfg.activeWeekDay);
/* 549 */       startCalendar.set(11, timeCfg.activeHour);
/* 550 */       startCalendar.set(12, timeCfg.activeMinute);
/* 551 */       long startTime = startCalendar.getTimeInMillis();
/* 552 */       if (startTime > curTime) {
/* 553 */         startTime -= 604800000L;
/*     */       }
/* 555 */       long endTime = startTime + getDurationMillis(durationCfg);
/* 556 */       if (curTime > endTime) {
/* 557 */         return startTime;
/*     */       }
/* 559 */       if (canInTimeDuration) {
/* 560 */         return startTime;
/*     */       }
/* 562 */       return startTime - 604800000L; }
/* 563 */     if (isHourCircle(timeCfg)) {
/* 564 */       startCalendar.set(12, timeCfg.activeMinute);
/* 565 */       long startTime = startCalendar.getTimeInMillis();
/* 566 */       if (startTime > curTime) {
/* 567 */         startTime -= 3600000L;
/*     */       }
/* 569 */       long endTime = startTime + getDurationMillis(durationCfg);
/* 570 */       if (curTime > endTime) {
/* 571 */         return startTime;
/*     */       }
/* 573 */       if (canInTimeDuration) {
/* 574 */         return startTime;
/*     */       }
/* 576 */       return startTime - 3600000L;
/*     */     }
/*     */     
/* 579 */     return -2L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static STimeCommonCfg getCommonCfg(int timeCommonCfgId)
/*     */   {
/* 590 */     return STimeCommonCfg.get(timeCommonCfgId);
/*     */   }
/*     */   
/*     */   public static boolean isHourCircle(STimeCommonCfg timeCommonCfg) {
/* 594 */     return (timeCommonCfg.activeWeekDay <= 0) && (timeCommonCfg.activeHour < 0);
/*     */   }
/*     */   
/*     */   public static boolean isDayCircle(STimeCommonCfg timeCommonCfg) {
/* 598 */     return (timeCommonCfg.activeWeekDay <= 0) && (timeCommonCfg.activeHour >= 0);
/*     */   }
/*     */   
/*     */   public static boolean isWeekCircle(STimeCommonCfg timeCommonCfg) {
/* 602 */     return timeCommonCfg.activeWeekDay > 0;
/*     */   }
/*     */   
/*     */   public static boolean isTimeCommonCfgExist(int timeCommonCfgid) {
/* 606 */     return STimeCommonCfg.get(timeCommonCfgid) != null;
/*     */   }
/*     */   
/*     */   public static boolean checkTimeLimitCfgConflict(int activityTimeCfgId0, int activityTimeCfgId1) {
/* 610 */     if ((!STimeLimitCommonCfg.getAll().containsKey(Integer.valueOf(activityTimeCfgId0))) || (!STimeLimitCommonCfg.getAll().containsKey(Integer.valueOf(activityTimeCfgId1))))
/*     */     {
/* 612 */       return true;
/*     */     }
/* 614 */     long startTime0 = getLimitTimeBegin(activityTimeCfgId0);
/* 615 */     long endTime0 = getLimitTimeEnd(activityTimeCfgId0);
/* 616 */     long startTime1 = getLimitTimeBegin(activityTimeCfgId1);
/* 617 */     long endTime1 = getLimitTimeEnd(activityTimeCfgId1);
/* 618 */     return checkTimeConflict(startTime0, endTime0, startTime1, endTime1);
/*     */   }
/*     */   
/*     */   public static String format(long time, String pattern) {
/* 622 */     SimpleDateFormat sdf = new SimpleDateFormat(pattern);
/* 623 */     return sdf.format(Long.valueOf(time));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getTimePoint(STimePointCommonCfg sTimePointCommonCfg)
/*     */   {
/* 631 */     Calendar nowCalendar = DateTimeUtils.getCalendar();
/* 632 */     nowCalendar.set(1, sTimePointCommonCfg.start_year);
/* 633 */     nowCalendar.set(2, sTimePointCommonCfg.start_month - 1);
/* 634 */     nowCalendar.set(5, sTimePointCommonCfg.start_day);
/* 635 */     nowCalendar.set(11, sTimePointCommonCfg.start_hour);
/* 636 */     nowCalendar.set(12, sTimePointCommonCfg.start_minute);
/* 637 */     nowCalendar.set(13, 0);
/* 638 */     nowCalendar.set(14, 0);
/* 639 */     return nowCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Calendar getCalendar(long millis)
/*     */   {
/* 651 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 652 */     calendar.setTimeInMillis(millis);
/*     */     
/* 654 */     return calendar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static STimeDurationCommonCfg getTimeDurationCfg(int timeDurationCommonCfgid)
/*     */   {
/* 665 */     return STimeDurationCommonCfg.get(timeDurationCommonCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getBeforeStartTime(long curtime, STimeDurationCommonCfg timeDurationCfg)
/*     */   {
/* 677 */     if (timeDurationCfg == null)
/*     */     {
/* 679 */       return 0L;
/*     */     }
/* 681 */     return getBeforeStartTime(curtime, timeDurationCfg.timeCommonCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getDurationMillis(STimeDurationCommonCfg timeDurationCfg)
/*     */   {
/* 692 */     long minutes = getDurationMinute(timeDurationCfg);
/* 693 */     return TimeUnit.MINUTES.toMillis(minutes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void test() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 748 */     Calendar nowCalendar = Calendar.getInstance();
/* 749 */     nowCalendar.set(1, 0);
/* 750 */     nowCalendar.set(2, -1);
/* 751 */     nowCalendar.set(5, 0);
/* 752 */     nowCalendar.set(11, 0);
/* 753 */     nowCalendar.set(12, 0);
/* 754 */     nowCalendar.set(13, 0);
/* 755 */     nowCalendar.set(14, 0);
/* 756 */     System.out.println(nowCalendar.getTimeInMillis());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\TimeCommonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */