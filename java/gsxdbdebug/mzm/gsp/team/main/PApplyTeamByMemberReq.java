/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PApplyTeamByMemberReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long member;
/*    */   
/*    */   public PApplyTeamByMemberReq(long roleid, long member)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.member = member;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 393, true))
/*    */     {
/* 33 */       GameServer.logger().info(String.format("[team]PApplyTeamByMemberReq.processImp@ can not ApplyTeamByMember!|roleId=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 41 */     if (TeamInterface.isRoleInTeam(this.roleid, false))
/*    */     {
/* 43 */       TeamManager.sendNormalResult(this.roleid, 24, new String[0]);
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     Long teamid = Role2team.select(Long.valueOf(this.member));
/* 49 */     if (teamid == null)
/*    */     {
/* 51 */       return false;
/*    */     }
/* 53 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/*    */     
/* 55 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(leaderId) }));
/*    */     
/* 57 */     xbean.Team xTeam = xtable.Team.get(teamid);
/* 58 */     if (xTeam == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     return TeamManager.applyTeamByTeamId(this.roleid, leaderId, teamid.longValue(), xTeam);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PApplyTeamByMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */