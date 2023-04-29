/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PApplyTeamByTeamId
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long teamId;
/*    */   
/*    */   public PApplyTeamByTeamId(long roleid, long teamId)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 394, true))
/*    */     {
/* 34 */       GameServer.logger().info(String.format("[team]PApplyTeamByTeamId.processImp@ can not ApplyTeamByTeamId!|roleId=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (TeamInterface.isRoleInTeam(this.roleid, false))
/*    */     {
/* 41 */       TeamManager.sendNormalResult(this.roleid, 24, new String[0]);
/* 42 */       return false;
/*    */     }
/* 44 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(this.roleid, false, false);
/*    */     
/* 46 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(leaderId) }));
/*    */     
/* 48 */     xbean.Team xTeam = xtable.Team.get(Long.valueOf(this.teamId));
/* 49 */     if (xTeam == null)
/*    */     {
/* 51 */       TeamManager.sendNormalResult(this.roleid, 35, new String[0]);
/* 52 */       return false;
/*    */     }
/* 54 */     return TeamManager.applyTeamByTeamId(this.roleid, leaderId, this.teamId, xTeam);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PApplyTeamByTeamId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */