/*     */ package hub;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
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
/*     */ class BroadcastInterceptor
/*     */ {
/* 208 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/* 209 */   private final HashMap<Integer, BroadcastSeqInterceptor> seqInterceptors = new HashMap();
/*     */   
/*     */   public final boolean add(int nodeid, int seq)
/*     */   {
/* 213 */     BroadcastSeqInterceptor seqInterceptor = getBroadcastSeqInterceptor(nodeid);
/* 214 */     return seqInterceptor.add(seq);
/*     */   }
/*     */   
/*     */   private final BroadcastSeqInterceptor getBroadcastSeqInterceptor(int nodeid)
/*     */   {
/* 219 */     BroadcastSeqInterceptor seqInterceptor = null;
/* 220 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 223 */       seqInterceptor = (BroadcastSeqInterceptor)this.seqInterceptors.get(Integer.valueOf(nodeid));
/*     */     }
/*     */     finally
/*     */     {
/* 227 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */     
/* 230 */     if (seqInterceptor != null)
/*     */     {
/* 232 */       return seqInterceptor;
/*     */     }
/*     */     
/* 235 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 238 */       seqInterceptor = (BroadcastSeqInterceptor)this.seqInterceptors.get(Integer.valueOf(nodeid));
/* 239 */       if (seqInterceptor == null)
/*     */       {
/* 241 */         seqInterceptor = new BroadcastSeqInterceptor();
/* 242 */         this.seqInterceptors.put(Integer.valueOf(nodeid), seqInterceptor);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 247 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */     
/* 250 */     return seqInterceptor;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\BroadcastInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */