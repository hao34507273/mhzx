/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MatchQueue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RepeatTeamSession
/*    */   extends Session
/*    */ {
/*    */   private long teamId;
/*    */   
/*    */   public RepeatTeamSession(long interval, long teamId)
/*    */   {
/* 19 */     super(interval, teamId);
/* 20 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     MatchNRTimeTaskManager.getInstance().addTask(new RepeatTeam());
/*    */   }
/*    */   
/*    */   class RepeatTeam
/*    */     extends LogicProcedure
/*    */   {
/*    */     RepeatTeam() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 36 */       MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(true);
/* 37 */       matchQueue.getRepeatteamids().remove(Long.valueOf(RepeatTeamSession.this.teamId));
/* 38 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RepeatTeamSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */