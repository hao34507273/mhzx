/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HulaTeamHandler
/*    */   implements JoinTeamCheckHandler
/*    */ {
/*    */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*    */   {
/* 17 */     if (roleWorldId == leaderWorldId)
/*    */     {
/* 19 */       JoinTeamResult result = new JoinTeamResult();
/* 20 */       result.setSucceed(true);
/* 21 */       return result;
/*    */     }
/*    */     
/*    */ 
/* 25 */     JoinTeamResult result = new JoinTeamResult();
/* 26 */     result.setSucceed(false);
/* 27 */     switch (joinTeamType)
/*    */     {
/*    */ 
/*    */     case JOIN_TEAM__INVITE: 
/* 31 */       HulaManager.sendErrorInfo(roleId, 3);
/*    */       
/* 33 */       break;
/*    */     
/*    */     case JOIN_TEAM__APPLY: 
/* 36 */       HulaManager.sendErrorInfo(teamInfo.getLeaderId(), 3);
/*    */       
/* 38 */       break;
/*    */     case JOIN_TEAM__PLATFORM: 
/*    */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 48 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 56 */     if (roleWorldId == leaderWorldId)
/*    */     {
/* 58 */       ReturnTeamResult result = new ReturnTeamResult();
/* 59 */       result.setSucceed(true);
/* 60 */       return result;
/*    */     }
/*    */     
/*    */ 
/* 64 */     ReturnTeamResult result = new ReturnTeamResult();
/* 65 */     result.setSucceed(false);
/* 66 */     if (HulaWorldManager.getInstance().isHulaFubenWorld(roleWorldId))
/*    */     {
/* 68 */       HulaManager.sendErrorInfo(roleId, 4);
/*    */     }
/* 70 */     else if (HulaWorldManager.getInstance().isHulaFubenWorld(leaderWorldId))
/*    */     {
/* 72 */       HulaManager.sendErrorInfo(roleId, 3);
/*    */     }
/*    */     
/* 75 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */