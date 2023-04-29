/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     Long teamid = Role2team.select((Long)this.arg);
/* 20 */     if (teamid == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 25 */     if (xTeam == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     List<Long> lockRoles = TeamManager.getMemberListByXTeam(xTeam);
/* 32 */     lock(Basic.getTable(), lockRoles);
/*    */     
/*    */ 
/* 35 */     xTeam = xtable.Team.get(teamid);
/* 36 */     if (xTeam == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     TeamMember xMember = TeamManager.getXMember(xTeam, ((Long)this.arg).longValue());
/* 41 */     if (xMember == null)
/*    */     {
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     if (FightInterface.isInFight(((Long)this.arg).longValue()))
/*    */     {
/* 50 */       xMember.setIstobeoffline(true);
/* 51 */       return true;
/*    */     }
/*    */     
/* 54 */     if (TeamManager.checkRemoveTeam(((Long)this.arg).longValue(), teamid.longValue(), xTeam))
/*    */     {
/* 56 */       TeamManager.disTeam(teamid.longValue(), xTeam);
/* 57 */       return true;
/*    */     }
/*    */     
/* 60 */     boolean isLeader = false;
/* 61 */     long leaderId = ((TeamMember)xTeam.getMembers().get(0)).getRoleid();
/* 62 */     if (leaderId == ((Long)this.arg).longValue())
/*    */     {
/* 64 */       isLeader = true;
/*    */     }
/*    */     
/* 67 */     int oldStatus = xMember.getStatus();
/*    */     
/*    */ 
/* 70 */     if (!TeamManager.changeMemberStatus(teamid.longValue(), xTeam, ((Long)this.arg).longValue(), 2, false))
/*    */     {
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     TeamManager.triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, ((Long)this.arg).longValue(), oldStatus, 2, isLeader, false);
/*    */     
/*    */ 
/*    */ 
/* 79 */     TeamManager.changeMemberTempStatus(teamid.longValue(), xTeam, ((Long)this.arg).longValue(), 0);
/*    */     
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */