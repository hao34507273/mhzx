/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.ladder.SLeaderRemendMemberRes;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCLeaderRemendMemReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long leaderid;
/*    */   private final long memid;
/*    */   
/*    */   public PCLeaderRemendMemReq(long leaderid, long memid)
/*    */   {
/* 16 */     this.leaderid = leaderid;
/* 17 */     this.memid = memid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     Long teamid = TeamInterface.getTeamidByRoleid(this.leaderid, false);
/* 23 */     if (teamid == null) {
/* 24 */       GameServer.logger().info(String.format("[Ladder]PCLeaderRemendMemReq.processImp@do not has team|leaderid=%d", new Object[] { Long.valueOf(this.leaderid) }));
/*    */       
/* 26 */       return false;
/*    */     }
/* 28 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), false);
/* 29 */     if (teamInfo == null) {
/* 30 */       GameServer.logger().info(String.format("[Ladder]PCLeaderRemendMemReq.processImp@do not has team|leaderid=%d", new Object[] { Long.valueOf(this.leaderid) }));
/*    */       
/* 32 */       return false;
/*    */     }
/* 34 */     if (!teamInfo.isLeader(this.leaderid)) {
/* 35 */       GameServer.logger().info(String.format("[Ladder]PCLeaderRemendMemReq.processImp@is not leader|leaderid=%d", new Object[] { Long.valueOf(this.leaderid) }));
/*    */       
/* 37 */       return false;
/*    */     }
/* 39 */     if (teamInfo.isRoleInTeam(this.memid)) {
/* 40 */       SLeaderRemendMemberRes leaderRemendMemberRes = new SLeaderRemendMemberRes();
/* 41 */       mzm.gsp.online.main.OnlineManager.getInstance().send(this.memid, leaderRemendMemberRes);
/*    */     } else {
/* 43 */       GameServer.logger().info(String.format("[Ladder]PCLeaderRemendMemReq.processImp@role is not in team|leaderid=%d|memid=%d", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.memid) }));
/*    */       
/*    */ 
/* 46 */       return false;
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLeaderRemendMemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */