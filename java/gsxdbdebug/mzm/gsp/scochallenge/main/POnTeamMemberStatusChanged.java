/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged
/*    */   extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if ((((TeamMemberStatusChangedArg)this.arg).isLeaderChanged()) && (TaskInterface.isHaveGraphId(((TeamMemberStatusChangedArg)this.arg).getNowLeaderId(), SSchoolChallengeCfgConsts.getInstance().GRAPH_ID)))
/*    */     {
/* 15 */       return ScoChallengeManager.moveScoChallenage(((TeamMemberStatusChangedArg)this.arg).getOldLeaderId(), ((TeamMemberStatusChangedArg)this.arg).getNowLeaderId());
/*    */     }
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */