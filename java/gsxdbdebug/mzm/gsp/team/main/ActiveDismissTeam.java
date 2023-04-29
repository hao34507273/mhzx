/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.Team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActiveDismissTeam
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamId;
/*    */   
/*    */   public ActiveDismissTeam(long teamId)
/*    */   {
/* 21 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(this.teamId, false);
/* 28 */     if (teamInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     List<Long> members = teamInfo.getTeamMemberList();
/* 33 */     lock(Basic.getTable(), members);
/* 34 */     teamInfo = TeamInterface.getTeamInfo(this.teamId, true);
/* 35 */     if (!checkLockEqual(teamInfo, members))
/*    */     {
/* 37 */       GameServer.logger().error(String.format("[team]ActiveDismissTeam.processImp@team members changed, dismiss team fail!|teamId=%d", new Object[] { Long.valueOf(this.teamId) }));
/*    */       
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     TeamManager.disTeam(this.teamId, Team.get(Long.valueOf(this.teamId)));
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean checkLockEqual(TeamInfo teamInfo, List<Long> members)
/*    */   {
/* 55 */     if (teamInfo == null)
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     List<Long> membersTemp = teamInfo.getTeamMemberList();
/* 60 */     if (membersTemp.size() != members.size())
/*    */     {
/* 62 */       return false;
/*    */     }
/* 64 */     if (!membersTemp.containsAll(members))
/*    */     {
/* 66 */       return false;
/*    */     }
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\ActiveDismissTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */