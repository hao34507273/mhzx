/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ public abstract class Session extends BaseObserver
/*    */ {
/* 10 */   private static Map<Long, Session> sessions = Collections.synchronizedMap(new HashMap());
/*    */   
/* 12 */   private static AtomicLong nextSessionId = new AtomicLong(0L);
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
/*    */   public Session(long interval, long roleId)
/*    */   {
/* 26 */     super(interval);
/*    */     
/* 28 */     this.m_sessionId = nextSessionId.addAndGet(1L);
/* 29 */     this.m_ownerId = roleId;
/*    */     
/* 31 */     sessions.put(Long.valueOf(this.m_sessionId), this);
/*    */   }
/*    */   
/*    */   public static Session getSession(long sessionId)
/*    */   {
/* 36 */     return (Session)sessions.get(Long.valueOf(sessionId));
/*    */   }
/*    */   
/*    */   public static Session removeSession(long sessionId, long ownerId)
/*    */   {
/* 41 */     Session session = (Session)sessions.get(Long.valueOf(sessionId));
/* 42 */     if ((session != null) && (session.getOwerId() == ownerId))
/*    */     {
/* 44 */       sessions.remove(Long.valueOf(sessionId));
/* 45 */       session.stopTimer();
/* 46 */       return session;
/*    */     }
/*    */     
/* 49 */     return null;
/*    */   }
/*    */   
/*    */   public static Session removeSession(long sessionId)
/*    */   {
/* 54 */     Session session = (Session)sessions.get(Long.valueOf(sessionId));
/* 55 */     if (session != null)
/*    */     {
/* 57 */       sessions.remove(Long.valueOf(sessionId));
/* 58 */       session.stopTimer();
/* 59 */       return session;
/*    */     }
/*    */     
/* 62 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 68 */     onTimeOut();
/* 69 */     sessions.remove(Long.valueOf(this.m_sessionId));
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   protected abstract void onTimeOut();
/*    */   
/*    */   public long getSessionId()
/*    */   {
/* 77 */     return this.m_sessionId;
/*    */   }
/*    */   
/*    */   public long getOwerId()
/*    */   {
/* 82 */     return this.m_ownerId;
/*    */   }
/*    */   
/*    */ 
/*    */   public final void stopTimer()
/*    */   {
/* 88 */     sessions.remove(Long.valueOf(this.m_sessionId));
/*    */     
/* 90 */     super.stopTimer();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */