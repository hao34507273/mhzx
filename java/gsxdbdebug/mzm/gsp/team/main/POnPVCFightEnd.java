/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVCFightEndArg;
/*    */ import mzm.gsp.fight.event.PVCFightEndProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class POnPVCFightEnd extends PVCFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     PVCFightEndArg pvcArg = (PVCFightEndArg)this.arg;
/* 17 */     Long teamid = null;
/*    */     
/* 19 */     List<Long> noEscapedRoles = new ArrayList();
/* 20 */     List<Long> escapedRoles = new ArrayList();
/* 21 */     noEscapedRoles.addAll(pvcArg.activeAlivedRoles);
/* 22 */     noEscapedRoles.addAll(pvcArg.activeDeadRoles);
/* 23 */     escapedRoles.addAll(pvcArg.activeEscapedRoles);
/*    */     
/*    */ 
/* 26 */     if (noEscapedRoles.size() > 0)
/*    */     {
/* 28 */       teamid = Role2team.select((Long)noEscapedRoles.get(0));
/*    */     }
/*    */     else
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (teamid == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*    */     
/* 40 */     Set<Long> lockRoles = new java.util.HashSet();
/* 41 */     lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*    */     
/*    */ 
/* 44 */     lock(xtable.Basic.getTable(), lockRoles);
/*    */     
/* 46 */     xTeam = xtable.Team.get(teamid);
/* 47 */     if (!TeamManager.checkLock(xTeam, lockRoles))
/*    */     {
/* 49 */       GameServer.logger().warn(String.format("[team]POnPVCFightEnd.processImp@ check lock fail!|teamId=%d", new Object[] { teamid }));
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 54 */     TeamManager.afterFightProc(teamid, xTeam, noEscapedRoles);
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnPVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */