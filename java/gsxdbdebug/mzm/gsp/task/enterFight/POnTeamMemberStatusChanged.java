/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.TaskConfBean;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long teamid = ((TeamMemberStatusChangedArg)this.arg).teamid;
/* 12 */     long roleId = ((TeamMemberStatusChangedArg)this.arg).roleid;
/* 13 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamid, false);
/*    */     
/*    */ 
/* 16 */     TaskConfBean xTaskConfBean = xtable.Role2taskconf.get(Long.valueOf(leaderId));
/* 17 */     if (xTaskConfBean == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     if (!xTaskConfBean.getAllroles().contains(Long.valueOf(roleId)))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     JoinFightManager.cancelInvite(leaderId, xTaskConfBean);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */