/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoamEnterContextManager
/*    */ {
/* 20 */   private Map<Long, RoamEnterContext> id2Context = new HashMap();
/* 21 */   private Map<Long, Long> roleid2Contextid = new HashMap();
/*    */   
/* 23 */   private final AtomicLong idGenerator = new AtomicLong(0L);
/*    */   
/* 25 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 27 */   private static final RoamEnterContextManager instance = new RoamEnterContextManager();
/*    */   
/*    */   public static RoamEnterContextManager getInstance() {
/* 30 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public long addContext(RoamEnterContext context)
/*    */   {
/* 36 */     long contextid = -1L;
/* 37 */     this.lock.writeLock().lock();
/*    */     try {
/* 39 */       contextid = this.idGenerator.incrementAndGet();
/* 40 */       this.id2Context.put(Long.valueOf(contextid), context);
/*    */     }
/*    */     finally
/*    */     {
/* 44 */       this.lock.writeLock().unlock();
/*    */     }
/* 46 */     return contextid;
/*    */   }
/*    */   
/*    */   public boolean removeContext(long contextid)
/*    */   {
/* 51 */     this.lock.writeLock().lock();
/*    */     try {
/* 53 */       RoamEnterContext context = (RoamEnterContext)this.id2Context.remove(Long.valueOf(contextid));
/* 54 */       if (context == null) {
/* 55 */         return false;
/*    */       }
/* 57 */       for (Iterator i$ = context.getRoleidList().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 58 */         this.roleid2Contextid.remove(Long.valueOf(roleid));
/*    */       }
/* 60 */       if (context.getSessionid() > 0L) {
/* 61 */         Session.removeSession(context.getSessionid());
/*    */       }
/*    */     } finally {
/* 64 */       this.lock.writeLock().unlock();
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public RoamEnterContext getContext(long contextid)
/*    */   {
/* 72 */     RoamEnterContext context = null;
/* 73 */     this.lock.readLock().lock();
/*    */     try {
/* 75 */       context = (RoamEnterContext)this.id2Context.get(Long.valueOf(contextid));
/*    */     } finally {
/* 77 */       this.lock.readLock().unlock();
/*    */     }
/* 79 */     return context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RoamEnterContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */