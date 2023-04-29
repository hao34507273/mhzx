/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamVoipRoomManager
/*    */ {
/* 12 */   static Logger logger = Logger.getLogger("teamvoiproom");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isTeamVoipRoomSwitchOpenForRole(long roleid, boolean sendTips)
/*    */   {
/* 22 */     if (!OpenInterface.getOpenStatus(187))
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     if (OpenInterface.isBanPlay(roleid, 187))
/*    */     {
/* 28 */       OpenInterface.sendBanPlayMsg(roleid, 187);
/* 29 */       return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isTeamDissolved(long teamid)
/*    */   {
/* 43 */     return TeamInterface.getTeamInfo(teamid, false) == null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleInThisTeam(long roleid, long teamid)
/*    */   {
/* 56 */     Long roleTeamid = TeamInterface.getTeamidByRoleid(roleid, true);
/* 57 */     if (roleTeamid == null)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     if (roleTeamid.longValue() != teamid)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean checkRoleStatus(long roleid, int status)
/*    */   {
/* 76 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\TeamVoipRoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */