/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     lock(xtable.Role2buff.getTable(), ((TeamDissolveArg)this.arg).members);
/* 11 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 12 */       mzm.gsp.buff.main.BuffInterface.uninstallBuf(roleid, mzm.gsp.marriage.confbean.SMarriageConsts.getInstance().coupleInteamBuffid);
/*    */     }
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */