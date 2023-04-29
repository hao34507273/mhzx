/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PForceLeaveTeam
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PForceLeaveTeam(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Long teamid = Role2team.select(Long.valueOf(this.roleid));
/* 27 */     if (teamid == null)
/*    */     {
/* 29 */       GameServer.logger().error(String.format("[team]PForceLeaveTeam.processImp@ role is not in team!|roleId=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 30 */       return false;
/*    */     }
/* 32 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 33 */     if (xTeam == null)
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[team]PForceLeaveTeam.processImp@ team is already not exist!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(this.roleid), teamid }));
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     lock(Basic.getTable(), TeamManager.getMemberListByXTeam(xTeam));
/*    */     
/* 44 */     xTeam = xtable.Team.get(teamid);
/* 45 */     if (xTeam == null)
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[team]PForceLeaveTeam.processImp@ after lock, team is already not exist!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(this.roleid), teamid }));
/*    */       
/*    */ 
/*    */ 
/* 51 */       return false;
/*    */     }
/* 53 */     TeamMember xMember = TeamManager.getXMember(xTeam, this.roleid);
/* 54 */     if (xMember == null)
/*    */     {
/*    */ 
/* 57 */       GameServer.logger().error(String.format("[team]PForceLeaveTeam.processImp@ after lock, role is not in this team!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(this.roleid), teamid }));
/*    */       
/*    */ 
/*    */ 
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     if (TeamManager.checkRemoveTeam(this.roleid, teamid.longValue(), xTeam))
/*    */     {
/* 66 */       TeamManager.disTeam(teamid.longValue(), xTeam);
/* 67 */       return true;
/*    */     }
/*    */     
/* 70 */     boolean leaderChange = false;
/* 71 */     if (TeamManager.isLeader(this.roleid, xTeam))
/*    */     {
/*    */ 
/* 74 */       if (!TeamManager.autoChangeLeader(teamid.longValue(), xTeam))
/*    */       {
/* 76 */         GameServer.logger().error(String.format("[team]PForceLeaveTeam.processImp@ autoChangeLeader err!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(this.roleid), teamid }));
/*    */         
/*    */ 
/* 79 */         return false;
/*    */       }
/* 81 */       leaderChange = true;
/*    */     }
/* 83 */     int oldStatus = xMember.getStatus();
/* 84 */     if (!TeamManager.activeLeaveTeamWithEvent(teamid, xTeam, this.roleid, oldStatus, leaderChange))
/*    */     {
/* 86 */       GameServer.logger().error(String.format("[team]PForceLeaveTeam.processImp@ autoChangeLeader err!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(this.roleid), teamid }));
/*    */       
/*    */ 
/* 89 */       return false;
/*    */     }
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PForceLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */