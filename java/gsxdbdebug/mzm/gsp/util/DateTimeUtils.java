/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ 
/*     */ public class DateTimeUtils
/*     */ {
/*  14 */   private static ThreadLocal<Map<String, SimpleDateFormat>> localSdfs = new ThreadLocal();
/*     */   
/*     */   public static SimpleDateFormat getSimpleDateFormat(String pattern)
/*     */   {
/*  18 */     Map<String, SimpleDateFormat> sdfs = (Map)localSdfs.get();
/*  19 */     if (sdfs == null)
/*     */     {
/*  21 */       sdfs = new HashMap();
/*  22 */       localSdfs.set(sdfs);
/*     */     }
/*     */     
/*  25 */     SimpleDateFormat sdf = (SimpleDateFormat)sdfs.get(pattern);
/*  26 */     if (sdf == null)
/*     */     {
/*  28 */       sdf = new SimpleDateFormat(pattern);
/*  29 */       sdfs.put(pattern, sdf);
/*     */     }
/*  31 */     return sdf;
/*     */   }
/*     */   
/*  34 */   private static final ThreadLocal<Calendar> local = new ThreadLocal();
/*  35 */   public static final int RAW_OFFSET = getCalendar().getTimeZone().getRawOffset();
/*  36 */   public static final int RAW_OFFSET_SEC = RAW_OFFSET / 1000;
/*     */   
/*     */   public static final long MINUTE_OF_SECONDS = 60L;
/*     */   
/*     */   public static final long HOUR_OF_SECONDS = 3600L;
/*     */   public static final long DAY_OF_SECONDS = 86400L;
/*     */   public static final long WEEK_OF_SECONDS = 604800L;
/*     */   public static final long MINUTE_OF_MILLISECONDS = 60000L;
/*     */   public static final long HOUR_OF_MILLISECONDS = 3600000L;
/*     */   public static final long DAY_OF_MILLISECONDS = 86400000L;
/*     */   public static final long WEEK_OF_MILLSSECONDS = 604800000L;
/*  47 */   private static final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*  48 */   private static long offset = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setTimeOffset(long timeOffset)
/*     */   {
/*     */     try
/*     */     {
/*  57 */       rwLock.writeLock().lock();
/*  58 */       offset = timeOffset;
/*     */     }
/*     */     finally
/*     */     {
/*  62 */       rwLock.writeLock().unlock();
/*     */     }
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
/*     */   public static final boolean setDate(String value)
/*     */   {
/*  76 */     long newOffset = 0L;
/*     */     try
/*     */     {
/*  79 */       int year = Integer.parseInt(value.substring(0, 4));
/*  80 */       int month = Integer.parseInt(value.substring(4, 6)) - 1;
/*  81 */       int day = Integer.parseInt(value.substring(6, 8));
/*  82 */       int hour = Integer.parseInt(value.substring(8, 10));
/*  83 */       int minute = Integer.parseInt(value.substring(10, 12));
/*  84 */       int second = Integer.parseInt(value.substring(12, 14));
/*  85 */       Calendar calendar = getCalendar();
/*  86 */       calendar.clear();
/*  87 */       calendar.set(year, month, day, hour, minute, second);
/*  88 */       newOffset = calendar.getTimeInMillis() - System.currentTimeMillis();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     long timeOffset = newOffset;
/*  96 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 100 */         if (!GameServerInfoManager.setTimeOffset(this.val$timeOffset))
/*     */         {
/* 102 */           return false;
/*     */         }
/*     */         
/* 105 */         DateTimeUtils.setTimeOffset(this.val$timeOffset);
/*     */         
/* 107 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   public static final Calendar getCalendar()
/*     */   {
/* 114 */     Calendar calendar = (Calendar)local.get();
/* 115 */     if (calendar == null)
/*     */     {
/* 117 */       calendar = Calendar.getInstance();
/* 118 */       calendar.setFirstDayOfWeek(2);
/* 119 */       local.set(calendar);
/*     */     }
/* 121 */     return calendar;
/*     */   }
/*     */   
/*     */   public static final long getCurrTimeInMillis()
/*     */   {
/*     */     try
/*     */     {
/* 128 */       rwLock.readLock().lock();
/* 129 */       return System.currentTimeMillis() + offset;
/*     */     }
/*     */     finally
/*     */     {
/* 133 */       rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfCurrWeek(long millis)
/*     */   {
/* 139 */     Calendar calendar = getCalendar();
/* 140 */     calendar.setTimeInMillis(millis);
/* 141 */     calendar.set(7, calendar.getFirstDayOfWeek());
/* 142 */     calendar.set(11, 0);
/* 143 */     calendar.set(12, 0);
/* 144 */     calendar.set(13, 0);
/* 145 */     calendar.set(14, 0);
/*     */     
/* 147 */     long time = calendar.getTimeInMillis();
/* 148 */     return time;
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfCurrDay(long millis)
/*     */   {
/* 153 */     Calendar calendar = getCalendar();
/* 154 */     calendar.setTimeInMillis(millis);
/* 155 */     calendar.set(11, 0);
/* 156 */     calendar.set(12, 0);
/* 157 */     calendar.set(13, 0);
/* 158 */     calendar.set(14, 0);
/*     */     
/* 160 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfNextDay(long millis)
/*     */   {
/* 165 */     Calendar calendar = getCalendar();
/* 166 */     calendar.setTimeInMillis(millis);
/* 167 */     calendar.add(5, 1);
/* 168 */     calendar.set(11, 0);
/* 169 */     calendar.set(12, 0);
/* 170 */     calendar.set(13, 0);
/* 171 */     calendar.set(14, 0);
/*     */     
/* 173 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfNextHour(long millis)
/*     */   {
/* 178 */     Calendar calendar = getCalendar();
/* 179 */     calendar.setTimeInMillis(millis);
/* 180 */     calendar.add(11, 1);
/* 181 */     calendar.set(12, 0);
/* 182 */     calendar.set(13, 0);
/* 183 */     calendar.set(14, 0);
/*     */     
/* 185 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfNextMonth(long millis)
/*     */   {
/* 190 */     Calendar calendar = getCalendar();
/* 191 */     calendar.setTimeInMillis(millis);
/* 192 */     calendar.add(2, 1);
/* 193 */     calendar.set(5, 1);
/* 194 */     calendar.set(11, 0);
/* 195 */     calendar.set(12, 0);
/* 196 */     calendar.set(13, 0);
/* 197 */     calendar.set(14, 0);
/*     */     
/* 199 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfNextYear(long millis)
/*     */   {
/* 204 */     Calendar calendar = getCalendar();
/* 205 */     calendar.setTimeInMillis(millis);
/* 206 */     calendar.add(1, 1);
/* 207 */     calendar.set(2, 0);
/* 208 */     calendar.set(5, 1);
/* 209 */     calendar.set(11, 0);
/* 210 */     calendar.set(12, 0);
/* 211 */     calendar.set(13, 0);
/* 212 */     calendar.set(14, 0);
/*     */     
/* 214 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getBeginTimeOfYesterday(long millis)
/*     */   {
/* 219 */     Calendar calendar = getCalendar();
/* 220 */     calendar.setTimeInMillis(millis);
/* 221 */     calendar.add(5, -1);
/* 222 */     calendar.set(11, 0);
/* 223 */     calendar.set(12, 0);
/* 224 */     calendar.set(13, 0);
/* 225 */     calendar.set(14, 0);
/*     */     
/* 227 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getModifiedTime(long millis, int hour)
/*     */   {
/* 232 */     return getModifiedTime(millis, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getModifiedTime(long millis, int hour, int minute)
/*     */   {
/* 237 */     return getModifiedTime(millis, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getModifiedTime(long millis, int hour, int minute, int second)
/*     */   {
/* 242 */     Calendar calendar = getCalendar();
/* 243 */     calendar.setTimeInMillis(millis);
/* 244 */     calendar.add(11, hour);
/* 245 */     calendar.add(12, minute);
/* 246 */     calendar.add(13, second);
/* 247 */     calendar.add(14, 0);
/*     */     
/* 249 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getTimeInToday(long millis, int hour)
/*     */   {
/* 254 */     return getTimeInToday(millis, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getTimeInToday(long millis, int hour, int minute)
/*     */   {
/* 259 */     return getTimeInToday(millis, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getTimeInToday(long millis, int hour, int minute, int second)
/*     */   {
/* 264 */     Calendar calendar = getCalendar();
/* 265 */     calendar.setTimeInMillis(millis);
/* 266 */     calendar.set(11, hour);
/* 267 */     calendar.set(12, minute);
/* 268 */     calendar.set(13, second);
/* 269 */     calendar.set(14, 0);
/*     */     
/* 271 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getDailyResetTime(long currTime, int hour)
/*     */   {
/* 276 */     return getDailyResetTime(currTime, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getDailyResetTime(long currTime, int hour, int minute)
/*     */   {
/* 281 */     return getDailyResetTime(currTime, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getDailyResetTime(long currTime, int hour, int minute, int second)
/*     */   {
/* 286 */     long originTime = getTimeInToday(currTime, hour, minute, second);
/* 287 */     if (originTime <= currTime)
/*     */     {
/* 289 */       return originTime;
/*     */     }
/*     */     
/*     */ 
/* 293 */     return originTime - 86400000L;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final boolean needDailyReset(long oldTime, long currTime, int hour)
/*     */   {
/* 299 */     return needDailyReset(oldTime, currTime, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final boolean needDailyReset(long oldTime, long currTime, int hour, int minute)
/*     */   {
/* 304 */     return needDailyReset(oldTime, currTime, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final boolean needDailyReset(long oldTime, long currTime, int hour, int minute, int second)
/*     */   {
/* 309 */     long resetTime = getDailyResetTime(currTime, hour, minute, second);
/* 310 */     return oldTime < resetTime;
/*     */   }
/*     */   
/*     */   public static final long getTimeInWeek(long currTime, int dayOfWeek, int hour)
/*     */   {
/* 315 */     return getTimeInWeek(currTime, dayOfWeek, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getTimeInWeek(long currTime, int dayOfWeek, int hour, int minute)
/*     */   {
/* 320 */     return getTimeInWeek(currTime, dayOfWeek, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getTimeInWeek(long currTime, int dayOfWeek, int hour, int minute, int second)
/*     */   {
/* 325 */     Calendar calendar = getCalendar();
/* 326 */     calendar.setTimeInMillis(currTime);
/* 327 */     calendar.set(7, dayOfWeek);
/* 328 */     calendar.set(11, hour);
/* 329 */     calendar.set(12, minute);
/* 330 */     calendar.set(13, second);
/* 331 */     calendar.set(14, 0);
/*     */     
/* 333 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getWeeklyResetTime(long currTime, int dayOfWeek, int hour)
/*     */   {
/* 338 */     return getWeeklyResetTime(currTime, dayOfWeek, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getWeeklyResetTime(long currTime, int dayOfWeek, int hour, int minute)
/*     */   {
/* 343 */     return getWeeklyResetTime(currTime, dayOfWeek, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getWeeklyResetTime(long currTime, int dayOfWeek, int hour, int minute, int second)
/*     */   {
/* 348 */     long originTime = getTimeInWeek(currTime, dayOfWeek, hour, minute, second);
/* 349 */     if (originTime <= currTime)
/*     */     {
/* 351 */       return originTime;
/*     */     }
/*     */     
/*     */ 
/* 355 */     return originTime - 604800000L;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final boolean needWeeklyReset(long oldTime, long currTime, int dayOfWeek, int hour)
/*     */   {
/* 361 */     return needWeeklyReset(oldTime, currTime, dayOfWeek, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final boolean needWeeklyReset(long oldTime, long currTime, int dayOfWeek, int hour, int minute)
/*     */   {
/* 366 */     return needWeeklyReset(oldTime, currTime, dayOfWeek, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final boolean needWeeklyReset(long oldTime, long currTime, int dayOfWeek, int hour, int minute, int second)
/*     */   {
/* 371 */     long resetTime = getWeeklyResetTime(currTime, dayOfWeek, hour, minute, second);
/* 372 */     return oldTime < resetTime;
/*     */   }
/*     */   
/*     */   public static final long getTimeInMonth(long currTime, int dayOfMonth, int hour)
/*     */   {
/* 377 */     return getTimeInWeek(currTime, dayOfMonth, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getTimeInMonth(long currTime, int dayOfMonth, int hour, int minute)
/*     */   {
/* 382 */     return getTimeInMonth(currTime, dayOfMonth, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getTimeInMonth(long currTime, int dayOfMonth, int hour, int minute, int second)
/*     */   {
/* 387 */     Calendar calendar = getCalendar();
/* 388 */     calendar.setTimeInMillis(currTime);
/* 389 */     calendar.set(5, dayOfMonth);
/* 390 */     calendar.set(11, hour);
/* 391 */     calendar.set(12, minute);
/* 392 */     calendar.set(13, second);
/* 393 */     calendar.set(14, 0);
/*     */     
/* 395 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getTimeInLastMonth(long currTime, int dayOfMonth, int hour, int minute, int second)
/*     */   {
/* 400 */     Calendar calendar = getCalendar();
/* 401 */     calendar.setTimeInMillis(currTime);
/* 402 */     calendar.add(2, -1);
/* 403 */     calendar.set(5, dayOfMonth);
/* 404 */     calendar.set(11, hour);
/* 405 */     calendar.set(12, minute);
/* 406 */     calendar.set(13, second);
/* 407 */     calendar.set(14, 0);
/*     */     
/* 409 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final long getMonthlyResetTime(long currTime, int dayOfMonth, int hour)
/*     */   {
/* 414 */     return getMonthlyResetTime(currTime, dayOfMonth, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final long getMonthlyResetTime(long currTime, int dayOfMonth, int hour, int minute)
/*     */   {
/* 419 */     return getMonthlyResetTime(currTime, dayOfMonth, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final long getMonthlyResetTime(long currTime, int dayOfMonth, int hour, int minute, int second)
/*     */   {
/* 424 */     long originTime = getTimeInMonth(currTime, dayOfMonth, hour, minute, second);
/* 425 */     if (originTime <= currTime)
/*     */     {
/* 427 */       return originTime;
/*     */     }
/*     */     
/*     */ 
/* 431 */     return getTimeInLastMonth(currTime, dayOfMonth, hour, minute, second);
/*     */   }
/*     */   
/*     */ 
/*     */   public static final boolean needMonthlyReset(long oldTime, long currTime, int dayOfMonth, int hour)
/*     */   {
/* 437 */     return needMonthlyReset(oldTime, currTime, dayOfMonth, hour, 0, 0);
/*     */   }
/*     */   
/*     */   public static final boolean needMonthlyReset(long oldTime, long currTime, int dayOfMonth, int hour, int minute)
/*     */   {
/* 442 */     return needMonthlyReset(oldTime, currTime, dayOfMonth, hour, minute, 0);
/*     */   }
/*     */   
/*     */   public static final boolean needMonthlyReset(long oldTime, long currTime, int dayOfMonth, int hour, int minute, int second)
/*     */   {
/* 447 */     long resetTime = getMonthlyResetTime(currTime, dayOfMonth, hour, minute, second);
/* 448 */     return oldTime < resetTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final long valueOf(String value)
/*     */   {
/* 459 */     if (value.length() != 10)
/*     */     {
/* 461 */       throw new RuntimeException("the time format must be YYYYMMDDHH, e.g.:2013031314");
/*     */     }
/*     */     
/* 464 */     Calendar calendar = getCalendar();
/* 465 */     calendar.set(1, Integer.valueOf(value.substring(0, 4)).intValue());
/* 466 */     calendar.set(2, Integer.valueOf(value.substring(4, 6)).intValue() - 1);
/* 467 */     calendar.set(5, Integer.valueOf(value.substring(6, 8)).intValue());
/* 468 */     calendar.set(11, Integer.valueOf(value.substring(8, 10)).intValue());
/* 469 */     calendar.set(12, 0);
/* 470 */     calendar.set(13, 0);
/* 471 */     calendar.set(14, 0);
/*     */     
/* 473 */     return calendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static final boolean isInSameYear(long time0, long time1)
/*     */   {
/* 478 */     Calendar calendar = getCalendar();
/*     */     
/* 480 */     calendar.setTimeInMillis(time0);
/* 481 */     int year0 = calendar.get(1);
/*     */     
/* 483 */     calendar.setTimeInMillis(time1);
/* 484 */     return year0 == calendar.get(1);
/*     */   }
/*     */   
/*     */   public static final boolean isInSameMonth(long time0, long time1)
/*     */   {
/* 489 */     Calendar calendar = getCalendar();
/*     */     
/* 491 */     calendar.setTimeInMillis(time0);
/* 492 */     int year0 = calendar.get(1);
/* 493 */     int month0 = calendar.get(2);
/*     */     
/* 495 */     calendar.setTimeInMillis(time1);
/*     */     
/* 497 */     return (year0 == calendar.get(1)) && (month0 == calendar.get(2));
/*     */   }
/*     */   
/*     */   public static final boolean isInSameWeek(long time0, long time1)
/*     */   {
/* 502 */     Calendar calendar = getCalendar();
/*     */     
/* 504 */     calendar.setTimeInMillis(time0);
/* 505 */     int weeks = calendar.get(3);
/*     */     
/* 507 */     calendar.setTimeInMillis(time1);
/* 508 */     return (weeks == calendar.get(3)) && (Math.abs(diffDays(time0, time1)) <= 7);
/*     */   }
/*     */   
/*     */   public static final boolean isInThisWeek(long time)
/*     */   {
/* 513 */     return isInSameWeek(time, getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   public static final boolean isInSameDay(long time0, long time1)
/*     */   {
/* 518 */     return diffDays(time0, time1) == 0;
/*     */   }
/*     */   
/*     */   public static final int diffDays(long time0, long time1)
/*     */   {
/* 523 */     return (int)((time0 + RAW_OFFSET) / 86400000L - (time1 + RAW_OFFSET) / 86400000L);
/*     */   }
/*     */   
/*     */   public static final int diffDaysFromNow(long time)
/*     */   {
/* 528 */     return diffDays(getCurrTimeInMillis(), time);
/*     */   }
/*     */   
/*     */   public static final int getYear(long millis)
/*     */   {
/* 533 */     Calendar calendar = getCalendar();
/*     */     
/* 535 */     calendar.setTimeInMillis(millis);
/* 536 */     return calendar.get(1);
/*     */   }
/*     */   
/*     */   public static final int getMonth(long millis)
/*     */   {
/* 541 */     Calendar calendar = getCalendar();
/*     */     
/* 543 */     calendar.setTimeInMillis(millis);
/* 544 */     return calendar.get(2);
/*     */   }
/*     */   
/*     */   public static final int getDay(long millis)
/*     */   {
/* 549 */     Calendar calendar = getCalendar();
/*     */     
/* 551 */     calendar.setTimeInMillis(millis);
/* 552 */     return calendar.get(5);
/*     */   }
/*     */   
/*     */   public static final String formatTimestamp(long timestamp)
/*     */   {
/* 557 */     Calendar calendar = getCalendar();
/* 558 */     calendar.setTimeInMillis(timestamp);
/* 559 */     int year = calendar.get(1);
/* 560 */     int month = calendar.get(2) + 1;
/* 561 */     int day = calendar.get(5);
/* 562 */     int hour = calendar.get(11);
/* 563 */     int minute = calendar.get(12);
/* 564 */     int second = calendar.get(13);
/*     */     
/* 566 */     return String.format("%04d%02d%02d%02d%02d%02d", new Object[] { Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(second) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\DateTimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */