/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (!((TeamMemberStatusChangedArg)this.arg).leaderChange)
/*    */     {
/* 11 */       return false;
/*    */     }
/* 13 */     return POnTeamLeaderChanged.onLeaderChange(((TeamMemberStatusChangedArg)this.arg).getOldLeaderId(), ((TeamMemberStatusChangedArg)this.arg).teamid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */