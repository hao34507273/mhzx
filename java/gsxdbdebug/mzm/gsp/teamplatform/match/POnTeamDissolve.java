/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamDissolve
/*    */   extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if ((((TeamDissolveArg)this.arg).members == null) || (((TeamDissolveArg)this.arg).members.size() == 0))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     rmTeamProtectBuff(((TeamDissolveArg)this.arg).members);
/* 26 */     long leaderId = ((Long)((TeamDissolveArg)this.arg).members.get(0)).longValue();
/* 27 */     MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(leaderId, false);
/* 28 */     if (matchData == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     return TeamMatchMananger.cancelMatch(leaderId, CancelMatchType.TEAM_DISSOLVE_CANCEL);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void rmTeamProtectBuff(List<Long> members)
/*    */   {
/* 44 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 46 */       if (BuffInterface.isContainBuff(roleId, TeamMatchMananger.getMemberBuffId()))
/*    */       {
/* 48 */         BuffInterface.uninstallBufAsyc(roleId, TeamMatchMananger.getMemberBuffId());
/*    */       }
/* 50 */       if (BuffInterface.isContainBuff(roleId, TeamMatchMananger.getLeaderBuffId()))
/*    */       {
/* 52 */         BuffInterface.uninstallBufAsyc(roleId, TeamMatchMananger.getLeaderBuffId());
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */