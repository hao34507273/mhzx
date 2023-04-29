/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class ROnTeamCreate extends TeamCreateRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     if (RoleStatusInterface.containsStatus(((TeamCreateArg)this.arg).getLeader(), 2161))
/*    */     {
/* 14 */       BallBattleActivityManager.addTask(new LogicRunnable()
/*    */       {
/*    */         public void process()
/*    */           throws Exception
/*    */         {
/* 19 */           BallBattleActivityManager.onTeamCreated((TeamCreateArg)ROnTeamCreate.this.arg);
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */