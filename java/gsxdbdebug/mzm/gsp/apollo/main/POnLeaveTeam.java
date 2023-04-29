/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long roleid = ((LeaveTeamArg)this.arg).roleid;
/* 16 */     long teamid = ((LeaveTeamArg)this.arg).teamid;
/* 17 */     if (!VoipRoomManager.isRoleInThisVoipRoom(roleid, 1, teamid))
/*    */     {
/*    */ 
/* 20 */       StringBuilder sb = new StringBuilder();
/* 21 */       sb.append(String.format("[teamvoiproom]POnLeaveTeam.processImp@role not in this team voip room|roleid=%d|teamid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid) }));
/*    */       
/* 23 */       TeamVoipRoomManager.logger.info(sb.toString());
/* 24 */       return false;
/*    */     }
/* 26 */     TeamVoipRoomOnebyOneManager.getInstance().addLogicProcedure(Long.valueOf(teamid), new PTryExitTeamVoipRoom(roleid, teamid));
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */