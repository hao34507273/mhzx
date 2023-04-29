/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeaderTakeNewSession
/*    */   extends Session
/*    */ {
/*    */   public LeaderTakeNewSession(long interval, long roleId)
/*    */   {
/* 18 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     MatchNRTimeTaskManager.getInstance().addTask(new BeNormalMatch(getOwerId(), 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   long getLeaderId()
/*    */   {
/* 34 */     return getOwerId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\LeaderTakeNewSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */