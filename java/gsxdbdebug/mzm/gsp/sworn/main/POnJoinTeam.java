/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ 
/*    */ public class POnJoinTeam extends mzm.gsp.team.event.JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     SwornManager.swornBuffForTeamChange(((JoinTeamArg)this.arg).teamid);
/* 10 */     return SwornManager.swornBuilderTeamChange(((JoinTeamArg)this.arg).teamid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */