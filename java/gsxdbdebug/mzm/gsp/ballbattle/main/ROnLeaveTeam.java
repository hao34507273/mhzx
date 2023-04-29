/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class ROnLeaveTeam extends LeaveTeamRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     if (RoleStatusInterface.containsStatus(((LeaveTeamArg)this.arg).roleid, 2161))
/*    */     {
/* 14 */       BallBattleActivityManager.addTask(new LogicRunnable()
/*    */       {
/*    */         public void process()
/*    */           throws Exception
/*    */         {
/* 19 */           BallBattleActivityManager.onLeaveTeam((LeaveTeamArg)ROnLeaveTeam.this.arg);
/*    */         }
/*    */         
/*    */       });
/* 23 */     } else if (RoleStatusInterface.containsStatus(((LeaveTeamArg)this.arg).roleid, 2162))
/*    */     {
/* 25 */       BallBattleGameInstance.handlePlayerLeaveTeam(((LeaveTeamArg)this.arg).roleid);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */