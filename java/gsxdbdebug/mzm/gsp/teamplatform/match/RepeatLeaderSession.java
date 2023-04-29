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
/*    */ public class RepeatLeaderSession
/*    */   extends Session
/*    */ {
/*    */   private long leaderId;
/*    */   
/*    */   public RepeatLeaderSession(long interval, long leaderId)
/*    */   {
/* 19 */     super(interval, leaderId);
/* 20 */     this.leaderId = leaderId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     MatchNRTimeTaskManager.getInstance().addTask(new RepeatLeader());
/*    */   }
/*    */   
/*    */   class RepeatLeader
/*    */     extends LogicProcedure
/*    */   {
/*    */     RepeatLeader() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 36 */       MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(true);
/* 37 */       matchQueue.getRepeatleaderids().remove(Long.valueOf(RepeatLeaderSession.this.leaderId));
/* 38 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RepeatLeaderSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */