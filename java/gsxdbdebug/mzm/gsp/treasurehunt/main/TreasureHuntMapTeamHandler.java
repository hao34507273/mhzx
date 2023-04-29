/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.treasurehunt.STreasureHuntNormalFail;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TreasureHuntMapTeamHandler
/*    */   implements JoinTeamCheckHandler
/*    */ {
/*    */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*    */   {
/* 18 */     JoinTeamResult result = new JoinTeamResult();
/* 19 */     result.setSucceed(false);
/*    */     
/* 21 */     STreasureHuntNormalFail sMemberTreasureHuntNormalFail = new STreasureHuntNormalFail();
/* 22 */     sMemberTreasureHuntNormalFail.result = 17;
/*    */     
/* 24 */     OnlineManager.getInstance().sendAtOnce(roleId, sMemberTreasureHuntNormalFail);
/*    */     
/* 26 */     STreasureHuntNormalFail sLeaderTreasureHuntNormalFail = new STreasureHuntNormalFail();
/* 27 */     sLeaderTreasureHuntNormalFail.result = 16;
/*    */     
/* 29 */     OnlineManager.getInstance().sendAtOnce(teamInfo.getLeaderId(), sLeaderTreasureHuntNormalFail);
/*    */     
/* 31 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 37 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/* 38 */     returnTeamResult.setSucceed(false);
/* 39 */     return returnTeamResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\TreasureHuntMapTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */