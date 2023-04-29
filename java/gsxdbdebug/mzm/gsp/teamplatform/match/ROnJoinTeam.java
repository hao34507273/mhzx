/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.event.JoinTeamRunnable;
/*    */ 
/*    */ public class ROnJoinTeam extends JoinTeamRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnJoinTeam proc = new POnJoinTeam();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */