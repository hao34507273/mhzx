/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.TaskConfBean;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long teamid = ((TeamDissolveArg)this.arg).teamid;
/* 12 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamid, false);
/*    */     
/*    */ 
/* 15 */     TaskConfBean xTaskConfBean = xtable.Role2taskconf.get(Long.valueOf(leaderId));
/* 16 */     if (xTaskConfBean == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     JoinFightManager.cancelInvite(leaderId, xTaskConfBean);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */