/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if ((((LeaveTeamArg)this.arg).isLeaderChanged()) && (TaskInterface.isHaveGraphId(((LeaveTeamArg)this.arg).getNowLeaderId(), SSchoolChallengeCfgConsts.getInstance().GRAPH_ID)))
/*    */     {
/* 15 */       return ScoChallengeManager.moveScoChallenage(((LeaveTeamArg)this.arg).getOldLeaderId(), ((LeaveTeamArg)this.arg).getNowLeaderId());
/*    */     }
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */