/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.team.confbean.TeamConsts;
/*    */ import mzm.gsp.team.event.TeamStableStateChangedProcedure;
/*    */ 
/*    */ public class POnTeamStableStateChanged extends TeamStableStateChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long teamId = ((TeamStableStateChangeArg)this.arg).getTeamId();
/* 14 */     List<Long> members = ((TeamStableStateChangeArg)this.arg).getMembers();
/* 15 */     if ((members == null) || (members.size() != TeamManager.teamConsts.TEAM_CAPACITY))
/*    */     {
/* 17 */       TeamManager.logger.warn(String.format("[Team]POnTeamStableStateChanged.processImp@稳定队伍发生变化，但队伍人数不满%d人！|teamId=%d|num=%d", new Object[] { Integer.valueOf(TeamManager.teamConsts.TEAM_CAPACITY), Long.valueOf(teamId), Integer.valueOf(members == null ? 0 : members.size()) }));
/*    */     }
/*    */     
/* 20 */     changeStableBuffOn(teamId, members);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void changeStableBuffOn(long teamId, List<Long> members)
/*    */   {
/* 32 */     boolean installBuff = false;
/* 33 */     installBuff = isInstallBuff();
/*    */     
/* 35 */     int stableBuffId = TeamManager.teamConsts.STABLE_TEAM_BUF;
/*    */     
/* 37 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       if (installBuff)
/*    */       {
/* 41 */         BuffInterface.installBuffAsyc(member, stableBuffId);
/*    */       }
/*    */       else {
/* 44 */         BuffInterface.uninstallBufAsyc(member, stableBuffId);
/*    */       }
/*    */     }
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
/*    */   boolean isInstallBuff(long teamId, List<Long> members, boolean installBuff)
/*    */   {
/* 59 */     lock(xtable.Basic.getTable(), members);
/* 60 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, true);
/* 61 */     if (teamInfo != null)
/*    */     {
/* 63 */       installBuff = teamInfo.isStableTeam();
/*    */     }
/* 65 */     return installBuff;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean isInstallBuff()
/*    */   {
/* 74 */     return ((TeamStableStateChangeArg)this.arg).isInstall();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnTeamStableStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */