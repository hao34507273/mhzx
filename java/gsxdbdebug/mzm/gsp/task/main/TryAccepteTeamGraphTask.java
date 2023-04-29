/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TryAccepteTeamGraphTask
/*    */   extends Session
/*    */ {
/*    */   private final long teamId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   private final int tryCount;
/*    */   
/*    */   public TryAccepteTeamGraphTask(long teamId, int graphId, int taskId, int tryCount)
/*    */   {
/* 24 */     super(1L, teamId);
/* 25 */     this.teamId = teamId;
/* 26 */     this.graphId = graphId;
/* 27 */     this.taskId = taskId;
/* 28 */     this.tryCount = tryCount;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 34 */     new TryAccepteAgain().execute();
/*    */   }
/*    */   
/*    */   class TryAccepteAgain extends LogicProcedure
/*    */   {
/*    */     TryAccepteAgain() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 43 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(TryAccepteTeamGraphTask.this.teamId, false);
/* 44 */       if (teamInfo == null)
/*    */       {
/* 46 */         return false;
/*    */       }
/* 48 */       new AccpetTaskProcedure(teamInfo.getLeaderId(), TryAccepteTeamGraphTask.this.graphId, TryAccepteTeamGraphTask.this.taskId, TryAccepteTeamGraphTask.this.tryCount + 1).execute();
/* 49 */       GameServer.logger().info(String.format("[task]TryAccepteAgain.processImp@ try accept again!| teamId=%d|leaderId=%d|graphId=%d|taskId=%d|tryCount=%d", new Object[] { Long.valueOf(TryAccepteTeamGraphTask.this.teamId), Long.valueOf(teamInfo.getLeaderId()), Integer.valueOf(TryAccepteTeamGraphTask.this.graphId), Integer.valueOf(TryAccepteTeamGraphTask.this.taskId), Integer.valueOf(TryAccepteTeamGraphTask.this.tryCount + 1) }));
/*    */       
/*    */ 
/*    */ 
/* 53 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TryAccepteTeamGraphTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */