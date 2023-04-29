/*     */ package mzm.gsp.timer.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DateObserver
/*     */   extends Observer
/*     */ {
/*     */   private final MyDate m_myDate;
/*     */   
/*     */   public static class MyDate
/*     */   {
/*     */     public static final int ERR_DATE = -1;
/*     */     private static final long millSecondsOf1Hour = 3600000L;
/*     */     private static final long millSecondsOf1Day = 86400000L;
/*     */     private static final long millSecondsOf7Days = 604800000L;
/*     */     private static final int TYPE_ONCE = 0;
/*     */     private static final int TYPE_EVERY_WEEK = 1;
/*     */     private static final int TYPE_EVERY_DAY = 2;
/*     */     private static final int TYPE_EVERY_MONTH = 3;
/*     */     private static final int TYPE_MONTH_EVERY_DAY = 4;
/*     */     private static final int TYPE_MONTH_EVERY_WEEK = 5;
/*     */     private static final int TYPE_EVERY_HOUR = 6;
/*     */     private int year;
/*     */     private int month;
/*     */     private int date;
/*     */     private int dayofweek;
/*     */     private double hour;
/*     */     private int minute;
/*     */     private int type;
/*     */     private long interval;
/*     */     
/*     */     public MyDate(int minute)
/*     */     {
/*  44 */       this.minute = minute;
/*  45 */       this.type = 6;
/*  46 */       Calendar nowCal = Calendar.getInstance();
/*  47 */       nowCal.setTimeInMillis(DateTimeUtils.getCurrTimeInMillis());
/*  48 */       int nowMinute = nowCal.get(12);
/*  49 */       int nowSec = nowCal.get(13);
/*  50 */       long nowMillInHour = nowMinute * 60L * 1000L + nowSec * 1000L + nowCal.get(14);
/*  51 */       long observerMillInHour = minute * 60L * 1000L;
/*  52 */       if (nowMillInHour >= observerMillInHour) {
/*  53 */         this.interval = (3600000L - (nowMillInHour - observerMillInHour));
/*     */       } else {
/*  55 */         this.interval = (observerMillInHour - nowMillInHour);
/*     */       }
/*     */     }
/*     */     
/*     */     public MyDate(int dayofweek, int hour)
/*     */     {
/*  61 */       init(-1, dayofweek, hour);
/*     */     }
/*     */     
/*     */     public MyDate(int month, int dayofweek, int hour) {
/*  65 */       init(month, dayofweek, hour);
/*     */     }
/*     */     
/*     */     public MyDate(int year, int month, int date, int hour) {
/*  69 */       init(year, month, date, hour);
/*     */     }
/*     */     
/*     */     public MyDate(int dayofweek, double hour) {
/*  73 */       init(-1, dayofweek, hour);
/*     */     }
/*     */     
/*     */     public MyDate(int month, int dayofweek, double hour) {
/*  77 */       init(month, dayofweek, hour);
/*     */     }
/*     */     
/*     */     public MyDate(int year, int month, int date, double hour) {
/*  81 */       init(year, month, date, hour);
/*     */     }
/*     */     
/*     */     public MyDate(int year, int month, int date, int hour, int min, int sec) {
/*  85 */       init(year, month, date, hour, min, sec);
/*     */     }
/*     */     
/*     */     public MyDate(Date d) {
/*  89 */       Calendar c = Calendar.getInstance();
/*  90 */       c.setTime(d);
/*  91 */       init(c.get(1), c.get(2), c.get(5), c.get(11), c.get(12), c.get(13));
/*     */     }
/*     */     
/*     */     public MyDate(Calendar c)
/*     */     {
/*  96 */       init(c.get(1), c.get(2), c.get(5), c.get(11), c.get(12), c.get(13));
/*     */     }
/*     */     
/*     */     private void init(int year, int month, int date, int hour, int min, int sec)
/*     */     {
/* 101 */       double hourd = hour + min / 60.0D + sec / 3600.0D;
/* 102 */       init(year, month, date, hourd);
/*     */     }
/*     */     
/*     */     private void init(int month, int dayofweek, double hour) {
/* 106 */       if ((month > 11) || (month < -1) || (dayofweek < 1) || (dayofweek > 7) || (hour < 0.0D) || (hour >= 24.0D))
/* 107 */         throw new RuntimeException("DateObserver.MyDate : 日期设置错误");
/* 108 */       long curTimeMil = DateTimeUtils.getCurrTimeInMillis();
/* 109 */       if (month == -1) {
/* 110 */         this.year = (month = this.date = -1);
/* 111 */         this.dayofweek = dayofweek;
/* 112 */         this.hour = hour;
/* 113 */         this.type = 1;
/*     */         
/* 115 */         Calendar timerCal = Calendar.getInstance();
/* 116 */         timerCal.setTimeInMillis(curTimeMil);
/* 117 */         int dayNum = dayofweek - timerCal.get(7);
/* 118 */         timerCal.add(5, dayNum);
/* 119 */         setIntegralHour(timerCal, hour);
/* 120 */         this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/* 121 */         if (this.interval < 0L)
/* 122 */           this.interval += 604800000L;
/*     */       } else {
/* 124 */         this.year = (this.date = -1);
/* 125 */         this.month = month;
/* 126 */         this.dayofweek = dayofweek;
/* 127 */         this.hour = hour;
/* 128 */         this.type = 5;
/*     */         
/* 130 */         Calendar timerCal = Calendar.getInstance();
/* 131 */         timerCal.setTimeInMillis(curTimeMil);
/* 132 */         int dayNum = dayofweek - timerCal.get(7);
/* 133 */         timerCal.add(5, dayNum);
/* 134 */         setIntegralHour(timerCal, hour);
/*     */         
/* 136 */         if (timerCal.getTimeInMillis() < curTimeMil) {
/* 137 */           timerCal.add(5, 7);
/*     */         }
/*     */         
/* 140 */         while (timerCal.get(2) != month) {
/* 141 */           timerCal.add(5, 7);
/*     */         }
/*     */         
/* 144 */         this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/*     */       }
/*     */     }
/*     */     
/*     */     public void init(int year, int month, int date, double hour) {
/* 149 */       if ((hour < 0.0D) || (hour >= 24.0D) || (month > 11) || (date > 31))
/* 150 */         throw new RuntimeException("DateObserver.MyDate : 日期设置错误");
/* 151 */       this.year = year;
/* 152 */       this.month = month;
/* 153 */       this.date = date;
/* 154 */       this.dayofweek = -1;
/* 155 */       this.hour = hour;
/*     */       
/* 157 */       long curTimeMil = DateTimeUtils.getCurrTimeInMillis();
/* 158 */       Calendar timerCal = Calendar.getInstance();
/* 159 */       timerCal.setTimeInMillis(curTimeMil);
/*     */       
/* 161 */       int nowMonth = timerCal.get(2);
/* 162 */       if (date == -1) {
/* 163 */         if (month == -1) {
/* 164 */           this.type = 2;
/* 165 */           setIntegralHour(timerCal, hour);
/* 166 */           this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/* 167 */           if (this.interval < 0L)
/* 168 */             this.interval += 86400000L;
/*     */         } else {
/* 170 */           this.type = 4;
/* 171 */           timerCal.set(2, month);
/*     */           
/* 173 */           if (curTimeMil > timerCal.getTimeInMillis()) {
/* 174 */             timerCal.add(1, 1);
/* 175 */             timerCal.set(5, 1);
/* 176 */           } else if (nowMonth != month) {
/* 177 */             timerCal.set(5, 1);
/*     */           }
/* 179 */           setIntegralHour(timerCal, hour);
/* 180 */           this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/* 181 */           if (this.interval < 0L) {
/* 182 */             timerCal.add(6, 1);
/* 183 */             if (timerCal.get(2) > month)
/*     */             {
/* 185 */               timerCal.add(1, 1);
/* 186 */               timerCal.set(2, month);
/* 187 */               timerCal.set(5, 1);
/* 188 */               this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/*     */             } else {
/* 190 */               this.interval += 86400000L;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 195 */       else if (month == -1) {
/* 196 */         this.type = 3;
/* 197 */         timerCal.set(5, date);
/* 198 */         setIntegralHour(timerCal, hour);
/* 199 */         if (curTimeMil > timerCal.getTimeInMillis())
/* 200 */           timerCal.add(2, 1);
/* 201 */         this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/*     */       } else {
/* 203 */         this.type = 0;
/* 204 */         timerCal.set(2, month);
/* 205 */         timerCal.set(5, date);
/* 206 */         setIntegralHour(timerCal, hour);
/* 207 */         if (curTimeMil > timerCal.getTimeInMillis())
/* 208 */           timerCal.add(1, 1);
/* 209 */         this.interval = (timerCal.getTimeInMillis() - curTimeMil);
/*     */       }
/*     */     }
/*     */     
/*     */     private void setIntegralHour(Calendar cal, double hour) {
/* 214 */       int iHour = (int)hour;
/*     */       
/* 216 */       int iSecond = (int)(3600.0D * hour - 3600 * iHour);
/* 217 */       int iMinute = iSecond / 60;
/* 218 */       iSecond %= 60;
/* 219 */       cal.set(11, iHour);
/* 220 */       cal.set(12, iMinute);
/* 221 */       cal.set(13, iSecond);
/* 222 */       cal.set(14, 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateObserver(MyDate myDate)
/*     */   {
/* 232 */     super(Math.ceil(myDate.interval / 1000.0D));
/* 233 */     this.m_myDate = myDate;
/*     */     
/* 235 */     if (TimerManager.logger.isDebugEnabled()) {
/* 236 */       long timeout = getTimeoutTimestamp();
/* 237 */       Calendar targettime = Calendar.getInstance();
/* 238 */       targettime.setTimeInMillis(timeout);
/* 239 */       TimerManager.logger.debug("[time] DateObserver : " + getClass().toString() + ", inteval=" + TimeUnit.MILLISECONDS.toMinutes(myDate.interval) + ", date=" + targettime.getTime().toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateObserver(int timeCommonCfgId)
/*     */   {
/* 250 */     this(TimeCommonUtil.createMaydate(timeCommonCfgId));
/*     */   }
/*     */   
/*     */   public boolean update()
/*     */   {
/* 255 */     boolean ret = onTimeOut();
/* 256 */     if (this.m_myDate.type == 0)
/* 257 */       return false;
/* 258 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 259 */     long timeout = getTimeoutTimestamp();
/* 260 */     if (ret) {
/* 261 */       if (this.m_myDate.type == 6) {
/* 262 */         if (curTime <= timeout) {
/* 263 */           timeout += 3600000L;
/*     */         } else {
/* 265 */           long turn = (curTime - timeout - 1L) / 3600000L + 1L;
/* 266 */           timeout += 3600000L * turn;
/*     */         }
/* 268 */         setIntervalMilliSeconds(timeout - curTime);
/*     */         
/* 270 */         if (GameServer.logger().isDebugEnabled()) {
/* 271 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 272 */           GameServer.logger().debug(String.format("[DateObserver]DateObserver.update@每小时触发器触发,下一次触发时间|nextTime=%s|curTime=%s|intervalMill=%d", new Object[] { sdf.format(new Date(timeout)), sdf.format(new Date(curTime)), Long.valueOf(getIntervalMilliSeconds()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 282 */       else if (this.m_myDate.type == 1) {
/* 283 */         long millsOf7Days = 604800000L;
/* 284 */         if (curTime <= timeout) {
/* 285 */           timeout += millsOf7Days;
/*     */         } else {
/* 287 */           long turn = (curTime - timeout - 1L) / millsOf7Days + 1L;
/* 288 */           timeout += millsOf7Days * turn;
/*     */         }
/* 290 */         setIntervalMilliSeconds(timeout - curTime);
/*     */         
/* 292 */         if (GameServer.logger().isDebugEnabled()) {
/* 293 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 294 */           GameServer.logger().debug(String.format("[DateObserver]DateObserver.update@每周触发器触发,下一次触发时间|nextTime=%s|curTime=%s|intervalMill=%d", new Object[] { sdf.format(new Date(timeout)), sdf.format(new Date(curTime)), Long.valueOf(getIntervalMilliSeconds()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 304 */       else if (this.m_myDate.type == 2) {
/* 305 */         if (curTime <= timeout) {
/* 306 */           timeout += 86400000L;
/*     */         } else {
/* 308 */           long turn = (curTime - timeout - 1L) / 86400000L + 1L;
/* 309 */           timeout += 86400000L * turn;
/*     */         }
/*     */         
/* 312 */         setIntervalMilliSeconds(timeout - curTime);
/*     */         
/* 314 */         if (GameServer.logger().isDebugEnabled()) {
/* 315 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 316 */           GameServer.logger().debug(String.format("[DateObserver]DateObserver.update@每天触发器触发,下一次触发时间|nextTime=%s|curTime=%s|intervalMill=%d", new Object[] { sdf.format(new Date(timeout)), sdf.format(new Date(curTime)), Long.valueOf(getIntervalMilliSeconds()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 326 */       else if (this.m_myDate.type == 3)
/*     */       {
/* 328 */         Calendar calendar = Calendar.getInstance();
/* 329 */         calendar.setTimeInMillis(timeout);
/* 330 */         calendar.add(2, 1);
/* 331 */         long nextTriggerTime = calendar.getTimeInMillis();
/* 332 */         while (nextTriggerTime < curTime) {
/* 333 */           calendar.add(2, 1);
/* 334 */           nextTriggerTime = calendar.getTimeInMillis();
/*     */         }
/*     */         
/* 337 */         timeout = nextTriggerTime;
/* 338 */         setIntervalMilliSeconds(timeout - curTime);
/*     */         
/* 340 */         if (GameServer.logger().isDebugEnabled()) {
/* 341 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 342 */           GameServer.logger().debug(String.format("[DateObserver]DateObserver.update@每月触发器触发,下一次触发时间|nextTime=%s|curTime=%s|intervalMill=%d", new Object[] { sdf.format(new Date(timeout)), sdf.format(new Date(curTime)), Long.valueOf(getIntervalMilliSeconds()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 352 */       else if (this.m_myDate.type == 4)
/*     */       {
/* 354 */         Calendar calendar = Calendar.getInstance();
/* 355 */         calendar.setTimeInMillis(timeout);
/* 356 */         int originalMonth = calendar.get(2);
/* 357 */         calendar.add(5, 1);
/* 358 */         long nextTimeMil = calendar.getTimeInMillis();
/* 359 */         if (nextTimeMil < curTime) {
/* 360 */           int turn = (int)((curTime - nextTimeMil - 1L) / 86400000L + 1L);
/* 361 */           calendar.add(5, turn);
/* 362 */           nextTimeMil = calendar.getTimeInMillis();
/*     */         }
/* 364 */         timeout = nextTimeMil;
/*     */         
/* 366 */         if (originalMonth != calendar.get(2)) {
/* 367 */           return false;
/*     */         }
/* 369 */         setIntervalMilliSeconds(timeout - curTime);
/*     */         
/* 371 */         if (GameServer.logger().isDebugEnabled()) {
/* 372 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 373 */           GameServer.logger().debug(String.format("[DateObserver]DateObserver.update@固定月每天触发器触发,下一次触发时间|nextTime=%s|curTime=%s|intervalMill=%d", new Object[] { sdf.format(new Date(timeout)), sdf.format(new Date(curTime)), Long.valueOf(getIntervalMilliSeconds()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 383 */       else if (this.m_myDate.type == 5)
/*     */       {
/* 385 */         Calendar calendar = Calendar.getInstance();
/* 386 */         calendar.setTimeInMillis(timeout);
/* 387 */         int originalMonth = calendar.get(2);
/* 388 */         calendar.add(3, 1);
/* 389 */         long nextTimeMil = calendar.getTimeInMillis();
/* 390 */         if (nextTimeMil < curTime) {
/* 391 */           int turn = (int)((curTime - nextTimeMil - 1L) / 604800000L + 1L);
/* 392 */           calendar.add(3, turn);
/* 393 */           nextTimeMil = calendar.getTimeInMillis();
/*     */         }
/* 395 */         timeout = nextTimeMil;
/*     */         
/* 397 */         if (originalMonth != calendar.get(2)) {
/* 398 */           return false;
/*     */         }
/* 400 */         setIntervalMilliSeconds(timeout - curTime);
/*     */         
/* 402 */         if (GameServer.logger().isDebugEnabled()) {
/* 403 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 404 */           GameServer.logger().debug(String.format("[DateObserver]DateObserver.update@固定月每天触发器触发,下一次触发时间|nextTime=%s|curTime=%s|intervalMill=%d", new Object[] { sdf.format(new Date(timeout)), sdf.format(new Date(curTime)), Long.valueOf(getIntervalMilliSeconds()) }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 416 */     return ret;
/*     */   }
/*     */   
/*     */   private void setIntervalMilliSeconds(long l) {
/* 420 */     super.setIntervalSeconds(Math.ceil(l / 1000.0D));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getPrevTriggerTime()
/*     */   {
/* 430 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 431 */     if (this.m_myDate.type == 1)
/* 432 */       return currTime - (604800000L - this.m_myDate.interval);
/* 433 */     if (this.m_myDate.type == 2)
/* 434 */       return currTime - (86400000L - this.m_myDate.interval);
/* 435 */     if (this.m_myDate.type == 3) {
/* 436 */       Calendar timerCal = Calendar.getInstance();
/* 437 */       timerCal.setTimeInMillis(currTime + this.m_myDate.interval);
/* 438 */       timerCal.add(2, -1);
/* 439 */       return timerCal.getTimeInMillis(); }
/* 440 */     if (this.m_myDate.type == 4) {
/* 441 */       Calendar timerCal = Calendar.getInstance();
/* 442 */       timerCal.setTimeInMillis(currTime + this.m_myDate.interval);
/* 443 */       int oldMonth = timerCal.get(2);
/* 444 */       timerCal.add(5, -1);
/* 445 */       if (timerCal.get(2) != oldMonth) {
/* 446 */         return -1L;
/*     */       }
/* 448 */       return timerCal.getTimeInMillis(); }
/* 449 */     if (this.m_myDate.type == 0) {
/* 450 */       Calendar timerCal = Calendar.getInstance();
/* 451 */       timerCal.setTimeInMillis(currTime + this.m_myDate.interval);
/* 452 */       timerCal.add(1, -1);
/* 453 */       return timerCal.getTimeInMillis();
/*     */     }
/*     */     
/* 456 */     throw new RuntimeException("DateObserver type error, " + toString());
/*     */   }
/*     */   
/*     */   protected abstract boolean onTimeOut();
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\DateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */