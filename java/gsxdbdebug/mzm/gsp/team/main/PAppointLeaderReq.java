/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.FightInterface;
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
/*    */ public class PAppointLeaderReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long oldLeader;
/*    */   private final long newLeader;
/*    */   
/*    */   public PAppointLeaderReq(long oldLeader, long newLeader)
/*    */   {
/* 25 */     this.oldLeader = oldLeader;
/* 26 */     this.newLeader = newLeader;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     Long teamid = Role2team.select(Long.valueOf(this.oldLeader));
/* 33 */     if (teamid == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*    */     
/* 39 */     List<Long> teamMembers = TeamManager.getMemberListByXTeam(xTeam);
/* 40 */     if ((!teamMembers.contains(Long.valueOf(this.oldLeader))) || (!teamMembers.contains(Long.valueOf(this.newLeader))))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     lock(Basic.getTable(), teamMembers);
/*    */     
/* 47 */     xTeam = xtable.Team.get(teamid);
/* 48 */     if (xTeam == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     if (!TeamManager.isLeader(this.oldLeader, xTeam))
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     if (!canActiveAppointLeaderInStatus(this.oldLeader))
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     if (FightInterface.isInObserving(this.oldLeader))
/*    */     {
/* 65 */       TeamManager.sendNormalResult(this.oldLeader, 72, new String[0]);
/* 66 */       return false;
/*    */     }
/*    */     
/* 69 */     if (FightInterface.isInFight(this.oldLeader))
/*    */     {
/* 71 */       return false;
/*    */     }
/* 73 */     if (this.oldLeader == this.newLeader)
/*    */     {
/* 75 */       return false;
/*    */     }
/* 77 */     return TeamManager.appointLeader(teamid.longValue(), xTeam, this.newLeader, this.oldLeader);
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
/*    */ 
/*    */   private boolean canActiveAppointLeaderInStatus(long roleId)
/*    */   {
/* 91 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 47, true))
/*    */     {
/* 93 */       GameServer.logger().error(String.format("[team]PAppointLeaderReq.canActiveAppointLeaderInStatus@ active appoint leader is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 97 */       return false;
/*    */     }
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PAppointLeaderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */