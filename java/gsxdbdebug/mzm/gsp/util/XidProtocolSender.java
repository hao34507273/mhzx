/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xio.Creator;
/*     */ import xio.IOError;
/*     */ import xio.Manager;
/*     */ import xio.Protocol;
/*     */ import xio.Xio;
/*     */ 
/*     */ public class XidProtocolSender implements Closeable
/*     */ {
/*  18 */   private static final Logger logger = Logger.getLogger("root");
/*     */   private static final int DEFAULT_TIMEOUT = 20000;
/*     */   private final XidProtocolReq req;
/*     */   private final int timeout;
/*     */   
/*     */   public static void onXidProtocolResponse(XidProtocolRsp rsp) {
/*  24 */     if (rsp == null)
/*     */     {
/*  26 */       return;
/*     */     }
/*     */     
/*  29 */     Manager manager = rsp.getProtocol().getConnection().getCreator().getManager();
/*  30 */     XidProtocolSender sender = (XidProtocolSender)manager.removeContext(rsp.getXid());
/*  31 */     if (null == sender)
/*     */     {
/*  33 */       logger.warn(String.format("XidProtocolSender.onResponse context lost|prototocl=%s", new Object[] { rsp.getProtocol() }));
/*  34 */       return;
/*     */     }
/*     */     
/*  37 */     sender.onResponse(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */   private final boolean repeatSendOnTimeout;
/*     */   
/*     */   private final int maxRepeatSendCount;
/*     */   
/*     */   private int repeatSendCount;
/*     */   
/*     */   protected Future<?> future;
/*     */   
/*     */   public XidProtocolSender(XidProtocolReq req)
/*     */   {
/*  51 */     this(req, false, 0, 20000);
/*     */   }
/*     */   
/*     */   public XidProtocolSender(XidProtocolReq req, boolean repeatSendOnTimeout)
/*     */   {
/*  56 */     this(req, repeatSendOnTimeout, 0, 20000);
/*     */   }
/*     */   
/*     */   public XidProtocolSender(XidProtocolReq req, boolean repeatSendOnTimeout, int repeatSendCount)
/*     */   {
/*  61 */     this(req, repeatSendOnTimeout, repeatSendCount, 20000);
/*     */   }
/*     */   
/*     */ 
/*     */   public XidProtocolSender(XidProtocolReq req, boolean repeatSendOnTimeout, int maxRepeatSendCount, int timeout)
/*     */   {
/*  67 */     this.req = req;
/*  68 */     this.repeatSendOnTimeout = repeatSendOnTimeout;
/*  69 */     this.maxRepeatSendCount = maxRepeatSendCount;
/*  70 */     this.timeout = timeout;
/*  71 */     this.repeatSendCount = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getTimeout()
/*     */   {
/*  80 */     return this.timeout;
/*     */   }
/*     */   
/*     */   public final void close()
/*     */     throws IOException
/*     */   {
/*  86 */     if (null != this.future)
/*     */     {
/*  88 */       if ((this.future instanceof FutureX))
/*     */       {
/*     */ 
/*  91 */         FutureX<XidProtocol> futureX = (FutureX)this.future;
/*  92 */         futureX.setException(new IOError("AsynchronousClose"));
/*     */         
/*  94 */         this.future = null;
/*     */         
/*  96 */         return;
/*     */       }
/*     */       
/*  99 */       if ((this.future instanceof ScheduledFuture))
/*     */       {
/* 101 */         ScheduledFuture<?> scheduledFuture = (ScheduledFuture)this.future;
/* 102 */         boolean cancelResult = scheduledFuture.cancel(false);
/*     */         
/* 104 */         this.future = null;
/*     */         
/* 106 */         if (!cancelResult)
/*     */         {
/* 108 */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 114 */     onTimeout(-1);
/*     */   }
/*     */   
/*     */   public final boolean send(Xio to)
/*     */   {
/* 119 */     if (null == to)
/*     */     {
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     Manager manager = to.getCreator().getManager();
/* 125 */     int xid = manager.addContext(this);
/* 126 */     this.req.setXid(xid);
/* 127 */     if (this.req.getProtocol().send(to))
/*     */     {
/* 129 */       if (null == this.future)
/*     */       {
/* 131 */         this.future = Executor.getInstance().schedule(new Timeout(manager, xid), getTimeout(), TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/* 134 */       return true;
/*     */     }
/*     */     
/* 137 */     manager.removeContext(xid);
/*     */     
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public final FutureX<XidProtocol> submit(Xio to)
/*     */   {
/* 144 */     if (null != to)
/*     */     {
/* 146 */       Manager manager = to.getCreator().getManager();
/* 147 */       int xid = manager.addContext(this);
/* 148 */       this.req.setXid(xid);
/*     */       
/* 150 */       FutureX<XidProtocol> futureX = new FutureX(getTimeout());
/* 151 */       if (send(to))
/*     */       {
/* 153 */         this.future = futureX;
/*     */         
/* 155 */         return futureX;
/*     */       }
/*     */       
/* 158 */       manager.removeContext(xid);
/*     */       
/* 160 */       this.future = null;
/*     */     }
/*     */     
/* 163 */     throw new IOError(toString() + to);
/*     */   }
/*     */   
/*     */   public final FutureX<XidProtocol> submit(Manager manager)
/*     */   {
/* 168 */     return submit(manager.get());
/*     */   }
/*     */   
/*     */   protected final void onResponse(XidProtocolRsp rsp)
/*     */   {
/* 173 */     if (null != this.future)
/*     */     {
/* 175 */       if ((this.future instanceof FutureX))
/*     */       {
/*     */ 
/* 178 */         FutureX<XidProtocol> futureX = (FutureX)this.future;
/* 179 */         futureX.set(rsp);
/*     */         
/* 181 */         this.future = null;
/*     */         
/* 183 */         return;
/*     */       }
/*     */       
/* 186 */       if ((this.future instanceof ScheduledFuture))
/*     */       {
/* 188 */         ScheduledFuture<?> scheduledFuture = (ScheduledFuture)this.future;
/* 189 */         boolean cancelResult = scheduledFuture.cancel(false);
/*     */         
/* 191 */         this.future = null;
/*     */         
/* 193 */         if (!cancelResult)
/*     */         {
/* 195 */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 200 */     this.req.onResponse(rsp);
/*     */   }
/*     */   
/*     */   protected final void onTimeout(Xio xio, int code)
/*     */   {
/* 205 */     if (this.maxRepeatSendCount > 0)
/*     */     {
/* 207 */       if (this.repeatSendCount++ >= this.maxRepeatSendCount)
/*     */       {
/* 209 */         onTimeout(code);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 216 */       onTimeout(code);
/*     */     }
/*     */     
/* 219 */     if (this.repeatSendOnTimeout)
/*     */     {
/* 221 */       send(xio);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void onTimeout(int code)
/*     */   {
/* 227 */     this.req.onTimeout(code);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\XidProtocolSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */