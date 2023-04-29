/*     */ package hub;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Xio;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GHubBroadcastManager
/*     */ {
/*  22 */   public static final Logger logger = Logger.getLogger("hub");
/*  23 */   private static final GHubBroadcastManager instance = new GHubBroadcastManager();
/*     */   
/*     */   public static final GHubBroadcastManager getInstance()
/*     */   {
/*  27 */     return instance;
/*     */   }
/*     */   
/*  30 */   private final AtomicInteger sequenceGenerator = new AtomicInteger();
/*  31 */   private final Map<Integer, BroadcastInterceptor> interceptors = new HashMap();
/*     */   
/*     */   private GHubBroadcastManager()
/*     */   {
/*  35 */     this.sequenceGenerator.set(new Random().nextInt());
/*     */     
/*  37 */     this.interceptors.put(Integer.valueOf(0), new BroadcastInterceptor());
/*  38 */     this.interceptors.put(Integer.valueOf(1), new BroadcastInterceptor());
/*  39 */     this.interceptors.put(Integer.valueOf(2), new BroadcastInterceptor());
/*  40 */     this.interceptors.put(Integer.valueOf(3), new BroadcastInterceptor());
/*  41 */     this.interceptors.put(Integer.valueOf(4), new BroadcastInterceptor());
/*  42 */     this.interceptors.put(Integer.valueOf(5), new BroadcastInterceptor());
/*  43 */     this.interceptors.put(Integer.valueOf(6), new BroadcastInterceptor());
/*  44 */     this.interceptors.put(Integer.valueOf(7), new BroadcastInterceptor());
/*  45 */     this.interceptors.put(Integer.valueOf(8), new BroadcastInterceptor());
/*     */   }
/*     */   
/*     */   public final void dispatch(DataBroadcast broadcast)
/*     */   {
/*  50 */     BroadcastInterceptor interceptor = (BroadcastInterceptor)this.interceptors.get(Integer.valueOf(broadcast.direction));
/*  51 */     if (interceptor == null)
/*     */     {
/*  53 */       logger.warn(String.format("[hub]GHubBroadcastManager.dispatch@interceptor is null|broadcast=%s", new Object[] { broadcast }));
/*     */       
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     if (interceptor.add(broadcast.src_id, broadcast.seq))
/*     */     {
/*  60 */       if (logger.isDebugEnabled())
/*     */       {
/*  62 */         logger.debug(String.format("[hub]GHubBroadcastManager.dispatch@need dispatch broadcast|broadcast=%s", new Object[] { broadcast }));
/*     */       }
/*     */       
/*  65 */       CrossServerInterface.onDataBroadcast(broadcast);
/*     */       
/*  67 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean broadcast(DataBroadcast broadcast)
/*     */   {
/*  73 */     if (!doBroadcast(broadcast, true))
/*     */     {
/*  75 */       new RetryBroadcastObserver(broadcast);
/*     */       
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     new RepeatBroadcastObserver(broadcast);
/*     */     
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   final boolean doBroadcast(DataBroadcast broadcast, boolean isSsetSequence)
/*     */   {
/*  87 */     Collection<Xio> xios = GHubClientManager.getInstance().getRouteXios();
/*  88 */     if (xios == null)
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (isSsetSequence)
/*     */     {
/*  95 */       broadcast.seq = this.sequenceGenerator.getAndIncrement();
/*     */     }
/*     */     
/*  98 */     boolean result = false;
/*  99 */     for (Xio to : xios)
/*     */     {
/* 101 */       if (broadcast.send(to))
/*     */       {
/* 103 */         result = true;
/*     */       }
/*     */     }
/*     */     
/* 107 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\GHubBroadcastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */