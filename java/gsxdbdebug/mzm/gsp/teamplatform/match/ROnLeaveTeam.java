/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.event.LeaveTeamRunnable;
/*    */ 
/*    */ public class ROnLeaveTeam extends LeaveTeamRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnLeaveTeam proc = new POnLeaveTeam();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */