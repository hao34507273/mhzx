/*     */ package mzm.gsp.server.main;
/*     */ 
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.server.SSyncServerLevel;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class ServerLevelObject
/*     */ {
/*  10 */   private static ServerLevelObject instance = new ServerLevelObject();
/*     */   
/*     */   public static ServerLevelObject getInstance()
/*     */   {
/*  14 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  22 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   public int level;
/*     */   public long startTime;
/*     */   public long upgradeTime;
/*     */   
/*     */   public int getLevel()
/*     */   {
/*     */     try
/*     */     {
/*  32 */       this.lock.readLock().lock();
/*  33 */       return this.level;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  38 */       String logStr = String.format("[serverlevel]ServerLevelObject.getLevel@get serverlevel error", new Object[0]);
/*     */       
/*  40 */       ServerManager.logger.error(logStr, e);
/*  41 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/*  45 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public long getStartTime()
/*     */   {
/*     */     try
/*     */     {
/*  53 */       this.lock.readLock().lock();
/*  54 */       return this.startTime;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  59 */       String logStr = String.format("[serverlevel]ServerLevelObject.getStartTime@get getStartTime error", new Object[0]);
/*     */       
/*  61 */       ServerManager.logger.error(logStr, e);
/*  62 */       return 0L;
/*     */     }
/*     */     finally
/*     */     {
/*  66 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public long getUpgradeTime()
/*     */   {
/*     */     try
/*     */     {
/*  74 */       this.lock.readLock().lock();
/*  75 */       return this.upgradeTime;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       String logStr = String.format("[serverlevel]ServerLevelObject.getUpgradeTime@get upgradeTime error", new Object[0]);
/*     */       
/*  82 */       ServerManager.logger.error(logStr, e);
/*  83 */       return 0L;
/*     */     }
/*     */     finally
/*     */     {
/*  87 */       this.lock.readLock().unlock();
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
/*     */   public void update(int level, long startTime, long upgradeTime)
/*     */   {
/*     */     try
/*     */     {
/* 103 */       this.lock.writeLock().lock();
/*     */       
/* 105 */       this.level = level;
/* 106 */       this.startTime = startTime;
/* 107 */       this.upgradeTime = upgradeTime;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 112 */       String logStr = String.format("[serverlevel]ServerLevelObject.update@update server level info error|level=%d|startTime=%d|upgradeTime=%d|oldLevel=%d", new Object[] { Integer.valueOf(level), Long.valueOf(startTime), Long.valueOf(upgradeTime), Integer.valueOf(this.level) });
/*     */       
/*     */ 
/*     */ 
/* 116 */       ServerManager.logger.error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 121 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillSSyncServerLevel(SSyncServerLevel s)
/*     */   {
/*     */     try
/*     */     {
/* 129 */       this.lock.readLock().lock();
/*     */       
/* 131 */       s.level = this.level;
/* 132 */       s.starttime = this.startTime;
/* 133 */       s.upgradetime = this.upgradeTime;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 138 */       String logStr = String.format("[serverlevel]ServerLevelObject.fillSSyncServerLevel@fill server level info error|level=%d|startTime=%d|upgradeTime=%d|oldLevel=%d", new Object[] { Integer.valueOf(this.level), Long.valueOf(this.startTime), Long.valueOf(this.upgradeTime), Integer.valueOf(this.level) });
/*     */       
/*     */ 
/*     */ 
/* 142 */       ServerManager.logger.error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 147 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\ServerLevelObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */