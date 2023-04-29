/*    */ package mzm.gsp.team.activity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.SSynTeamsInfo;
/*    */ import mzm.gsp.team.TeamMemberInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynTeamsInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final List<Long> teamIds;
/*    */   
/*    */   public PSynTeamsInfo(long roleId, List<Long> teamIds)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.teamIds = teamIds;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 32 */     long selfTeamId = 0L;
/* 33 */     Long teamId_temp = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 34 */     if (teamId_temp != null) {
/* 35 */       selfTeamId = teamId_temp.longValue();
/*    */     }
/*    */     
/* 38 */     List<Long> teamsSelect = TeamActivityManager.getRefreshMembers(this.teamIds, selfTeamId);
/* 39 */     if (teamsSelect == null) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     SSynTeamsInfo pro = new SSynTeamsInfo();
/* 44 */     for (Iterator i$ = teamsSelect.iterator(); i$.hasNext();) { long teamId = ((Long)i$.next()).longValue();
/* 45 */       mzm.gsp.team.main.TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, false);
/* 46 */       if (teamInfo != null)
/*    */       {
/*    */ 
/* 49 */         List<Long> members = teamInfo.getTeamMemberList();
/* 50 */         if ((members != null) && (members.size() != 0))
/*    */         {
/*    */ 
/* 53 */           mzm.gsp.team.TeamInfo teamInfoPro = new mzm.gsp.team.TeamInfo();
/* 54 */           teamInfoPro.teamid = teamId;
/* 55 */           for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/* 56 */             TeamMemberInfo roleInfo = new TeamMemberInfo();
/* 57 */             TeamInterface.fillTeamMemberInfo(member, roleInfo);
/* 58 */             teamInfoPro.members.add(roleInfo);
/*    */           }
/*    */           
/* 61 */           pro.teams.add(teamInfoPro);
/*    */         }
/*    */       } }
/* 64 */     OnlineManager.getInstance().send(this.roleId, pro);
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\activity\PSynTeamsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */