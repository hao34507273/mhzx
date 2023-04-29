/*     */ package hub;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xio.Xio;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeepAliveManager
/*     */   implements Runnable
/*     */ {
/*     */   private static final int DEFAULT_ALIVE_MINUTE = 5;
/*     */   private static final long TTL_CHECK_INTERVAL = 1000L;
/*  24 */   private static final Logger logger = Logger.getLogger("hub");
/*     */   
/*  26 */   private static final KeepAliveManager instance = new KeepAliveManager();
/*     */   
/*     */   public static KeepAliveManager getInstance()
/*     */   {
/*  30 */     return instance;
/*     */   }
/*     */   
/*  33 */   private final ReentrantLock locker = new ReentrantLock();
/*  34 */   private final Map<Xio, TTL> xio2ttl = new HashMap();
/*     */   private final long aliveTime;
/*     */   
/*     */   private KeepAliveManager()
/*     */   {
/*  39 */     int aliveMinute = 5;
/*  40 */     String strAliveTime = System.getProperty("com.zulong.mhzx.alivetime");
/*  41 */     if ((strAliveTime != null) && (!strAliveTime.isEmpty()))
/*     */     {
/*  43 */       aliveMinute = Integer.parseInt(strAliveTime);
/*     */     }
/*  45 */     this.aliveTime = (60000L * aliveMinute);
/*     */   }
/*     */   
/*     */   public void init()
/*     */   {
/*  50 */     new KeepAliveObserver();
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*     */     try
/*     */     {
/*  57 */       this.locker.lock();
/*     */       
/*  59 */       List<Xio> timeoutXios = null;
/*  60 */       Iterator<Map.Entry<Xio, TTL>> itr = this.xio2ttl.entrySet().iterator();
/*  61 */       while (itr.hasNext())
/*     */       {
/*  63 */         Map.Entry<Xio, TTL> entry = (Map.Entry)itr.next();
/*  64 */         TTL ttl = (TTL)entry.getValue();
/*  65 */         if (!ttl.isAlive())
/*     */         {
/*  67 */           if (timeoutXios == null)
/*     */           {
/*  69 */             timeoutXios = new LinkedList();
/*     */           }
/*  71 */           timeoutXios.add(entry.getKey());
/*     */         }
/*     */       }
/*     */       
/*  75 */       if (timeoutXios != null)
/*     */       {
/*  77 */         for (Xio xio : timeoutXios)
/*     */         {
/*  79 */           xio.close();
/*  80 */           this.xio2ttl.remove(xio);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  86 */       this.locker.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onKeepAlive(Xio xio)
/*     */   {
/*     */     try
/*     */     {
/*  94 */       this.locker.lock();
/*     */       
/*  96 */       TTL ttl = (TTL)this.xio2ttl.get(xio);
/*  97 */       if (ttl == null)
/*     */       {
/*  99 */         GameServer.logger().warn(String.format("KeepAliveManager.onKeepAlive@xio ttl info is null|xio_info=%s", new Object[] { xio }));
/*     */       }
/*     */       else
/*     */       {
/* 103 */         ttl.reset(this.aliveTime);
/*     */       }
/*     */     }
/*     */     finally {
/* 107 */       this.locker.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addXio(Xio xio)
/*     */   {
/* 113 */     if (xio == null)
/*     */     {
/* 115 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 120 */       this.locker.lock();
/*     */       
/* 122 */       this.xio2ttl.put(xio, new TTL(this.aliveTime));
/*     */       
/* 124 */       logger.info(String.format("KeepAliveManager.addXio@add xio success|xio_info=%s", new Object[] { xio }));
/*     */     }
/*     */     finally
/*     */     {
/* 128 */       this.locker.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeXio(Xio xio)
/*     */   {
/* 134 */     if (xio == null)
/*     */     {
/* 136 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 141 */       this.locker.lock();
/*     */       
/* 143 */       if (this.xio2ttl.remove(xio) != null)
/*     */       {
/* 145 */         logger.info(String.format("KeepAliveManager.removeXio@remove xio success|xio_info=%s", new Object[] { xio }));
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 150 */       this.locker.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TTL
/*     */   {
/*     */     private long ttl;
/*     */     
/*     */     public TTL(long ttl)
/*     */     {
/* 160 */       this.ttl = ttl;
/*     */     }
/*     */     
/*     */     public void reset(long ttl)
/*     */     {
/* 165 */       this.ttl = ttl;
/*     */     }
/*     */     
/*     */     public boolean isAlive()
/*     */     {
/* 170 */       this.ttl -= 1000L;
/*     */       
/* 172 */       return this.ttl > 0L;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class KeepAliveObserver extends MilliObserver
/*     */   {
/*     */     public KeepAliveObserver()
/*     */     {
/* 180 */       super();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 186 */       Executor.getInstance().execute(KeepAliveManager.instance);
/*     */       
/* 188 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\KeepAliveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */