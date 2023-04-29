/*     */ package log;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.w3c.dom.Document;
/*     */ import xio.Engine;
/*     */ import xio.Manager;
/*     */ import xio.Xio;
/*     */ 
/*     */ public class Logger extends Manager
/*     */ {
/*     */   private static final String HOST_NAME = "localhost";
/*     */   private static final String SERVER_NAME = "gs";
/*  22 */   private Xio logio = null;
/*  23 */   private ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*  25 */   private static volatile Logger instance = null;
/*     */   
/*     */   public Logger()
/*     */   {
/*  29 */     instance = this;
/*     */   }
/*     */   
/*     */   public static Logger getInstance()
/*     */   {
/*  34 */     return instance;
/*     */   }
/*     */   
/*     */   public static void loadConf(String conf) throws Exception
/*     */   {
/*  39 */     Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(conf);
/*  40 */     Engine.getInstance().register(new xio.XioConf(doc.getDocumentElement()));
/*     */   }
/*     */   
/*     */ 
/*     */   protected void addXio(Xio xio)
/*     */   {
/*  46 */     this.lock.writeLock().lock();
/*     */     try {
/*  48 */       this.logio = xio;
/*  49 */       GameServer.logger().warn("[logger] connected to log server, " + xio);
/*     */     } finally {
/*  51 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Xio get()
/*     */   {
/*  59 */     this.lock.readLock().lock();
/*     */     try {
/*  61 */       return this.logio;
/*     */     } finally {
/*  63 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void removeXio(Xio xio, Throwable e)
/*     */   {
/*  70 */     this.lock.writeLock().lock();
/*     */     try {
/*  72 */       this.logio = null;
/*  73 */       GameServer.logger().warn("[logger] disconnected from log server, " + xio, e);
/*     */     } finally {
/*  75 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int size()
/*     */   {
/*  82 */     int size = 0;
/*     */     
/*  84 */     this.lock.readLock().lock();
/*     */     try {
/*  86 */       if (this.logio != null) {
/*  87 */         size = 1;
/*     */       }
/*     */     } finally {
/*  90 */       this.lock.readLock().unlock();
/*     */     }
/*     */     
/*  93 */     return size;
/*     */   }
/*     */   
/*     */   void _addLog(int priority, String logStr)
/*     */   {
/*  98 */     this.lock.readLock().lock();
/*     */     try {
/* 100 */       if (this.logio != null) {
/* 101 */         long logid = CommonUtils.getLong(Math.abs((int)DateTimeUtils.getCurrTimeInMillis()), xdb.Xdb.random().nextInt());
/* 102 */         StringBuilder sb = new StringBuilder();
/* 103 */         sb.append(205).append("|").append(GameServerInfoManager.getZoneId()).append("|");
/* 104 */         sb.append(logid).append("|").append(logStr);
/*     */         
/* 106 */         RemoteLog p = new RemoteLog();
/* 107 */         p.priority = priority;
/* 108 */         p.msg.replace(sb.toString().getBytes("UTF-8"));
/* 109 */         p.hostname.replace("localhost".getBytes("UTF-8"));
/* 110 */         p.servicename.replace("gs".getBytes("UTF-8"));
/* 111 */         p.send(this.logio);
/*     */       }
/*     */       else {
/* 114 */         GameServer.logger().warn("logservice没有连接，没有记录的log：" + logStr);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 118 */       GameServer.logger().error("向manager发送日志失败，没有记录的log：" + logStr, e);
/*     */     } finally {
/* 120 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void addLog(int priority, String logStr)
/*     */   {
/* 128 */     Logger l = instance;
/*     */     
/* 130 */     if (l == null) {
/* 131 */       GameServer.logger().warn("logservice没有连接，没有记录的log：" + logStr);
/*     */     }
/*     */     else {
/* 134 */       l._addLog(priority, logStr);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\log\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */