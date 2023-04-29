/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTeamDissolve
/*    */   extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     lock(Basic.getTable(), ((TeamDissolveArg)this.arg).members);
/* 17 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 18 */       BuffInterface.uninstallBuf(roleid, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */     }
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */