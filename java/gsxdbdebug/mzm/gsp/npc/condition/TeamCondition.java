/*    */ package mzm.gsp.npc.condition;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class TeamCondition implements Condition
/*    */ {
/*    */   private int teamNumMin;
/*    */   private int teamNumMax;
/*    */   private int teamLevelMin;
/*    */   private int teamState;
/*    */   
/*    */   public TeamCondition(int teamNumMin, int teamNumMax, int teamLevelMin, int teamState)
/*    */   {
/* 17 */     this.teamNumMin = teamNumMin;
/* 18 */     this.teamNumMax = teamNumMax;
/* 19 */     this.teamLevelMin = teamLevelMin;
/* 20 */     this.teamState = teamState;
/*    */   }
/*    */   
/*    */   public boolean isTrue(long roleId)
/*    */   {
/* 25 */     switch (this.teamState) {
/*    */     case 1: 
/* 27 */       Long teamid = TeamInterface.getTeamidByRoleid(roleId, false);
/* 28 */       Iterator i$; if (teamid != null) {
/* 29 */         List<Long> memberList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 30 */         if ((memberList.size() > this.teamNumMax) && (this.teamNumMax > 0)) {
/* 31 */           return false;
/*    */         }
/* 33 */         if (this.teamLevelMin > 0) {
/* 34 */           for (i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 35 */             if (RoleInterface.getLevel(roleid) < this.teamLevelMin)
/* 36 */               return false;
/*    */           }
/*    */         }
/*    */       }
/* 40 */       return true;
/*    */     case 3: 
/* 42 */       if (TeamInterface.isRoleInTeam(roleId, false)) {
/* 43 */         return false;
/*    */       }
/* 45 */       return true;
/*    */     
/*    */     case 2: 
/* 48 */       Long teamLong = TeamInterface.getTeamidByRoleid(roleId, false);
/* 49 */       if (teamLong == null) {
/* 50 */         return false;
/*    */       }
/* 52 */       long teamLeaderid = TeamInterface.getTeamLeaderByTeamid(teamLong.longValue(), false);
/* 53 */       if (teamLeaderid != roleId) {
/* 54 */         return false;
/*    */       }
/* 56 */       List<Long> memberList = TeamInterface.getTeamMemberList(teamLong.longValue(), false);
/* 57 */       Iterator i$; if (this.teamLevelMin > 0) {
/* 58 */         for (i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 59 */           if (RoleInterface.getLevel(roleid) < this.teamLevelMin)
/* 60 */             return false;
/*    */         }
/*    */       }
/* 63 */       if (memberList.size() > this.teamNumMax) {
/* 64 */         return false;
/*    */       }
/* 66 */       if (memberList.size() < this.teamNumMin) {
/* 67 */         return false;
/*    */       }
/* 69 */       return true;
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\condition\TeamCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */