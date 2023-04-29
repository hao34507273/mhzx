/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ 
/*    */ 
/*    */ public class CrossBattleKnockOutMapTeamHandler
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
/*    */ 
/*    */     case JOIN_TEAM__INVITE: 
/*    */     case JOIN_TEAM__APPLY: 
/*    */     case JOIN_TEAM__PLATFORM: 
/* 34 */       onTeamOperatorFail(2, roleId);
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 39 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 47 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/* 48 */     returnTeamResult.setSucceed(true);
/* 49 */     return returnTeamResult;
/*    */   }
/*    */   
/*    */   private void onTeamOperatorFail(int ret, long roleId)
/*    */   {
/* 54 */     SCrossBattleSelectionNormalRes selectionNormalRes = new SCrossBattleSelectionNormalRes();
/* 55 */     selectionNormalRes.ret = ret;
/*    */     
/* 57 */     OnlineManager.getInstance().send(roleId, selectionNormalRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleKnockOutMapTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */