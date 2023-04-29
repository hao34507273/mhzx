/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ 
/*    */ public class POnJoinTeam extends mzm.gsp.team.event.JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ConfirmManager.afterTeamChange(((JoinTeamArg)this.arg).leaderid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */