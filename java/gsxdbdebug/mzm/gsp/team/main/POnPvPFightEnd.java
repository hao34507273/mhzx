/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class POnPvPFightEnd extends PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     PVPFightEndArg pveArg = (PVPFightEndArg)this.arg;
/*    */     
/* 20 */     List<Long> activenoEscapedRoles = new ArrayList();
/* 21 */     List<Long> activeEscapedRoles = new ArrayList();
/* 22 */     Set<Long> activeRoleList = new HashSet(pveArg.activeRoleList);
/* 23 */     activeRoleList.removeAll(pveArg.activeEscapedRoles);
/* 24 */     List<Long> passivenoEscapedRoles = new ArrayList();
/* 25 */     List<Long> passiveEscapedRoles = new ArrayList();
/* 26 */     Set<Long> passiveRoleList = new HashSet(pveArg.passiveRoleList);
/* 27 */     passiveRoleList.removeAll(pveArg.passiveEscapedRoles);
/*    */     
/* 29 */     activenoEscapedRoles.addAll(activeRoleList);
/* 30 */     activeEscapedRoles.addAll(((PVPFightEndArg)this.arg).activeEscapedRoles);
/* 31 */     passivenoEscapedRoles.addAll(passiveRoleList);
/* 32 */     passiveEscapedRoles.addAll(((PVPFightEndArg)this.arg).passiveEscapedRoles);
/*    */     
/* 34 */     NoneRealTimeTaskManager.getInstance().addTask(new PvpFightEndProc(activenoEscapedRoles, activeEscapedRoles));
/* 35 */     NoneRealTimeTaskManager.getInstance().addTask(new PvpFightEndProc(passivenoEscapedRoles, passiveEscapedRoles));
/*    */     
/* 37 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   class PvpFightEndProc
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final List<Long> noEscapedRoles;
/*    */     private final List<Long> escapedRoles;
/*    */     
/*    */     public PvpFightEndProc(List<Long> noEscapedRoles)
/*    */     {
/* 49 */       this.noEscapedRoles = noEscapedRoles;
/* 50 */       this.escapedRoles = escapedRoles;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 56 */       Long teamid = null;
/*    */       
/* 58 */       if (this.noEscapedRoles.size() > 0)
/*    */       {
/* 60 */         teamid = Role2team.select((Long)this.noEscapedRoles.get(0));
/*    */       }
/*    */       else
/*    */       {
/* 64 */         return false;
/*    */       }
/*    */       
/* 67 */       if (teamid == null)
/*    */       {
/* 69 */         return false;
/*    */       }
/* 71 */       xbean.Team xTeam = xtable.Team.select(teamid);
/*    */       
/* 73 */       Set<Long> lockRoles = new HashSet();
/* 74 */       lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*    */       
/*    */ 
/* 77 */       lock(xtable.Basic.getTable(), lockRoles);
/*    */       
/* 79 */       xTeam = xtable.Team.get(teamid);
/* 80 */       if (!TeamManager.checkLock(xTeam, lockRoles))
/*    */       {
/* 82 */         GameServer.logger().warn(String.format("[team]PvpFightEndProc.processImp@ check lock fail!|teamId=%d", new Object[] { teamid }));
/* 83 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 87 */       TeamManager.afterFightProc(teamid, xTeam, this.noEscapedRoles);
/*    */       
/* 89 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnPvPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */