/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ 
/*    */ public class PPlayerRealLogout
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     Long teamId = TeamInterface.getTeamidByRoleid(((Long)this.arg).longValue(), true);
/* 16 */     if (teamId == null)
/*    */     {
/* 18 */       RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 558);
/* 19 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 23 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 24 */     if (teamInfo == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     new PUnSetCoupleDailyStatus(teamInfo.getTeamMemberList()).execute();
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PPlayerRealLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */