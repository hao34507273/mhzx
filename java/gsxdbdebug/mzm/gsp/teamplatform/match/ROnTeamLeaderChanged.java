/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamLeaderChangedRunnable;
/*    */ 
/*    */ public class ROnTeamLeaderChanged extends TeamLeaderChangedRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnTeamLeaderChanged proc = new POnTeamLeaderChanged();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */