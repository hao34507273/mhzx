/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateTimeManager
/*     */ {
/*     */   public static final int MINUTES_OF_ONE_HOUR = 60;
/*     */   public static final int SECONDES_OF_ONE_MINUTE = 60;
/*     */   public static final int SECONDS_OF_ONE_HOUR = 3600;
/*     */   public static final int SECONDS_OF_ONE_DAY = 86400;
/*     */   public static final int MILLISECONDS_OF_ONE_SECOND = 1000;
/*     */   public static final int MILLISECONDS_OF_ONE_MINUTE = 60000;
/*     */   public static final int MILLISECONDS_OF_ONE_HOUR = 3600000;
/*     */   public static final int MILLISECONDS_OF_ONE_DAY = 86400000;
/*  23 */   private static final int RAW_OFFSET_MILLIS = TimeZone.getDefault().getRawOffset();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInSameDay(long ms1, long ms2)
/*     */   {
/*  33 */     return isInSameDay(ms1, ms2, 0, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInSameDay(long ms1, long ms2, int offsetHour, int offsetMinute)
/*     */   {
/*  45 */     return getDurationTimes(ms1, ms2, offsetHour, offsetMinute) == 0;
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
/*     */   public static int getDurationTimes(long beginMillis, long endMillis, int hour, int minute, int second, int millis)
/*     */   {
/*  60 */     long offsetMs = hour * 3600000 + minute * 60000 + second * 1000 + millis + RAW_OFFSET_MILLIS;
/*     */     
/*     */ 
/*  63 */     long endMs = endMillis + offsetMs;
/*  64 */     long beginMs = beginMillis + offsetMs;
/*     */     
/*  66 */     return (int)(endMs / 86400000L - beginMs / 86400000L);
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
/*     */   public static int getDurationTimes(long beginMillis, long endMillis, int hour, int minute, int second)
/*     */   {
/*  79 */     return getDurationTimes(beginMillis, endMillis, hour, minute, second, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getDurationTimes(long beginMillis, long endMillis, int hour, int minute)
/*     */   {
/*  91 */     return getDurationTimes(beginMillis, endMillis, hour, minute, 0, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getDurationTimes(long beginMillis, long endMillis, int hour)
/*     */   {
/* 103 */     return getDurationTimes(beginMillis, endMillis, hour, 0, 0, 0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\DateTimeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */