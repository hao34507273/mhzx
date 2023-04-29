/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class ROnTeamDissolve extends TeamDissolveRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     if (RoleStatusInterface.containsStatus(((TeamDissolveArg)this.arg).getLeader(), 2161))
/*    */     {
/* 14 */       BallBattleActivityManager.addTask(new LogicRunnable()
/*    */       {
/*    */         public void process()
/*    */           throws Exception
/*    */         {
/* 19 */           BallBattleActivityManager.onTeamDisposed((TeamDissolveArg)ROnTeamDissolve.this.arg);
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */