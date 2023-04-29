/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoundRobinRoundSessionManager
/*    */ {
/* 14 */   private static RoundRobinRoundSessionManager instance = new RoundRobinRoundSessionManager();
/*    */   
/*    */   static RoundRobinRoundSessionManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private ReentrantLock lock = new ReentrantLock();
/* 22 */   private HashMap<Integer, Long> sessionids = new HashMap();
/*    */   
/*    */   void startPrepareSession(long interval, int activityCfgid, int roundIndex, boolean isMain)
/*    */   {
/* 26 */     this.lock.lock();
/*    */     try
/*    */     {
/* 29 */       Long sessionid = (Long)this.sessionids.remove(Integer.valueOf(activityCfgid));
/* 30 */       if (sessionid != null)
/*    */       {
/* 32 */         Session.removeSession(sessionid.longValue());
/*    */       }
/* 34 */       long newsessionid = new RoundRobinRoundPrepareSession(interval, activityCfgid, roundIndex, isMain).getSessionId();
/* 35 */       this.sessionids.put(Integer.valueOf(activityCfgid), Long.valueOf(newsessionid));
/* 36 */       CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinRoundSessionManager.startPrepareSession@start prepare session|interval=%d|activity_cfg_id=%d|round_index=%d|is_main=%b|sessionid=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Boolean.valueOf(isMain), Long.valueOf(newsessionid) }));
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/*    */ 
/* 42 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void startFightSession(long interval, int activityCfgid, int roundIndex, boolean isMain)
/*    */   {
/* 48 */     this.lock.lock();
/*    */     try
/*    */     {
/* 51 */       Long sessionid = (Long)this.sessionids.remove(Integer.valueOf(activityCfgid));
/* 52 */       if (sessionid != null)
/*    */       {
/* 54 */         Session.removeSession(sessionid.longValue());
/*    */       }
/* 56 */       long newsessionid = new RoundRobinRoundFightSession(interval, activityCfgid, roundIndex, isMain).getSessionId();
/* 57 */       this.sessionids.put(Integer.valueOf(activityCfgid), Long.valueOf(newsessionid));
/* 58 */       CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinRoundSessionManager.startFightSession@start fight session|interval=%d|activity_cfg_id=%d|round_index=%d|is_main=%b|sessionid=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Boolean.valueOf(isMain), Long.valueOf(newsessionid) }));
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/*    */ 
/* 64 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void stopSession(int activityCfgid)
/*    */   {
/* 70 */     this.lock.lock();
/*    */     try
/*    */     {
/* 73 */       Long sessionid = (Long)this.sessionids.remove(Integer.valueOf(activityCfgid));
/* 74 */       if (sessionid != null)
/*    */       {
/* 76 */         Session.removeSession(sessionid.longValue());
/* 77 */         CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinRoundSessionManager.startFightSession@stop session|activity_cfg_id=%d|sessionid=%d", new Object[] { Integer.valueOf(activityCfgid), sessionid }));
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 84 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinRoundSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */