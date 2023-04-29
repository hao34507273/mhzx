/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.SCancelInviteBeLeader;
/*    */ import mzm.gsp.team.main.PAppointLeaderReq;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCTryBeLeaderReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCTryBeLeaderReq(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     Long teamId = Role2team.select(Long.valueOf(this.roleId));
/* 26 */     if (teamId == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     xbean.Team xTeam = xtable.Team.select(teamId);
/* 31 */     if (xTeam == null) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!xTeam.getIschangeleadering()) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     boolean isChangeSuc = true;
/* 40 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/* 41 */     if (leaderId != this.roleId) {
/* 42 */       PAppointLeaderReq p = new PAppointLeaderReq(leaderId, this.roleId);
/* 43 */       isChangeSuc = p.call();
/*    */     }
/*    */     
/* 46 */     if (!isChangeSuc) {
/* 47 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 52 */     xTeam = xtable.Team.get(teamId);
/* 53 */     if (xTeam == null) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     xTeam.setIschangeleadering(false);
/*    */     
/* 59 */     TeamInterface.broadcastInTeam(teamId.longValue(), new SCancelInviteBeLeader());
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\PCTryBeLeaderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */