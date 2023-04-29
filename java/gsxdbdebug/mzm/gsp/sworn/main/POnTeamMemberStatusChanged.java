/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     SwornManager.swornBuffForTeamChange(((TeamMemberStatusChangedArg)this.arg).teamid);
/* 11 */     if ((((TeamMemberStatusChangedArg)this.arg).isOffline()) || (((TeamMemberStatusChangedArg)this.arg).isTempLeave())) {
/* 12 */       return SwornManager.swornBuilderTeamChange(((TeamMemberStatusChangedArg)this.arg).teamid);
/*    */     }
/* 14 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */