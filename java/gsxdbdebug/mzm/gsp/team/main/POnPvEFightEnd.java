/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class POnPvEFightEnd extends PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     PVEFightEndArg pveArg = (PVEFightEndArg)this.arg;
/* 18 */     Long teamid = null;
/*    */     
/* 20 */     List<Long> noEscapedRoles = new ArrayList();
/* 21 */     List<Long> escapedRoles = new ArrayList();
/* 22 */     noEscapedRoles.addAll(pveArg.alivedRoles);
/* 23 */     noEscapedRoles.addAll(pveArg.diedRoles);
/* 24 */     escapedRoles.addAll(pveArg.escapedRoles);
/*    */     
/*    */ 
/* 27 */     if (noEscapedRoles.size() > 0)
/*    */     {
/* 29 */       teamid = Role2team.select((Long)noEscapedRoles.get(0));
/*    */     }
/*    */     else
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (teamid == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*    */     
/* 42 */     Set<Long> lockRoles = new java.util.HashSet();
/* 43 */     lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*    */     
/*    */ 
/* 46 */     lock(Basic.getTable(), lockRoles);
/*    */     
/* 48 */     xTeam = xtable.Team.get(teamid);
/*    */     
/* 50 */     if (!TeamManager.checkLock(xTeam, lockRoles))
/*    */     {
/* 52 */       GameServer.logger().warn(String.format("[team]POnPvEFightEnd.processImp@ check lock fail!|teamId=%d", new Object[] { teamid }));
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     TeamManager.afterFightProc(teamid, xTeam, noEscapedRoles);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */