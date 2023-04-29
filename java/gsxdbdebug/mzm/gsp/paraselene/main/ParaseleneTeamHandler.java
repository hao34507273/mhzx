/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ParaseleneTeamHandler
/*    */   implements JoinTeamCheckHandler
/*    */ {
/*    */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*    */   {
/* 28 */     JoinTeamResult result = new JoinTeamResult();
/* 29 */     result.setSucceed(false);
/* 30 */     int level = RoleInterface.getLevel(roleId);
/* 31 */     boolean r = ActivityInterface.isInActivityLevelByLevel(SParaseleneCfgConsts.getInstance().ActivityId, level);
/* 32 */     if (!r)
/*    */     {
/* 34 */       ParaseleneManager.sendErrorInfo(roleId, 3);
/* 35 */       ParaseleneManager.sendErrorInfo(teamInfo.getLeaderId(), 3);
/* 36 */       return result;
/*    */     }
/*    */     
/* 39 */     if ((RoleStatusInterface.checkCanSetStatus(roleId, 12, true)) && (RoleStatusInterface.setStatus(roleId, 12, true)))
/*    */     {
/*    */ 
/* 42 */       result.setSucceed(true);
/*    */     }
/*    */     
/*    */ 
/* 46 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 52 */     if (ParaseleneManager.isParaseleneWorld(leaderWorldId))
/*    */     {
/* 54 */       ReturnTeamResult result = new ReturnTeamResult();
/* 55 */       if ((RoleStatusInterface.checkCanSetStatus(roleId, 12, true)) && (RoleStatusInterface.setStatus(roleId, 12, true)))
/*    */       {
/*    */ 
/* 58 */         result.setSucceed(true);
/*    */       }
/*    */       else
/*    */       {
/* 62 */         result.setSucceed(false);
/* 63 */         ReturnTeamResult.Result returnResult = new ReturnTeamResult.Result(3001, new String[0]);
/*    */         
/*    */ 
/* 66 */         result.setResult(returnResult);
/*    */       }
/* 68 */       return result;
/*    */     }
/*    */     
/*    */ 
/* 72 */     ReturnTeamResult result = new ReturnTeamResult();
/*    */     
/* 74 */     if (ParaseleneManager.isParaseleneWorld(roleWorldId))
/*    */     {
/* 76 */       boolean r = RoleStatusInterface.unsetStatus(roleId, 12);
/* 77 */       result.setSucceed(r);
/*    */     }
/*    */     else
/*    */     {
/* 81 */       result.setSucceed(false);
/*    */     }
/* 83 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */