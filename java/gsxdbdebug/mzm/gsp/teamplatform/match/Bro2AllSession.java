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
/*    */ public class Bro2AllSession
/*    */   extends Session
/*    */ {
/*    */   public Bro2AllSession(long interval, long roleId)
/*    */   {
/* 16 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     MatchNRTimeTaskManager.getInstance().addTask(new PBroTeamInfo(getOwerId()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   long getLeaderId()
/*    */   {
/* 32 */     return getOwerId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\Bro2AllSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */