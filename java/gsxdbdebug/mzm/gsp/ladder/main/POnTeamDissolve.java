/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 10 */     xbean.LadderActivity xselectLadderActivity = xtable.Ladderactivity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 11 */     if (xselectLadderActivity == null) {
/* 12 */       return false;
/*    */     }
/* 14 */     if (xselectLadderActivity.getRoleids().contains(Long.valueOf(((TeamDissolveArg)this.arg).getLeader()))) {
/* 15 */       new LadderHandler.TeamLeaveLadderProcedure(((TeamDissolveArg)this.arg).teamid, ((TeamDissolveArg)this.arg).members).call();
/* 16 */       xbean.LadderActivity xLadderActivity = xtable.Ladderactivity.get(Long.valueOf(localid));
/* 17 */       xLadderActivity.getRoleids().removeAll(((TeamDissolveArg)this.arg).members);
/* 18 */       return true;
/*    */     }
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */