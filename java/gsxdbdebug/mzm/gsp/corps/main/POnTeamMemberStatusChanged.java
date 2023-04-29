/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamMemberStatusChanged
/*    */   extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     CorpsManager.afterTeamChange(((TeamMemberStatusChangedArg)this.arg).getOldLeaderId());
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */