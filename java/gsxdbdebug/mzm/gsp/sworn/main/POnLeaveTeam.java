/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ 
/*    */ public class POnLeaveTeam extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     SwornManager.delSwornBuff(((LeaveTeamArg)this.arg).roleid);
/* 11 */     SwornManager.swornBuffForTeamChange(((LeaveTeamArg)this.arg).teamid);
/*    */     
/* 13 */     return SwornManager.swornBuilderTeamChange(((LeaveTeamArg)this.arg).teamid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */