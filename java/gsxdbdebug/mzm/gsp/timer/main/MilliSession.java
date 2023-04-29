/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MilliSession
/*    */   extends BaseMilliObserver
/*    */ {
/* 17 */   private static Map<Long, MilliSession> sessions = Collections.synchronizedMap(new HashMap());
/*    */   
/* 19 */   private static AtomicLong nextSessionId = new AtomicLong(0L);
/*    */   
/*    */ 
/*    */ 
/*    */   private final long m_sessionId;
/*    */   
/*    */ 
/*    */ 
/*    */   private final long m_ownerId;
/*    */   
/*    */ 
/*    */ 
/*    */   public MilliSession(long intervalMilliSeconds, long roleId)
/*    */   {
/* 33 */     super(intervalMilliSeconds);
/*    */     
/* 35 */     this.m_sessionId = nextSessionId.addAndGet(1L);
/* 36 */     this.m_ownerId = roleId;
/*    */     
/* 38 */     sessions.put(Long.valueOf(this.m_sessionId), this);
/*    */   }
/*    */   
/*    */   public static MilliSession getSession(long sessionId)
/*    */   {
/* 43 */     return (MilliSession)sessions.get(Long.valueOf(sessionId));
/*    */   }
/*    */   
/*    */   public static MilliSession removeSession(long sessionId, long ownerId)
/*    */   {
/* 48 */     MilliSession session = (MilliSession)sessions.get(Long.valueOf(sessionId));
/* 49 */     if ((session != null) && (session.getOwerId() == ownerId))
/*    */     {
/* 51 */       sessions.remove(Long.valueOf(sessionId));
/* 52 */       session.stopTimer();
/* 53 */       return session;
/*    */     }
/*    */     
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   public static MilliSession removeSession(long sessionId)
/*    */   {
/* 61 */     MilliSession session = (MilliSession)sessions.get(Long.valueOf(sessionId));
/* 62 */     if (session != null)
/*    */     {
/* 64 */       sessions.remove(Long.valueOf(sessionId));
/* 65 */       session.stopTimer();
/* 66 */       return session;
/*    */     }
/*    */     
/* 69 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 75 */     onTimeOut();
/* 76 */     sessions.remove(Long.valueOf(this.m_sessionId));
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   protected abstract void onTimeOut();
/*    */   
/*    */   public long getSessionId()
/*    */   {
/* 84 */     return this.m_sessionId;
/*    */   }
/*    */   
/*    */   public long getOwerId()
/*    */   {
/* 89 */     return this.m_ownerId;
/*    */   }
/*    */   
/*    */ 
/*    */   public final void stopTimer()
/*    */   {
/* 95 */     sessions.remove(Long.valueOf(this.m_sessionId));
/*    */     
/* 97 */     super.stopTimer();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\MilliSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */