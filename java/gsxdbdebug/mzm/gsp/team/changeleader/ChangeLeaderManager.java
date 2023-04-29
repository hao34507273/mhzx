/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.confbean.TeamConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.LeaderChangeBean;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2leaderchange;
/*    */ 
/*    */ 
/*    */ public class ChangeLeaderManager
/*    */ {
/*    */   static int getChangeLeaderInterval()
/*    */   {
/* 14 */     int second = TeamConsts.getInstance().CHANGE_LEADER_TIME_INTERVAL;
/* 15 */     return second * 60;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static long startChangeLeaderSession(long roleId)
/*    */   {
/* 24 */     Session session = new NeedChangeLeaderSession(getChangeLeaderInterval(), roleId);
/* 25 */     return session.getSessionId();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean startChangeLeaderSession(long leaderId, LeaderChangeBean xLeaderChangeBean)
/*    */   {
/* 36 */     if (xLeaderChangeBean == null) {
/* 37 */       xLeaderChangeBean = Pod.newLeaderChangeBean();
/* 38 */       Role2leaderchange.insert(Long.valueOf(leaderId), xLeaderChangeBean);
/*    */     }
/* 40 */     else if (xLeaderChangeBean.getSessionid() > 0L) {
/* 41 */       Session.removeSession(xLeaderChangeBean.getSessionid());
/*    */     }
/*    */     
/* 44 */     long sessionId = startChangeLeaderSession(leaderId);
/* 45 */     if (sessionId <= 0L) {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     xLeaderChangeBean.setSessionid(sessionId);
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\ChangeLeaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */