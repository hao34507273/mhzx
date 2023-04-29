/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCheckAFLeaderJoinMatch
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long leaderId;
/*    */   
/*    */   public PCheckAFLeaderJoinMatch(long leaderId)
/*    */   {
/* 17 */     this.leaderId = leaderId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.leaderId);
/* 25 */     if (teamInfo == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (!teamInfo.isTeamExist())
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!teamInfo.isLeader(this.leaderId))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     RoleMatchInfo matchInfo = new RoleMatchInfo(this.leaderId, false);
/* 38 */     if ((!matchInfo.inMatchQueue()) || (!matchInfo.isTeamMatch()) || (!matchInfo.isMatchNewGuyIng()))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     List<Long> newGuyIds = MJoinTeamOnNewGuy.getInstance().getNewGuysInTeam(this.leaderId, matchInfo, teamInfo);
/* 43 */     if (newGuyIds.size() >= matchInfo.getTakeNewGuyNum())
/*    */     {
/*    */ 
/* 46 */       MatchNRTimeTaskManager.getInstance().addTask(new BeNormalMatch(this.leaderId, 2));
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PCheckAFLeaderJoinMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */