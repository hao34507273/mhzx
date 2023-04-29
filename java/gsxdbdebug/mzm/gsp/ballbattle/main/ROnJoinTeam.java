/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class ROnJoinTeam extends JoinTeamRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     if (RoleStatusInterface.containsStatus(((JoinTeamArg)this.arg).getNewGuyRoleId(), 2161))
/*    */     {
/* 14 */       BallBattleActivityManager.addTask(new LogicRunnable()
/*    */       {
/*    */         public void process() throws Exception
/*    */         {
/* 18 */           BallBattleActivityManager.onJoinTeam((JoinTeamArg)ROnJoinTeam.this.arg);
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */