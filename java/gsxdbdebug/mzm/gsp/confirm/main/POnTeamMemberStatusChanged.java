/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ConfirmManager.afterTeamChange(((TeamMemberStatusChangedArg)this.arg).getOldLeaderId());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */