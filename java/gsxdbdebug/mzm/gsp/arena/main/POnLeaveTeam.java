/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     return new PCheckLeave(((LeaveTeamArg)this.arg).roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */