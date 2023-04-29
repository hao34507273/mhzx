/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamDissolveRunnable;
/*    */ 
/*    */ public class ROnTeamDissolve extends TeamDissolveRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnTeamDissolve proc = new POnTeamDissolve();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */