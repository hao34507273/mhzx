/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamCreate
/*    */   extends TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long leaderId = ((TeamCreateArg)this.arg).getLeader();
/* 18 */     MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(leaderId, false);
/* 19 */     if (matchData == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     return RoleQueueManager.cancelMatch(leaderId, CancelMatchType.CREATE_TEAM_CANCEL);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */