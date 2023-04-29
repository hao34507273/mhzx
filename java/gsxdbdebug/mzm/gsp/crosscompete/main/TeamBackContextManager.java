/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class TeamBackContextManager
/*    */ {
/* 12 */   private Map<Long, TeamBackContext> id2Context = new java.util.HashMap();
/* 13 */   private Map<Long, Long> roleid2Contextid = new java.util.HashMap();
/*    */   
/* 15 */   private final AtomicLong idGenerator = new AtomicLong(0L);
/*    */   
/* 17 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 19 */   private static final TeamBackContextManager instance = new TeamBackContextManager();
/*    */   
/*    */   public static TeamBackContextManager getInstance() {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public long addContext(TeamBackContext context)
/*    */   {
/* 28 */     long contextid = -1L;
/* 29 */     this.lock.writeLock().lock();
/*    */     try {
/* 31 */       List<Long> memberList = context.getRoleidList();
/* 32 */       Long leaderContextid = (Long)this.roleid2Contextid.get(memberList.get(0));
/* 33 */       if (leaderContextid != null) {
/* 34 */         return leaderContextid.longValue();
/*    */       }
/*    */       
/* 37 */       contextid = this.idGenerator.incrementAndGet();
/* 38 */       this.id2Context.put(Long.valueOf(contextid), context);
/*    */       
/* 40 */       for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 41 */         this.roleid2Contextid.put(Long.valueOf(roleid), Long.valueOf(contextid));
/*    */       }
/* 43 */       CrossCompeteManager.logInfo("TeamBackContextManager.addContext@create context|contextid=%d|roles=%s", new Object[] { Long.valueOf(contextid), memberList });
/*    */     }
/*    */     finally
/*    */     {
/* 47 */       this.lock.writeLock().unlock();
/*    */     }
/* 49 */     return contextid;
/*    */   }
/*    */   
/*    */   public TeamBackContext removeContext(long contextid)
/*    */   {
/* 54 */     TeamBackContext context = null;
/* 55 */     this.lock.writeLock().lock();
/*    */     try {
/* 57 */       context = (TeamBackContext)this.id2Context.remove(Long.valueOf(contextid));
/* 58 */       if (context == null) {
/* 59 */         return null;
/*    */       }
/* 61 */       for (Iterator i$ = context.getRoleidList().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 62 */         Long roleContextid = (Long)this.roleid2Contextid.get(Long.valueOf(roleid));
/* 63 */         if ((roleContextid != null) && (roleContextid.longValue() == contextid)) {
/* 64 */           this.roleid2Contextid.remove(Long.valueOf(roleid));
/*    */         }
/*    */       }
/*    */       
/* 68 */       CrossCompeteManager.logInfo("TeamBackContextManager.removeContext@remove succeed|contextid=%d|roles=%s", new Object[] { Long.valueOf(contextid), context.getRoleidList() });
/*    */     }
/*    */     finally
/*    */     {
/* 72 */       this.lock.writeLock().unlock();
/*    */     }
/* 74 */     return context;
/*    */   }
/*    */   
/*    */ 
/*    */   public TeamBackContext getContext(long contextid)
/*    */   {
/* 80 */     TeamBackContext context = null;
/* 81 */     this.lock.readLock().lock();
/*    */     try {
/* 83 */       context = (TeamBackContext)this.id2Context.get(Long.valueOf(contextid));
/*    */     } finally {
/* 85 */       this.lock.readLock().unlock();
/*    */     }
/* 87 */     return context;
/*    */   }
/*    */   
/*    */   long getContextidByRoleid(long roleid) {
/* 91 */     Long contextid = (Long)this.roleid2Contextid.get(Long.valueOf(roleid));
/* 92 */     if (contextid == null) {
/* 93 */       return -1L;
/*    */     }
/* 95 */     return contextid.longValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\TeamBackContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */