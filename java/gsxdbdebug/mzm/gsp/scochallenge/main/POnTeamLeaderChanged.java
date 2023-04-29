/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (TaskInterface.isHaveGraphId(((TeamLeaderChangedArg)this.arg).newLeader, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID))
/*    */     {
/* 14 */       return ScoChallengeManager.moveScoChallenage(((TeamLeaderChangedArg)this.arg).oldLeader, ((TeamLeaderChangedArg)this.arg).newLeader);
/*    */     }
/* 16 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */