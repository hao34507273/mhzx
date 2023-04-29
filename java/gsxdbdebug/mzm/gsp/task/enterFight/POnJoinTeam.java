/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.TaskConfBean;
/*    */ import xtable.Role2taskconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnJoinTeam
/*    */   extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long teamid = ((JoinTeamArg)this.arg).teamid;
/* 18 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamid, false);
/*    */     
/*    */ 
/* 21 */     TaskConfBean xTaskConfBean = Role2taskconf.get(Long.valueOf(leaderId));
/* 22 */     if (xTaskConfBean == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     JoinFightManager.cancelInvite(leaderId, xTaskConfBean);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */