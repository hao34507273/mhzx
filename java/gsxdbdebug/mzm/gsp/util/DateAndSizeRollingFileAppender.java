/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.log4j.FileAppender;
/*     */ import org.apache.log4j.Layout;
/*     */ import org.apache.log4j.helpers.CountingQuietWriter;
/*     */ import org.apache.log4j.helpers.LogLog;
/*     */ import org.apache.log4j.helpers.OptionConverter;
/*     */ import org.apache.log4j.spi.ErrorHandler;
/*     */ import org.apache.log4j.spi.LoggingEvent;
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
/*     */ public class DateAndSizeRollingFileAppender
/*     */   extends FileAppender
/*     */ {
/*     */   static final int TOP_OF_TROUBLE = -1;
/*     */   static final int TOP_OF_MINUTE = 0;
/*     */   static final int TOP_OF_HOUR = 1;
/*     */   static final int HALF_DAY = 2;
/*     */   static final int TOP_OF_DAY = 3;
/*     */   static final int TOP_OF_WEEK = 4;
/*     */   static final int TOP_OF_MONTH = 5;
/* 117 */   protected long maxFileSize = 10485760L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 122 */   protected int maxBackupIndex = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */   private String datePattern = "'.'yyyy-MM-dd";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String scheduledFilename;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */   private long nextCheck = System.currentTimeMillis() - 1L;
/*     */   
/* 145 */   Date now = new Date();
/*     */   
/*     */   SimpleDateFormat sdf;
/*     */   
/* 149 */   RollingCalendar rc = new RollingCalendar();
/*     */   
/* 151 */   int checkPeriod = -1;
/*     */   
/*     */ 
/* 154 */   static final TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateAndSizeRollingFileAppender() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DateAndSizeRollingFileAppender(Layout layout, String filename, String datePattern)
/*     */     throws IOException
/*     */   {
/* 170 */     super(layout, filename, true);
/* 171 */     this.datePattern = datePattern;
/* 172 */     activateOptions();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getMaximumFileSize()
/*     */   {
/* 183 */     return this.maxFileSize;
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
/*     */   public void setMaximumFileSize(long maxFileSize)
/*     */   {
/* 199 */     this.maxFileSize = maxFileSize;
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
/*     */   public void setMaxFileSize(String value)
/*     */   {
/* 213 */     this.maxFileSize = OptionConverter.toFileSize(value, this.maxFileSize + 1L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMaxBackupIndex()
/*     */   {
/* 221 */     return this.maxBackupIndex;
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
/*     */   public void setMaxBackupIndex(int maxBackups)
/*     */   {
/* 234 */     this.maxBackupIndex = maxBackups;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDatePattern(String pattern)
/*     */   {
/* 243 */     this.datePattern = pattern;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getDatePattern()
/*     */   {
/* 249 */     return this.datePattern;
/*     */   }
/*     */   
/*     */   public void activateOptions()
/*     */   {
/* 254 */     super.activateOptions();
/* 255 */     if ((this.datePattern != null) && (this.fileName != null))
/*     */     {
/* 257 */       this.now.setTime(System.currentTimeMillis());
/* 258 */       this.sdf = new SimpleDateFormat(this.datePattern);
/* 259 */       int type = computeCheckPeriod();
/* 260 */       printPeriodicity(type);
/* 261 */       this.rc.setType(type);
/* 262 */       File file = new File(this.fileName);
/* 263 */       this.scheduledFilename = (this.fileName + this.sdf.format(new Date(file.lastModified())));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 268 */       LogLog.error("Either File or DatePattern options are not set for appender [" + this.name + "].");
/*     */     }
/*     */   }
/*     */   
/*     */   void printPeriodicity(int type)
/*     */   {
/* 274 */     switch (type)
/*     */     {
/*     */     case 0: 
/* 277 */       LogLog.debug("Appender [" + this.name + "] to be rolled every minute.");
/* 278 */       break;
/*     */     case 1: 
/* 280 */       LogLog.debug("Appender [" + this.name + "] to be rolled on top of every hour.");
/* 281 */       break;
/*     */     case 2: 
/* 283 */       LogLog.debug("Appender [" + this.name + "] to be rolled at midday and midnight.");
/* 284 */       break;
/*     */     case 3: 
/* 286 */       LogLog.debug("Appender [" + this.name + "] to be rolled at midnight.");
/* 287 */       break;
/*     */     case 4: 
/* 289 */       LogLog.debug("Appender [" + this.name + "] to be rolled at start of week.");
/* 290 */       break;
/*     */     case 5: 
/* 292 */       LogLog.debug("Appender [" + this.name + "] to be rolled at start of every month.");
/* 293 */       break;
/*     */     default: 
/* 295 */       LogLog.warn("Unknown periodicity for appender [" + this.name + "].");
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int computeCheckPeriod()
/*     */   {
/* 309 */     RollingCalendar rollingCalendar = new RollingCalendar(gmtTimeZone, Locale.ENGLISH);
/*     */     
/* 311 */     Date epoch = new Date(0L);
/* 312 */     if (this.datePattern != null)
/*     */     {
/* 314 */       for (int i = 0; i <= 5; i++)
/*     */       {
/* 316 */         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern);
/*     */         
/* 318 */         simpleDateFormat.setTimeZone(gmtTimeZone);
/* 319 */         String r0 = simpleDateFormat.format(epoch);
/* 320 */         rollingCalendar.setType(i);
/* 321 */         Date next = new Date(rollingCalendar.getNextCheckMillis(epoch));
/* 322 */         String r1 = simpleDateFormat.format(next);
/* 323 */         if ((r0 != null) && (r1 != null) && (!r0.equals(r1)))
/*     */         {
/* 325 */           return i;
/*     */         }
/*     */       }
/*     */     }
/* 329 */     return -1;
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
/*     */   public void sizeRollOver()
/*     */   {
/* 349 */     LogLog.debug("rolling over count=" + ((CountingQuietWriter)this.qw).getCount());
/* 350 */     LogLog.debug("maxBackupIndex=" + this.maxBackupIndex);
/*     */     
/* 352 */     String datedFilename = this.fileName + this.sdf.format(this.now);
/*     */     
/* 354 */     if (this.maxBackupIndex > 0)
/*     */     {
/*     */ 
/* 357 */       File file = new File(datedFilename + '.' + this.maxBackupIndex);
/* 358 */       if (file.exists()) {
/* 359 */         file.delete();
/*     */       }
/*     */       
/*     */ 
/* 363 */       for (int i = this.maxBackupIndex - 1; i >= 1; i--)
/*     */       {
/* 365 */         file = new File(datedFilename + "." + i);
/* 366 */         if (file.exists())
/*     */         {
/* 368 */           File target = new File(datedFilename + '.' + (i + 1));
/* 369 */           LogLog.debug("Renaming file " + file + " to " + target);
/* 370 */           file.renameTo(target);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 375 */       File target = new File(datedFilename + "." + 1);
/*     */       
/* 377 */       closeFile();
/*     */       
/* 379 */       file = new File(this.fileName);
/* 380 */       LogLog.debug("Renaming file " + file + " to " + target);
/* 381 */       file.renameTo(target);
/*     */     }
/* 383 */     else if (this.maxBackupIndex < 0)
/*     */     {
/*     */ 
/* 386 */       for (int i = 1; i < Integer.MAX_VALUE; i++)
/*     */       {
/* 388 */         File target = new File(datedFilename + "." + i);
/* 389 */         if (!target.exists())
/*     */         {
/* 391 */           closeFile();
/* 392 */           File file = new File(this.fileName);
/* 393 */           file.renameTo(target);
/* 394 */           LogLog.debug("Renaming file " + file + " to " + target);
/* 395 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 404 */       setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 408 */       LogLog.error("setFile(" + this.fileName + ", false) call failed.", e);
/*     */     }
/* 410 */     this.scheduledFilename = datedFilename;
/*     */   }
/*     */   
/*     */   public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException
/*     */   {
/* 415 */     super.setFile(fileName, append, this.bufferedIO, this.bufferSize);
/* 416 */     if (append)
/*     */     {
/* 418 */       File f = new File(fileName);
/* 419 */       ((CountingQuietWriter)this.qw).setCount(f.length());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void setQWForFiles(Writer writer)
/*     */   {
/* 425 */     this.qw = new CountingQuietWriter(writer, this.errorHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void timeRollOver()
/*     */     throws IOException
/*     */   {
/* 434 */     if (this.datePattern == null)
/*     */     {
/* 436 */       this.errorHandler.error("Missing DatePattern option in rollOver().");
/* 437 */       return;
/*     */     }
/*     */     
/* 440 */     String datedFilename = this.fileName + this.sdf.format(this.now);
/*     */     
/*     */ 
/*     */ 
/* 444 */     if (this.scheduledFilename.equals(datedFilename))
/*     */     {
/* 446 */       return;
/*     */     }
/*     */     
/*     */ 
/* 450 */     closeFile();
/*     */     
/* 452 */     File target = new File(this.scheduledFilename);
/* 453 */     if (target.exists())
/*     */     {
/* 455 */       target.delete();
/*     */     }
/*     */     
/* 458 */     File file = new File(this.fileName);
/* 459 */     boolean result = file.renameTo(target);
/* 460 */     if (result)
/*     */     {
/* 462 */       LogLog.debug(this.fileName + " -> " + this.scheduledFilename);
/*     */     }
/*     */     else
/*     */     {
/* 466 */       LogLog.error("Failed to rename [" + this.fileName + "] to [" + this.scheduledFilename + "].");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 473 */       super.setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 477 */       this.errorHandler.error("setFile(" + this.fileName + ", false) call failed.");
/*     */     }
/* 479 */     this.scheduledFilename = datedFilename;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void subAppend(LoggingEvent event)
/*     */   {
/* 491 */     long n = System.currentTimeMillis();
/*     */     
/* 493 */     if (n >= this.nextCheck)
/*     */     {
/* 495 */       this.now.setTime(n);
/* 496 */       this.nextCheck = this.rc.getNextCheckMillis(this.now);
/*     */       try
/*     */       {
/* 499 */         timeRollOver();
/*     */       }
/*     */       catch (IOException ioe)
/*     */       {
/* 503 */         LogLog.error("rollOver() failed.", ioe);
/*     */       }
/*     */     }
/* 506 */     else if ((this.fileName != null) && (((CountingQuietWriter)this.qw).getCount() >= this.maxFileSize))
/*     */     {
/* 508 */       sizeRollOver();
/*     */     }
/* 510 */     super.subAppend(event);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\DateAndSizeRollingFileAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */