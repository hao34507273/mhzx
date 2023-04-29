/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends mzm.gsp.team.event.TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ConfirmManager.afterTeamChange(((TeamLeaderChangedArg)this.arg).oldLeader);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */