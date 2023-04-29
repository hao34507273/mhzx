/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.gang.event.GangTeamDissolvedArg;
/*    */ import mzm.gsp.gang.event.GangTeamDissolvedProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnGangTeamDissolved extends GangTeamDissolvedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     lock(Basic.getTable(), ((GangTeamDissolvedArg)this.arg).members);
/*    */     
/* 17 */     for (Iterator i$ = ((GangTeamDissolvedArg)this.arg).members.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 18 */       BuffInterface.uninstallBuf(r, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */     }
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnGangTeamDissolved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */