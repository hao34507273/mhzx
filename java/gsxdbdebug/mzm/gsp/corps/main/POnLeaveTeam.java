/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     CorpsManager.afterTeamChange(((LeaveTeamArg)this.arg).getOldLeaderId());
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */